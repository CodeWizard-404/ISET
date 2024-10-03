def meilleurs_eleves(notes):
    meilleures_moys = []
    meilleure_moy = -1
    
    for nom, liste_notes in notes.items():
        if liste_notes:  
            moy = sum(liste_notes) / len(liste_notes)
            if moy > meilleure_moy:
                meilleures_moys = [nom]
                meilleure_moy = moy
            elif moy == meilleure_moy:
                meilleures_moys.append(nom)
    
    return meilleures_moys, meilleure_moy

notes = {"Sami": [8, 10, 12], "Monia": [10, 9], "Amel": [], "Lina": [12, 10, 8]}
meilleurs, meilleure_moy = meilleurs_eleves(notes)

if meilleurs:
    if len(meilleurs) == 1:
        print(f"Le meilleur élève est {meilleurs[0]} avec une moyenne de {meilleure_moy}.")
    else:
        print(f"Les meilleurs élèves sont {', '.join(meilleurs)} avec une moyenne de {meilleure_moy}.")
else:
    print("Aucun élève n'a de notes.")
