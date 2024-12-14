#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include<stdlib.h>
void main()
{
	pid_t cpid;
	
	cpid=fork();
	
	if(cpid==0){
		printf("I am child process pid is %d\n",getpid());
		sleep(10);
		printf("Child terminated\n");
		exit(0);
	}else{
		
		printf("\nI am parent process, pid is %d\n",getpid());
		cpid=wait(NULL);
		printf("Parent process Terminated.child pid is %d\n",cpid);
		
	}	

}



/*

I am parent process, pid is 3776
I am child process pid is 3777
Child terminated
Parent process Terminated.child pid is 3777


*/
