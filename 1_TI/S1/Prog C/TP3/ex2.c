#include<stdio.h>
void main()
{
    int a,s,i,min=0,max=21,moy;
    do{
        printf("write a: ");
        scanf("%d",&a);
        if((a>=0)&&(a<=20)){
            if(a<min){
                min=a;
            }
            if(a>max){
                max=a;
            }
            s=s+a;
            i++;
        }
    }while(a!=-1);
    moy=s/i;
    printf("moyenne=%d\nmax=%d\nmin=%d\n",moy,max,min);
}