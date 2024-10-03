#include <stdio.h>
int estAbondant(int x){
    int i,s=0;
    for (i=1;i<=x/2;i++){
        if (x%i==0){
            s=s+i;
        }  
    }
    if (x<s){
        return 1;
    }else{
        return 0;
    }
}

void main(){
    int i;
    for(i=2;i<500;i++){
        if(estAbondant(i)==1){
            printf("%d\n",i);
        }
    }
}