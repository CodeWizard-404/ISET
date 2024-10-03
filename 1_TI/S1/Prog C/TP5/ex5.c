#include <stdio.h>

void stars(int l,int c){
    int i,j;
    for(i=0; i<l; i++){
		for(j=0; j<c; j++)
		{
			printf("*");
		}
    printf("\n");
    }
}
int perimetre(int l,int c){
    return (l+c)*2;
}
int surface(int l,int c){
    return l*c;
}

void main(){
    int l,c;
    printf("Enter Longeur : ");scanf("%d",&c);
    printf("Enter Largeur : ");scanf("%d",&l);
    printf("le perimetre est %d, la surface est %d\n",perimetre(l,c),surface(l,c));
    stars(l,c);
}