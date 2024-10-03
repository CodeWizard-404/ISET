# 1/

class Complex:
    # Classe pour un nombre complexe
    def __init__(self, x, y):
        # Constructeur de la classe
        self.x = x
        self.y = y

    def affiche(self):
        # Affiche les valeurs
        print(f"({self.x} + {self.y}i)")

# 4/

    def show(self):
        # Affiche les attributs
        print(f"Partie réelle: {self.x}, Partie imaginaire: {self.y}")

# 5/

    def compareComplex(self, other):
        # Compare les attributs
        return self.x == other.x and self.y == other.y

    def clone(self):
        # Clone un objet Complex.
        return Complex(self.x, self.y)





# 2/

# Instanciation de c1
c1 = Complex()



# 3/

print(c1.__doc__)  # Affiche la documentation  (None)
print(c1)  # Affiche l'objet (<__main__.Complex object at 0x000002330CDDA8D0>)



# 4/

# Affectation de valeurs 
c1.x = 3
c1.y = 4

def affichecomplex(complex):
    print(f"({complex.x} + {complex.y}i)")

affichecomplex(c1)  # (3 + 4i)

c1.show()  # Partie réelle: 3, Partie imaginaire: 4



# 5/

# Creation de l'objet c2 
c2 = Complex(3, 4)

# Test de compareComplex
print(c1.compareComplex(c2))  # True

print(c1 == c2)  # False
c1 = c2
print(c1 == c2)  # True
c3 = c1.clone()
print(c1 == c3)  # True
