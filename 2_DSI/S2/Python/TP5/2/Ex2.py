class DateNaissance:
    def __init__(self, jour, mois, année):
        self.jour = jour
        self.mois = mois
        self.année = année

    def ToString(self):
        return f"{self.jour:02d}/{self.mois:02d}/{self.année}"


class Personne:
    def __init__(self, nom, prénom, date_naissance):
        self.nom = nom
        self.prénom = prénom
        self.date_naissance = date_naissance

    def Afficher(self):
        print("Nom:", self.nom)
        print("Prénom:", self.prénom)
        print("Date de naissance:", self.date_naissance.ToString())


class Employé(Personne):
    def __init__(self, nom, prénom, date_naissance, salaire):
        super().__init__(nom, prénom, date_naissance)
        self.salaire = salaire

    def Afficher(self):
        super().Afficher()
        print("Salaire:", "{:.2f}".format(self.salaire))


class Chef(Employé):
    def __init__(self, nom, prénom, date_naissance, salaire, service):
        super().__init__(nom, prénom, date_naissance, salaire)
        self.service = service

    def Afficher(self):
        super().Afficher()
        print("Service:", self.service)


# Exemple d'exécution
P = Personne("Elyes", "Math", DateNaissance(1, 7, 1982))
P.Afficher()
print()

E = Employé("Elyes", "Math", DateNaissance(1, 7, 1985), 7865.548)
E.Afficher()
print()

Ch = Chef("Elyes", "Math", DateNaissance(1, 7, 1988), 7865.548, "Ressource humaine")
Ch.Afficher()
