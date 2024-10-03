#include<stdio.h>
#include<ctype.h>
void main(){
    char a,b;
    printf("write b :");
    scanf("%c",&a);
    if((isalpha(a))&&(islower(a))){
        b=toupper(a);
    }else if((isalpha(a))&&(isupper(a))){
        b=tolower(a);
    }
    printf("%c",b);
}