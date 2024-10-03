#include<stdio.h>
void main(){
    var t1,t2,t3,PJ,A;
    int k,j;
    float cj,ck;
    printf("donnez le kilometrage: ");
    scanf("%d",&k);
    printf("donnez le nb des jours: ");
    scanf("%d",&j);
    // cout par kilometrage
    if(k<100){
        ck=t1/k;
    }else if((k>100)&&(k<=1000)){
        ck=t2/k;
    }else if(k>1000){
        ck=t3/k;
    }
    ck=ck+A+(ck*0.17);
    // cout par jours
    cj=(PJ*j)+A+(PJ*j*0.17);

    printf("Location au kilometre= %.2f",ck);
    printf("Forfait journalier= %.2f",cj);

    if (cj>ck){
        printf("Forfait journalier est plus aventeu");
    }else{
        printf("Location au kilometre est plus aventeu");
    }
}

    