def fusionner_dictionnaires(dict1={}, dict2={}, dict3={}):
    fusion = {}
    for d in [dict1, dict2, dict3]:
            for cle, valeur in d.items():
                if cle in fusion:
                    fusion[cle].append(valeur)
                else:
                    fusion[cle] = [valeur]
    return fusion

dict1 = {"a": 1, "d": 4, "g": 7}
dict2 = {"a": 1, "b": 2, "h": [8]}
dict3 = {"a": 2, "c": 3, "h": 9}

resultat = fusionner_dictionnaires(dict1, dict2, dict3)
print(resultat)
