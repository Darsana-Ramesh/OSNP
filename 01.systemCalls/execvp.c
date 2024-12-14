#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
void main()
{
	printf("I am execvp Pid is %d\n",getpid());

}

/*

darsana@user-HP-280-G3-MT:~/Desktop/OSLab/exp1$ gcc execvp.c
darsana@user-HP-280-G3-MT:~/Desktop/OSLab/exp1$ ./a.out
I am execvp Pid is 4567

*/
