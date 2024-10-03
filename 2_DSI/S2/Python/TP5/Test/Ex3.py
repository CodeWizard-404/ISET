import math

def reaction(v):
    return round(v / 3.6)

def freinage(v, route_seche=True):
    if route_seche:
        return round(v ** 2 / 200)
    else:
        return round((v ** 2 / 200) * 2)

def distance_arret(v, route_seche=True):
    return reaction(v) + freinage(v, route_seche)

# Tests unitaires pour la fonction reaction
def test_reaction():
    assert reaction(10) == 3
    assert reaction(20) == 6
    assert reaction(30) == 8

# Tests unitaires pour la fonction freinage
def test_freinage():
    assert freinage(10) == 1
    assert freinage(20) == 5
    assert freinage(30) == 10

# Tests unitaires pour la fonction distance_arret
def test_distance_arret():
    assert distance_arret(10) == 4
    assert distance_arret(20) == 11
    assert distance_arret(30) == 18

if __name__ == "__main__":
    print("Tests pour la fonction reaction :")
    test_reaction()
    print("Tous les tests pour la fonction reaction ont réussi.")

    print("\nTests pour la fonction freinage :")
    test_freinage()
    print("Tous les tests pour la fonction freinage ont réussi.")

    print("\nTests pour la fonction distance_arret :")
    test_distance_arret()
    print("Tous les tests pour la fonction distance_arret ont réussi.")

    vitesse = float(input("Entrez la vitesse du véhicule en km/h : "))
    route_seche = input("La route est-elle mouillée ? (Oui/Non) : ").lower() == "non"

    dist_arret = distance_arret(vitesse, route_seche)
    print(f"La distance d'arrêt du véhicule est de {dist_arret} mètres.")
