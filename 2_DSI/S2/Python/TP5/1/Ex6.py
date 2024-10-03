import math

class Point:
    # La classe Point représente un point dans un plan cartésien.
    
    def __init__(self, x=0, y=0):
        # Constructeur de la classe Point.

        self.__x = x
        self.__y = y

    def __add__(self, p):
        # Surcharge de l'opérateur '+' pour additionner deux points.

        return Point(self.__x + p.__x, self.__y + p.__y)

    def __sub__(self, p):
        # Surcharge de l'opérateur '-' pour soustraire un point à un autre.

        return Point(self.__x - p.__x, self.__y - p.__y)

    def __lt__(self, p):
        # Surcharge de l'opérateur '<' pour comparer deux points par leur distance à l'origine.

        m_self = math.sqrt((self.__x ** 2) + (self.__y ** 2))
        m_p = math.sqrt((p.__x ** 2) + (p.__y ** 2))
        return m_self < m_p

    def __le__(self, p):
        # Surcharge de l'opérateur '<=' pour comparer deux points par leur distance à l'origine.

        m_self = math.sqrt((self.__x ** 2) + (self.__y ** 2))
        m_p = math.sqrt((p.__x ** 2) + (p.__y ** 2))
        return m_self <= m_p

    def __gt__(self, p):
        # Surcharge de l'opérateur '>' pour comparer deux points par leur distance à l'origine.

        m_self = math.sqrt((self.__x ** 2) + (self.__y ** 2))
        m_p = math.sqrt((p.__x ** 2) + (p.__y ** 2))
        return m_self > m_p

    def __ge__(self, p):
        # Surcharge de l'opérateur '>=' pour comparer deux points par leur distance à l'origine.

        m_self = math.sqrt((self.__x ** 2) + (self.__y ** 2))
        m_p = math.sqrt((p.__x ** 2) + (p.__y ** 2))
        return m_self >= m_p

    def __eq__(self, p):
        # Surcharge de l'opérateur '==' pour comparer deux points par leur distance à l'origine.

        m_self = math.sqrt((self.__x ** 2) + (self.__y ** 2))
        m_p = math.sqrt((p.__x ** 2) + (p.__y ** 2))
        return m_self == m_p
    
    def __str__(self):
        return f"({self.__x}, {self.__y})"
    

# Création d'instances de la classe Point
point1 = Point(3, 4)
point2 = Point(5, 6)

# Test des différentes méthodes de la classe Point
print("Addition:", point1 + point2)
print("Soustraction:", point1 - point2)
print("Comparaison (<):", point1 < point2)
print("Comparaison (<=):", point1 <= point2)
print("Comparaison (>):", point1 > point2)
print("Comparaison (>=):", point1 >= point2)
print("Comparaison (==):", point1 == point2)
