package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import aplication.Aplicació;
import classes.PeticioIntercanvi;
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
		JOptionPane.showMessageDialog(null, inter.toStringPerRespondre(), "Escull una oferta activa per intercanviar", JOptionPane.INFORMATION_MESSAGE);
		String num_pet = JOptionPane.showInputDialog("Indica el número de oferta activa per intercanviar");
		while (num_pet == null || num_pet.equals("") || (inter.getIsContestada(Integer.parseInt(num_pet)))) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Oferta no disponible!", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, inter.toStringPerRespondre(), "Escull una oferta activa per intercanviar", JOptionPane.INFORMATION_MESSAGE);
            num_pet = JOptionPane.showInputDialog("Indica el número de oferta activa per intercanviar");
		}

        // Mostrem per pantalla els productes del usuari
        JOptionPane.showMessageDialog(null, usuaris.getUsuari(indUsuari).toStringProdsUsu(), "Escull una producte per intercanviar", JOptionPane.INFORMATION_MESSAGE);
		String prod_usu = JOptionPane.showInputDialog("Indica el número del producte per intercanviar");
		while (prod_usu == null || prod_usu.equals("") || (inter.getIsContestada(Integer.parseInt(num_pet)))) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Producte no disponible!", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, usuaris.getUsuari(indUsuari).toStringProdsUsu(), "Escull un producte per intercanviar", JOptionPane.INFORMATION_MESSAGE);
            prod_usu = JOptionPane.showInputDialog("Indica el número del producte per intercanviar");
		}

        // Demanem a l'usuari el codi de l'intercanvi
		String nom_codi = JOptionPane.showInputDialog("Indica el codi de l'intercanvi");
		while (nom_codi == null || prod_usu.equals("") || (inter.existeixCodiIntercanvi(nom_codi) != -1)) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Codi no disponible!", "ERROR", JOptionPane.ERROR_MESSAGE);
            prod_usu = JOptionPane.showInputDialog("Indica el codi de l'intercanvi");
		}

        PeticioIntercanvi pet = new PeticioIntercanvi(nom_codi, usuaris.getAlies(indUsuari), inter.getAliesEmisor(Integer.parseInt(prod_usu)), "1", "2");
        inter.afegirPeticio(pet);

        b.setBackground(Color.WHITE);
    }
}
