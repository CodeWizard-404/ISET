def saisie_notes():
    notes = []
    while True:
        note = float(input("Entrez une note : "))
        if note < 0:
            break
        notes.append(note)
        nombre_notes = len(notes)
        if nombre_notes > 0:
            note_max = max(notes)
            note_min = min(notes)
            moyenne = sum(notes) / nombre_notes
            print(f"Nombre de notes entrées : {nombre_notes}")
            print(f"Note la plus élevée : {note_max}")
            print(f"Note la plus basse : {note_min}")
            print(f"Moyenne de toutes les notes : {moyenne:.2f}")
        else:
            print("Aucune note entrée.")
    return notes

saisie_notes()
