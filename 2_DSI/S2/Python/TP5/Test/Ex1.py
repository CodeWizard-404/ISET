import unittest

def moyenne(liste):
    assert len(liste) > 0, "La liste ne peut pas être vide."
    return sum(liste) / len(liste)

def concatener(L1, L2):
    resultat = list(set(L1 + L2))
    return resultat

class TestFonctions(unittest.TestCase):

    def test_moyenne_1_element(self):
        self.assertEqual(moyenne([1]), 1)

    def test_moyenne_multiple_elements(self):
        self.assertEqual(moyenne([1, 2, 3, 4, 5, 6, 7]), 4)
        self.assertEqual(moyenne([1, 2]), 1.5)

    def test_moyenne_liste_vide(self):
        with self.assertRaises(AssertionError):
            moyenne([])

    def test_concatener(self):
        self.assertCountEqual(concatener([1, 2, 9, 10], [1, 2, 3, 4, 5, 6, 7]), [1, 2, 3, 4, 5, 6, 7, 9, 10])
        self.assertCountEqual(concatener([1, 2, 9, 10], [3, 45, 8, 34]), [1, 2, 3, 34, 8, 9, 10, 45])
        self.assertCountEqual(concatener([], [3, 45, 8, 34, 3]), [3, 34, 8, 45])

if __name__ == '__main__':
    unittest.main()
