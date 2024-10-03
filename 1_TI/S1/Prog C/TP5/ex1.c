#include<stdio.h>
#include<conio.h>

int suivant(char a){
    
    printf("Enter a Char : ");
    scanf("%c",&a);
    printf("%c", a+1);

}

void main(){
    char a;
    suivant(a);
}