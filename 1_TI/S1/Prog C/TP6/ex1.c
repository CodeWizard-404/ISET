#include <stdio.h>

int chaine_camp(char ch1[], char ch2[])
{
    int i=0;
    while(ch1[i]==ch2[i])
    {
        if(ch1[i]=='\0' || ch2[i]=='\0')
            break;
        i++;
    }
    if(ch1[i]=='\0' && ch2[i]=='\0'){
        return 0;
    }else{
        return -1;
    }
}

void main(){
    char ch1[20],ch2[20];
    int r;
    printf("enter ch1 > ");
    scanf("%s",ch1);
    printf("enter ch2 > ");
    scanf("%s",ch2);

    r=chaine_camp(ch1,ch2);
    if (r==0){
        printf("egaux");
    }else{
        printf("non egaux");       
    }
}