class Temps:
    # Représente le moment de la journée.     
    def __init__(self, heure=0, minute=0, seconde=0):
        # Constructeur de la classe Temps. 
        self.heure = heure
        self.minute = minute
        self.seconde = seconde

    def afficher_temps(self):
        # Affiche le temps dans la forme heure:minute:seconde. 
        print("%.2d:%.2d:%.2d" % (self.heure, self.minute, self.seconde))

    def est_apres(self, autre_temps):
        # Vérifie si self suit chronologiquement autre_temps. 
        return (self.heure, self.minute, self.seconde) > (autre_temps.heure, autre_temps.minute, autre_temps.seconde)

    def increment(self, secondes):
        # Ajoute un nombre donné de secondes à l'objet Temps. 
        total_secondes = self.temps_vers_int() + secondes
        self.heure, self.minute, self.seconde = self.int_vers_temps(total_secondes)

    def temps_vers_int(self):
        # Convertit l'objet Temps en nombre entier de secondes. 
        minutes = self.heure * 60 + self.minute
        secondes = minutes * 60 + self.seconde
        return secondes

    def int_vers_temps(self, secondes):
        # Convertit un nombre entier de secondes en objet Temps. 
        temps = Temps()
        minutes, temps.seconde = divmod(secondes, 60)
        temps.heure, temps.minute = divmod(minutes, 60)
        return temps

    def __add__(self, autre_temps):
        # Surcharge de l'opérateur '+' pour additionner deux objets Temps. 
        total_secondes = self.temps_vers_int() + autre_temps.temps_vers_int()
        return self.int_vers_temps(total_secondes)

# Création d'instances de la classe Temps
temps1 = Temps(12, 30, 45)
temps2 = Temps(10, 15, 20)

# Test des méthodes de la classe Temps
temps1.afficher_temps()
print("Est après:", temps1.est_apres(temps2))
temps1.increment(100)
temps1.afficher_temps()

# Test de l'opérateur '+'
temps3 = temps1 + temps2
temps3.afficher_temps()
