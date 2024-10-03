#10 et 100 et multiples de 3
liste_multiple_de_3 = [i for i in range(10, 101) if i % 3 == 0]

#10 valeurs positives
liste_valeurs_positives = [x for x in range(2, 21, 2)]


# Trier et inverser
liste_positive.sort(reverse=True)

# Supprimer le dernier
del liste_positive[-1]

# Saisir
chaine_caracteres = input("Entrez une chaîne de caractères : ")

#liste de caractères
liste_caracteres = list(chaine_caracteres)

# Trier
liste_caracteres.sort()

print("multiples de 3 entre 10 et 100:", liste_multiple_de_3)
print("liste valeurs positives :",liste_valeurs_positives)
print("Liste positive triée et inversée avec le dernier élément supprimé:", liste_positive)
print("Liste de caractères triée:", liste_caracteres)