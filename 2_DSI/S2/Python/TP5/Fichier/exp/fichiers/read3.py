# -*- coding: utf-8 -*-
"""
Created on Fri Apr 23 11:35:34 2021

@author: Administrateur
"""
#ouverture
f=open("voitures.txt","r")
#lecture
L=f.readlines()
#affichage
print("**contenu de L**")
print(L)
print("**fin contenu L**")
#fermeture
f.close()
