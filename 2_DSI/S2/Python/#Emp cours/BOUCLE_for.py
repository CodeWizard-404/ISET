# -*- coding: utf-8 -*-
"""
Created on Fri Feb 18 08:19:07 2022

@author: USER
"""
print("*************************");print ("exemple1");print("*************************")
for i in [0, 1, 2, 3]: 
    print("i a pour valeur", i)
#i a pour valeur 0 i a pour valeur 1 i a pour valeur 2 i a pour valeur 3.
print("*************************");print ("exemple2");print("*************************")

for i in range(4): 
    print("i a pour valeur", i)
c = ["DSI", "est", "dans", "la salle", "2121"] 
for i in range(len(c)): 
    print("i vaut", i, "et c[i] vaut", c[i])
print("*************************");print ("exemple3");print("*************************")    
v = "Bonjour DSI"
for lettre in v:
    print(lettre)
liste = [1,5,10,15,20,25]
for i in liste:
    if i > 15:
        print("On stoppe la boucle")
        break
    print(i)

print("*************************");print ("exemple4");print("*************************")

i = 0
while i < 10:
    print("Je ne dois pas poser une question sans lever la main")
    i = i +1

#D’une façon abrégée :
print("#####################");print ("D’une façon abrégée :");print("######################")
s = sum ( [ i**2 for i in range(1, 11) ] )

print("*************************");print ("exemple5");print("*************************")
s = 0
for i in range(1, 11):
    s += i**2
    
#