
# Liste des gouvernorats avec leurs coordonnées (latitude, longitude)
gouvernorats=[["Ariana",36.86250,10.19556],["Beja",36.73333,9.18333],["Ben Arous", 36.75333,10.2222],["Bizerte",37.29,9.87],["Gabes",33.88333,10.11667],["Gafsa",34.42500,8.78417],[ "Jendouba",36.50111,8.77944],["Kairouan",35.68,10.10],["Kasserine",35.18,8.83],["Kebili ",33.70194,8.97361],["Le kef",36.19,8.71],["Mahdia" ,35.52,11.07],["Manouba",36.80778,10.10111], ["Medenine",33.35,10.49], ["Monastir",35.79,10.82], ["Nabeul",36.45000,10.73333], ["Sfax", 34.74056,10.76028], ["Sidi Bouzid" ,35.04028,	9.49361], ["Siliana",36.08333, 9.36667], ["Sousse",	35.82556,10.64111], ["Tatouine",32.93333,10.45000],["Tozeur",33.93,8.13],["Tunis", 36.80278,10.17972],["Zaghouan",36.40,10.14]]

import math

# Fonction pour vérifier si la liste est triée par nom
def verify_order(communes):
    """
    Vérifie si la liste de gouvernorats est triée par nom.
    Retourne True si la liste est triée, False sinon.
    """
    # Parcourir la liste et comparer chaque élément avec le suivant
    for i in range(len(communes)-1):
        if communes[i][0] > communes[i+1][0]:
            return False
    return True

# Tester la fonction verify_order
print("Tester la fonction verify_order")
liste_triee = [["Ariana",36.86250,10.19556],["Beja",36.73333,9.18333],["Ben Arous", 36.75333,10.2222]]
liste_non_triee = [["Beja",36.73333,9.18333],["Ariana",36.86250,10.19556],["Ben Arous", 36.75333,10.2222]]
print(verify_order(liste_triee))  # True
print(verify_order(liste_non_triee))  # False
print(verify_order(gouvernorats))  # True

# Fonction pour trouver les coordonnées d'un gouvernorat
def coordinate(nom, liste):
    """
    Trouve les coordonnées d'un gouvernorat dans une liste.
    Retourne un tuple (latitude, longitude), ou None si le gouvernorat n'est pas trouvé.
    """
    debut = 0
    fin = len(liste) - 1
    while debut <= fin:
        milieu = (debut + fin) // 2
        if liste[milieu][0] == nom:
            return (liste[milieu][1], liste[milieu][2])
        elif liste[milieu][0] < nom:
            debut = milieu + 1
        else:
            fin = milieu - 1
    return None

# Tester la fonction coordinate
print("\nTester la fonction coordinate")
print(coordinate("Ariana", gouvernorats))  # (36.8625, 10.19556)
print(coordinate("Tunis", gouvernorats))  # (36.80278, 10.17972)
print(coordinate("Gouvernorat inconnu", gouvernorats))  # None

# Fonction pour calculer la distance euclidienne entre deux coordonnées
def distance_coord(x1, y1, x2, y2):
    """
    Calcule la distance euclidienne entre deux coordonnées (x1, y1) et (x2, y2).
    """
    return math.sqrt((x1 - x2)**2 + (y1 - y2)**2)

# Fonction pour calculer la distance entre deux gouvernorats
def distance(gouv1, gouv2, liste):
    """
    Calcule la distance euclidienne entre deux gouvernorats dans une liste.
    Retourne la distance, ou None si un des gouvernorats n'est pas trouvé.
    """
    coord1 = coordinate(gouv1, liste)
    coord2 = coordinate(gouv2, liste)
    if coord1 is None or coord2 is None:
        return None
    return distance_coord(coord1[0], coord1[1], coord2[0], coord2[1])

# Tester la fonction distance
print("\nTester la fonction distance")
print(distance("Ariana", "Tunis", gouvernorats))  # 22.57298384046194
print(distance("Ariana", "Gouvernorat inconnu", gouvernorats))  # None

# Fonction pour calculer la distance totale d'une tournée
def tour_distance(liste):
    """
    Calcule la distance totale d'une tournée à travers tous les gouvernorats dans la liste.
    La tournée commence à la première ville, visite toutes les autres dans l'ordre,
    et revient à la première ville.
    """
    dist_totale = 0
    for i in range(len(liste)):
        ville1 = liste[i]
        if i == len(liste) - 1:
            ville2 = liste[0]
        else:
            ville2 = liste[i+1]
        dist_totale += distance_coord(ville1[1], ville1[2], ville2[1], ville2[2])
    return dist_totale

# Tester la fonction tour_distance
print("\nTester la fonction tour_distance")
print(tour_distance(gouvernorats))  # 1821.5720603721944

# Fonction pour trouver le gouvernorat le plus proche
def closest(gouv, liste):
    """
    Trouve le gouvernorat le plus proche d'un gouvernorat donné dans une liste.
    Retourne le nom du gouvernorat le plus proche.
    """
    coord_gouv = coordinate(gouv, liste)
    if coord_gouv is None:
        return None
    dist_min = float('inf')
    gouv_proche = None
    for ville in liste:
        if ville[0] != gouv:
            dist = distance_coord(coord_gouv[0], coord_gouv[1], ville[1], ville[2])
            if dist < dist_min:
                dist_min = dist
                gouv_proche = ville[0]
    return gouv_proche

# Tester la fonction closest
print("\nTester la fonction closest")
print(closest("Ariana", gouvernorats))  # Tunis
print(closest("Gouvernorat inconnu", gouvernorats))  # None