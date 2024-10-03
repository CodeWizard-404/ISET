#include<stdio.h>
void main()
{
    int i,s,x,ux,dx,cx,ui,di,ci;
    int t[100];

    printf("Enter table size: ");
    scanf("%d",&s);

    for (i=0;i<s;i++){
        printf("Enter @%d: ",i);
        scanf("%d",&t[i]);
    }

    printf("Enter x :");
    scanf("%d",&x);
        ux=x%10;
        dx=(x/10)%10;
        cx=x/100;
        
    for (i=0;i<s;i++){
        ui=t[i]%10;
        di=(t[i]/10)%10;
        ci=t[i]/100;


        if(ui==ux){
            if(di==dx){
                if(ci==cx){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }else if(di==cx){
                if(ci==dx){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }
        }else if(ui==dx){
            if(di==ux){
                if(ci==cx){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }else if(di==cx){
                if(ci==ux){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }
        }else if(ui==cx){
            if(di==ux){
                if(ci==dx){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }else if(di==dx){
                if(ci==ux){
                    printf("%d et %d sont freres\n",x,t[i]);
                }
            }
        }
    }
}







