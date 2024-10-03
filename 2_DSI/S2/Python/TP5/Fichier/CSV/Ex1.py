import csv

# 1. Ouvrir le fichier thé-info.csv en mode lecture
with open('thé-info.csv', 'r') as file:
    # 2. Utiliser csv.reader pour lire le contenu du fichier
    reader = csv.reader(file)
    
    # 3. Afficher le contenu du fichier
    print("Contenu du fichier :")
    for row in reader:
        print(row)
    
    # Réinitialiser le pointeur du fichier
    file.seek(0)
    
    # 4. Utiliser csv.DictReader pour lire le contenu du fichier
    reader = csv.DictReader(file)
    
    # 5. Afficher le dictionnaire obtenu
    print("\nDictionnaire obtenu :")
    for row in reader:
        print(row)