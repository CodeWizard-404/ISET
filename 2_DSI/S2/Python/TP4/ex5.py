ventes = {"Sami": 14, "Saloua": 19, "khaoula": 15, "lina": 21}



def total_ventes(ventes):
    total = sum(ventes.values())
    return total

total = total_ventes(ventes)
print("Nombre total de ventes :", total)




def meilleur_vendeur(ventes):
    meilleur_nom = max(ventes, key=ventes.get)
    return meilleur_nom

meilleur = meilleur_vendeur(ventes)
print("Meilleur vendeur :", meilleur)
