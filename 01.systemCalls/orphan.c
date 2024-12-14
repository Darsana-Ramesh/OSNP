#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include<stdlib.h>
void main()
{
	pid_t cpid;
	
	pid=fork();
	if(pid==0){
		printf("I am child process pid is %d",getpid());
		sleep(100);
		printf("Child terminated\n",var);
	}else{
		
		printf("\nI am parent process, pid is %d",getpid());
		exit(0);
		
	}	

}


/*
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ gcc orphan.c
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ ./a.out 

I am parent process, pid is 3274
I am child process pid is 3275
Child terminated

*/


