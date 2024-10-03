
def somDiv(n):
    # Retourne la somme des diviseurs propres de n.
    somme = 0
    for i in range(1, n):
        if n % i == 0:
            somme += i
    return somme

def estParfait(n):
    # Vérifie si n est un nombre parfait.
    return somDiv(n) == n

def estPremier(n):
    # Vérifie si n est un nombre premier.
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def estChanceux(a):
    # Vérifie si a est un nombre chanceux.
    for n in range(a-1):
        if not estPremier(a + n + n**2):
            return False
    return True

def verif(func, par):
    print(f"{func(par)}")
    

# Test
verif(somDiv, 12)
verif(estParfait, 6)
verif(estPremier, 31)
verif(estChanceux, 11)



import tkinter as tk

# Initialisation des listes
parfaits = []
chanceux = []

# Remplissage des listes
for i in range(2, 1001):
    if estParfait(i):
        parfaits.append(i)
    if estChanceux(i):
        chanceux.append(i)

root = tk.Tk()
root.title("EX7")

parfaits_str = "\n".join(map(str, parfaits))
chanceux_str = "\n".join(map(str, chanceux))

parfaits_label = tk.Label(root, text=f"Nombres Parfaits:\n{parfaits_str}", justify='left')
parfaits_label.grid(row=0, column=0, padx=10, pady=10)

chanceux_label = tk.Label(root, text=f"Nombres Chanceux:\n{chanceux_str}", justify='left')
chanceux_label.grid(row=0, column=1, padx=10, pady=10)

root.mainloop()
