#include<stdio.h>

int divise(int a, int b){
    if(a%b==0){
        return 1;
    }else{
        return 0;
    }
}

int premier(int a){
    int p=0,i;

   for(i=1; i<=a; i++)
   {
      if(a%i==0)
      {
         p++;
      }
   }
   if(p==2)
   {
        return 1;
    }else{
        return 0;
    }
}

void main (){

    int n,test1,test2,test3,i;
    int t[100];

    printf("Enter integer : ");
    scanf("%d",&n);

    printf("\n\tLes diviseur\n\n");

    for(i=1;i<=n/2;i++){

        if(divise(n,i)==1){
            if(premier(i)==1){
                printf("%d est un div de %d et premier \n",i,n);
            }else if(premier(i)==0){
                printf("%d est un div de %d \n",i,n);
            }

        }
    }

    printf("\n\tLes premier\n\n");

    for(i=1;i<n;i++){

        if(premier(i)==1){
            printf("%d est premier \n",i);
        }
    }
}