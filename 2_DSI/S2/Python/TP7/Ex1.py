"""
pip install matplotlib
pip install matplotlib --no-deps
pip install cycler
pip install python-dateutil
pip install kiwisolver
"""

import matplotlib.pyplot as plt

# Definition de la fonction f
def f(x):
    return x**3 - 6*x**2 + 9*x + 1

# Fonction pour tracer la representation graphique de f
def graph(start, end, steps):
    x_values = []
    y_values = []
    current_x = start
    while current_x <= end:
        x_values.append(current_x)
        y_values.append(f(current_x))
        current_x += steps
    
    plt.plot(x_values, y_values)
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.title('Graph of f(x)')
    plt.grid(True)
    plt.show()

# Tests
# Test de la fonction f avec quelques valeurs
print("Test de la fonction f:")
print("f(2) =", f(2))  # Attendu: 7
print("f(3) =", f(3))  # Attendu: 28

# Test de la fonction graph
print("\nTest de la fonction graph:")
graph(-0.5, 4.5, 0.1)  # Attendu: Affichage de la representation graphique de f sur l'intervalle [-0.5, 4.5]
