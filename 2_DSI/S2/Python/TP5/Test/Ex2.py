import unittest

def Saisie1(chaine):
    assert chaine[0].isalpha(), "Le premier caractère doit faire partie de l'alphabet."
    assert len(chaine) >= 8, "La chaîne doit avoir au moins 8 caractères."
    assert any(char.isdigit() for char in chaine), "La chaîne doit contenir au moins un chiffre."
    assert any(char in "-_#" for char in chaine), "La chaîne doit contenir au moins un caractère spécial (-, _ ou #)."
    return chaine

def Saisie2(chaine):
    try:
        if not chaine[0].isalpha():
            raise ValueError("Le premier caractère doit faire partie de l'alphabet.")
        if len(chaine) < 8:
            raise ValueError("La chaîne doit avoir au moins 8 caractères.")
        if not any(char.isdigit() for char in chaine):
            raise ValueError("La chaîne doit contenir au moins un chiffre.")
        if not any(char in "-_#" for char in chaine):
            raise ValueError("La chaîne doit contenir au moins un caractère spécial (-, _ ou #).")
        return chaine
    except ValueError as e:
        raise ValueError(str(e))

class TestSaisieFunctions(unittest.TestCase):

    def test_Saisie1_valid(self):
        self.assertEqual(Saisie1("aBc123-_#"), "aBc123-_#")

    def test_Saisie1_invalid_first_char(self):
        with self.assertRaises(AssertionError):
            Saisie1("1abc123-_#")

    def test_Saisie1_invalid_length(self):
        with self.assertRaises(AssertionError):
            Saisie1("aBc123")

    def test_Saisie1_invalid_no_digit(self):
        with self.assertRaises(AssertionError):
            Saisie1("aBcdef-_#")

    def test_Saisie1_invalid_no_special_char(self):
        with self.assertRaises(AssertionError):
            Saisie1("aBc123def")

    def test_Saisie2_valid(self):
        self.assertEqual(Saisie2("aBc123-_#"), "aBc123-_#")

    def test_Saisie2_invalid_first_char(self):
        with self.assertRaises(ValueError):
            Saisie2("1abc123-_#")

    def test_Saisie2_invalid_length(self):
        with self.assertRaises(ValueError):
            Saisie2("aBc123")

    def test_Saisie2_invalid_no_digit(self):
        with self.assertRaises(ValueError):
            Saisie2("aBcdef-_#")

    def test_Saisie2_invalid_no_special_char(self):
        with self.assertRaises(ValueError):
            Saisie2("aBc123def")

if __name__ == '__main__':
    unittest.main()
