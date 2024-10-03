#include <stdio.h>
void main(){
    int i,j,s1,s2,s3,c1,c2,c3;
    int t[100],v[100],z[100];
    printf("Enter table 1 size: ");
    scanf("%d",&s1);
    for (i=0;i<s1;i++){
        printf("Enter @%d: ", i);
        scanf("%d",&t[i]);
    }
    for (i=0;i<s1;i++){
        for (j=0;j<s1;j++){
            if (t[j]>t[i]){
                c1=t[i];
                t[i]=t[j];
                t[j]=c1;
            }
        }
    }
    for(i=0;i<s1;i++){
        printf("T1 @%d: %d\n",i,t[i]);
    }


    printf("Enter table 2 size: ");
    scanf("%d",&s2);
    for (i=0;i<s2;i++){
        printf("Enter @%d: ", i);
        scanf("%d",&v[i]);
    }
    for (i=0;i<s2;i++){
        for (j=0;j<s2;j++){
            if (v[j]>v[i]){
                c2=v[i];
                v[i]=v[j];
                v[j]=c2;
            }
        }
    }
    for(i=0;i<s2;i++){
        printf("T2 @%d: %d\n",i,v[i]);
    }


    s3=s1+s2;
    for (i=0;i<s1;i++){
        z[i]=t[i];
    }
    for (i=0,j=s1;j<s3 && i<s2;i++,j++){
        z[j]=v[i];
    }
    for(i=0;i<s3;i++){
        printf("T3 n @%d: %d\n",i,z[i]);
    }


    for (i=0;i<s3;i++){
        for (j=0;j<s3;j++){
            if (z[j]>z[i]){
                c3=z[i];
                z[i]=z[j];
                z[j]=c3;
            }
        }
    }
    for(i=0;i<s3;i++){
        printf("T3 tri @%d: %d\n",i,z[i]);
    }
}



