#include <stdio.h>


void char_find(char ch[],char c){
    int i,j;
    j=strlen(ch);
    for(i=0;i<j;i++){
        if(ch[i]==c){
            printf("char position:%d\n",i);
        }
    }
}

void main(){
    char ch[20];
    char c;
    
    printf("enter char > ");
    scanf("%c",&c);
    printf("enter ch > ");
    scanf("%s",ch);
    
    char_find(ch,c);
}
