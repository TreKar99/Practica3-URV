package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import aplication.Aplicació;
import lists.*;

// Aquest classe serà responsable de tractar els esdeveniments del botó 4.
public class AccionBoton4 implements ActionListener {
    
    private Aplicació finestra;
    private LlistaUsuaris llista;
    private int indUsuari;

    public AccionBoton4 (Aplicació finestra, LlistaUsuaris llista, int indUsuari){
        this.finestra = finestra;
        this.llista = llista;
        this.indUsuari = indUsuari; 
    }

    public void actionPerformed(ActionEvent evt) {
        // Obtenim la referència del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		b.setBackground(Color.BLUE);

        // Mostrem per pantalla les ofertes d'intercanvi actives
		String nom = JOptionPane.showInputDialog("Indica el teu nou codi d'usuari");
		while (nom == null || nom.equals("") || (llista.buscarUsuari(nom) != -1)) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Usuari ja existent!", "ERROR", JOptionPane.ERROR_MESSAGE);
			nom = JOptionPane.showInputDialog("Indica el teu nou codi d'usuari ");
		}

        llista.setAlies(indUsuari, nom);
		b.setBackground(Color.WHITE);
    }
}
