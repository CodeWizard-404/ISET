def saisir():
    with open("concours.txt", "w") as fichier:
        while True:
            ligne = input("Entrez les données du candidat (NCIN;NOM;PRENOM;AGE;DECISION) ou 'fin' pour terminer : ")
            if ligne.lower() == "fin":
                break
            fichier.write(ligne + "\n")

def admis():
    with open("concours.txt", "r") as fichier_source, open("admis.txt", "w") as fichier_cible:
        for ligne in fichier_source:
            champs = ligne.strip().split(";")
            if champs[-1] == "admis":
                fichier_cible.write(ligne)

def attente():
    with open("admis.txt", "r") as fichier_source, open("attente.txt", "w") as fichier_cible:
        for ligne in fichier_source:
            champs = ligne.strip().split(";")
            if int(champs[3]) > 30:
                fichier_cible.write(f"{champs[0]};{champs[1]} {champs[2]}\n")

def statistiques(dec):
    with open("concours.txt", "r") as fichier:
        lignes = fichier.readlines()
        total = len(lignes)
        count = sum(1 for ligne in lignes if ligne.strip().split(";")[-1] == dec)
        pourcentage = (count / total) * 100
        return pourcentage

def supprimer():
    with open("admis.txt", "r") as fichier_source, open("admis_temp.txt", "w") as fichier_cible:
        for ligne in fichier_source:
            champs = ligne.strip().split(";")
            if int(champs[3]) < 30:
                fichier_cible.write(ligne)
    with open("admis_temp.txt", "r") as fichier_source, open("admis.txt", "w") as fichier_cible:
        for ligne in fichier_source:
            fichier_cible.write(ligne)
            
            
            
            
exemple = """12345;nom1;prenom1;25;admis
67890;nom2;prenom2;35;admis
24680;nom3;prenom3;32;refuse
"""

with open("concours.txt", "w") as fichier:
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

# Check admis.txt after supprimer() function
with open("admis.txt", "r") as fichier:
    content = fichier.read()
    print("Contenu de admis.txt après suppression:")
    print(content)
