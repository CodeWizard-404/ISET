class myString(str):
    def append(self, s):
        return myString(self + s)

    def pop(self, index):
        return myString(self[:index] + self[index+1:])


# Exemple d'utilisation
s1 = myString("bonjour")
s2 = myString("DSI22")

print(s1.append(" DSI !"))  # affiche 'bonjour DSI !'
print(s2.pop(2))  # affiche 'DS22'
