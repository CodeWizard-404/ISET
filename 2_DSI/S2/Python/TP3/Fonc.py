
#EX1


def valide(s):
    return all(ch in 'atgc' for ch in s)


def saisie(ch):
    while True:
        x = input(ch)
        if valide(x):
            return x
        else:
            print("La saisie n'est pas valide. 'a', 't', 'g' ou 'c'.")


def prop(ch, s):
    count = 0
    i = 0
    while i < len(ch):
        i = ch.find(s, i)
        if i == -1:
            break
        count += 1
        i += 1
    return count


def seq_comp(s):
    s_str = s.upper() 
    c_str = s_str.replace('A', 't').replace('T', 'a').replace('C', 'g').replace('G', 'c')
    c_seq = list(c_str.upper())  
    return c_seq










#EX2


def minMaxMoy(liste):
    minimum = min(liste)
    maximum = max(liste)
    moyenne = sum(liste) / len(liste)
    return minimum, maximum, moyenne



def update_results():
        new_value = int(entry.get())
        liste.append(new_value)
        min_value, max_value, avg_value = minMaxMoy(liste)
        min_label.config(text=f"Minimum: {min_value}")
        max_label.config(text=f"Maximum: {max_value}")
        avg_label.config(text=f"Moyenne: {avg_value:.2f}")