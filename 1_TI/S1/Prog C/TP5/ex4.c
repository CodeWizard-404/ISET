#include <stdio.h>

void remplir(int t[],int n){
    int i;
    for (i=0;i<n;i++){
        printf(">Enter T[%d]: ",i);
        scanf("%d", &t[i]);
    }
}
void afficher(int t[], int n){
    int i;
    for(i=0;i<n;i++){
        printf(">Element T[%d]: %d\n",i,t[i]);
    }
}
void remplacer(int t[],int n, int x, int y){
    int i;
    for(i=0;i<n;i++){
        if(t[i]==x){
            t[i]=y;
        }
    }
}

void main(){
    int n,a[100],x,y;

    printf("enter table size : ");
    scanf("%d",&n);
    printf("enter x to replace it : ");
    scanf("%d",&x);
    printf("enter y to replace x : ");
    scanf("%d",&y);
    remplir(a,n);
    remplacer(a,n,x,y);
    afficher(a,n);
}