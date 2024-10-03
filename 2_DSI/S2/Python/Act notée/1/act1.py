
# DSI 21
# GROUP 2

# Laghouanem Sofien
# Hamraoui Arij



import tkinter as tk  
from tkinter import messagebox 

# Dictionnaire pour stocker les articles avec leur code comme clé
articles = {}

# Dictionnaire pour stocker les clients avec leur code comme clé
clients = {}

# Dictionnaire pour stocker les commandes avec leur numéro comme clé
commandes = {}




# Fonction pour ajouter un client avec son code, nom et adresse
def ajouter_client(code, nom, adresse):
    if code not in clients:                                                                         # Vérifie si le code client n'existe pas déjà
        clients[code] = {'nom': nom, 'adresse': adresse, 'commandes': []}                           # Ajoute le client au dictionnaire clients
        return True                                                                                 # Retourne True si l'ajout est réussi
    else:
        return False                                                                                # Retourne False si le client existe déjà





# Fonction pour ajouter une commande avec le code client, numéro de commande et date de commande
def ajouter_commande(code_client, numero_commande, date_commande):
    if code_client in clients:                                                                                  # Vérifie si le code client existe
        commandes[numero_commande] = {'date': date_commande, 'articles': [], 'client': code_client}             # Ajoute la commande au dictionnaire commandes
        clients[code_client]['commandes'].append(numero_commande)                                               # Met à jour la liste des commandes du client
        return True                                                                                             # Retourne True si l'ajout est réussi
    else:
        return False                                                                                            # Retourne False si le client n'existe pas




# Fonction pour saisir des articles pour une commande spécifique
def saisir_articles_commande(numero_commande, code_article, quantite):
    if numero_commande in commandes and code_article in articles:                                               # Vérifie si la commande et l'article existent
        commandes[numero_commande]['articles'].append({'code_article': code_article, 'quantite': quantite})     # Ajoute l'article à la commande
        articles[code_article]['quantity'] -= quantite                                                          # Met à jour la quantité d'articles disponible
        return True                                                                                             # Retourne True si l'ajout est réussi
    else:
        return False                                                                                            # Retourne False si la commande ou l'article est introuvable





# Fonction pour calculer le total d'une commande
def calculer_total_commande(numero_commande):
    total = 0.0                                                                                                 # Initialise le total à 0
    if numero_commande in commandes:                                                                            # Vérifie si la commande existe
        for item in commandes[numero_commande]['articles']:                                                     # Parcourt les articles de la commande
            code_article = item['code_article']
            quantite = item['quantite']
            total += articles[code_article]['prix_unitaire'] * quantite                                         # Calcule le total en multipliant le prix unitaire par la quantité
    return total                                                                                                # Retourne le total calculé





# Fonction pour afficher les commandes d'un client
def afficher_commandes_client(code_client):
    if code_client in clients:                                                                                  # Vérifie si le client existe
        messagebox.showinfo("Commandes Client", get_commandes_client_text(code_client))                         # Affiche les commandes du client
    else:
        messagebox.showerror("Erreur", "Client introuvable.")                                                   # Affiche une erreur si le client est introuvable





# Fonction pour compter le nombre de commandes par client
def compter_commandes_par_client():
    compteur_commandes = {}                                                                                     # Initialise un dictionnaire pour stocker les compteurs de commandes
    for code_client, info_client in clients.items():                                                            # Parcourt les clients et leurs informations
        compteur_commandes[code_client] = len(info_client['commandes'])                                         # Compte le nombre de commandes pour chaque client
    return compteur_commandes                                                                                   # Retourne le dictionnaire de comptage





# Fonction pour afficher le nombre de commandes par client
def afficher_commandes_par_client():
    message = get_commandes_par_client_text()                                                                   # Récupère le texte à afficher
    messagebox.showinfo("Nombre de Commandes par Client", message)                                              # Affiche le nombre de commandes par client





