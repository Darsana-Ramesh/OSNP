#include <stdio.h>
#include <unistd.h>
#include<sys/stat.h>

void main()
{
	struct stat buf;
	stat("./waits.c",&buf);
	printf("size of the file is %ld\n",buf.st_size);
}


/*
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ gcc stat.c
darsana@user-HP-280-G3-MT:~/Desktop/OSLab$ ./a.out 
Total size of the file is 776

*/
