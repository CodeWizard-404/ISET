#include<stdio.h>
#include<conio.h>

int majuscule(char a){
    
    printf("Enter a Char : ");
    scanf("%c",&a);
    printf("%c", a-32);

}

void main(){
    char a;
    majuscule(a);
}