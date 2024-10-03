# -*- coding: utf-8 -*-
"""
Created on Wed May  4 09:02:53 2022

@author: USER
"""
#importation du module csv
import csv
#ouverture en lecture
f= open("personnes.csv","r")

#lecture utilisation du parseur csv 
lecteur= csv.reader(f, delimiter=";")
#affichage itération sur chaque ligne


for ligne in lecteur :
    print(ligne)

f.close()