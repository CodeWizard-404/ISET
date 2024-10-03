# -*- coding: utf-8 -*-
"""
Created on Sun Feb  5 19:05:44 2023

@author: Elyes
"""

v = "Bonjour DSI"
for lettre in v:
    print(lettre)
#for avec liste
personnes = ["Ali", "samia", "aloua", "Elyes"]
for i in range(4):
    print(personnes[i])
    
    
    
for i in range(len(personnes)):
    print(f"Le nom de la personne {i} est : {personnes[i]}")
    

s = 0
for i in range(1, 8):
    
    s += i**2
    print(s)    