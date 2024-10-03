# DSI 21
# GROUP 2

# Laghouanem Sofien
# Hamraoui Arij

import unittest

# Classe Duree pour représenter une durée en heures, minutes et secondes
class Duree:
    def __init__(self, h=0, m=0, s=0):
        self._h = h
        self._m = m
        self._s = s
        self._normalize()

    # Normalise la durée pour que les secondes et les minutes soient dans des limites valides
    def _normalize(self):
        if self._s >= 60:
            self._m += self._s // 60
            self._s %= 60
        if self._m >= 60:
            self._h += self._m // 60
            self._m %= 60

    # Convertit la durée en secondes
    def toSecondes(self):
        return self._h * 3600 + self._m * 60 + self._s

    # Calcule la différence en secondes entre deux durées
    def delta(self, d):
        return self.toSecondes() - d.toSecondes()

    # Vérifie si la durée courante est après une autre durée
    def apres(self, d):
        return self.toSecondes() > d.toSecondes()

    # Ajoute une autre durée à la durée courante
    def ajouter(self, d):
        self._h += d._h
        self._m += d._m
        self._s += d._s
        self._normalize()

    # Représentation en chaîne de caractères de la durée
    def __str__(self):
        return "{:02}:{:02}:{:02}".format(self._h, self._m, self._s)

# Classe Chanson pour représenter une chanson avec un titre, un auteur et une durée
class Chanson:
    def __init__(self, titre, auteur, duree):
        self._titre = titre
        self._auteur = auteur
        self._duree = duree

    # Représentation en chaîne de caractères de la chanson
    def __str__(self):
        return f"{self._titre} - {self._auteur} - {self._duree}"

    # Comparaison des chansons par leur durée
    def __lt__(self, autre_chanson):
        return self._duree.toSecondes() < autre_chanson._duree.toSecondes()

# Classe Album pour représenter un album contenant plusieurs chansons
class Album:
    def __init__(self, numero):
        self._numero = numero
        self._chansons = []

    # Ajoute une chanson à l'album si les contraintes sont respectées
    def add(self, chanson):
        if len(self._chansons) >= 10 or self.total_duree().toSecondes() + chanson._duree.toSecondes() > 75 * 60:
            return False
        self._chansons.append(chanson)
        return True

    # Calcule la durée totale de l'album
    def total_duree(self):
        duree_totale = Duree()
        for chanson in self._chansons:
            duree_totale.ajouter(chanson._duree)
        return duree_totale

    # Représentation en chaîne de caractères de l'album
    def __str__(self):
        result = f"Album {self._numero} ({len(self._chansons)} chansons, {self.total_duree()})\n"
        for index, chanson in enumerate(self._chansons, 1):
            result += f"{index:02}: {chanson}\n"
        return result.strip()

# Générateur pour lire les chansons à partir d'un fichier
def lire_chansons(filename):
    with open(filename, 'r') as file:
        for ligne in file:
            titre, auteur, duree_str = ligne.strip().split(',')
            min_sec = duree_str.split(':')
            duree = Duree(0, int(min_sec[0]), int(min_sec[1]))
            yield Chanson(titre.strip(), auteur.strip(), duree)

# Crée des albums en lisant les chansons d'un fichier
def creer_albums(filename):
    albums = []
    album_numero = 1
    album = Album(album_numero)

    for chanson in lire_chansons(filename):
        if not album.add(chanson):
            albums.append(album)
            album_numero += 1
            album = Album(album_numero)
            album.add(chanson)
    
    albums.append(album)
    return albums

if __name__ == "__main__":
    albums = creer_albums('chansons.txt')
    for album in albums:
        print(album)

# Tests unitaires pour la classe Duree
class TestDuree(unittest.TestCase):
    def test_normalize(self):
        d = Duree(1, 70, 80)
        self.assertEqual(d._h, 2)
        self.assertEqual(d._m, 11)
        self.assertEqual(d._s, 20)

    def test_toSecondes(self):
        d = Duree(1, 1, 1)
        self.assertEqual(d.toSecondes(), 3661)

    def test_delta(self):
        d1 = Duree(1, 1, 1)
        d2 = Duree(0, 59, 59)
        self.assertEqual(d1.delta(d2), 62)

    def test_apres(self):
        d1 = Duree(1, 1, 1)
        d2 = Duree(0, 59, 59)
        self.assertTrue(d1.apres(d2))
        self.assertFalse(d2.apres(d1))

    def test_ajouter(self):
        d1 = Duree(1, 30, 30)
        d2 = Duree(0, 30, 45)
        d1.ajouter(d2)
        self.assertEqual(d1._h, 2)
        self.assertEqual(d1._m, 1)
        self.assertEqual(d1._s, 15)

# Tests unitaires pour la classe Chanson
class TestChanson(unittest.TestCase):
    def test_str(self):
        duree = Duree(0, 3, 30)
        chanson = Chanson("Test Song", "Test Artist", duree)
        self.assertEqual(str(chanson), "Test Song - Test Artist - 00:03:30")

    def test_lt(self):
        duree1 = Duree(0, 3, 30)
        duree2 = Duree(0, 4, 0)
        chanson1 = Chanson("Song 1", "Artist", duree1)
        chanson2 = Chanson("Song 2", "Artist", duree2)
        self.assertTrue(chanson1 < chanson2)
        self.assertFalse(chanson2 < chanson1)

# Tests unitaires pour la classe Album
class TestAlbum(unittest.TestCase):
    def test_add(self):
        album = Album(1)
        chanson1 = Chanson("Song 1", "Artist", Duree(0, 3, 30))
        chanson2 = Chanson("Song 2", "Artist", Duree(0, 72, 0))
        self.assertTrue(album.add(chanson1))
        self.assertFalse(album.add(chanson2))

    def test_total_duree(self):
        album = Album(1)
        chanson1 = Chanson("Song 1", "Artist", Duree(0, 3, 30))
        chanson2 = Chanson("Song 2", "Artist", Duree(0, 4, 30))
        album.add(chanson1)
        album.add(chanson2)
        self.assertEqual(str(album.total_duree()), "00:08:00")

    def test_str(self):
        album = Album(1)
        chanson1 = Chanson("Song 1", "Artist", Duree(0, 3, 30))
        album.add(chanson1)
        self.assertEqual(str(album), "Album 1 (1 chansons, 00:03:30)\n01: Song 1 - Artist - 00:03:30")

if __name__ == "__main__":
    unittest.main()


if __name__ == "__main__":
    albums = creer_albums('chansons.txt')
    for album in albums:
        print(album)