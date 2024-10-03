#include<stdio.h>
void main(){
    float a,b;
    char c;
    printf("write a: ");
    scanf("%f",&a);
    printf("write op: ");
    scanf("%s",&c);
    printf("write b: ");
    scanf("%f",&b);
    if (c == '+') {
        printf("%d %c %d = %.2f\n",a,c,b,a+b);
    }else if (c == '-') {
        printf("%d %c %d = %.2f\n",a,c,b,a-b);
    }else if (c == '*') {
        printf("%d %c %d = %.2f\n",a,c,b,a*b);
    }else if (c == '/') {
        printf("%d %c %d = %.2f\n",a,c,b,a/b);
    }else{
        printf("ERROR");
    }
}