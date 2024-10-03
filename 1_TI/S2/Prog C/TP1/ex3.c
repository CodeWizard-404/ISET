#include <stdio.h>
#include <string.h>
#include <ctype.h>

struct DATE
{
    int jour;
    char mois[10];
    int annee;
    int moisi;
};

struct Adress
{
    int Nu;
    char NomR[50];
    char NomV[20];
    char NomP[20];
};

struct Student
{
    char Name[50];
    char LastName[50];
    int CIN;
    int Num;
    struct DATE DN;
    int Level;
    int Group;
    char Specialty[20];
    float MoyGn;
    struct Adress AD;
};

void Get_Data(int n, struct Student T[20])
{

    printf("\033[36m======================================================================================\033[0m");
    for (int i = 1; i <= n; i++)
    {

        printf("\n\033[34m*Enter Student N%d Data :\033[0m\n", i);

        printf(" -Name:\t\t");
        scanf("%s", T[i].Name);

        printf(" -LastName:\t");
        scanf("%s", T[i].LastName);

        do
        {
            printf(" -CIN:\t\t");
            scanf("%d", &T[i].CIN);
        } while ((T[i].CIN > 999999) || (T[i].CIN < 10000));

        do
        {
            printf(" -Num d'inscri:\t");
            scanf("%d", &T[i].Num);
        } while ((T[i].Num > 999999) || (T[i].Num < 10000));

        printf(" -Date de Naissance:\n");
        do
        {
            printf("   -Jour:\t");
            scanf("%d", &T[i].DN.jour);
        } while ((T[i].DN.jour > 31) || (T[i].DN.jour < 1));


        var char months[][12] = {"janvier", "fevrier", "mars", "avril", "mai", "Juin", "Juillet", "aout", "september", "october", "november", "december"};
        int test1;
        do
        {
            printf("   -Mois:\t");
            scanf("%s", T[i].DN.mois);
            test1 = 1;
            for (int j = 0; j < 12; j++)
            {
                for (int k = 0; T[i].DN.mois[k]; k++)
                {
                    T[i].DN.mois[k] = tolower(T[i].DN.mois[k]);
                }
                if (strcmp(T[i].DN.mois, months[j]) == 0)
                {
                    T[i].DN.moisi = j + 1;
                    test1 = 0;
                }
            }
        } while (test1 != 0);

        do
        {
            printf("   -Annee:\t");
            scanf("%d", &T[i].DN.annee);
        } while ((T[i].DN.annee > 2023) || (T[i].DN.annee < 1900));

        do
        {
            printf(" -Level:\t");
            scanf("%d", &T[i].Level);
        } while ((T[i].Level > 10) || (T[i].Level < 1));

        do
        {
            printf(" -Group:\t");
            scanf("%d", &T[i].Group);
        } while ((T[i].Group > 10) || (T[i].Group < 1));

        printf(" -Speciality:\t");
        scanf("%s", T[i].Specialty);

        do
        {
            printf(" -Moy Gen:\t");
            scanf("%f", &T[i].MoyGn);
        } while ((T[i].MoyGn > 20) || (T[i].MoyGn < 0));
    }
}

void Show_Data(struct Student T[20], int add)
{

    char grp[4];
    char ans1[2];
    int s;
    do
    {
        strcpy(ans1, "y");
        printf("\033[36m======================================================================================\033[0m\n\n");
        printf("\033[34m*What student you want to see ?: \033[0m");
        scanf("%d", &s);
        printf("\n +Student N%d (%s's) Data :\n", s, T[s].Name);
        printf("  -Name : \t%-15sLastname : \t%-15s\n", T[s].Name, T[s].LastName);
        if (add == 1)
        {
            printf("  -Adress : \t%d, %s, %s, %s\n", T[s].AD.Nu, T[s].AD.NomR, T[s].AD.NomV, T[s].AD.NomP);
        }
        printf("  -CIN  : \t%d\n", T[s].CIN);
        printf("  -Num Inscri : %d\n", T[s].Num);
        printf("  -Date de Naissance :  %d/%d/%d\n", T[s].DN.jour, T[s].DN.moisi, T[s].DN.annee);
        strncpy(grp, T[s].Specialty, 4);
        printf("  -Speciality : %-15s\tClasse : %4s %d%d\n", T[s].Specialty, grp, T[s].Level, T[s].Group);
        printf("  -Moyenne : \t%0.2f\n\n", T[s].MoyGn);
        printf("\033[36m======================================================================================\033[0m\n");
        printf(" \033[34m+Want to check another [y/n] ? :\033[0m");
        scanf("%s", ans1);
    } while (strcmp(ans1, "n"));
}

void B_students(int n, struct Student T[20])
{

    printf("\033[36m======================================================================================\033[0m\n\n");
    printf("\033[34mAll the student that there lastName starts with B :\033[0m\n\n");
    int test2 = 0;
    for (int i = 1; i <= n; i++)
    {
        if ((T[i].LastName[0] == 'B') || (T[i].LastName[0] == 'b'))
        {
            printf(" -LastName : %-15s\tName : %-15s\n", T[i].LastName, T[i].Name);
            test2 = 1;
        }
    }
    if (test2 == 0)
    {
        printf("\t\t0 Students\n");
    }
}

void Add_Adress(struct Student T[20])
{

    char ans2[2];
    int new;
    do
    {
        strcpy(ans2, "y");
        printf("\033[36m======================================================================================\033[0m\n\n");
        printf("\033[34m*What student you want to add an adress to? : \033[0m");
        scanf("%d", &new);
        printf("\n +Student N%d (%s's) adress : ", new, T[new].Name);
        printf("\n  -Num : \t");
        scanf("%d", &T[new].AD.Nu);
        printf("  -Street : \t");
        scanf("%s", T[new].AD.NomR);
        printf("  -City : \t");
        scanf("%s", T[new].AD.NomV);
        printf("  -Country : \t");
        scanf("%s", T[new].AD.NomP);
        printf("\n\n\033[36m======================================================================================\033[0m\n");
        printf(" \033[34m+Want to add to another [y/n] ? :\033[0m");
        scanf("%s", ans2);
    } while (strcmp(ans2, "n"));
}

int main(void)
{

    // get student info

    int n;
    struct Student T[20];
    int add = 0;
    do
    {
        printf("=> \033[31mNumber of Students?: \033[0m");
        scanf("%d", &n);
    } while ((n < 1) || (n > 20));

    Get_Data(n, T);

    // show student

    Show_Data(T, add);

    // show B students

    B_students(n, T);

    // add adress

    Add_Adress(T);
    add = 1;

    char ans3[2];
    printf("\033[36m======================================================================================\033[0m\n");
    printf("\n \033[34m+Want to check Students after update [y/n] ? :");
    scanf("%s", ans3);
    if (strcmp(ans3, "n"))
    {
        Show_Data(T, add);
    }

    printf("\n\n\033[32m======================================================================================\033[0m\n\n");
    printf("\t\t\t\033[1;32m*Thank You for using my Program*\n");
    printf("\t\t\t================================\033[0m\n\n\n");
}