def ajouter_nouveau_client():
    # Fonction interne pour valider les données du nouveau client
    def valider_nouveau_client():
        # Récupération des données saisies par l'utilisateur
        code = int(entry_code.get())
        nom = entry_nom.get()
        adresse = entry_adresse.get()
        # Appel de la fonction pour ajouter un client avec les données saisies
        if ajouter_client(code, nom, adresse):                                                                  # Vérifie si l'ajout du client est réussi
            messagebox.showinfo("Succès", "Nouveau client ajouté avec succès.")                                 # Affiche un message de succès
            nouveau_client_window.destroy()                                                                     # Ferme la fenêtre de saisie du nouveau client
        else:
            messagebox.showerror("Erreur", "Le client existe déjà.")                                            # Affiche une erreur si le client existe déjà

    # Création d'une nouvelle fenêtre pour saisir les informations du nouveau client
    nouveau_client_window = tk.Toplevel(root)
    nouveau_client_window.title("Nouveau Client") 
    nouveau_client_window.geometry("300x150")  

    # Création des libellés et champs de saisie pour le code, le nom et l'adresse du nouveau client
    label_code = tk.Label(nouveau_client_window, text="Code :")
    label_code.grid(row=0, column=0, padx=5, pady=5)
    entry_code = tk.Entry(nouveau_client_window)
    entry_code.grid(row=0, column=1, padx=5, pady=5)

    label_nom = tk.Label(nouveau_client_window, text="Nom :")
    label_nom.grid(row=1, column=0, padx=5, pady=5)
    entry_nom = tk.Entry(nouveau_client_window)
    entry_nom.grid(row=1, column=1, padx=5, pady=5)

    label_adresse = tk.Label(nouveau_client_window, text="Adresse :")
    label_adresse.grid(row=2, column=0, padx=5, pady=5)
    entry_adresse = tk.Entry(nouveau_client_window)
    entry_adresse.grid(row=2, column=1, padx=5, pady=5)

    # Bouton pour valider les informations du nouveau client
    button_valider = tk.Button(nouveau_client_window, text="Valider", command=valider_nouveau_client)
    button_valider.grid(row=3, column=0, columnspan=2, padx=5, pady=5)





def ajouter_nouveau_article():
    # Fonction interne pour valider les données du nouvel article
    def valider_nouveau_article():
        # Récupération des données saisies par l'utilisateur
        code = entry_code.get()
        label = entry_label.get()
        quantity = int(entry_quantity.get())
        prix_unitaire = float(entry_prix_unitaire.get())
        articles[code] = {'label': label, 'quantity': quantity, 'prix_unitaire': prix_unitaire}          # Ajout du nouvel article au dictionnaire des articles
        messagebox.showinfo("Succès", "Nouvel article ajouté avec succès.")                              # Affichage d'un message de succès
        nouveau_article_window.destroy()

    # Création d'une nouvelle fenêtre pour saisir les informations du nouvel article
    nouveau_article_window = tk.Toplevel(root)
    nouveau_article_window.title("Nouvel Article")                                                          
    nouveau_article_window.geometry("300x150")                                                              

    # Création des libellés et champs de saisie pour le code, le label, la quantité et le prix unitaire du nouvel article
    label_code = tk.Label(nouveau_article_window, text="Code :")
    label_code.grid(row=0, column=0, padx=5, pady=5)
    entry_code = tk.Entry(nouveau_article_window)
    entry_code.grid(row=0, column=1, padx=5, pady=5)

    label_label = tk.Label(nouveau_article_window, text="Label :")
    label_label.grid(row=1, column=0, padx=5, pady=5)
    entry_label = tk.Entry(nouveau_article_window)
    entry_label.grid(row=1, column=1, padx=5, pady=5)

    label_quantity = tk.Label(nouveau_article_window, text="Quantité :")
    label_quantity.grid(row=2, column=0, padx=5, pady=5)
    entry_quantity = tk.Entry(nouveau_article_window)
    entry_quantity.grid(row=2, column=1, padx=5, pady=5)

    label_prix_unitaire = tk.Label(nouveau_article_window, text="Prix Unitaire :")
    label_prix_unitaire.grid(row=3, column=0, padx=5, pady=5)
    entry_prix_unitaire = tk.Entry(nouveau_article_window)
    entry_prix_unitaire.grid(row=3, column=1, padx=5, pady=5)

    # Bouton pour valider les informations du nouvel article
    button_valider = tk.Button(nouveau_article_window, text="Valider", command=valider_nouveau_article)
    button_valider.grid(row=4, column=0, columnspan=2, padx=5, pady=5)







