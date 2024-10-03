class Calcul:
    def __init__(self):
        pass

    def Factorielle(self, n):
        if n == 0:
            return 1
        else:
            return n * self.Factorielle(n-1)

    def Somme(self, n):
        return sum(range(1, n+1))

    def testPrim(self, n):
        if n < 2:
            return False
        for i in range(2, int(n**0.5) + 1):
            if n % i == 0:
                return False
        return True

    def pgcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def testPrims(self, a, b):
        return self.pgcd(a, b) == 1

    def tableMult(self, n):
        for i in range(1, 11):
            print(f"{n} x {i} = {n*i}")

    def allTablesMult(self):
        for i in range(1, 10):
            print(f"Table de multiplication de {i}:")
            self.tableMult(i)
            print()

    def listDiv(self, n):
        Ldiv = [1]
        for i in range(2, n//2 + 1):
            if n % i == 0:
                Ldiv.append(i)
        Ldiv.append(n)
        return Ldiv

    def listDivPrim(self, n):
        Ldiv = self.listDiv(n)
        LdivPrim = []
        for num in Ldiv:
            if self.testPrim(num):
                LdivPrim.append(num)
        return LdivPrim


# Test des méthodes
calcul = Calcul()

# Test de la méthode Factorielle
print("Factorielle de 5:", calcul.Factorielle(5))

# Test de la méthode Somme
print("Somme des 5 premiers entiers:", calcul.Somme(5))

# Test de la méthode testPrim
print("Est-ce que 7 est premier?", calcul.testPrim(7))

# Test de la méthode testPrims
print("Sont-ils premiers entre eux? (15, 28):", calcul.testPrims(15, 28))

# Test de la méthode tableMult
print("Table de multiplication de 7:")
calcul.tableMult(7)

# Test de la méthode allTablesMult
print("Toutes les tables de multiplication:")
calcul.allTablesMult()

# Test de la méthode listDiv
print("Liste des diviseurs de 24:", calcul.listDiv(24))

# Test de la méthode listDivPrim
print("Liste des diviseurs premiers de 24:", calcul.listDivPrim(24))
