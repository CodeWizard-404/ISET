#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *next;
} Node;

void Inverser(Node **head) {
    Node *prev = NULL;
    Node *current = *head;
    Node *next = NULL;

    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    *head = prev;
}

void AjouterElement(Node **head, int data) {
    Node *newNode = (Node *) malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

void AfficherListe(Node *head) {
    Node *current = head;

    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }

    printf("\n");
}

int main() {
    Node *head = NULL;
    int n, valeur;
    printf("NB of Cells : ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("Elt %d : ", i+1);
        scanf("%d", &valeur);
        AjouterElement(&head, valeur);
    }

    printf("Liste originale: ");
    AfficherListe(head);

    Inverser(&head);

    printf("Liste inversee: ");
    AfficherListe(head);

    return 0;
}
 