from Fonc import *
import tkinter as tk




minimum, maximum, moyenne = minMaxMoy([10, 18, 14, 20, 12, 16])

print("Minimum:", minimum)
print("Maximum:", maximum)
print("Moyenne:", moyenne)


import tkinter as tk






window = tk.Tk()
window.title("EX2")

liste = []

entry_label = tk.Label(window, text="Entrez une valeur:")
entry_label.pack()

entry = tk.Entry(window, width=10)
entry.pack()

add_button = tk.Button(window, text="Ajouter", command=update_results)
add_button.pack()

min_label = tk.Label(window, text="Minimum: ")
min_label.pack()

max_label = tk.Label(window, text="Maximum: ")
max_label.pack()

avg_label = tk.Label(window, text="Moyenne: ")
avg_label.pack()

window.mainloop()
