import csv
import os
import matplotlib.pyplot as plt
from collections import defaultdict
import datetime

class Produit:
    def __init__(self, prod_id, prod_nom, prod_prix, prod_qte, prod_dispo):
        self.prod_id = int(prod_id)
        self.prod_nom = prod_nom
        self.prod_prix = float(prod_prix)
        self.prod_qte = int(prod_qte)
        self.prod_dispo = prod_dispo == 'oui'
    
    def __str__(self):
        return f"{self.prod_id};{self.prod_nom};{self.prod_prix};{self.prod_qte};{'oui' if self.prod_dispo else 'non'}"

class Client:
    def __init__(self, cli_id, cli_raison_sociale, cli_adresse, cli_ville, cli_tel):
        self.cli_id = int(cli_id)
        self.cli_raison_sociale = cli_raison_sociale
        self.cli_adresse = cli_adresse
        self.cli_ville = cli_ville
        self.cli_tel = cli_tel

    def __str__(self):
        return f"{self.cli_id};{self.cli_raison_sociale};{self.cli_adresse};{self.cli_ville};{self.cli_tel}"

class Commande:
    def __init__(self, com_id, cli_id, date):
        self.com_id = int(com_id)
        self.cli_id = int(cli_id)
        self.date = date

    def __str__(self):
        return f"{self.com_id};{self.cli_id};{self.date}"
    
    
def creerCommandes():
    """
    Cree le fichier CSV commandes.csv avec le contenu specifie.
    """
    lignes = [
        "com_id;cli_id;DATE",
        "1;1;12/05/2024",
        "3;2;13/05/2024",
        "4;3;13/05/2024",
        "4;4;20/04/2024",
        "5;1;20/04/2024",
        "6;6;25/04/2024",
        "7;7;25/04/2024",
        "8;1;30/04/2024",
        "9;9;30/04/2024",
        "10;8;30/04/2024",
        "11;4;01/05/2024",
        "12;10;02/05/2024",
        "13;1;03/05/2024",
        "14;1;04/05/2024"
    ]

    with open('commandes.csv', 'w', newline='', encoding='utf-8') as f:
        for ligne in lignes:
            f.write(ligne + '\n')


def ouvrir(fichier, mode='r', encoding='utf-8'):
    """
    Ouvre un fichier CSV.
    
    :param fichier: Nom du fichier a ouvrir.
    :param mode: Mode d'ouverture du fichier (par defaut 'r').
    :param encoding: Encodage du fichier (par defaut 'utf-8').
    :return: L'objet fichier ouvert ou None si le fichier est introuvable.
    """
    try:
        return open(fichier, mode, newline='', encoding=encoding)
    except FileNotFoundError:
        print("Fichier introuvable")
        return None
    except UnicodeDecodeError:
        print("Erreur d'encodage, reessayez avec un autre encodage.")
        return None

def lirelignes(obj_fichier):
    """
    Lit toutes les lignes d'un fichier CSV.
    
    :param obj_fichier: L'objet fichier ouvert.
    :return: Une liste de toutes les lignes du fichier.
    """
    with obj_fichier:
        reader = csv.reader(obj_fichier, delimiter=';')
        return list(reader)

def afficherlignes(lignes):
    """
    Affiche les lignes d'une liste de maniere formatee.
    
    :param lignes: Liste des lignes a afficher.
    """
    headers = lignes[0]
    for ligne in lignes[1:]:
        for i, value in enumerate(ligne):
            print(f"{headers[i]} : {value}")
        print("************************************************")

