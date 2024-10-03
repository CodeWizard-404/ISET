import csv

def saisir():
    with open("concours.csv", "w", newline='') as fichier:
        writer = csv.writer(fichier, delimiter=';')
        while True:
            ligne = input("Entrez les données du candidat (NCIN;NOM;PRENOM;AGE;DECISION) ou 'fin' pour terminer : ")
            if ligne.lower() == "fin":
                break
            writer.writerow(ligne.split(';'))

def admis():
    with open("concours.csv", "r", newline='') as fichier_source, open("admis.csv", "w", newline='') as fichier_cible:
        reader = csv.reader(fichier_source, delimiter=';')
        writer = csv.writer(fichier_cible, delimiter=';')
        for ligne in reader:
            if ligne[-1] == "admis":
                writer.writerow(ligne)

def attente():
    with open("admis.csv", "r", newline='') as fichier_source, open("attente.csv", "w", newline='') as fichier_cible:
        reader = csv.reader(fichier_source, delimiter=';')
        writer = csv.writer(fichier_cible, delimiter=';')
        for ligne in reader:
            if int(ligne[3]) > 30:
                writer.writerow([ligne[0], f"{ligne[1]} {ligne[2]}"])

def statistiques(dec):
    with open("concours.csv", "r", newline='') as fichier:
        reader = csv.reader(fichier, delimiter=';')
        lignes = list(reader)
        total = len(lignes)
        count = sum(1 for ligne in lignes if ligne[-1] == dec)
        pourcentage = (count / total) * 100
        return pourcentage

def supprimer():
    with open("admis.csv", "r", newline='') as fichier_source, open("admis_temp.csv", "w", newline='') as fichier_cible:
        reader = csv.reader(fichier_source, delimiter=';')
        writer = csv.writer(fichier_cible, delimiter=';')
        for ligne in reader:
            if int(ligne[3]) < 30:
                writer.writerow(ligne)
    with open("admis_temp.csv", "r", newline='') as fichier_source, open("admis.csv", "w", newline='') as fichier_cible:
        reader = csv.reader(fichier_source, delimiter=';')
        writer = csv.writer(fichier_cible, delimiter=';')
        for ligne in reader:
            writer.writerow(ligne)
            
            
            
            
exemple = """12345;nom1;prenom1;25;admis
67890;nom2;prenom2;35;admis
24680;nom3;prenom3;32;refuse
"""

with open("concours.csv", "w", newline='') as fichier:
    fichier.write(exemple)

# Test saisir() function
saisir()

# Test admis() function
admis()

# Test attente() function
attente()

# Test statistiques() function for "admis"
pourcentage_admis = statistiques("admis")
print("Pourcentage d'admis:", pourcentage_admis)

# Test statistiques() function for "refuse"
pourcentage_refuse = statistiques("refuse")
print("Pourcentage de refus:", pourcentage_refuse)

# Test supprimer() function
supprimer()

# Check admis.csv after supprimer() function
with open("admis.csv", "r") as fichier:
    content = fichier.read()
    print("Contenu de admis.csv après suppression:")
    print(content)
