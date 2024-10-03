if __name__ =='__main__':
    print("exercice 1")
    print("5 + 5 = {}".format(5+5))                    #le console afficher 10
    print('2 - 9 = {}'.format(2-9))                    #le console afficher -7
    print("7 + 3 * 4 = {}".format(7+3*4))              # le console afficher 19 qui est la somme de (3*4)+7
    print("( 7 + 3 ) * 4 = {}".format((7+3)*4))        #le console afficher 40 qui est la some de ( 7 +3 ) * 4
    print("3 ** 3 = {}".format(3**3))                   #le console afficher 27 qui est 3 puissance 3
    print("3 ** 0.5 = {}".format(3**0.5))               #le console afficher 1.7320508075688772 qui est 3 puissance 0.5
    print("5 / 2 = {}".format(5/2) )                    # le console afficher 2.5 qui est la resultant de 5 diviser 2
    print("5.0 / 2 = {}".format(5.0/2))                 # le console afficher 2.5 qui est la resultant de 5.0 diviser 2
    print("5 / 2.0 = {}".format(5/2.0))                 # le console afficher 2.5 qui est la resultant de 5 diviser 2.0
    print("5 / 2 = {}".format(5/2))                     # le console afficher 2.5 qui est la resultant de 5 diviser 2
    print("float(5) / 2 = {}".format(float(5)/2))      # le console afficher 2.5 qui est la resultant de float(5) diviser 2
    print("4*2.5 / 3 = {}".format(4*2.5/3))                    # le console afficher 3.33333333335 qui est la resultant de 4*2.5(10) diviser 3

    """                 partie 2                     """
    x=10                            # affectation du variable variable x par 10
    x=x+1                           # incrementer X par 1
    largeur=20                      # affectation du variable largeur par 20
    hauteur=5*9.3                   # affectation du variable hauteur par  46.5(resultat du 5*9.3)
    v=largeur*hauteur               # affectation du variable v par  930.0(resultat du hauteur * largeur)
    print(v)                        # affichage du valeur du variable v
    largeur=10                      # ecraser la valeur du variable largeur par 10
    print(v)                        # affichage du valeur du variable v

    """                 partie 3                     """
    type(largeur)                   # le type du variable largeur est entier(int)
    type(hauteur)                   # le type du variable hauteur est reel(float)
    type(v)                         # le type du variable v est reel(float)

    """                 partie 4                     """
    print("3"*10)                   # l'affichage de la chaine '3' 10 fois
    print(3 * 10)                   # l'affichage la resultat de la multiplication du 3 par 10
    # '3'*10.0                        l'affichage d'une error syntaxic car en ne peut pas multipliyer les chaine de caractere que par des entier
    print("3"+"3")                  # l'affichage de la concatination de la chaine '3'+'3'
    print(3 + 3)                    # l'affichage de la resultat du 3+3 qui est 6
    # "3" + 3                       l'affichage d'un error syntaxic car en ne peut pas ajouter un entier a une chaine de caractere
