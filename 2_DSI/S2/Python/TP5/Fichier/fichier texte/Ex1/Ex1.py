# 1. Créer et écrire le fichier "texte.txt"
with open("texte.txt", "w") as f:
    f.write("Il prend sa sacoche remplie de papiers divers, de livres, de magazines, de crayons... « Le poids\nde mes connaissances. » comme il aime dire.\n")
    f.write("Mais ils étaient beaucoup plus rapides et plus grands. Le peu de voitures qui circulaient encore\nétaient ultra sécurisées. C'est pourquoi la vitesse maximum autorisée avait été portée à 230km/h.\n")
    f.write("Les gens pouvaient commencer à travailler à l'aide de leur ordinateur portables relié au réseau\npar leur téléphone mobile. Ils auraient pu travailler de chez eux, mais le contact humain restait\nune priorité.")

# 2. Ouvrir le fichier en lecture
with open("texte.txt", "r") as f:
    lines = f.readlines()
    print("Nombre de lignes:", len(lines))
    li=1
    for line in lines:
        print(f"Nombre de caractères de ligne {li}:", len(line.strip()))
        li+=1
# 3. Ajouter une nouvelle phrase à la fin du fichier
with open("texte.txt", "a") as f:
    f.write("\nTu vas le prendre avec toi. Tu brancheras ton\ntéléphone mobile dessus afin que je puisse rester en contact avec toi. Il te faudra aussi\nun câble de liaison pour brancher ton ordinateur sur le réseau militaire.")