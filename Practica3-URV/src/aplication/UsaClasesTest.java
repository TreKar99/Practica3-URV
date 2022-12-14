package aplication;

import java.io.*;
import java.util.Scanner;

import classes.*;
import lists.LlistaPeticionsIntercanvi;
import lists.LlistaProductes;
import lists.LlistaUsuaris;

public class UsaClasesTest {

	static final int MAX = 5000;
    public static void main(String[] args) throws IOException{

			//Scanner fitxerUsuaris = new Scanner(new File("elcolega.txt"));
			//ObjectOutputStream fitxerSortida = new ObjectOutputStream(new FileOutputStream("Densitat.bin"));
			Scanner fitxerProductes = new Scanner(new File("productesTest.txt"));
			Scanner fitxerPeticioIntercanvi = new Scanner(new File("intercanvisTest.txt"));
			

			LlistaProductes llistaProductes = readProductes(fitxerProductes);
			System.out.println(llistaProductes.toString());
			fitxerProductes.close();

			LlistaPeticionsIntercanvi llistaPeticions = readIntercanvis(fitxerPeticioIntercanvi);
			System.out.println(llistaPeticions.toString());
			fitxerPeticioIntercanvi.close();

			//LlistaUsuaris llistaUsers = new LlistaUsuaris(2);
			//String usuari;

			/*while(fitxerUsuaris.hasNextLine()){
				usuari = fitxerUsuaris.nextLine();
				readUsuaris(usuari, llistaUsers);
				System.out.println(usuari);
			}


			fitxerUsuaris.close();*/
	
	}
	public static void readUsuaris(String usuari, LlistaUsuaris llistaUsers) {
		Scanner atributtes = new Scanner(usuari);
		atributtes.useDelimiter(";");

		String alies, email;
		int codiPostal;

		alies = atributtes.next();
		email = atributtes.next();
		codiPostal = Integer.parseInt(atributtes.next());

		Usuari currUser = new Usuari(alies, email, codiPostal);
		llistaUsers.AfegirUsuari(currUser);

		
		atributtes.close();
	}

	/**
	 * Métode que llegieix el fitxer que conté els productes i retorna una llista amb els mateixos
	 * @param fitxerProductes
	 * @return LlistaProductes
	 */
	public static LlistaProductes readProductes(Scanner fitxerProductes) {

		LlistaProductes aux = new LlistaProductes(MAX);

		while(fitxerProductes.hasNextLine()) {

			aux.afegirProducte(parseProductes(fitxerProductes.nextLine()));
		}

		return (aux);

	}

	/**
	 * Métode que transforma una linea en un Producte : be o servei
	 * @param lineaProducte
	 * @return Producte
	 */
	public static Producte parseProductes(String lineaProducte) {

		Producte p;
		String codi, descripcio, tipus, dataOferta, fiOferiment;
		float amplada, alcada, fons ,pes;

		Scanner atributtes = new Scanner(lineaProducte);
		atributtes.useDelimiter(";");

		codi = atributtes.next();
		descripcio = atributtes.next();
		tipus = atributtes.next();
		dataOferta = atributtes.next();

		if (tipus.toLowerCase() == "be") {

			amplada = Float.parseFloat(atributtes.next());
			alcada = Float.parseFloat(atributtes.next());
			fons = Float.parseFloat(atributtes.next());
			pes = Float.parseFloat(atributtes.next());

			Be aux = new Be(codi, descripcio, tipus, dataOferta, amplada, alcada, fons, pes);
			p = aux.copia();

		} else if (tipus.toLowerCase() == "servei") {

			fiOferiment = atributtes.next();

			Servei aux = new Servei(codi, descripcio, tipus, dataOferta, fiOferiment);
			p = aux.copia();
		} else {
			p = null;
		}

		atributtes.close();
		return (p);
	}

	/**
	 * Métode que llegieix el fitxer que conté els intercanvis i retorna una llista amb els mateixos
	 * @param fitxerPeticioIntercanvi
	 * @return LlistaPeticionsIntercanvi
	 */
	public static LlistaPeticionsIntercanvi readIntercanvis(Scanner fitxerPeticioIntercanvi) {

		LlistaPeticionsIntercanvi aux = new LlistaPeticionsIntercanvi(MAX);

		while(fitxerPeticioIntercanvi.hasNextLine()) {
			aux.AfegirPeticio(parseIntercanvis(fitxerPeticioIntercanvi.nextLine()));
		}
		return (aux);
	}

	/**
	 * Métode que transforma una linea del fitxer en una petició d'intercanvi
	 * @param lineaIntercanvi
	 * @return PeticioIntercanvi
	 */
	public static PeticioIntercanvi parseIntercanvis(String lineaIntercanvi) {

		PeticioIntercanvi aux;

		Scanner atributtes = new Scanner(lineaIntercanvi);
		atributtes.useDelimiter(";");

		aux = new PeticioIntercanvi(atributtes.next());
		aux.setUsuariEmisor(atributtes.next());
		aux.setUsuariRemitent(atributtes.next());
		aux.setProducteOferit(atributtes.next());
		aux.setProducteRebre(atributtes.next());
		aux.setAfirmativa(Boolean.parseBoolean(atributtes.next()));
		aux.setValoracioEmisor(Integer.parseInt(atributtes.next()));
		aux.setValoracioRemitent(Integer.parseInt(atributtes.next())); 

		atributtes.close();

		return (aux);
	}
}


