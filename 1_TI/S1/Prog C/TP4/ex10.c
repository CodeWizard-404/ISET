#include<stdio.h>
void main(){
    int i,s,m,so,x,max,diff0,diff1,closest;
    int t[100];
    printf("Enter table size: ");
    scanf("%d",&s);
    so=0;
    for (i=0;i<s;i++){
        printf("Enter @%d: ", i);
        scanf("%d",&t[i]);
        so=so+t[i];
    }
    m=so/s;
    max=0;
    for (i=0;i<s;i++){
        if(t[i]>max){
            max=t[i];
        }
    }
    diff0=max;
    for (i=0;i<s;i++){
        if(m>t[i]){
            diff1=m-t[i];
            if(diff1<diff0){
                diff0=diff1;
                closest=t[i];
            }
        }else if(m<t[i]){
            diff1=t[i]-m;
            if(diff1<diff0){
                diff0=diff1;
                closest=t[i];
            }
        }else{
            closest=m;
        }
    }
    printf("moyenne : %d\n",m);
    printf("closest : %d",closest);
    
}