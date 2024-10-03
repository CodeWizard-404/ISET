#include <stdio.h>

void tableMultiplication(int n){
    int i,j,p;

    for(i=1;i<=n;i++){
        printf("-----");
    }printf("------\n|  * ");

    for(j=1;j<=n;j++){
            if(j<10){printf("|  %d ",j);}
            else{printf("| %d ",j);}
    }printf("|\n");

    for(i=1;i<=n;i++){
        printf("-----");
    }printf("------\n");

    for(i=1;i<=n;i++){
        if(i<10){printf("|  %d ",i);}
        else{printf("| %d ",i);}

        for(j=1;j<=n;j++){
            p=i*j;
            if((p<10)&&(p<100)){
                printf("|  %d ",p);
            }else if((p>9)&&(p<100)) {
                printf("| %d ",p);
            }else if((p>9)&&(p>99)){
                printf("|%d ",p);
            }
        }printf("|\n");

        for(j=1;j<=n;j++){
            printf("-----");
        }printf("------\n");
    }
}

void main(){
    int n;
    
    do{
        printf("Enter n: ");
        scanf("%d",&n);
    }while((n<1)||(n>20));
    
    tableMultiplication(n);
}