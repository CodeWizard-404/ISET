def voisinsCase(plateau, case):
    i, j = case
    voisins = set()

    if i > 0 and not plateau[i-1][j]:
        voisins.add((i-1, j))

    if i < len(plateau)-1 and not plateau[i+1][j]:
        voisins.add((i+1, j))

    if j > 0 and not plateau[i][j-1]:
        voisins.add((i, j-1))

    if j < len(plateau[0])-1 and not plateau[i][j+1]:
        voisins.add((i, j+1))

    return voisins


def voisinsCases(plateau, cases):
    voisins = set()

    for case in cases:
        voisins.update(voisinsCase(plateau, case))

    return voisins


def accessibles(plateau, case):
    accessible = {case}
    starter = {case}

    while starter:
        current = starter.pop()
        neighbors = voisinsCase(plateau, current)
        new_neighbors = neighbors - accessible
        accessible.update(new_neighbors)
        starter.update(new_neighbors)

    return accessible


def chemin(plateau, deb, fin):
    return fin in accessibles(plateau, deb)





plateau = [[True, False, False, False], [False, True, True, False]]
print(chemin(plateau, (1, 3), (1, 0))) 
print(chemin(plateau, (1, 3), (0, 1)))
