#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include<stdlib.h>
void main()
{
	pid_t pid;
	
	pid=fork();
	int var=10;
	if(pid==0){
		printf("I am child process pid is %d",getpid());
		var++;
		printf("\nvar=%d\n",var);
		exit(0);
	}else{
		
		printf("\nI am parent process, pid is %d",getpid());
		var=var+5;
		printf("\nvar=%d\n",var);
		sleep(100);
	}	

}


