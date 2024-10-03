#include <stdio.h>



void main() {

    struct DATE {
        int jour;
        int mois;
        int annee;
    };

    struct DATE d1,d2;
    char *ch1="1st date is the smaller";
    char *ch2="2nd date is the smaller";

    printf("Enter 1st Date : ");
    do{
    printf("\nDay:\t");
    scanf("%d",&d1.jour);
    }while((d1.jour>31)||(d1.jour<1));
    
    do{
    printf("Month:\t");
    scanf("%d",&d1.mois);
    }while((d1.mois>12)||(d1.mois<1));

    do{
    printf("Year:\t");
    scanf("%d",&d1.annee);
    }while((d1.annee>3000)||(d1.annee<1000));
    
    
    printf("\nEnter 2nd Date : ");
    do{
    printf("\nDay:\t");
    scanf("%d",&d2.jour);
    }while((d2.jour>31)||(d2.jour<1));

    do{
    printf("Month:\t");
    scanf("%d",&d2.mois);
    }while((d2.mois>12)||(d2.mois<1));

    do{
    printf("Year:\t");
    scanf("%d",&d2.annee);
    }while((d2.annee>3000)||(d2.annee<1000));

    printf("\n\n");

    if(d2.annee<d1.annee){
        printf("%s",ch2);
    }else if (d2.annee>d1.annee){
        printf("%s",ch1);
    }else{
        if (d2.mois<d1.mois){
            printf("%s",ch2);
        }else if (d2.mois>d1.mois){
            printf("%s",ch1);
        }else{
            if (d2.jour<d1.jour){
                printf("%s",ch2);
            }else if (d2.jour>d1.jour){
                printf("%s",ch1);
            }else{
                printf("Both Dates are equal");
            }
        }
    }
    printf("\n\n");
}