def ajouter_nouvelle_commande():
    # Fonction interne pour valider les données de la nouvelle commande
    def valider_nouvelle_commande():
        # Récupération des données saisies par l'utilisateur
        code_client = int(entry_code_client.get())
        numero_commande = int(entry_numero_commande.get())
        date_commande = entry_date_commande.get()
        # Appel de la fonction pour ajouter une commande avec les données saisies
        if ajouter_commande(code_client, numero_commande, date_commande):                                       # Vérifie si l'ajout de la commande est réussi
            messagebox.showinfo("Succès", "Nouvelle commande ajoutée avec succès.")                             # Affiche un message de succès
            nouvelle_commande_window.destroy()                                                                  # Ferme la fenêtre de saisie de la nouvelle commande
        else:
            messagebox.showerror("Erreur", "Le client n'existe pas.")                                           # Affiche une erreur si le client n'existe pas

    # Création d'une nouvelle fenêtre pour saisir les informations de la nouvelle commande
    nouvelle_commande_window = tk.Toplevel(root)
    nouvelle_commande_window.title("Nouvelle Commande")  
    nouvelle_commande_window.geometry("300x150")  

    # Création des libellés et champs de saisie pour le code client, le numéro de commande et la date de commande de la nouvelle commande
    label_code_client = tk.Label(nouvelle_commande_window, text="Code Client :")
    label_code_client.grid(row=0, column=0, padx=5, pady=5)
    entry_code_client = tk.Entry(nouvelle_commande_window)
    entry_code_client.grid(row=0, column=1, padx=5, pady=5)

    label_numero_commande = tk.Label(nouvelle_commande_window, text="Numéro de Commande :")
    label_numero_commande.grid(row=1, column=0, padx=5, pady=5)
    entry_numero_commande = tk.Entry(nouvelle_commande_window)
    entry_numero_commande.grid(row=1, column=1, padx=5, pady=5)

    label_date_commande = tk.Label(nouvelle_commande_window, text="Date de Commande :")
    label_date_commande.grid(row=2, column=0, padx=5, pady=5)
    entry_date_commande = tk.Entry(nouvelle_commande_window)
    entry_date_commande.grid(row=2, column=1, padx=5, pady=5)

    # Bouton pour valider les informations de la nouvelle commande
    button_valider = tk.Button(nouvelle_commande_window, text="Valider", command=valider_nouvelle_commande)
    button_valider.grid(row=3, column=0, columnspan=2, padx=5, pady=5)







# Fonction pour afficher une fenêtre de saisie des détails de l'article
def saisir_articles_commande_2():
    # Fonction interne appelée lors de la validation des détails de l'article saisis
    def on_submit():
        numero_commande = entry_commande.get()
        code_article = entry_article.get()
        quantite = entry_quantite.get()

        if numero_commande.isdigit() and quantite.isdigit():
            numero_commande = int(numero_commande)
            code_article = code_article
            quantite = int(quantite)
            if saisir_articles_commande(numero_commande, code_article, quantite):
                messagebox.showinfo("Succès", "Article ajouté à la commande avec succès.")
                window.destroy()
            else:
                messagebox.showerror("Erreur", "Commande ou article introuvable.")
        else:
            messagebox.showerror("Erreur", "Veuillez saisir des nombres entiers pour le numéro de commande et la quantité.")

    # Création d'une nouvelle fenêtre pour saisir les détails de l'article
    window = tk.Toplevel(root)
    window.title("Ajouter un article à la commande")
    window.geometry("300x150")

    label_commande = tk.Label(window, text="Numéro de commande:")
    label_commande.grid(row=0, column=0, padx=5, pady=5)
    entry_commande = tk.Entry(window)
    entry_commande.grid(row=0, column=1, padx=5, pady=5)

    label_article = tk.Label(window, text="Code de l'article:")
    label_article.grid(row=1, column=0, padx=5, pady=5)
    entry_article = tk.Entry(window)
    entry_article.grid(row=1, column=1, padx=5, pady=5)

    label_quantite = tk.Label(window, text="Quantité:")
    label_quantite.grid(row=2, column=0, padx=5, pady=5)
    entry_quantite = tk.Entry(window)
    entry_quantite.grid(row=2, column=1, padx=5, pady=5)

    # Ajout d'un bouton pour valider les détails de l'article saisis
    submit_button = tk.Button(window, text="Valider", command=on_submit)
    submit_button.grid(row=3, column=0, columnspan=2, padx=5, pady=5)




