# -*- coding: utf-8 -*-
"""
Created on Fri Apr 23 11:35:34 2021

@author: Administrateur
"""
#ouverture
f=open("voitures.txt","r")
#lecture
s=f.readline()
#affichage
print("**contenu de s**")
print(s)
print("**fin contenu s**")
#fermeture
f.close()
