#include <stdio.h>

void fuse(char *ch1,char *ch2)
{
	int i;
	int j=strlen(ch2);
	
    for(i=0;ch2[i];i++){
    	ch1[i+j]=ch2[i];
	}
	ch1[i+j]='\0';
}


void main()
{
 
    char ch1[20],ch2[20];  
 
    printf("Enter ch1 > ");
    gets(ch1);
    printf("Enter ch2 > ");
    gets(ch2);
    fuse(ch1,ch2);
    printf("ch1+ch2 = ch3 > %s\n",ch1);

}