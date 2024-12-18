#include<stdio.h>

struct process{
	int pid;
	int burst_time;
	int waiting_time;
	int turnaround_time;
};

int main(){
	int no_process;
	int avg_wait=0;
	int avg_turn=0;
	float avg_waiting;
	float avg_turnaround;
	

	printf("\nEnter the number of process: ");
	scanf("%d",&no_process);
	struct process q[no_process];
	for(int i=0;i<no_process;i++){
		q[i].pid=i;
		printf("\nenter the burst time of %d: ",i);
		scanf("%d",&q[i].burst_time);
	}

	q[0].waiting_time=0;
	q[0].turnaround_time=q[0].burst_time;

	for(int i=1;i<no_process;i++){
		q[i].waiting_time=q[i-1].waiting_time+q[i-1].burst_time;
		q[i].turnaround_time=q[i].waiting_time+q[i].burst_time;
	}
 
	for(int i=0;i<no_process;i++){
		avg_wait=avg_wait+q[i].waiting_time;
		avg_turn=avg_turn+q[i].turnaround_time;
	}

	avg_waiting=avg_wait/(float)no_process;
	avg_turnaround=avg_turn/(float)no_process;

	

	printf("\npid     |  burst time   | waiting time  | turnaround time");
	printf("\n____________________________________________________________");
	for(int i=0;i<no_process;i++){
		printf("\n%d\t |\t",q[i].pid);
		printf("%d\t|\t",q[i].burst_time);
		printf("%d\t|\t",q[i].waiting_time);
		printf("%d\t|\t",q[i].turnaround_time);		
	}

	printf("\n\nAverage waiting time=%f\n",avg_waiting);
	printf("Average turnaround time time=%f\n",avg_turnaround);
}


/*
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ gcc fcfs.c
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ ./a.out

Enter the number of process: 5    

enter the burst time of 0: 7

enter the burst time of 1: 3

enter the burst time of 2: 6

enter the burst time of 3: 4

enter the burst time of 4: 9

pid     |  burst time   | waiting time  | turnaround time
__________________________________________________________
0	 	|			7	|			0	|	7			|	
1	 	|			3	|			7	|	10			|	
2	 	|			6	|			10	|	16			|	
3	 	|			4	|			16	|	20			|	
4	 	|			9	|			20	|	29			|	

Average waiting time=10.600000
Average turnaround time time=16.400000


*/


