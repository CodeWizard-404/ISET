# from tkinter import*

# fenetre = Tk()

# texte = Label(fenetre, text="Hello World")
# texte['fg']='red'
# texte.pack()

# from tkinter import messagebox

# messagebox.showwarning("warning example","warning messagebox")
# messagebox.showerror("error example","error messagebox")
# messagebox.askquestion("Ask Question exemple","quit?")
# messagebox.askyesno("Ask yes/no exemple", "quit?")
# messagebox.askokcancel("Ask ok cancel exemple", "quit?")
# messagebox.askyesno("Ask retry cancel exemple", "quit?")

# fenetre.mainloop()


import tkinter as tk
root=tk.Tk()
root.geometry('300x200')
def ExitApp():
    MsgBox = tk.messagebox.askquestion('Exit App','Really Quit?',icon = 'error')
    if MsgBox == 'yes':
        root.destroy()
    else:
        tk.messagebox.showinfo('Welcome Back',command=ExitApp)

buttonEg = tk.Button(root,text='Exit App',command=ExitApp)
buttonEg.pack()
root.mainloop()
    


