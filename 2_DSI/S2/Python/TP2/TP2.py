#Ex1:

# nom = input("nom : ")
# prenom = input("prenom : ")
# genre  = input("genre [1:mas/2:fem] : ")

# if genre=="1" :
#     print("M.", nom , prenom)
# elif genre=="2" :
#     print("Mme", nom, prenom)
# else :
#     print("Vous devez choisir entre 1 ou 2")
    

#Ex2 :

# ch = input("chaine : ")

# palindrome = True

# for i in range(len(ch) // 2):
#     if ch[i] != ch[-i - 1]:
#         palindrome = False
#         break
    
# if palindrome :
#     print("La chaine est un palindrome")
# else :
#     print("La chaine n'est pas un palindrome")

#Ex3 :

# def Reverse_Word(phrase):
#     mots = phrase.split()
#     mots.reverse()
#     phrase2 = ' '.join(mots)
    
#     return phrase2

# phrase = input("phrase : ")
# phrase2 = Reverse_Word(phrase)
# print( phrase2 )

#Ex4 :

# def majuscule_mot(phrase):
#     mots = phrase.split()
#     for i in range(0, len(mots)):
#         mots[i] = mots[i][0].upper() + mots[i][1:].lower()
#     return " ".join(mots)

# phrase = input("phrase : ")
# print(majuscule_mot(phrase))

#Ex5 :

# import time

# def affichage_temporise():
#     for i in range(1, 11):
#         print(i)
#         time.sleep(1)

# affichage_temporise()

#Ex6 :


import re

def NbCMin(Mpass):
    x = 0
    for ch in Mpass:
        if ch.islower():
            x += 1
    return x

def NbCMaj(Mpass):
    x = 0
    for ch in Mpass:
        if ch.isupper():
            x += 1
    return x

def NbCAlpha(Mpass):
    x = 0
    for ch in Mpass:
        if not ch.isalpha():
            x += 1
    return x

def LongMaj(Mpass):
    maxl = 0
    len1 = 0
    for ch in Mpass:
        if ch.isupper():
            len1 += 1
            maxl = max(maxl, len1)
        else:
            len1 = 0
    return maxl

def LongMin(Mpass):
    maxl = 0
    len1 = 0
    for ch in Mpass:
        if ch.islower():
            len1 += 1
            maxl = max(maxl, len1)
        else:
            len1 = 0
    return maxl


def Score(Mpass):
    
    if re.search(r'[^\x00-\x7F]', Mpass) or ' ' in Mpass:
        return "Le mot de passe ne doit pas contenir de lettres accentuées ou d'espaces."
    
    b1 = (len(Mpass) * 4) 
    b2 = ((len(Mpass) - NbCMaj(Mpass)) * 2)
    b3 = ((len(Mpass) - NbCMin(Mpass)) * 3)
    b4 = (NbCAlpha(Mpass) * 5) 

    p1 = (LongMin(Mpass) * 2) 
    p2 = (LongMaj(Mpass) * 3)

    score = b1+b2+b3+b4-p1-p2

    if score < 20:
        return "Très faible"
    elif score < 40:
        return "Faible"
    elif score < 80:
        return "Fort"
    else:
        return "Très fort"




# passF = input("saisir Mot de pass : ")
# print("Le mot de Mpasse '{}' est : {}".format(passF, Score(passF)))




import tkinter as tk
from tkinter import messagebox

def check_Mpass():
    Mpass = Mpass0.get()
    strength = Score(Mpass)
    messagebox.showinfo("Résultat", "La force du mot de passe est : {}".format(strength))

def Show():
    if visibility.get():
        Mpass0.config(show="")
    else:
        Mpass0.config(show="*")


root = tk.Tk()
root.title("Password Checker")
root.geometry("300x150")  
root.eval('tk::PlaceWindow . center')
root.configure(bg="#424242")

label = tk.Label(root, text="Password :", font=("Arial", 12), bg="#424242", fg="white")
label.grid(row=0, column=0, pady=5, padx=5, sticky='w')

Mpass0 = tk.Entry(root, show="*", font=("Arial", 12))
Mpass0.grid(row=0, column=1, pady=5, padx=5, sticky='e')

visibility = tk.BooleanVar()
checkV = tk.Checkbutton(root, text="Show", variable=visibility, command=Show, font=("Arial", 10), bg="#424242", fg="white")
checkV.grid(row=1, column=0, columnspan=2, pady=5, padx=5, sticky='w')

ShowB = tk.Button(root, text="Vérifier", command=check_Mpass, bg="#4CAF50", fg="white", font=("Arial", 12))
ShowB.grid(row=2, column=0, columnspan=2, pady=5, padx=5)

root.mainloop()



