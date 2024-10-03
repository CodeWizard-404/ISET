def compterMots(chaine):
    f_mots = {}

    mots = chaine.split()

    for mot in mots:
        mot = mot.strip(".,!?;:\"")
        mot = mot.lower()

        if mot in f_mots:
            f_mots[mot] += 1
        else:
            f_mots[mot] = 1

    return f_mots

ch = input("chaine : ")
resultat = compterMots(ch)
print(resultat)
