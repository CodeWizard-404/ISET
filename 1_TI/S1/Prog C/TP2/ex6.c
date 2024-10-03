#include<stdio.h>
void main(){
    int m;
    printf("write m: ");
    scanf("%d",&m);
    if((m>10)&&(m<12)){
        printf("Passable");
    }else if((m>12)&&(m<14)){
        printf("Assez bien");
    }else if((m>14)&&(m<16)){
        printf("Bien");
    }else if(m>16){
        printf("Tres bien");
    }else{
        printf("Refuser");
    }
}
