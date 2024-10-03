#Ex2

#print("Nous commençons la manipulation de PYTHON")

#nom = input("nom : ")
#age = int(input("age : "))
#print("Bonjour", nom , "vous avez", age, "ans.")

# x = int(input("1er entier : "))
# y = int(input("2eme entier : "))
# s = x+y
# p = x*y

# if y != 0:
#     d = x/y
#     print("x/y = ",d)
# else:
#     print("x/y impossible")

# print("x+y = ", s)
# print("x*y = ", p)

#Ex3

# from math import pi
# r =int(input("Entrez le rayon du disque : "))
# s = pi*r**2
# print("L'aire du disque est" , s)

#Ex4

# pSeuil = 2.3
# vSeuil = 7.41

# pres = input("pressioin : ")
# vol = input("volume : ")

# if float(pres)>pSeuil and float(vol)>vSeuil:
#     print(" le volume et la pression sont supérieurs aux seuils")
# elif float(pres)>pSeuil:
#     print(" seule la pression est supérieure à la pression seuil")
# elif float(pres)>vSeuil:
#     print(" seul le volume est supérieur au volume seuil")
# else:
#     print("Tout va bien.")

#Ex5

# a=0
# b=10

# for a in range(a,b):
#     print("a : " , a)

# for b in range(10, 0, -1):
#     if b % 2 != 0:
#         print("b : " , b)

# ch = "Test"
# for ch in ch:
#     print(ch)
    
# for i in range(0, 15, 3):
#     print(i)
    
# for i in range(1, 11):
#     if i == 5:
#         break
#     print(i)
    
# for i in range(1, 11):
#     if i == 5:
#         continue
#     print(i)

#Ex6

# import math
# n = float(input("Nb : "))
# if n >= 0:
#     r = math.sqrt(n)
#     print("racine carree ", n, " : ", r)
# else:
#     print("Erreur : Nb negative")
    
#Ex7

# a = int(input("A : "))
# b = int(input("B : "))
# c = int(input("C : "))

# if a <= b <= c:
#     print(str(a) + str(b) + str(c))
# elif a <= c <= b:
#     print(str(a) + str(c) + str(b))
# elif b <= a <= c:
#     print(str(b) + str(a) + str(c))
# elif b <= c <= a:
#     print(str(b) + str(c) + str(a))
# elif c <= a <= b:
#     print(str(c) + str(a) + str(b))
# else:
#     print(str(c) + str(b) + str(a))

#Ex8

# if __name__ =='__main__':
#     print("exercice 8")
#     s='un exemple de chaine'
#     s2="un autre exemple" 
#     print(s[1]) 
#     print(s[0],s2[0]) 
#     print(s[4], s2[0]) 
#     print(s+' et '+ s2) 
#     s3=s+' et '+ s2 
#     print(s3)
#     print(s2*2) 
#     print('la taille du s est : '+str(len(s))) 
#     print(s3[0:3]) 
#     print(s3[4:8]) 
#     print(s3[:3]) 
#     print(s3[3:]) 
#     print(s3[::-1]) 
#     print(s3.find('exemple')) 
#     print(s3.replace('chaine',"str")) 
#     help(str) 

#Ex9

# l = float(input("Saisissez la largeur du rectangle : "))
# h = float(input("Saisissez la hauteur du rectangle : "))

# s = l * h
# p = 2 * (l + h)

# print("La surface du rectangle est : {:.2f}".format(s))
# print("Le périmètre du rectangle est : {:.2f}".format(p))

#Ex10

# a = "salut"
# b = 102
# c = 10.318

# print("a: {}, b: {}, c: {:.2f}".format(a, b, c))

# perc_GC = (4500 + 2575) / 14800 * 100

# print("Le pourcentage de GC est {:.0f} %".format(perc_GC))
# print("Le pourcentage de GC est {:.1f} %".format(perc_GC))
# print("Le pourcentage de GC est {:.2f} %".format(perc_GC))
# print("Le pourcentage de GC est {:.3f} %".format(perc_GC))

#Ex11

a = 251
b = 247

s = int(input("ASCII du caractere : "))

d = (a * s + 256) // 256
e = (a * s + b) % 256

print("Les caractères cryptes :", chr(d), chr(e))
