# -*- coding: utf-8 -*-
"""
Created on Fri Apr 23 11:35:34 2021

@author: Administrateur
"""
#ouverture
f=open("voitures.txt","r")
#lecture
ligne=f.readline()
while ligne != "":
    print(ligne)
    ligne = f.readline()
#fermeture
f.close()
