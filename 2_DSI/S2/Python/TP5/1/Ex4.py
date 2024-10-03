class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __del__(self):
        print("Point détruit.")


class Rectangle:
    def __init__(self, largeur, hauteur, coin_sup_gauche):
        self.largeur = largeur
        self.hauteur = hauteur
        self.coin_sup_gauche = coin_sup_gauche if coin_sup_gauche else Point()

    def __del__(self):
        print("Rectangle détruit.")

def trouveCentre(rectangle):
    x = rectangle.coin_sup_gauche.x + rectangle.largeur / 2
    y = rectangle.coin_sup_gauche.y - rectangle.hauteur / 2
    return Point(x, y)


# Instanciation de l'objet rectangle1
rectangle1 = Rectangle(50, 35, Point(12, 27))

# Test du destructeur de la classe Rectangle
del rectangle1

# Re Instanciation de l'objet rectangle1
rectangle1 = Rectangle(50, 35, Point(12, 27))

# Modification de la taille du rectangle1
rectangle1.largeur += 20
rectangle1.hauteur -= 5

# Test de modifictaion
print(f"Rectangle 1 =>  largeur: {rectangle1.largeur} , hauteur: {rectangle1.hauteur}")


# Test de la fonction trouveCentre avec rectangle1
centre_rectangle1 = trouveCentre(rectangle1)
print(f"Les coordonnées du centre du rectangle 1 sont ({centre_rectangle1.x}, {centre_rectangle1.y}).")
