#include <stdio.h>

void remplir(int t[],int n){
    int i;
    for(i=0;i<n;i++){
        printf("Enter T[%d]: ",i);
        scanf("%d",&t[i]);
    }
}
void afficher(int t[],int n){
    int i;
    for(i=0;i<n;i++){
        printf("T[%d]= %d\n",i,t[i]);
    }
}
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
void afficherAbondant( int t[], int n){
    int i;
    for(i=0;i<n;i++){
        if(estAbondant(t[i])==1){
            printf("%d est abondant\n",t[i]);
        }
    }
}
int rechPosAbondant(int t[],int n){
    int p;
    int i=0;
    do{
        p=estAbondant(t[i]);
        i++;
    }while((p!=1)&&(i<n));
    return i-1;
}
int supprimerElem(int t[],int n,int pos){
    int i;
    for(i=pos;i<n-1;i++){
        t[i]=t[i+1];
    }
    n--;
    return n;
}
int supprimerFirstAbondant(int t[],int n){
    int pos=rechPosAbondant(t,n);
    n=supprimerElem(t,n,pos);
    return n;
}
int supprimerAllAbondant(int t[],int n){
    int i;
    for(i=0;i<n;i++){
        n=supprimerFirstAbondant(t,n);
    }
    return n;
}
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

void afficherAmi (int t[],int n,int x){
    int i;
    for(i=0;i<n;i++){
        if(estAmi(x,t[i])==1){
            printf("%d est ami de %d\n",t[i],x);
        }
    }
}


void main(){

    int n,x,p,pos,M,N,nb;
    int t[100];

    printf("Enter tab Size: ");
    scanf("%d",&n);

    remplir(t,n);
    printf("\n-----------------------------------\n\n");

    afficher(t,n);
    printf("\n-----------------------------------\n\n");

    printf("Enter x to check Abondant: ");
    scanf("%d",&x);
    if (estAbondant(x)==1){
        printf("%d est Abondant",x);
    }else{
        printf("%d pas Abondant",x);
    }
    printf("\n-----------------------------------\n\n");
    
    afficherAbondant(t,n);
    printf("\n-----------------------------------\n\n");

    p=rechPosAbondant(t,n);
    printf("position 1er Abondant: %d",p);
    printf("\n\n-----------------------------------\n\n");


    printf("Enter pos Of NB to Supp : ");
    scanf("%d",&pos);
    printf("Tableau apres supp NB au pos %d:\n\n",pos);
    n=supprimerElem(t,n,pos);
    afficher(t,n);
    printf("\n-----------------------------------\n\n");
    
    
    printf("Tableau apres supp First Abondent:\n");
    n=supprimerFirstAbondant(t,n);
    afficher(t,n);
    printf("\n-----------------------------------\n\n");


    printf("Tableau apres supp All Abondent:\n");
    n=supprimerAllAbondant(t,n);
    afficher(t,n+1);
    printf("\n-----------------------------------\n\n");


    printf("Enter M and N to check Ami\n");
    scanf("%d",&M);
    scanf("%d",&N);
    if (estAmi(M,N)==1){
        printf("%d et %d est Ami",M,N);
    }else{
        printf("%d et %d pas Ami",M,N);
    }
    printf("\n-----------------------------------\n\n");

    printf("Enter x : ");
    scanf("%d",&nb);      
    printf("NB ami de %d au Tableau :\n",nb);
    afficherAmi(t,n,nb);

}