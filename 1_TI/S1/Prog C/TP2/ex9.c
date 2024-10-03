#include<stdio.h>
void main(){
    float t,p,bmi,pi;
    char s;
    printf("donnez le sex (m/f): ");
    scanf("%c",&s);
    printf("donnez la taille en cm: ");
    scanf("%f",&t);
    printf("donnez le poids en kg: ");
    scanf("%f",&p);
    if(s=='m'){
        pi=(t-100)-(t-150)/4;
        printf("PI(poid ideal Homme)= %.2f\n",pi);
    }else{
        pi=(t-100)-(t-150)/2;
        printf("PI(poid ideal Femme)= %.2f\n",pi);
    }
    bmi=p/(t/100);
    printf("BMI(body mass index)= %.2f\n",bmi);
    if(bmi<27){
        printf("indiquer comme normale\n");
    }else if((bmi>=27)&&(bmi<32)){
        printf("indiquer comme Obese\n");
    }else if(bmi>=32){
        printf("indiquer comme Malade\n");
    }
}