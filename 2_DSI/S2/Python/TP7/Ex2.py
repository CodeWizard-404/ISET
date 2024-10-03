import csv 
import numpy as np  
import matplotlib.pyplot as plt  
from tkinter import *  
from tkinter import ttk 

# Fonction pour charger les donnees du fichier CSV
def load_data(file_path):
    # Initialisation des listes pour stocker les donnees
    dates = []
    countries = []
    infections = []
    deaths = []
    recoveries = []

    # Ouverture du fichier CSV en mode lecture
    with open(file_path, 'r') as file:
        # Creation d'un lecteur de fichier CSV
        reader = csv.DictReader(file, delimiter=';')
        # Parcours des lignes du fichier CSV
        for row in reader:
            # Extraction des donnees de chaque colonne et ajout dans les listes correspondantes
            dates.append(row['Date'])
            countries.append(row['Pays'])
            infections.append(int(row['Infections']))
            deaths.append(int(row['Deces']))
            recoveries.append(int(row['Guerisons']))

    # Retourne les donnees chargees
    return dates, countries, infections, deaths, recoveries

# Fonction pour tracer la courbe d'une serie temporelle
def plot_time_series(dates, data, labels, title, xlabel, ylabel, linestyle='-'):
    # Creation d'une figure pour le graphique
    plt.figure(figsize=(10, 6))
    # Trace des courbes avec les donnees fournies
    for i in range(len(data)):
        plt.plot(dates, data[i], label=labels[i], linestyle=linestyle)
    # Ajout de titres et etiquettes
    plt.title(title)
    plt.xlabel(xlabel)
    plt.ylabel(ylabel)
    plt.xticks(rotation=45)  # Rotation des etiquettes de l'axe des x pour une meilleure lisibilite
    plt.legend()  # Affichage de la legende
    plt.grid(True)  # Affichage d'une grille
    plt.tight_layout()  # Ajustement automatique de la disposition
    plt.show()  # Affichage du graphique

# Chargement des donnees a partir du fichier CSV
dates, countries, infections, deaths, recoveries = load_data('coronaviruschiffres.csv')

# Fonction pour afficher le graphique en fonction du choix de l'utilisateur
def show_plot():
    # Recuperation du choix de l'utilisateur depuis la variable de choix
    choice = choice_var.get()
    if choice == 'Nouveaux cas en Tunisie (Mars et Avril)':
        # Extraction des donnees specifiques pour la Tunisie
        tunisia_infections = [infections[i] for i in range(len(countries)) if countries[i] == 'Tunisie']
        dates_tunisia = [dates[i] for i in range(len(countries)) if countries[i] == 'Tunisie'] 
        # Trace de la courbe des nouveaux cas en Tunisie
        plot_time_series(dates_tunisia, [tunisia_infections], ['Tunisie'],
                         'Nouveaux cas en Tunisie (Mars et Avril)', 'Date', 'Nouveaux cas', linestyle='-')
        
    elif choice == 'Total des deces (Italie, Espagne, France)':
        # Extraction des donnees specifiques pour l'Italie, l'Espagne et la France
        italy_deaths = [deaths[i] for i in range(len(countries)) if countries[i] == 'Italie']
        spain_deaths = [deaths[i] for i in range(len(countries)) if countries[i] == 'Espagne']
        france_deaths = [deaths[i] for i in range(len(countries)) if countries[i] == 'France']
        # Extraction des dates correspondantes
        italy_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'Italie']  
        spain_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'Espagne']  
        france_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'France']  
        # Trace de la courbe du total des deces pour les pays selectionnes
        plot_time_series(italy_dates, [italy_deaths], ['Italie'], 'Total des deces (Italie, Espagne, France)',
                        'Date', 'Nombre de deces', linestyle='-')

    elif choice == 'Guerisons (Tunisie, Algerie, Maroc - Avril)':
        # Extraction des donnees specifiques pour la Tunisie, l'Algerie et le Maroc
        tunisia_recoveries = [recoveries[i] for i in range(len(countries)) if countries[i] == 'Tunisie']
        algeria_recoveries = [recoveries[i] for i in range(len(countries)) if countries[i] == 'Algerie']
        morocco_recoveries = [recoveries[i] for i in range(len(countries)) if countries[i] == 'Maroc']
        # Extraction des dates correspondantes
        tunisia_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'Tunisie']  
        algeria_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'Algerie']  
        morocco_dates = [dates[i] for i in range(len(countries)) if countries[i] == 'Maroc']  
        # Trace de la courbe des guerisons pour les pays selectionnes
        plot_time_series(tunisia_dates, [tunisia_recoveries], ['Tunisie'], 'Guerisons (Tunisie, Algerie, Maroc - Avril)',
                        'Date', 'Nombre de guerisons', linestyle='-')


# Creation de la fenêtre principale de l'interface graphique avec tkinter
root = Tk()
root.title("Courbes relatives a la pandemie Covid19")

# Creation du cadre principal
mainframe = ttk.Frame(root, padding="100")
mainframe.grid(column=0, row=0, sticky=(N, W, E, S))

# Ajout d'une etiquette pour la selection de la courbe a afficher
ttk.Label(mainframe, text="Selectionnez la courbe a afficher:").grid(column=1, row=1, sticky=W)

# Creation d'une variable pour stocker le choix de l'utilisateur
choice_var = StringVar()

# Creation d'une liste deroulante pour permettre a l'utilisateur de choisir la courbe a afficher
choice_combobox = ttk.Combobox(mainframe, textvariable=choice_var)
choice_combobox['values'] = ['Nouveaux cas en Tunisie (Mars et Avril)',
                             'Total des deces (Italie, Espagne, France)',
                             'Guerisons (Tunisie, Algerie, Maroc - Avril)']
choice_combobox.grid(column=1, row=2, sticky=(W, E))
choice_combobox.current(0)  # Selection par defaut du premier element de la liste

# Creation d'un bouton pour afficher le graphique en fonction du choix de l'utilisateur
ttk.Button(mainframe, text="Afficher", command=show_plot).grid(column=1, row=3, sticky=W)

# Ajustement des marges pour les elements du cadre principal
for child in mainframe.winfo_children():
    child.grid_configure(padx=5, pady=5)

# Lancement de la boucle principale pour afficher l'interface graphique
root.mainloop()
