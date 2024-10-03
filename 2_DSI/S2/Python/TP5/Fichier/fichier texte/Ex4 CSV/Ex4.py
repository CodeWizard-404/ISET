import csv

def AjoutNote(liste):
    with open("notes.csv", "a", newline='') as fichier:
        writer = csv.writer(fichier)
        for note in liste:
            writer.writerow([note])

def ListeNotes():
    notes = []
    with open("notes.csv", "r", newline='') as fichier:
        reader = csv.reader(fichier)
        for ligne in reader:
            notes.append(float(ligne[0]))
    return notes

# Exemple
liste_notes = [15.5, 12.0, 8.5, 18.0, 10.5]
AjoutNote(liste_notes)

notes = ListeNotes()
moyenne = sum(notes) / len(notes)
print(f"Moyenne des notes : {moyenne:.2f}")

with open("notes2.csv", "w", newline='') as fichier:
    writer = csv.writer(fichier)
    for note in notes:
        decision = "admis" if note >= 10 else "refuse"
        writer.writerow([f"{note:.1f} {decision}"])