def afficher_tous_les_donnees():
    message = get_tous_les_donnees_text()                           # Récupère le texte contenant toutes les données à afficher
    messagebox.showinfo("Tous les Données", message)                # Affiche les données dans une boîte de dialogue







# Fonction pour afficher une fenêtre de saisie du code client
def get_client_code():
    # Fonction interne appelée lors de la validation du code client saisi
    def on_submit():
        code_client = entry.get()                                                                           # Récupère le code client saisi par l'utilisateur
        if code_client.isdigit():                                                                           # Vérifie si le code client est un nombre entier
            code_client = int(code_client)                                                                  # Convertit le code client en entier
            afficher_commandes_client(code_client)                                                          # Affiche les commandes du client correspondant
            window.destroy()                                                                                # Ferme la fenêtre de saisie du code client
        else:
            messagebox.showerror("Erreur", "Code client invalide. Veuillez saisir un nombre entier.")       # Affiche une erreur si le code client n'est pas un nombre entier

    # Création d'une nouvelle fenêtre pour saisir le code client
    window = tk.Toplevel(root)
    window.title("Entrez le code du client")  
    window.geometry("300x100") 

    label = tk.Label(window, text="Entrez le code du client :")
    label.grid(row=0, column=0, padx=5, pady=5)
    entry = tk.Entry(window)
    entry.grid(row=0, column=1, padx=5, pady=5)
    
    # Ajout d'un bouton pour valider le code client saisi
    submit_button = tk.Button(window, text="Valider", command=on_submit)
    submit_button.grid(row=1, column=0, columnspan=2, padx=5, pady=5)
    
    
    
    
    
    
    


# Fonction pour générer le texte des commandes d'un client spécifique
def get_commandes_client_text(code_client):
    # Initialise le texte résultant avec les informations du client
    result_text = "Client: {}\n".format(clients[code_client]['nom'])
    result_text += "Adresse: {}\n".format(clients[code_client]['adresse'])
    result_text += "--------------------------\n"
    # Parcourt les commandes du client pour les ajouter au texte résultant
    for numero_commande in clients[code_client]['commandes']:
        commande = commandes[numero_commande]
        total = calculer_total_commande(numero_commande)
        result_text += "Numéro de Commande: {}\n".format(numero_commande)
        result_text += "Date: {}\n".format(commande['date'])
        result_text += "Total: {:.2f}\n".format(total)
        result_text += "--------------------------\n"
    return result_text






# Fonction pour générer le texte du nombre de commandes par client
def get_commandes_par_client_text():
    result_text = ""
    # Parcourt tous les clients pour compter le nombre de commandes de chacun
    for code_client, info_client in clients.items():
        result_text += "Code Client: {}\n".format(code_client)
        result_text += "Nom Client: {}\n".format(info_client['nom'])
        result_text += "Nombre de Commandes: {}\n".format(len(info_client['commandes']))
        result_text += "--------------------------\n"
    return result_text







# Fonction pour générer le texte de toutes les données (clients, articles et commandes)
def get_tous_les_donnees_text():
    result_text = "Liste de tous les clients :\n\n"
    # Parcourt tous les clients pour ajouter leurs informations au texte résultant
    for code_client, info_client in clients.items():
        result_text += "Code Client: {}\n".format(code_client)
        result_text += "Nom Client: {}\n".format(info_client['nom'])
        result_text += "Adresse Client: {}\n".format(info_client['adresse'])
        result_text += "--------------------------\n"

    result_text += "\nListe de tous les articles :\n\n"
    # Parcourt tous les articles pour ajouter leurs informations au texte résultant
    for code_article, info_article in articles.items():
        result_text += "Code Article: {}\n".format(code_article)
        result_text += "Label Article: {}\n".format(info_article['label'])
        result_text += "Quantité Article: {}\n".format(info_article['quantity'])
        result_text += "Prix Unitaire Article: {:.2f}\n".format(info_article['prix_unitaire'])
        result_text += "--------------------------\n"

    result_text += "\nListe de toutes les commandes :\n\n"
    # Parcourt toutes les commandes pour ajouter leurs informations au texte résultant
    for numero_commande, info_commande in commandes.items():
        result_text += "Numéro de Commande: {}\n".format(numero_commande)
        result_text += "Date de Commande: {}\n".format(info_commande['date'])
        result_text += "Articles de la Commande:\n"
        for item in info_commande['articles']:
            result_text += "- Code Article: {}\n".format(item['code_article'])
            result_text += "- Quantité: {}\n".format(item['quantite'])
        result_text += "--------------------------\n"

    return result_text










