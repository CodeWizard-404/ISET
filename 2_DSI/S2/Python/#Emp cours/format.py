# -*- coding: utf-8 -*-
"""
Created on Thu Feb 17 21:25:02 2022

@author: USER
"""

"""
la fonction print() affiche l'argument qu'on lui passe entre parenthèses et un retour à ligne. 
Ce retour à ligne supplémentaire est ajouté par défaut. 
Si  on ne veut pas afficher ce retour à la ligne, on peut utiliser l'argument 
le « mot-clé » end :
"""

print("******************")
print("exemple 1")
print("******************")
print("affiche et passe à la ligne")
print("Toujours "," dans la même ligne")
print("termine par un + et pas par un passage à la ligne",end="*")
print("Je suis sur la même ligne") 
print()# simple passage à la ligne
print ( "pi = % s "  %  "3.14159" )


"""
On peut également spécifier à l'intérieur des accolades un nom qu'on utilisera
 comme paramètre dans la méthode format pour obtenir 
 une phrase encore plus claire :"""

print("******************")
print("exemple 2")
print("******************")
age_de_lutilisateur = 26
print( "J'ai {age} ans".format(age=age_de_lutilisateur))


"""On peut mettre autant d'emplacements dans une chaîne de caractères que nécessaire."""
print("******************")
print("exemple 3")
print("******************")
prenom = "dsi22"
age = 21
print( "Je m'appelle {} et j'ai {} ans.".format(prenom, age))



"""On peut également spécifier à l'intérieur des accolades un indice,
 qui fera référence à la position de l'argument de la méthode format à utiliser."""

print("******************")
print("exemple 4")
print("******************")
langage = "Python"
print("Je m'appelle {0} et j'ai {1} ans. {0} apprends le langage {2}.".format(prenom, age, langage))

"""
On peut également remettre des noms à l'intérieur des accolades 
afin d'obtenir quelque chose de plus agréable à lire :

"""
print("Je m'appelle {prenom} et j'ai {age} ans. {prenom} apprends le langage {langage}.".format(prenom=prenom,age=age,langage=langage))

"""
Il est possible de spécifier des options de formatage avancées directement à l'intérieur des accolades.

Les options de formatages sont séparées des données par le symbole des deux-points :"""

print("******************")
print("exemple 5")
print("******************")
nombre = 80

# Avec format
nombre_pad = "{:04d}".format(nombre)  # 0080

print(nombre_pad)

"""
Enfin, il est possible de préciser sur combien de caractères vous voulez qu'un résultat
 soit écrit et comment se fait l'alignement (à gauche, à droite ou centré). 
 Dans la portion de code suivante, 
le caractère ; sert de séparateur entre les instructions sur une même ligne :
"""
print("******************")
print("exemple 6")
print("******************")
print("{:^6d}".format(10)) 
print("{:^6d}".format(1000))
print("{:*^6d}".format(10))
print("{:*^6d}".format(1000))


print("atom {:>4s}".format("HN"))
print("atom {:>4s}".format("HDE1"))

""" L'instruction 7.3f signifie que l'on souhaite écrire un float avec 3 décimales
 et formaté sur 7 caractères par défaut justifiés à droite. 
 L'instruction 10.3f fait la même chose sur 10 caractères. 
le séparateur décimal . compte pour un caractère"""

print("{:7.3f}".format(1000))
print("{:7.3f}".format(200.22558))


