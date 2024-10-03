#include<stdio.h>

int addition(int a, int b){
    return a+b;
}

int sustraction(int a, int b){
    return a-b;
}

int multiplication(int a, int b){
    return a*b;
}

void parfait(int a){
    int i,s;
    for(i=1;i<a;i++){
        if(a%i==0){
            s=s+i;
        }
    }
    if(s==a){
    printf("%d Nombre parfait\n",a);
    }else{
    printf("%d n'est pas un Nombre parfait\n",a);
    }
}

void inverse(int a){
    int inv=0;
    while (a!=0)
   {
      inv=inv*10;
      inv=inv+a%10;
      a=a/10;
   }
   printf("inverse= %d\n",inv);
}

void impair(int a){
   if (a%2==0){
    printf("%d Paire\n",a);
   } else{
    printf("%d Impaire\n",a);
   }
}

void affichage(){
    printf("hello");
}


void main(){
    int x=3,y=2,z=6,t=123, add, sus,mul;
    add=addition(x,y);
    sus=sustraction(x,y);
    mul=multiplication(x,z);
    parfait(z);
    inverse(t);
    impair(z);
    printf("addition = %d\n",add);
    printf("sustraction = %d\n",sus);
    printf("multiplication = %d\n",mul);
    affichage();
}