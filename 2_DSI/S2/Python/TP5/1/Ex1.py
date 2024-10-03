class Livre:
    def __init__(self, titre, auteur, prix, annee):
        self.titre = titre
        self.auteur = auteur
        self.prix = prix
        self.annee = annee

def meme_titre(livre_instance, titre_demande):
    return livre_instance.titre == titre_demande

# Instanciation de deux livres
livre1 = Livre("Livre 1", "Auteur1", 25, 2000)
livre2 = Livre("Livre 2", "Auteur2", 20, 1999)

# Test de la fonction
print(meme_titre(livre1, "Livre 1"))  # True
print(meme_titre(livre2, "Livre 1"))  # False
