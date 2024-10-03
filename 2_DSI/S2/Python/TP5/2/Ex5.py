class Parallelepipede:
    def __init__(self, longueur=1, largeur=1, hauteur=1):
        self.longueur = longueur
        self.largeur = largeur
        self.hauteur = hauteur
        self.nom = 'parallélépipède'

    def volume(self):
        return self.longueur * self.largeur * self.hauteur

    def __repr__(self):
        return f"Le {self.nom} de côtés {self.longueur}, {self.largeur} et {self.hauteur} a un volume de {self.volume()}."

class Cube(Parallelepipede):
    def __init__(self, côté=1):
        super().__init__(côté, côté, côté)
        self.nom = 'cube'


# Test du module Parallépipède
parallelepipede = Parallelepipede(12, 8, 10)
print(parallelepipede)

# Test de la classe Cube
cube = Cube(10)
print(cube)
