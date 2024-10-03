#include <stdio.h>
int estAmi(int x,int y){
    int i,sx=0,sy=0;
    for (i=1;i<=x/2;i++){
        if (x%i==0){
            sx=sx+i;
        }  
    }
    for (i=1;i<=y/2;i++){
        if (y%i==0){
            sy=sy+i;
        }  
    }
    if((sx==y)&&(sy==x)){
        return 1;
    }else{
        return 0;
    }
}

void main(){
    int i,j;
    for(i=1;i<500;i++){
        for(j=1;j<500;j++){
            if(estAmi(i,j)==1){
                printf("%d est %d ami\n",i,j);
            }
        }
    }
}