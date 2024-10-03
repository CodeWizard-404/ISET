# -*- coding: utf-8 -*-
"""
Created on Wed May  4 17:40:41 2022

@author: USER
"""

import csv
with open('data2.csv','w',newline='') as fichiercsv:
    writer=csv.writer(fichiercsv)
    writer.writerow(['Nom', 'Prenom', 'E-mail', 'Telephone'])
    writer.writerow(['ben sassi', 'Sami', 'sami@gmail.com', '52535455'])
    writer.writerow(['TRABELSI', 'Alya', 'alya@gmail.com', '97989654'])
    writer.writerow(['HARBAOUI', 'Saloua', 'saloua.harbaoui@gmail.com', '53567789'])
    writer.writerow(['ALOUI', 'sihem', 'sihem.aloui@gmail.com', '54566776']) 
