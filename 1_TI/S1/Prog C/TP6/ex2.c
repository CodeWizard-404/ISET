#include <stdio.h>

void chaine_rev(char ch[]){
    int j=0,i=0,x;
    j=strlen(ch)-1;
    while(i<j){
        x=ch[j];
        ch[j]=ch[i];
        ch[i]=x;
        i++;
        j--;
    }
    printf("rev chaine > %s",ch);
}

void main(){
    char ch[20];

    printf("enter ch > ");
    scanf("%s",ch);
    chaine_rev(ch);
}
