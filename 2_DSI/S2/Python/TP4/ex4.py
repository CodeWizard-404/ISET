def compterMots(chaine):
    mots = chaine.split()
    frequences = {}
    for mot in mots:
        mot = mot.lower()  
        if mot in frequences:
            frequences[mot] += 1
        else:
            frequences[mot] = 1
    return frequences

phrase = "Ala Ala test program ala ala"
frequences_mots = compterMots(phrase)

for mot, freq in frequences_mots.items():
    print(f"l'élément de clé {mot} vaut {freq}")
