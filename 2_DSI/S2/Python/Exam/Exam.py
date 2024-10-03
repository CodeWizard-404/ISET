#6 Class Pilote

class Pilote:
    def __init__(self, nom, prenom, adresse):
        self.nom = nom
        self.prenom = prenom
        self.adresse = adresse

#1 Class Vol_direct

class Vol_direct:
    def __init__(self, nom, dep, arr, jour, heure, distance):
        self.nom = nom
        self.dep = dep
        self.arr = arr
        self.jour = jour
        self.heure = heure
        self.distance = distance
        self.pilote = None


#2/7 Redefinir la méthode __str__() 

    def __str__(self):
        if self.pilote:
            return f"Ce vol part de '{self.dep}' vers '{self.arr}' le '{self.jour}' à {self.heure} heure, la distance est de {self.distance} miles. Le pilote est {self.pilote.nom} {self.pilote.prenom}"
        else:
            return f"Ce vol part de '{self.dep}' vers '{self.arr}' le '{self.jour}' à {self.heure} heure, la distance est de {self.distance} miles."


#3 Class Vols

class Vols:
    def __init__(self, vols):
        self.vols = vols

#4 Méthode Liste_successeurs 

    def Liste_successeurs(self, ville):
        successeurs = []
        for vol in self.vols:
            if vol.dep == ville and vol.arr not in successeurs:
                successeurs.append(vol.arr)
        return successeurs

#5 Méthode Appartient

    def Appartient(self, ville):
        for vol in self.vols:
            if vol.dep == ville or vol.arr == ville:
                return True
        return False

#6 Méthode Piloter

    def Piloter(self, vol, pilote):
        vol.pilote = pilote

    def __str__(self):
        return f"Le pilote est {self.vols[0].pilote}"

#8 Méthode Affiche

    def Affiche(self):
        for vol in self.vols:
            print(vol)

#9/a Fonction saisir_jour
def saisie_Jour():
    jours = ["lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"]
    while True:
        jour = input("Entrez un jour de la semaine : ").lower()
        if jour in jours:
            return jour
        else:
            print("ERROR: Jour incorrect !")

#9/a Fonction saisir_heure
def saisie_Heure():
    while True:
        heure = input("Entrez une heure (entre 00 et 23) : ")
        if heure.isdigit() and 00 <= int(heure) <= 23:
            return int(heure)
        else:
            print("ERROR: Heur incorrect !")

#9/a Fonction saisir_ville
def saisie_ville():
    villes = ["Tunis", "Djerba", "Sfax", "Sousse", "Monastir"]
    while True:
        ville = input("Entrez une ville : ").capitalize()
        if ville in villes:
            return ville
        else:
            print("ERROR: Ville incorrect !")
            
            
#6 Fonction Saisie_Pilote          
def Saisie_Pilote():
    nom = input("Entrez le nom du pilote : ")
    prenom = input("Entrez le prénom du pilote : ")
    adresse = input("Entrez l'adresse du pilote : ")
    return Pilote(nom, prenom, adresse)

# Programme principal
LV = []

n = int(input("Entrez le nombre de vols : "))
for i in range(n):
    nom_vol = input(f"Entrez le nom du vol {i+1} : ")
    dep = saisie_ville()
    arr = saisie_ville()
    while arr == dep:
        print("ERROR: Ville de départ et d'arrivée ne peuvent pas être les mêmes !")
        arr = saisie_ville()
    jour = saisie_Jour()
    heure = saisie_Heure()
    distance = float(input("Entrez la distance : "))
    LV.append(Vol_direct(nom_vol, dep, arr, jour, heure, distance))

#9/b objet Vol

V = Vols(LV)

#9/b List vols

print("Tous les vols disponibles :")
V.Affiche()

pilote = Saisie_Pilote()

V.Piloter(LV[0], pilote)

V.Affiche()

#9/c ville qui doit appartenir au plan du vol

ville = saisie_ville()
if V.Appartient(ville):
    successeurs = V.Liste_successeurs(ville)
    print(f"Les villes successeurs de {ville} sont : {successeurs}")
else:
    print(f"{ville} n'appartient pas au plan de vol.")
