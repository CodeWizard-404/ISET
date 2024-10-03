EXERCICE 1
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
    struct cellule
{
    int info;
    struct cellule *suiv;
};
/*Déclaration du type Pile*/
typedef struct cellule *Pile;
/*Déclaration des fonctions*/
void Init(Pile *P);
void Empiler(Pile *P, int e);
void Depiler(Pile *P, int *e);
int PileVide(Pile P);
void Copie(Pile *P1, Pile *P2);
void Afficher(Pile P);
int Somme(Pile P);
int SommeRec(Pile P);
void Supprimer(Pile *P, int e);
/*Programme principal*/
main()
{
    Pile P = 0;
    Pile P1;
    int x, choix;

    do
    {
        system("cls");
        printf("\t 1- Initialiser la pile \n");
        printf("\t 2- Empiler un element \n");
        printf("\t 3- Depiler un element \n");
        printf("\t 4- Tester si la pile est vide ou non \n");
        printf("\t 5- Afficher \n");

        printf("\t 6- Somme \n");
        printf("\t 7- Somme Recursive \n");
        printf("\t 8- Supprimer un element \n");
        printf("\t 9- Quitter \n\n");

        printf("Entrer votre choix : ");
        scanf("%d", &choix);
        printf("\n\n");

        switch (choix)
        {
        case 1:
            Init(&P);
            break;
        case 2:
            printf("Donner un element : ");
            scanf("%d", &x);
            Empiler(&P, x);
            break;
        case 3:
            if (!PileVide(P))
            {
                Depiler(&P, &x);
                printf("l'elt depile est : %d \n", x);
            }
            else
                printf("PILE VIDE !!!\n");
            break;
        case 4:
            if (PileVide(P))
                printf("La pile est vide \n");
            else
                printf("Pile non vide \n");
            break;
        case 5:
            Copie(&P, &P1);
            printf("Les elts de la pile sont : \n");
            Afficher(P1);
            break;
        case 6:
            Copie(&P, &P1);
            printf("La somme est %d \n", Somme(P1));
            break;
        case 7:
            Copie(&P, &P1);
            printf("La somme est %d \n", SommeRec(P1));
            break;
        case 8:
            printf("Donner l'element a supprimer : ");
            scanf("%d", &x);
            Supprimer(&P, x);
            break;
        case 9:
            break;
        default:
            printf("Entrer un choix valide !!!!!");
            break;
        }
        getch();
    } while (choix != 9);
}
/*Définition des fonctions*/
void Init(Pile *P)
{
    *P = 0;
}
void Empiler(Pile *P, int e)
{
    Pile q;
    q = malloc(sizeof(struct cellule));
    q->info = e;
    q->suiv = *P;
    *P = q;
}
void Depiler(Pile *P, int *e)
{
    Pile q;
    if (*P)
    {
        *e = (*P)->info;
        q = *P;
        *P = (*P)->suiv;
        free(q);
        q = 0;
    }
}
int PileVide(Pile P)
{
    if (P == 0)
        return 1;
    else
        return 0;
}
void Copie(Pile *P1, Pile *P2)
{
    Pile q = 0;
    int e;
    *P2 = 0;
    while (*P1)
    {
        Depiler(P1, &e);
        Empiler(&q, e);
    }
    while (q)
    {
        Depiler(&q, &e);
        Empiler(P1, e);
        Empiler(P2, e);
    }
}
void Afficher(Pile P)
{
    int e;
    while (P)
    {
        Depiler(&P, &e);
        printf(" %d --", e);
    }
}

int Somme(Pile P)
{
    int s, e;
    s = 0;
    while (P)
    {
        Depiler(&P, &e);
        s = s + e;
    }
    return s;
}

