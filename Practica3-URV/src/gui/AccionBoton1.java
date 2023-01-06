package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import aplication.Aplicació;
import lists.*;

// Aquest classe serà responsable de tractar els esdeveniments del botó 1.
public class AccionBoton1 implements ActionListener {
	
	private Aplicació finestra;
	private LlistaPeticionsIntercanvi llista;
	
	public AccionBoton1(Aplicació finestra, LlistaPeticionsIntercanvi llista) {
		this.finestra = finestra;
		this.llista = llista;
	}
	
	public void actionPerformed(ActionEvent evt) {
		// Obtenim la referència del control que ha provocat l'esdeveniment.
		JButton b = (JButton) evt.getSource();
		b.setBackground(Color.BLUE);
		
		// Mostrem per pantalla les ofertes d'intercanvi actives
		JOptionPane.showMessageDialog(null, llista.toStringPerRespondre(), "Ofertes d'intercanvi actives", 
		JOptionPane.INFORMATION_MESSAGE);
		b.setBackground(Color.WHITE);

	}

	
	
    // 2. Listar peticiones de intercambio activas
    // 3. Añadir una peticion de intercambio a una activa
    // 4. Consultar intercambios usuario
        // Tabla de botones con id o nombre producto.
        // Pinchando se podrá consultar el detalle del intercambio
        // Valoracion con colores
    // 5. Canviar alies d'usuari
}
