def mots_lettre_position(liste, lettre, position):
    return [mot for mot in liste if len(mot) > position and mot[position] == lettre]

mots = ['Mohamed', 'Mourad', 'maha', 'omar', 'monia', 'besma', 'elyes', 'sami', 
        'soumaya', 'dalenda', 'sondes', 'salma', 'souraya', 'ali', 'chedly',
        'sana', 'salim', 'sarra', 'hedi', 'ines', 'a']

mots_trouves = mots_lettre_position(mots, 'o', 1)
print(mots_trouves)
