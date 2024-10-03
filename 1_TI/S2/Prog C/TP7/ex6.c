#include <stdio.h>
#include <stdlib.h>

struct Element
{
    int value;
    struct Element *next;
};

// Initialisation
struct Element *initialize()
{
    return NULL;
}

// Vide
int isEmpty(struct Element *List)
{
    return List == NULL;
}

// Taille
int size(struct Element *List)
{
    int count = 0;
    struct Element *current = List;
    while (current != NULL)
    {
        count++;
        current = current->next;
    }
    return count;
}

// Affichage liste
void display(struct Element *List)
{
    struct Element *current = List;
    while (current != NULL)
    {
        printf("%d -> ", current->value);
        current = current->next;
    }
    printf("NULL\n");
}

// Insertion tête
struct Element *insertAtList(struct Element *List, int value)
{
    struct Element *newElement = (struct Element *)malloc(sizeof(struct Element));
    newElement->value = value;
    newElement->next = List;
    return newElement;
}

// Insertion queue
struct Element *insertAtTail(struct Element *List, int value)
{
    struct Element *newElement = (struct Element *)malloc(sizeof(struct Element));
    newElement->value = value;
    newElement->next = NULL;

    if (isEmpty(List))
    {
        return newElement;
    }

    struct Element *current = List;
    while (current->next != NULL)
    {
        current = current->next;
    }
    current->next = newElement;
    return List;
}

// Suppression tête
struct Element *deleteAtList(struct Element *List)
{
    if (isEmpty(List))
    {
        return NULL;
    }

    struct Element *newList = List->next;
    free(List);
    return newList;
}

// Suppression queue
struct Element *deleteAtTail(struct Element *List)
{
    if (isEmpty(List))
    {
        return NULL;
    }

    if (List->next == NULL)
    {
        free(List);
        return NULL;
    }

    struct Element *current = List;
    while (current->next->next != NULL)
    {
        current = current->next;
    }
    free(current->next);
    current->next = NULL;
    return List;
}

// Suppression position
struct Element *deleteAtPosition(struct Element *List, int position)
{
    if (isEmpty(List))
    {
        return NULL;
    }
    if (position <= 1)
    {
        return deleteAtList(List);
    }

    int currentPosition = 1;
    struct Element *current = List;
    while (currentPosition < position - 1 && current->next != NULL)
    {
        current = current->next;
        currentPosition++;
    }

    if (current->next == NULL)
    {
        printf("Invalid position!\n");
        return List;
    }

    struct Element *elementToDelete = current->next;
    current->next = elementToDelete->next;
    free(elementToDelete);
    return List;
}

void Union_Intersection(struct Element **L1, struct Element **L2)
{
    struct Element *current2 = *L2;

    while (current2 != NULL)
    {
        int value2 = current2->value;
        struct Element *current1 = *L1;
        int found = 0;

        while (current1 != NULL)
        {
            if (current1->value == value2)
            {
                found = 1;
                break;
            }
            current1 = current1->next;
        }    

        if (!found)     
        {
            *L1 = insertAtTail(*L1, value2);
            *L2 = deleteAtPosition(*L2, 1);
        }
        else
        {
            *L2 = deleteAtPosition(*L2, 1);
        }

        current2 = *L2;
    }
}

int main()
{
    struct Element *L1 = initialize();
    struct Element *L2 = initialize();

    printf("Enter values for list L1, separated by spaces (0 to stop): ");
    int value;
    while (scanf("%d", &value) == 1 && value != 0)
    {
        L1 = insertAtTail(L1, value);
    }

    printf("Enter values for list L2, separated by spaces (0 to stop): ");
    while (scanf("%d", &value) == 1 && value != 0)
    {
        L2 = insertAtTail(L2, value);
    }

    printf("Initial L1: ");
    display(L1);
    printf("Initial L2: ");
    display(L2);

    Union_Intersection(&L1, &L2);

    printf("Final L1 (union): ");
    display(L1);
    printf("Final L2 (intersection): ");
    display(L2);

    return 0;
}