#include <stdio.h>
#include<conio.h>
#include <string.h>

int estBrillante(char ch[]) {
    int i,n;
    n=strlen(ch);
    for(i=0;i<ch;i++){
        if(i%2==0){
            if((ch[i]>64)&&(ch[i]<91)){
                return 1;
            }else{
                return 0;
            }
        }else{
            if((ch[i]>96)&&(ch[i]<123)){
                return 1;
            }else{
                return 0;
            }
        }
    }
}

 int estAmi(char ch1[],char ch2[]){
    int i,j,k=0;
    for(i=0;i<strlen(ch1);i++){
		for(j=0;j<strlen(ch2);j++){
			if(tolower(ch1[i])==tolower(ch2[j])){
				k++;
			}
        }
    }
    if (k==strlen(ch1)){
		return 1;
	}
	else{
		return 0;
	}
 }


 int estAmiBrillant (char ch1[],char ch2[]){
    int a,b1,b2;
    a=estAmi(ch1,ch2);
    b1=estBrillante(ch1);
    b2=estBrillante(ch2);
    if((a==1)&&(b1==1)&&(b2==1)){
        return 1;
    }else{
        return 0;
    }
 }
 int estPalindrome ( char ch[]){
    int i,n;
    n=strlen(ch)-1;

    while (n>i) {
        if (ch[i++] == ch[n--]) {
            return 1;
        }
    }
 }

 int verifier(char ch[],char c){
 	int i,j;
    j=strlen(ch);
    for(i=0;i<j;i++){
        if(ch[i]==c){
            return i+1;
        }
    }
 }


 void ExtraireChaine (char ch1[],char ch2[]){
    int i,j,n1,n2,temp,test=0;
    n1=strlen(ch1);
    n2=strlen(ch2);
    for(i=0; i<n1; i++){
        temp= i;
        for(j=0; j<n2; j++){
            if(ch1[i]==ch2[j]){
                i++;
            }
        }
        test = i-temp;
        if(test==n2){
            i = temp;
            for(j=i; j<(n1-n2); j++)
                ch1[j] = ch1[j+n2];
            n1 = n1-n2;
            ch1[j]='\0';
        }
    }
    printf("New String = %s\n\n\n", ch1);
 }

void main(){
    char ch[20],ch1[20],ch2[20],ch3[20],ch4[20],ch5[20],ch6[20],ch7[20],ch8[20],ca,cl;
    int a,b,c,d,e;



    printf("brillant\n\n");
    printf("Enter a string : ");
    scanf("%s",ch);
    a=estBrillante(ch);
    if(a==1){
        printf("ch est brillante\n\n\n");
    }else{
        printf("ch pas brillante\n\n\n");
    }

    printf("ami\n\n");
    printf("Enter a string : ");
    scanf("%s",ch1);
    printf("Enter a string : ");
    scanf("%s",ch2);
    b=estAmi(ch1,ch2);
    if(b==1){
        printf("ch1 et ch2 sont ami\n\n\n");
    }else{
        printf("ch1 et ch2 pas ami\n\n\n");
    }

    printf("brillant et ami\n\n");
    printf("Enter a string : ");
    scanf("%s",ch7);
    printf("Enter a string : ");
    scanf("%s",ch8);
    c=estAmiBrillant(ch7,ch8);
    if(c==1){
        printf("ch1 et ch2 sont ami et brillant\n\n\n");
    }else{
        printf("ch1 et ch2 pas ami et brillant\n\n\n");
    }

    printf("palindrom\n\n");
    printf("Enter a string : ");
    scanf("%s",ch3);
    d=estPalindrome(ch3);
    if(d==1){
        printf("ch est palindrome\n\n\n");
    }else{
        printf("ch pas palindrome\n\n\n");
    }

    printf("verifier pos\n\n");
    printf("Enter a caracter : ");
    scanf("%c %c",&cl,&ca);
    printf("Enter a string : ");
    scanf("%s",ch4);
    e=verifier(ch4,ca);
    printf("caracter position %d\n\n\n",e);
    

    printf("extraire ch\n\n");
    printf("Enter a string : ");
    scanf("%s",ch5);
    printf("Enter a string : ");
    scanf("%s",ch6);
    ExtraireChaine(ch5,ch6);

}