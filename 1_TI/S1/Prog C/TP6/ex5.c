#include <stdio.h>

void find(char ch1[],char ch2[])
{
	int i,j,k;
    k=strlen(ch2);
    for (i=0,j=0;ch1[i]!='\0'&& ch2[j]!='\0';i++){
        if (ch1[i]==ch2[j]){
            j++;
        }else{
            j=0;
        }
    }
    if(j==k){
        printf("ch2 found at position %d", i-j+1);
    }else{
        printf("ch2 not found");
    }
}


void main(){
 
    char ch1[20],ch2[20];  
 
    printf("Enter ch1 > ");
    gets(ch1);
    printf("Enter ch2 > ");
    gets(ch2);
    find(ch1,ch2);

}