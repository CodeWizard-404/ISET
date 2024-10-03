# -*- coding: utf-8 -*-
"""
Created on Fri Apr 23 11:35:34 2021

@author: Administrateur
"""
#ouverture
f=open("moto2.txt","w")

L=["honda\n","yamaha\n","polo\n"]
   
   #ecriture
f.writelines(L)
#fermeture
f.close()
