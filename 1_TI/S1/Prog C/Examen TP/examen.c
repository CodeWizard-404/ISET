#include<stdio.h>

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

int estPositif(int x){
    if (x>=0){
        return 1;
    }else{
        return 0;
    }
}

void afficherPositif(int t[],int n){
    int i;
    int nb=0;
    for(i=0;i<n;i++){
        nb=nb+estPositif(t[i]);
    }
    printf("NB positif du Tab: %d\n",nb);
}

int rechPosPostif(int t[],int n){
    int p;
    int i=0;
    do{
        p=estPositif(t[i]);
        i++;
    }while((p!=1)&&(i<n));
    return i-1;
}

int rechercheElem(int t[],int n,int x){
    int i=0;
    while(i<n){
        if(t[i]==x){
            return i;
        }
        i++;
    }
    return -1;
}

int supprimerElem(int t[],int n,int pos){
    int i;
    for(i=pos;i<n-1;i++){
        t[i]=t[i+1];
    }
    n--;
    return n;
}

int supprimerPositif(int t[],int n){
    int pos,i;
    for(i=0;i<n;i++){
        pos=rechPosPostif(t,n);
        n=supprimerElem(t,n,pos);
    }
    return n;
}

int chercherPlateau(int t[],int n,int x ,int y){
    int i,r,test;
    r=rechercheElem(t,n,x);
    if(r==-1){
        printf("%d not found",x);
    }else{
        for(i=r;i<=y;i++){
            if(t[i]==x){
                test=1;
            }else{
                test=0;
            }
        }
        if(test==1){
            return r;
        }else{
            return 0;
        }
    }
}

int supprimerPlateau (int t[],int n,int x ,int y){
    int pos=chercherPlateau(t,n,x,y);
    for(int i=0;i<y;i++){
        n=supprimerElem(t,n,pos);
    }
    return n;
}

int sommePositif(int t[],int n){
    int i;
    int nb=0;
    for(i=0;i<n;i++){
        nb=nb+estPositif(t[i]);
    }
    return nb;
}

void main(){
    int n,x,xx,a,b,z,zz,s,r;
    int t[100];

    do{
        printf("Enter tab Size: ");
        scanf("%d",&n);
    }while((n<0)||(n>100));

    remplir(t,n);
    printf("\n-----------------------------------\n\n");

    afficher(t,n);
    printf("\n-----------------------------------\n\n");

    printf("Enter x to check positif or negatif: ");
    scanf("%d",&x);
    if (estPositif(x)==1){
        printf("%d est positif",x);
    }else{
        printf("%d est negatif",x);
    }
    printf("\n-----------------------------------\n\n");
    
    afficherPositif(t,n);
    printf("\n-----------------------------------\n\n");

    z=rechPosPostif(t,n);
    printf("position 1er nb positif: %d",z);
    printf("\n\n-----------------------------------\n\n");

    
    printf("Enter x to check position: ");
    scanf("%d",&xx);
    zz=rechercheElem(t,n,xx);
    printf("position %d: %d",xx,zz);
    printf("\n-----------------------------------\n\n");

    printf("tableau apres supp x:\n");
    n=supprimerElem(t,n,zz);
    printf("\n");
    afficher(t,n);
    printf("\n-----------------------------------\n\n");
    
    
    printf("tableau apres supp postif:\n");
    s=sommePositif(t,n);
    n=supprimerPositif(t,n);
    afficher(t,n);
    printf("\n-----------------------------------\n\n");


    printf("Enter plateau nb: ");
    scanf("%d",&a);
    printf("Enter plateau size: ");
    scanf("%d",&b);
    printf("position plateau: ");
    r=chercherPlateau(t,n,a,b);
    if(r==0){
        printf("not found");
    }else{
        printf("%d",r);
    }
    printf("\n-----------------------------------\n\n");

    
    n=supprimerPlateau(t,n,a,b);
    printf("\nTab apres sup plateau : \n");
    afficher(t,n);




    

}