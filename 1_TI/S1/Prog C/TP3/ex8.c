#include<stdio.h>
void main(){
    int a,p=0,i;
    printf("write a: ");
    scanf("%d",&a);
    
    for (i=1; i<=a; i++){
        if(a%i==0){
            p++;
        }
    }
    if (p==2){
        printf("%d est premier",a);
    }else{
        printf("%d n'est pas premier",a);
    }
}