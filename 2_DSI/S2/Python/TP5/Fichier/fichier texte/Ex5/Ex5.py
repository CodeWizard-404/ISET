def mots_communs(fichier1, fichier2):
    with open(fichier1, "r") as f1, open(fichier2, "r") as f2:
        mots1 = set(ligne.strip().lower() for ligne in f1)
        mots2 = set(ligne.strip().lower() for ligne in f2)
        mots_communs = list(mots1 & mots2)
        return mots_communs

# Exemple d'utilisation
fichier1 = "fichier1.txt"
fichier2 = "fichier2.txt"
mots_communs = mots_communs(fichier1, fichier2)
print("Mots communs :", mots_communs)