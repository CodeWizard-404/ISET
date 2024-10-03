#include<stdio.h>
void main(){
    int i,t1,t2,test ;
    int t[100],v[100];
    printf("Enter table 1 size: ");
    scanf("%d",&t1);
    printf("Enter table 2 size: ");
    scanf("%d",&t2);
    for(i=0;i<t1;i++){
        printf("Enter T1 @%d: ",i);
        scanf("%d",&t[i]);
    }
    for(i=0;i<t2;i++){
        printf("Enter T2 @%d: ",i);
        scanf("%d",&v[i]);
    }
    i=0;
    test=0;
    do{
        if(t[i]!=v[i]){
            test=1;
        }
        i++;
    }while((test=1)&&(i!=t1)&&(t2==t1));
    if(test==1){
        printf("Table 1 & 2 are equal");
    }else{
        printf("Table 1 & 2 are not equal");
    }
    
}