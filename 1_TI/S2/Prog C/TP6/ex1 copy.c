#include <stdio.h>
#include <stdlib.h>

struct cellule
{
     int info;
     struct cellule *suiv;
};

typedef struct cellule *Liste;

void AjoutTete(Liste *L, int e);
void AjoutQueue(Liste *L, int e);
void Creer(Liste *L);
void Affiche(Liste L);
Liste AccessPos(Liste L, int k);
void AjoutPos(Liste *L, int e, int k);
int Occurence(Liste L, int e);
void SuppTete(Liste *L);
void SuppQueue(Liste *L);
void SuppPos(Liste *L, int k);
void SuppVal(Liste *L, int x);

int main()
{
     Liste L = NULL;
     int x, nb, choix, val, pos;

     do
     {
          printf("\n \n \n");
          printf("1- Creer la liste \n");
          printf("2- Afficher la liste \n");
          printf("3- Ajout tete \n");
          printf("4- Ajout queue \n");
          printf("5- Ajout Pos \n");
          printf("6- Nbre Occurences \n");
          printf("7- Suppression tete \n");
          printf("8- Suppression Queue \n");
          printf("9- Suppression Pos \n");
          printf("10- Suppression val \n");
          printf("11- Quitter \n");

          printf("\n Entrer votre choix :");
          scanf("%d", &choix);

          switch (choix)
          {
          case 1:
               printf("Donner les elements de la liste :\n");
               Creer(&L);
               break;
          case 2:
               printf("Les elements de la liste sont :\n");
               Affiche(L);
               break;
          case 3:
               printf("donner un entier : ");
               scanf("%d", &x);
               AjoutTete(&L, x);
               break;
          case 4:
               printf("donner un entier : ");
               scanf("%d", &x);
               AjoutQueue(&L, x);
               break;
          case 5:
               printf("donner un entier : ");
               scanf("%d", &x);
               printf("donner une position : ");
               scanf("%d", &pos);
               AjoutPos(&L, x, pos);
               break;
          case 6:
               printf("donner un entier : ");
               scanf("%d", &x);
               nb = Occurence(L, x);
               printf("Le nombre d'occurences est %d \n", nb);
               break;
          case 7:
               SuppTete(&L);
               break;
          case 8:
               SuppQueue(&L);
               break;
          case 9:
               printf("donner une position : ");
               scanf("%d", &pos);
               SuppPos(&L, pos);
               break;
          case 10:
               printf("donner une valeur : ");
               scanf("%d", &val);
               SuppVal(&L, val);
               break;
          case 11:
               break;
          default:
               printf("Choix non valide !!!! \n");
          }
     } while (choix != 11);

     return 0;
}

void AjoutTete(Liste *L, int e)
{
     Liste p;
     p=malloc(sizeof(struct cellule));
     p->info=e;
     p->suiv=*L;
     *L=p;
}

void AjoutQueue(Liste *L, int e)
{
     Liste p,q;
     if(*L==0)
     {
          AjoutTete(L,e);
     }
     else
     {
         p=*L;
         while(p->suiv)
             p=p->suiv;
         
         q=malloc(sizeof(struct cellule));
         q->info=e;
         q->suiv=0;
         p->suiv=q;
     }
}

void Creer(Liste *L)
{
     int i;
     int x,choix;
     do
      {
              printf("Donner un element : ");
              scanf("%d",&x);
              AjoutQueue(L,x);
              printf("Voulez vous ajouter un element  (0/1) : ");
              scanf("%d",&choix);
      }while(choix);
}

void Affiche(Liste L)
{
     Liste p=L;
     printf("\n Les elements de la liste sont : \n\n \t");
     while(p)
     {
             printf("%d ==> ",p->info);
             p=p->suiv;
     }
     printf("******Fin*******\n \n");
}


Liste AccessPos(Liste L, int k)
{
    Liste p = L;
    int i = 1;
    while((p != NULL)&&(i < k))
    {
        p = p->suiv;
        i++;
    }
    if(p == NULL)
    {
        printf("Erreur: Position invalide!\n");
        return NULL;
    }
    else
    {
        return p;
    }
}


void AjoutPos(Liste *L, int e, int k)
{
    int i;
    Liste p, q;

    if (k == 1) {
        AjoutTete(L, e);
    } else {
        p = AccessPos(*L, k-1);
        if (p != NULL) {
            q = malloc(sizeof(struct cellule));
            q->info = e;
            q->suiv = p->suiv;
            p->suiv = q;
        } else {
            printf("Erreur: Position invalide!\n");
        }
    }
}

int Occurence(Liste L, int e)
{
     Liste p = L;
     int cpt = 0;
     while (p != NULL)
     {
          if (p->info == e)
          {
               cpt++;
          }
          p = p->suiv;
     }
     return cpt;
}

void SuppTete(Liste *L)
{
     Liste p = *L;
     if (*L != NULL)
     {
          *L = (*L)->suiv;
          free(p);
     }
}

void SuppQueue(Liste *L)
{
     Liste p = *L;
     if (*L != NULL)
     {
          if ((*L)->suiv == NULL)
          {
               *L = NULL;
               free(p);
          }
          else
          {
               while ((p->suiv)->suiv != NULL)
               {
                    p = p->suiv;
               }
               free(p->suiv);
               p->suiv = NULL;
          }
     }
}

void SuppPos(Liste *L, int k)
{
     Liste p, q;
     if (k == 1)
     {
          SuppTete(L);
     }
     else
     {
          p = AccessPos(*L, k - 1);
          if (p != NULL)
          {
               q = p->suiv;
               if (q != NULL)
               {
                    p->suiv = q->suiv;
                    free(q);
               }
          }
     }
}

void SuppVal(Liste *L, int x)
{
     Liste p = *L;
     Liste q = NULL;
     while ((p != NULL) && (p->info != x))
     {
          q = p;
          p = p->suiv;
     }
     if (p != NULL)
     {
          if (q != NULL)
          {
               q->suiv = p->suiv;
          }
          else
          {
               *L = p->suiv;
          }
          free(p);
     }
}