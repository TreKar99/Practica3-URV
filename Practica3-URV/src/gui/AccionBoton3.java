package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import aplication.Aplicació;
import lists.*;

// Aquest classe serà responsable de tractar els esdeveniments del botó 3.
public class AccionBoton3 implements ActionListener {
    
    private Aplicació finestra;
    private LlistaUsuaris llista;
    private int indUsuari;

    public AccionBoton3 (Aplicació finestra, LlistaUsuaris llista, int indUsuari){
        this.finestra = finestra;
        this.llista = llista;
        this.indUsuari = indUsuari;
    }

    public void actionPerformed(ActionEvent evt) {
        // Obtenim la referència del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		b.setBackground(Color.BLUE);

        // Mostrem per pantalla les ofertes d'intercanvi actives
		JOptionPane.showMessageDialog(null, llista.toString(), "Usuaris", 
		JOptionPane.INFORMATION_MESSAGE);
		b.setBackground(Color.WHITE);
    }
}
