# Lecture du fichier
with open("transactions.txt", "r") as fichier:
    lignes = fichier.readlines()
    total_ventes = 0
    articles = {}

    # Parcours des lignes
    for ligne in lignes:
        ligne = ligne.strip()
        if ligne:
            id_article, prix, quantite = ligne.split(",")
            prix = int(prix)
            quantite = int(quantite)
            vente = prix * quantite
            total_ventes += vente
            articles[id_article] = prix
            print(f"Ligne : {ligne}")

    print(f"Total des ventes : {total_ventes}")
    print("Dictionnaire Articles :", articles)