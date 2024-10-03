class Point:
    def __init__(self, x, y, z=None):
        self.x = x
        self.y = y
        self.z = z

    def ToString(self):
        if self.z is None:
            return f"P({self.x:.2f}, {self.y:.2f})"
        else:
            return f"P({self.x:.2f}, {self.y:.2f}, {self.z:.2f})"


# Exemple d'exécution
P1 = Point(2, 3)
print(P1.ToString())

P2 = Point(1, -5, 6)
print(P2.ToString())
