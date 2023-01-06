package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import aplication.Aplicació;
import lists.*;

// Aquest classe serà responsable de tractar els esdeveniments del botó 2.
public class AccionBoton2 implements ActionListener {
    
    private Aplicació finestra;
    private LlistaUsuaris usuaris;
    private LlistaPeticionsIntercanvi inter;
    private int indUsuari;

    public AccionBoton2 (Aplicació finestra, LlistaUsuaris usuaris, LlistaPeticionsIntercanvi inter, int indUsuari){
        this.finestra = finestra;
        this.usuaris = usuaris;
        this.inter = inter;
        this.indUsuari = indUsuari;
    }

    public void actionPerformed(ActionEvent evt) {
        // Obtenim la referència del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		b.setBackground(Color.BLUE);

        // Mostrem per pantalla les ofertes d'intercanvi actives
		JOptionPane.showMessageDialog(null, usuaris.toString(), "Usuaris", 
		JOptionPane.INFORMATION_MESSAGE);
		b.setBackground(Color.WHITE);
    }
}
