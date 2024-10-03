from tkinter import *
from Fonc import *


# ch_adn = saisie("chaîne ADN : ")
# seq_adn = saisie("séquence ADN : ")
# prop_val = prop(ch_adn, seq_adn)
# print(f"La proportion : {prop_val}")

# seq = ["A", "T", "C", "G", "A", "T", "C", "G", "A", "T", "C"]
# print(f"Séquence d'origine : {seq}")
# print(f"Séquence complémentaire : {seq_comp(seq)}")


def prop_2():
    ch_adn = entry_ch_adn.get()
    seq_adn = entry_seq_adn.get()
    if valide(ch_adn) and valide(seq_adn):
        prop_val = prop(ch_adn, seq_adn)
        label_result.config(text=f"La proportion : {prop_val}")
    else:
        label_result.config(text="La saisie n'est pas valide. 'a', 't', 'g' ou 'c'.")

def cmp_seq_2():
    ch_adn = entry_ch_adn.get()
    if valide(ch_adn):
        complementary_seq = seq_comp(ch_adn)
        label_complementary_seq.config(text=f"Séquence complémentaire : {complementary_seq}")
    else:
        label_complementary_seq.config(text="La saisie n'est pas valide. 'a', 't', 'g' ou 'c'.")

window = Tk()
window.title("TP3 ex1")

label_ch_adn = Label(window, text="chaîne ADN : ")
label_ch_adn.grid(row=0, column=0, padx=5, pady=5)
entry_ch_adn = Entry(window)
entry_ch_adn.grid(row=0, column=1, padx=5, pady=5)

label_seq_adn = Label(window, text="séquence ADN : ")
label_seq_adn.grid(row=1, column=0, padx=5, pady=5)
entry_seq_adn = Entry(window)
entry_seq_adn.grid(row=1, column=1, padx=5, pady=5)

button_prop = Button(window, text="Calculate Proportion", command=prop_2)
button_prop.grid(row=2, column=0, columnspan=2, padx=5, pady=5)

button_seq = Button(window, text="Calculate Complementary Sequence", command=cmp_seq_2)
button_seq.grid(row=3, column=0, columnspan=2, padx=5, pady=5)

label_result = Label(window, text="")
label_result.grid(row=4, column=0, columnspan=2, padx=5, pady=5)

label_complementary_seq = Label(window, text="")
label_complementary_seq.grid(row=5, column=0, columnspan=2, padx=5, pady=5)

window.mainloop()