int SommeRec(Pile P)
{
    int e;
    if (P == 0)
        return 0;
    else
    {
        Depiler(&P, &e);
        return (e + SommeRec(P));
    }
}
void Supprimer(Pile *P, int e)
{
    Pile q;
    int x, trouve;
    q = 0;
    trouve = 0;
    while ((*P) && !trouve)
    {
        Depiler(P, &x);
        if (x == e)
            trouve = 1;
        else
            Empiler(&q, x);
    }
    while (q)
    {
        Depiler(&q, &x);
        Empiler(P, x);
    }
}
EXERCICE 2
#include <stdio.h>
#include <stdlib.h>
    /*définition nouveaux types*/
    struct cellule
{
    char valeur;
    struct cellule *suivant;
};
typedef struct cellule *pile;
/*initialisation*/
pile initialiser(pile l)
{
    l = NULL;
    return l;
}
/*vide*/
int vide(pile p)
{
    if (p == NULL)
        return 1;
    else
        return 0;
}
/*empiler*/
pile empiler(pile l, char e)
{
    pile p;
    p = (pile)malloc(sizeof(struct cellule));
    p->valeur = e;
    p->suivant = l;
    l = p;
    return l;
}
/*dépiler*/
pile depiler(pile l)
{
    pile p;
    p = l;
    l = l->suivant;
    free(p);
    return l;
}
/*sommet*/
char sommet(pile p)
{
    return p->valeur;
}
/*afficher*/
void afficher(pile l)
{
    pile p;
    p = initialiser(p);
    while (vide(l) == 0)
    {
        p = empiler(p, sommet(l));
        printf("%c\n", sommet(l));
        l = depiler(l);
    }
    while (vide(p) == 0)
    {
        l = empiler(l, sommet(p));
        p = depiler(p);
    }
}
pile saisie(pile p)
{
    char x;
    p = initialiser(p);
    do
    {
        puts("donner un caractère");
        scanf(" %c", &x);
        if (x != '#')
            p = empiler(p, x);
    } while (x != '#');
    return p;
}
int anagramme(pile p1, pile p2)
{
    pile p;
    p = initialiser(p);
    while (vide(p1) == 0)
    {
        if (sommet(p1) == sommet(p2))
        {
            p1 = depiler(p1);
            p2 = depiler(p2);
        }
        else
        {
            while (vide(p2) == 0 && sommet(p1) != sommet(p2))
            {
                p = empiler(p, sommet(p2));
                p2 = depiler(p2);
            }
            if (vide(p2) == 1)
                return 0;
            else
            {
                p1 = depiler(p1);
                p2 = depiler(p2);
                while (vide(p) == 0)
                {
                    p2 = empiler(p2, sommet(p));
                    p = depiler(p);
                }
            }
        }
    }
    if (vide(p1) == 1 && vide(p2) == 1)
        return 1;
    else
        return 0;
}
/*fonction principale*/
int main(void)
{
    int rep;
    pile p1, p2;
    /*insertions*/
    puts("saisie p1");
    p1 = saisie(p1);
    puts("saisie p2");
    p2 = saisie(p2);
    /*affichage*/
    puts("affichage pile1");
    afficher(p1);
    puts("");
    /*affichage*/
    puts("affichage pile2");
    afficher(p2);
    puts("");
    rep = anagramme(p1, p2);
    if (rep == 1)
        puts("les 2 piles sont anagrammes");
    else
        puts("les 2 piles ne sont pas anagrammes");
    return 0;
}
EXERCICE 3
#include <stdio.h>
#include <stdlib.h>
    /*définition nouveaux types*/
    struct cellulep
{
    char valeur;
    struct cellulep *suivant;
};
typedef struct cellulep *pile;
struct cellulef
{
    char valeur;
    struct cellulef *suivant;
    struct cellulef *dernier;
};
typedef struct cellulef *file;
/*initialisation pile*/
pile initialiserp(pile l)
{
    l = NULL;
    return l;
}
/*initialisation file*/
file initialiserf(file f)
{
    f = NULL;
    return f;
}
/*videp*/
int videp(pile p)
{
    if (p == NULL)
        return 1;
    else
        return 0;
}
/*videf*/
int videf(file f)
{
    if (f == NULL)
        return 1;
    else
        return 0;
}
/*empiler*/
pile empiler(pile l, char e)
{
    pile p;
    p = (pile)malloc(sizeof(struct cellulep));
    p->valeur = e;
    p->suivant = l;
    l = p;
    return l;
}
/*enfiler*/
file enfiler(file f, char x)
{
    file p;
    p = (file)malloc(sizeof(struct cellulef));
    p->valeur = x;
    p->suivant = NULL;
    if (videf(f) == 1)
        f = p;
    else
        (f->dernier)->suivant = p;
    f->dernier = p;
    return f;
}
/*dépiler*/
pile depiler(pile l)
{
    pile p;
    p = l;
    l = l->suivant;
    free(p);
    return l;
}
/*défiler*/
file defiler(file l)
{
    file p;
    p = l;
    l = l->suivant;
    if (videf(l) == 0)
        l->dernier = p->dernier;
    free(p);
    return l;
}
/*sommet*/
char sommet(pile p)
{
    return p->valeur;
}
/*tête*/
char tete(file f)
{
    return f->valeur;
}
/*afficher*/
void afficherp(pile l)
{
    pile p;
    p = initialiserp(p);
    while (videp(l) == 0)
    {
        p = empiler(p, sommet(l));
        printf("%c\t", sommet(l));
        l = depiler(l);
    }
    while (videp(p) == 0)
    {
        l = empiler(l, sommet(p));
        p = depiler(p);
    }
}
/*affichage file*/
void afficherf(file l)
{
    file p;
    p = initialiserf(p);
    while (videf(l) == 0)
    {
        p = enfiler(p, tete(l));
        printf("%c\t", tete(l));
        l = defiler(l);
    }
    while (videf(p) == 0)
    {
        l = enfiler(l, tete(p));
        p = defiler(p);
    }
}
pile lireligne(pile p)
{
    char x;
    p = initialiserp(p);
    fflush(stdin);
    do
    {
        puts("donner un caractère");
        scanf(" %c", &x);
        p = empiler(p, x);
    } while (x != '$');
    return p;
}
pile convertirligne(pile p)
{
    file f;
    int i, cpt;
    f = initialiserf(f);
    /*traitement de $*/
    p = depiler(p);
    /*traitement des autres caractères*/
    while (videp(p) == 0)
    {
        if (sommet(p) != '%' && sommet(p) != '#')
        {
            f = enfiler(f, sommet(p));
            p = depiler(p);
        }
        else
        {
            if (sommet(p) == '%')
            {
                while (videp(p) == 0)
                    p = depiler(p);
            }
            else
            {
                if (sommet(p) == '#')
                {
                    cpt = 0;
                    while (videp(p) == 0 && sommet(p) == '#')
                    {
                        cpt++;
                        p = depiler(p);
                    }
                    i = 1;
                    while (videp(p) == 0 && i <= cpt)
                    {
                        p = depiler(p);
                        i++;
                    }
                }
            }
        }
    }
    while (videf(f) == 0)
    {
        p = empiler(p, tete(f));
        f = defiler(f);
    }
    return p;
}
/*fonction principale*/
int main(void)
{
    pile p;
    p = initialiserp(p);
    puts("Saisie ligne");
    p = lireligne(p);
    /*conversion*/
    puts("conversion");
    p = convertirligne(p);
    /*affichage*/
    afficherp(p);
    puts("");
    return 0;
}
EXERCICE 4
#include <stdio.h>
#include <stdlib.h>
    /*définition nouveaux types*/
    struct cellule
{
    int valeur;
    struct cellule *suivant;
};
typedef struct cellule *pile;
/*initialisation*/
pile initialiserpile(pile p)
{
    p = NULL;
    return p;
}
/*test vide*/
int videpile(pile p)
{
    if (p == NULL)
        return 1;
    else
        return 0;
}
/*empiler*/
pile empiler(pile p, int e)
{
    pile q;
    q = (pile)malloc(sizeof(struct cellule));
    q->valeur = e;
    q->suivant = p;
    p = q;
    return p;
}
/*dépiler*/
pile depiler(pile p)
{
    pile q;
    q = p;
    p = p->suivant;
    free(q);
    return p;
}
/*retour valeur sommet*/
int sommet(pile p)
{
    return p->valeur;
}
/*purger une pile*/
pile purger(pile p)
{
    pile p1, p2;
    p1 = initialiserpile(p1);
    p2 = initialiserpile(p2);
    /*traitement 1er entier*/
    p1 = empiler(p1, sommet(p));
    p = depiler(p);
    while (videpile(p) == 0)
    {
        while (videpile(p1) == 0 && sommet(p) != sommet(p1))
        {
            p2 = empiler(p2, sommet(p1));
            p1 = depiler(p1);
        }
        if (videpile(p1) == 1)
        {
            p1 = empiler(p1, sommet(p));
        }
        p = depiler(p);
        while (videpile(p2) == 0)
        {
            p1 = empiler(p1, sommet(p2));
            p2 = depiler(p2);
        }
    }
    return p1;
}
/*affichage attention dépiler va appliquer les free
donc pour ne pas perdre les entiers il faut les sauvegarder
dans p1 et les ré empiler dans p*/
void afficher(pile p)
{
    pile p1;
    p1 = initialiserpile(p1);
    while (videpile(p) == 0)
    {
        printf("%d\n", sommet(p));
        p1 = empiler(p1, sommet(p));
        p = depiler(p);
    }
    while (videpile(p1) == 0)
    {
        p = empiler(p, sommet(p1));
        p1 = depiler(p1);
    }
}
int main(void)
{
    pile p, p1;
    int N, i, x;
    /*initialisation*/
    p = initialiserpile(p);
    p1 = initialiserpile(p1);
    /*Saisie*/
    puts("saisie");
    do
    {
        printf("Donner le nombre d'entiers :");
        scanf("%d", &N);
    } while (N < 1);
    for (i = 1; i <= N; i++)
    {
        printf("Donner entier num(%d): ", i);
        scanf("%d", &x);
        p = empiler(p, x);
    }
    puts("");
    /*affichage*/
    puts("Affichage des entiers de la pile");
    afficher(p);
    /*purge*/
    p = purger(p);
    puts("Affichage apres purge");
    afficher(p);
    return 0;
}
EXERCICE 59
#include <stdio.h>
#include <stdlib.h>
    /*définition de nouveaux types*/
    struct cellule
{
    int valeur;
    struct cellule *suivant;
};
struct ffile
{
    struct cellule *tete;
    struct cellule *queue;
};
typedef struct ffile file;
/*initialisation*/
void initialiserfile(file *f)
{
    (*f).tete = NULL;
    (*f).queue = NULL;
}
/*test vide*/
int videfile(file f)
{
    if (f.tete == NULL)
        return 1;
    else
        return 0;
}
/*retour valeur de la tête*/
int tete(file f)
{
    return (f.tete)->valeur;
}
/*enfiler*/
void enfiler(file *f, int x)
{
    struct cellule *p;
    p = (struct cellule *)malloc(sizeof(struct cellule));
    p->valeur = x;
    p->suivant = NULL;
    if (videfile(*f) == 0)
        ((*f).queue)->suivant = p;
    else
        ((*f).tete) = p;
    (*f).queue = p;
}
/*défiler*/
void defiler(file *f)
{
    struct cellule *p;
    if (videfile(*f) == 0)
    {
        p = (*f).tete;
        (*f).tete = ((*f).tete)->suivant;
        free(p);
        if ((*f).tete == NULL)
            (*f).queue = NULL;
    }
}
void afficher(file *f)
{
    file f2;
    initialiserfile(&f2);
    while (videfile(*f) == 0)
    {
        printf("%d\t", ((*f).tete)->valeur);
        enfiler(&f2, ((*f).tete)->valeur);
        defiler(f);
    }
    *f = f2;
    puts("");
}
/*saisie*/
void saisir(file *f, int n)
{
    int i, x;
    for (i = 1; i <= n; i++)
    {
        printf("donner un entier :");
        scanf("%d", &x);
        enfiler(f, x);
    }
}
/*purger une pile*/
void purger(file *f)
{
    file f1, f2;
    initialiserfile(&f1);
    initialiserfile(&f2);
    /*traitement 1er entier*/
    enfiler(&f1, tete((*f)));
    defiler(f);
    while (videfile(*f) == 0)
    {
        while (videfile(f1) == 0 && tete(*f) != tete(f1))
        {
            enfiler(&f2, tete(f1));
            defiler(&f1);
        }
        if (videfile(f1) == 1)
            enfiler(&f2, tete(*f));
        defiler(f);
        while (videfile(f1) == 0)
        {
            enfiler(&f2, tete(f1));
            defiler(&f1);
        }
        while (videfile(f2) == 0)
        {
            enfiler(&f1, tete(f2));
            defiler(&f2);
        }
    }
    *f = f1;
}
int main(void)
{
    file f;
    int n;
    initialiserfile(&f);
    /*lecture de n*/
    do
    {
        printf("donner le nombre d'entiers: ");
        scanf("%d", &n);
    } while (n < 1);
    /*saisie*/
    saisir(&f, n);
    puts("Affichage initial");
    afficher(&f);
    puts("Affichage apres purge");
    purger(&f);
    afficher(&f);
    return 0;
}