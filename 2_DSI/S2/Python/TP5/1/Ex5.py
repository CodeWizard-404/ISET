import datetime

class Individu:
    def __init__(self, nom, prenom, date_naissance):
        self.nom = nom
        self.prenom = prenom
        self.date_naissance = date_naissance

    def calculer_age(self):
        today = datetime.date.today()
        DN = datetime.datetime.strptime(self.date_naissance, "%Y-%m-%d").date()
        age = today.year - DN.year - ((today.month, today.day) < (DN.month, DN.day))
        return age

    def __str__(self):
        return f"Nom: {self.nom}, Prénom: {self.prenom}, Date de naissance: {self.date_naissance}, Age: {self.calculer_age()}"

class Etudiant(Individu):
    def __init__(self, nom, prenom, date_naissance, bac, notes=[]):
        super().__init__(nom, prenom, date_naissance)
        self.bac = bac
        self.notes = notes

    def ajouter_note(self, note):
        self.notes.append(note)

    def calculer_moyenne(self):
        return sum(self.notes) / len(self.notes)

    def __str__(self):
        return f"{super().__str__()}, Bac: {self.bac}, Notes: {self.notes}, Moyenne: {self.calculer_moyenne()}"


# Test
individu1 = Individu("Nom1", "Prenom1", "2002-08-28")
print(individu1)

etudiant1 = Etudiant("Nom2", "Prenom2", "2001-01-01", "Bac S", [14, 16, 18])
etudiant1.ajouter_note(12)
print(etudiant1)
