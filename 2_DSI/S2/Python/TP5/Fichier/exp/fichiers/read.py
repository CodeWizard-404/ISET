# -*- coding: utf-8 -*-
"""
Created on Fri Apr 23 11:35:34 2021

@author: Administrateur
"""
#ouverture
f=open("voitures.txt","r")
#lecture
s=f.read()
#affichage
print("**contenu de s**")
print(s)
print("**fin contenu s**")
#informations sur s
print("type de s :",type(s))
print("longueur de s : ",len(s))
#fermeture
f.close()