package Ex4;

import java.awt.event.*;

public class ConvertisseurEvent implements ActionListener { 
    private ConvertisseurView convertisseurView; 

    public ConvertisseurEvent(ConvertisseurView convertisseurViewParameter) { 
        convertisseurView = convertisseurViewParameter; 
    } 

    public void actionPerformed(ActionEvent e) { 
        if (e.getActionCommand().equals("piedsmetres")) { 
            convertisseurView.afficherMetres(); 
        } else if (e.getActionCommand().equals("metrespieds")) { 
            convertisseurView.afficherPieds(); 
        } 
    } 
}
