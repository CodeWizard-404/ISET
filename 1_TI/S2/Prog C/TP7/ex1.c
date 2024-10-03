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

// Insertion position
struct Element *insertAtPosition(struct Element *List, int value, int position)
{
    if (position <= 1)
    {
        return insertAtList(List, value);
    }

    int currentPosition = 1;
    struct Element *current = List;
    while (currentPosition < position - 1 && current != NULL)
    {
        current = current->next;
        currentPosition++;
    }

    if (current == NULL)
    {
        printf("Invalid position!\n");
        return List;
    }

    struct Element *newElement = (struct Element *)malloc(sizeof(struct Element));
    newElement->value = value;
    newElement->next = current->next;
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

// Renvoie pointeur sur position
struct Element *getPointer(struct Element *List, int position)
{
    if (isEmpty(List))
    {
        return NULL;
    }

    int currentPosition = 1;
    struct Element *current = List;
    while (currentPosition < position && current != NULL)
    {
        current = current->next;
        currentPosition++;
    }

    if (current == NULL)
    {
        return NULL;
    }

    return current;
}

// Recherche / renvoie pointeur si existe
struct Element *search(struct Element *List, int value)
{
    struct Element *current = List;
    while (current != NULL && current->value != value)
    {
        current = current->next;
    }
    return current;
}

// Inversion
struct Element *reverse(struct Element *List)
{
    if (isEmpty(List))
    {
        return NULL;
    }
    struct Element *prev = NULL;
    struct Element *current = List;
    struct Element *next = NULL;
    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    return prev;
}

// Tri
struct Element *sort(struct Element *List)
{
    if (isEmpty(List))
    {
        return NULL;
    }
    int temp;
    struct Element *current = List;
    struct Element *index = NULL;
    while (current != NULL)
    {
        index = current->next;
        while (index != NULL)
        {
            if (current->value > index->value)
            {
                temp = current->value;
                current->value = index->value;
                index->value = temp;
            }
            index = index->next;
        }
        current = current->next;
    }
    return List;
}

int main()
{
    struct Element *myList;
    int option, value, position, point, search;

    do
    {
        printf("\n\n");
        printf("\n===============================\n");
        printf("\033[0;34m");
        printf("1 - Initialise the list\n");
        printf("2 - Check empty\n");
        printf("3 - Get the size of the list\n");
        printf("4 - Display the list\n");
        printf("5 - Insert at the beginning of the list\n");
        printf("6 - Insert at the end of the list\n");
        printf("7 - Insert at a specific position in the list\n");
        printf("8 - Delete at the beginning of the list\n");
        printf("9 - Delete at the end of the list\n");
        printf("10 - Delete at a specific position in the list\n");
        printf("11 - Send Pointer\n");
        printf("12 - Find if exist\n");
        printf("13 - Reverse the list\n");
        printf("14 - Sort the list\n");
        printf("0 - Exit\033[0m\n");
        printf("===============================\n");
        printf("\n\n\033[0;31mChoose an option=>\033[0m  ");
        scanf("%d", &option);
        printf("\033[2J");
        printf("\033[H");
        printf("\033[0;31mResult => \033[0m");
        switch (option)
        {
        case 1:
            myList=initialize();
            printf("List initialized");
            break;
        case 2:
            if (isEmpty(myList))
            {
                printf("Empty");
            }
            else
            {
                printf("Not Empty");
            }
            break;
        case 3:
            printf("The size of the list is: %d\n", size(myList));
            break;
        case 4:
            display(myList);
            break;
        case 5:
            printf("Enter the value to insert: ");
            scanf("%d", &value);
            myList = insertAtList(myList, value);
            break;
        case 6:
            printf("Enter the value to insert: ");
            scanf("%d", &value);
            myList = insertAtTail(myList, value);
            break;
        case 7:
            printf("Enter the value to insert: ");
            scanf("%d", &value);
            printf("Enter the position to insert: ");
            scanf("%d", &position);
            myList = insertAtPosition(myList, value, position);
            break;
        case 8:
            myList = deleteAtList(myList);
            break;
        case 9:
            myList = deleteAtTail(myList);
            break;
        case 10:
            printf("Enter the position to delete: ");
            scanf("%d", &position);
            myList = deleteAtPosition(myList, position);
            break;
        case 11:
            printf("Enter the position to point on: ");
            scanf("%d", &point);
            getPointer(myList, point);
            printf("Pointing at position %d", point);
            break;
        case 12:
            printf("Enter value to search: ");
            scanf("%d", &search);
            getPointer(myList, point);
            printf("Pointing at position %d", point);
            break;
        case 13:
            myList = reverse(myList);
            break;
        case 14:
            myList = sort(myList);
            break;
        case 0:
            printf("Exiting the program...\n");
            break;
        default:
            printf("Invalid option\n");
            break;
        }

    } while (option != 0);

    return 0;
}