def modifierQte(prod_id, quantite):
    """
    Modifie la quantite d'un produit et met a jour sa disponibilite si necessaire.
    
    :param prod_id: ID du produit a modifier.
    :param quantite: Quantite a deduire du stock.
    """
    produits = []
    with ouvrir('PRODUIT.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader)  
        produits = [Produit(*row) for row in reader]

    for produit in produits:
        if produit.prod_id == prod_id:
            produit.prod_qte -= quantite
            if produit.prod_qte <= 0:
                produit.prod_qte = 0
                produit.prod_dispo = False
            break

    with ouvrir('PRODUIT.csv', 'w', encoding='latin1') as f:
        writer = csv.writer(f, delimiter=';')
        for produit in produits:
            writer.writerow([produit.prod_id, produit.prod_nom, produit.prod_prix, produit.prod_qte, 'oui' if produit.prod_dispo else 'non'])


def ajouterLigneCommande(com_id, prod_id, qte_commande):
    """
    Ajoute une ligne au fichier DETAILS_COMMANDE si le produit et la quantite sont disponibles.
    
    :param com_id: Numero de la commande.
    :param prod_id: Code du produit.
    :param qte_commande: Quantite commandee.
    """
    produits = []
    with ouvrir('PRODUIT.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        produits = [Produit(*row) for row in reader]

    produit_trouve = next((p for p in produits if p.prod_id == prod_id), None)
    
    if produit_trouve and produit_trouve.prod_dispo and produit_trouve.prod_qte >= qte_commande:
        with ouvrir('DETAILS_COMMANDE.csv', 'a', encoding='latin1') as f:
            writer = csv.writer(f, delimiter=';')
            writer.writerow([com_id, prod_id, qte_commande, produit_trouve.prod_prix * qte_commande])
        modifierQte(prod_id, qte_commande)

def totalCommande():
    """
    Affiche le total de chaque commande.
    """
    commandes = {}
    with ouvrir('DETAILS_COMMANDE.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader) 
        for row in reader:
            com_id = int(row[0])
            total = float(row[3])
            if com_id in commandes:
                commandes[com_id] += total
            else:
                commandes[com_id] = total

    for com_id, total in commandes.items():
        print(f"Num Commande : {com_id}, Total = {total}")
        
        

def ventes_par_produit():
    ventes = defaultdict(int)
    with open('DETAILS_COMMANDE.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader) 
        for row in reader:
            prod_id = int(row[1])
            qte_commande = int(row[2])
            ventes[prod_id] += qte_commande

    produits = []
    quantites = []

    with open('PRODUIT.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader)  
        for row in reader:
            prod_id = int(row[0])
            prod_nom = row[1]
            produits.append(prod_nom)
            quantites.append(ventes[prod_id])

    plt.figure(figsize=(10, 6))
    plt.bar(produits, quantites, color='blue')
    plt.xlabel('Produits')
    plt.ylabel('Quantité vendue')
    plt.title('Nombre de ventes par produit')
    plt.xticks(rotation=45, ha='right')
    plt.tight_layout()
    plt.show()


def commandes_par_date():
    commandes = defaultdict(int)
    with open('commandes.csv', 'r', encoding='utf-8') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader) 
        for row in reader:
            date = row[2]
            commandes[date] += 1

    dates = list(commandes.keys())
    commandes_par_date = list(commandes.values())

    dates = [datetime.datetime.strptime(date, '%d/%m/%Y').date() for date in dates]
    dates.sort()

    plt.figure(figsize=(10, 6))
    plt.plot(dates, commandes_par_date, marker='o', linestyle='-', color='red')
    plt.xlabel('Dates')
    plt.ylabel('Nombre de commandes')
    plt.title('Nombre de commandes par date')
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()

        
def commandes_par_client():
    commandes = defaultdict(int)
    with open('commandes.csv', 'r', encoding='utf-8') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader) 
        for row in reader:
            cli_id = int(row[1])
            commandes[cli_id] += 1

    clients = []
    nb_commandes = []

    with open('clients.csv', 'r', encoding='latin1') as f:
        reader = csv.reader(f, delimiter=';')
        next(reader)
        for row in reader:
            cli_id = int(row[0])
            cli_nom = row[1]
            clients.append(cli_nom)
            nb_commandes.append(commandes[cli_id])

    plt.figure(figsize=(10, 6))
    plt.bar(clients, nb_commandes, color='green')
    plt.xlabel('Clients')
    plt.ylabel('Nombre de commandes')
    plt.title('Nombre de commandes par client')
    plt.xticks(rotation=45, ha='right')
    plt.tight_layout()
    plt.show()





# Test des fonctions
if __name__ == "__main__":
    # Test de la fonction creerCommandes
    creerCommandes()

    # Test de la fonction ouvrir
    csvfile = ouvrir('clients.csv', 'a+', encoding='latin1')
    csvfile = ouvrir('prod.csv', encoding='latin1')
    
    # Test de la fonction lirelignes
    csvfile = ouvrir('clients.csv', encoding='latin1')
    if csvfile:
        lignes = lirelignes(csvfile)
        print(lignes)

    # Test de la fonction afficherlignes
    csvfile = ouvrir('clients.csv', encoding='latin1')
    if csvfile:
        lignes = lirelignes(csvfile)
        afficherlignes(lignes)
    
    # Test de la fonction modifierQte
    modifierQte(7, 20)
    
    # Test de la fonction ajouterLigneCommande
    ajouterLigneCommande(15, 3, 2)
    
    # Test de la fonction totalCommande
    totalCommande()
    
    # Test des courbes
    ventes_par_produit()
    commandes_par_date()
    commandes_par_client()
