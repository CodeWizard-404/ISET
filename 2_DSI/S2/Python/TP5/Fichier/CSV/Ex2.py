import csv

# 1. Ouvrir un fichier appelé nouveau-file.csv en mode écriture
with open('nouveau-file.csv', 'w', newline='') as file:
    fieldnames = ['Nom', 'Prenom', 'E-mail', 'Telephone']
    writer = csv.DictWriter(file, fieldnames=fieldnames)
    
    # 2. Créer un fichier CSV contenant les données du tableau
    writer.writeheader()
    writer.writerow({'Nom': 'ben sassi', 'Prenom': 'Sami', 'E-mail': 'sami@gmail.com', 'Telephone': '52535455'})
    writer.writerow({'Nom': 'TRABELSI', 'Prenom': 'Alya', 'E-mail': 'alya@gmail.com', 'Telephone': '97989654'})
    writer.writerow({'Nom': 'HARBAOUI', 'Prenom': 'Saloua', 'E-mail': 'saloua.harbaoui@gmail.com', 'Telephone': '53567789'})
    writer.writerow({'Nom': 'ALOUI', 'Prenom': 'sihem', 'E-mail': 'sihem.aloui@gmail.com', 'Telephone': '54566776'})
    
    # 3. Ajouter la ligne : Tlili,aroua,tlili.aroua@yahoo.fr,52565453 au fichier
    writer.writerow({'Nom': 'Tlili', 'Prenom': 'aroua', 'E-mail': 'tlili.aroua@yahoo.fr', 'Telephone': '52565453'})

# 4. Afficher les personnes dont le nom commence par S
with open('nouveau-file.csv', 'r') as file:
    reader = csv.DictReader(file)
    print("\nPersonnes dont le nom commence par S :")
    for row in reader:
        if row['Nom'].startswith('S'):
            print(row)