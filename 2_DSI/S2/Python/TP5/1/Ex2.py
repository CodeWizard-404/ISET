class CompteBancaire:
    def __init__(self, nom="DSI", solde=2500):
        self.nom = nom
        self.solde = solde

    def depot(self, somme):
        self.solde += somme

    def retrait(self, somme):
        if self.solde >= somme:
            self.solde -= somme
        else:
            print("Solde insuffisant.")

    def agios(self):
        self.solde -= self.solde * 0.05

    def affiche(self):
        print(f"Le solde du compte bancaire de {self.nom} est de {self.solde} dinars.")


# Exemples de la classe
compte1 = CompteBancaire("Sami", 800)
compte1.depot(350)
compte1.retrait(200)
compte1.affiche()  # Le solde du compte bancaire de Sami est de 950 dinars

compte2 = CompteBancaire()
compte2.depot(25)
compte2.affiche()  # Le solde du compte bancaire de DSI est de 2525 dinars.
