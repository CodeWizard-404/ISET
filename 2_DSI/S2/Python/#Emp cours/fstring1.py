# -*- coding: utf-8 -*-
"""
Created on Thu Feb 17 21:01:42 2022

@author: USER
"""

"""
L'écriture formatée est un mécanisme permettant d'afficher des variables avec un certain format, 
par exemple justifiées à gauche ou à droite, ou encore avec un certain nombre de décimales 
pour les floats. 

******************************

Les f-strings permettent une meilleure organisation de l'affichage des variables. 

"""
print("******************")
print("exemple 1")
print("******************")
x = 32
nom = "Elyes"
print(f"{nom} a {x} ans")
"""
Le caractère f avant les guillemets va indiquer à Python qu'il s'agit d'une 
f-string permettant de mettre en place le mécanisme de l'écriture formatée, 
contrairement à une string normale.
f-string est le diminutif de formatted string literals. 
"""

print("******************")
print("exemple 2")
print("******************")

prop_GC = (4500 + 2575) / 14800
print("La proportion de GC est", prop_GC)
#avec formatage 
"""
Le résultat obtenu présente trop de décimales (seize dans le cas présent).
 Pour écrire le résultat plus lisiblement, vous pouvez spécifier dans les 
 accolades {} le format qui vous intéresse. Dans le cas présent, 
 vous voulez formater un float pour l'afficher avec deux puis trois décimales :


"""
nb_G = 4500
nb_C = 2575
print(f"Ce génome contient {nb_G:d} G et {nb_C:d} C, soit une prop de GC de {prop_GC:.2f}")
perc_GC = prop_GC * 100
print(f"Ce génome contient {nb_G:d} G et {nb_C:d} C, soit un %GC de {perc_GC:.2f} %")


print("******************")
print("exemple 3")
print("******************")

print(10) ; print(1000)

print(f"{10:>6d}") ; print(f"{1000:>6d}")
   
print(f"{10:<6d}") ; print(f"{1000:<6d}")
 
print(f"{10:^6d}") ; print(f"{1000:^6d}")
 
print(f"{10:*^6d}") ; print(f"{1000:*^6d}")
print(f"{10:0>6d}") ; print(f"{1000:0>6d}")

"""
> spécifie un alignement à droite, < spécifie un alignement à gauche et ^ spécifie un alignement centré. Il est également possible d'indiquer le caractère qui servira de remplissage lors des alignements (l'espace est le caractère par défaut).

Ce formatage est également possible sur des chaînes de caractères avec la lettre s (comme string)

"""
print("******************")
print("exemple 4")
print("******************")

print("DSI22 2022") ; print("DSI22 Semestre2")

print(f"DS22 {'2022':>10s}") ; print(f"DSI22 {'Semestre2':>s}")