# Initialisation des données fictives pour les articles, les clients et les commandes
articles = {
    "A1": {"label": "Article 1", "quantity": 10, "prix_unitaire": 5.0},
    "A2": {"label": "Article 2", "quantity": 15, "prix_unitaire": 8.0},
    "A3": {"label": "Article 3", "quantity": 20, "prix_unitaire": 12.0},
}

clients = {
    1: {'nom': 'Client 1', 'adresse': 'Adresse 1', 'commandes': {101: {'date': '2024-03-22', 'articles': [{'code_article': 'A1', 'quantite': 2}]}}},
    2: {'nom': 'Client 2', 'adresse': 'Adresse 2', 'commandes': {102: {'date': '2024-03-23', 'articles': [{'code_article': 'A2', 'quantite': 1}]}}},
}

commandes = {
    101: {'date': '2024-03-22', 'articles': [{'code_article': 'A1', 'quantite': 2}]},
    102: {'date': '2024-03-23', 'articles': [{'code_article': 'A2', 'quantite': 1}]},
}








# Partie Interface Utilisateur avec tkinter


# Fonction appelée lors du clic sur le bouton "Valider"
def on_click():
    choix = entry.get()                                                             # Récupère le choix de l'utilisateur depuis la zone de saisie
    if choix == "1":
        ajouter_nouveau_client()                                                    # Appelle la fonction pour ajouter un nouveau client
    elif choix == "2":
        ajouter_nouvelle_commande()                                                 # Appelle la fonction pour ajouter une nouvelle commande
    elif choix == "3":
        ajouter_nouveau_article()                                                   # Appelle la fonction pour ajouter un nouvel article
    elif choix == "4":
        afficher_commandes_par_client()                                             # Appelle la fonction pour afficher le nombre de commandes par client
    elif choix == "5":
        get_client_code()                                                           # Appelle la fonction pour afficher les commandes du client
    elif choix == "6":
        afficher_tous_les_donnees()                                                 # Appelle la fonction pour afficher toutes les données
    elif choix == "7":
        saisir_articles_commande_2()
    elif choix == "8":
        root.quit()                                                                 # Quitte l'application
    else:
        messagebox.showerror("Erreur", "Choix invalide. Veuillez réessayer.")       # Affiche une erreur si le choix est invalide



# Création de la fenêtre principale
root = tk.Tk()
root.title("Gestionnaire de Commandes")
root.geometry("600x500")


root.configure(bg="#1e1e1e")


title_label = tk.Label(root, text="Gestionnaire de Commandes", font=("Helvetica", 24, "bold"), bg="#1e1e1e", fg="#FFFFFF")
title_label.pack(pady=20)


subtitle_label = tk.Label(root, text="Choisissez une option :", font=("Helvetica", 16), bg="#1e1e1e", fg="#CCCCCC")
subtitle_label.pack(pady=10)

options = [
    "1. Ajouter un nouveau client",
    "2. Ajouter une nouvelle commande",
    "3. Ajouter un nouvel article",
    "4. Afficher le nombre de commandes par client",
    "5. Afficher les commandes d'un client",
    "6. Afficher toutes les données",
    "7. Saisir les articles commandés",
    "8. Quitter"
]


for option in options:
    option_label = tk.Label(root, text=option, font=("Helvetica", 14), bg="#1e1e1e", fg="#AAAAAA")
    option_label.pack(padx=100, anchor='w')


entry = tk.Entry(root, font=("Helvetica", 14), bd=2)
entry.pack(pady=20, ipadx=50)


button = tk.Button(root, text="Valider", command=on_click, bg="#4CAF50", fg="white", relief=tk.FLAT, font=("Helvetica", 16, "bold"))
button.pack(pady=10)

root.mainloop()