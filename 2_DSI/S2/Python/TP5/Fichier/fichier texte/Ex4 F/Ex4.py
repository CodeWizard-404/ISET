def AjoutNote(liste):
    with open("notes.txt", "a") as fichier:
        for note in liste:
            fichier.write(str(note) + "\n")

def ListeNotes():
    notes = []
    with open("notes.txt", "r") as fichier:
        for ligne in fichier:
            notes.append(float(ligne.strip()))
    return notes

# Exemple
liste_notes = [15.5, 12.0, 8.5, 18.0, 10.5]
AjoutNote(liste_notes)

notes = ListeNotes()
moyenne = sum(notes) / len(notes)
print(f"Moyenne des notes : {moyenne:.2f}")

with open("notes2.txt", "w") as fichier:
    for note in notes:
        decision = "admis" if note >= 10 else "refuse"
        fichier.write(f"{note:.1f} {decision}\n")