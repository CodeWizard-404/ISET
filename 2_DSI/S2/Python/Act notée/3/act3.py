# DSI 21
# GROUP 2

# Laghouanem Sofien
# Hamraoui Arij

import random

# 1. Générer une séquence d'ADN aléatoire
def sequenceADN(n):
    bases = ['A', 'T', 'C', 'G']
    return ''.join([random.choice(bases) for _ in range(n)])

# 2. Vérifier si une chaîne est une séquence d'ADN valide  
def is_adn(s):
    valides = set('ATCGatcg')
    return len(s) > 0 and all(c in valides for c in s)

# 3. Trouver les positions d'un motif dans une séquence
def positions(s, p):
    pos = []
    n = len(s)
    m = len(p)
    for i in range(n-m+1):
        if s[i:i+m] == p:
            pos.append(i)
    return pos

# 4. Calculer la distance de Hamming entre deux chaînes de même longueur
def distance_h(s1, s2):
    if len(s1) != len(s2):
        return None
    dist = 0
    for c1, c2 in zip(s1, s2):
        if c1 != c2:
            dist += 1
    return dist

# 5. Calculer la matrice des distances de Hamming entre toutes les chaînes
def distances_matrice(l):
    n = len(l)
    mat = [[None]*n for _ in range(n)]
    for i in range(n):
        for j in range(i, n):
            if i == j:
                mat[i][j] = 0
            else:
                d = distance_h(l[i], l[j])
                mat[i][j] = d
                mat[j][i] = d
    return mat

# 6. Calculer le brin complémentaire d'une séquence d'ADN
NUC = ['A','C','G','T']
NUCINV = ['T','G','C','A']
def brinComplementaire(adn):
    return [NUCINV[NUC.index(b)] for b in adn]

# 7. Trouver le plus long palindrome dans une séquence
def plus_long_palindrome(s):
    def extendre(s, i, j):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i+1:j]
    
    longest = ''
    for i in range(len(s)):
        pal1 = extendre(s, i, i)     # palindromes impairs
        pal2 = extendre(s, i, i+1)   # palindromes pairs
        longest = max(longest, pal1, pal2, key=len)
    return longest if longest else ''



# Tests
print(sequenceADN(10))  # Génère une séquence aléatoire de longueur 10
print(is_adn('ATCG'))  # True
print(is_adn('ATCGX'))  # False
print(positions('GATATATGCATATACGC', 'ATAT'))  # [2, 3, 9, 10]
print(distance_h('ATGC', 'ATGC'))  # 0
print(distance_h('ATGC', 'ATGG'))  # 1
print(distance_h('ATGC', 'ATGT'))  # None (longueurs différentes)
print(distances_matrice(['AG', 'AT', 'GT', 'ACG', 'ACT']))
# [[0, 1, 2, None, None], [1, 0, 1, None, None], [2, 1, 0, None, None], [None, None, None, 0, 1], [None, None, None, 1, 0]]
print(brinComplementaire(['A', 'T', 'G', 'C']))  # ['T', 'A', 'C', 'G']
print(plus_long_palindrome('ABCDEFGFEDBAHBAHCCXYBACBACC'))  # ABCDEFGFEDBAHBAHCCXYBACBACBA