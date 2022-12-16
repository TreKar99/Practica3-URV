// TOWI BRANCH COMMIT

package aplication;

import java.io.*;
import java.util.Scanner;

import classes.*;
import lists.LlistaPeticionsIntercanvi;
import lists.LlistaProductes;
import lists.LlistaUsuaris;

public class UsaClasesTest {

	static final int MAX = 5000;
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int opcio;
		// Lectura dels fitxers de productes i intercanvis
		Scanner fitxerProductes = new Scanner(new File("productesTest.txt"));
		Scanner fitxerPeticioIntercanvi = new Scanner(new File("intercanvisTest.txt"));

		LlistaProductes llistaProductes = readProductes(fitxerProductes);
		LlistaPeticionsIntercanvi llistaIntercanvis = readIntercanvis(fitxerPeticioIntercanvi);
		LlistaUsuaris llistaUsuaris = new LlistaUsuaris(5);

		// Menú de consola
		mostraMenu();
		opcio = Integer.parseInt(teclat.nextLine());
		while ((opcio < 17) && (opcio > 0)) {
			switch (opcio) {
				case 1:
					opcio1(fitxerProductes, fitxerPeticioIntercanvi,llistaProductes, llistaIntercanvis);
					break;
				case 2:
					opcio2(llistaIntercanvis, llistaProductes, llistaUsuaris);
					break;
				case 3:
					opcio3(llistaProductes);
					break;
				case 4:
					opcio4(llistaProductes);
					break;
				case 5:
					opcio5();
					break;
				case 6:
					opcio6();
					break;
				case 7:
					opcio7();
					break;
				case 8:
					opcio8();
					break;
				case 9:
					opcio9();
					break;
				case 10:
					opcio10();
					break;
				case 11:
					opcio11();
					break;
				case 12:
					opcio12();
					break;
				case 13:
					opcio13();
					break;
				case 14:
					opcio14();
					break;
				case 15:
					opcio15();
					break;
				case 16:
					opcio16();
					break;
				case 17:
					opcio17(opcio);
					break;
			}

			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());

		}

	}

	/**
	 * Métode que mostra el menú d'opcions per consola
	 */
	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		System.out.println("\n\t1. Carregar fitxers");
		System.out.println("\t2. Llistar dades de llistes");
		System.out.println("\t3. Llistar ofertes de serveis actives");
		System.out.println("\t4. Llistar bens o productes fisics disponibles");
		System.out.println("\t5. Afegir nova oferta de serveis");
		System.out.println("\t6. Afegir nou be o producte fisic a intercanviar");
		System.out.println("\t7. Nova peticio d'intercanvi");
		System.out.println("\t8. Aceptar o refusar peticions");
		System.out.println("\t9. Donar d'alta nou usuari");
		System.out.println("\t10. Donar de baix un be o producte físic");
		System.out.println("\t11. Desactivar un servei");
		System.out.println("\t12. Peticions pendents");
		System.out.println("\t13. Peticions acceptades");
		System.out.println("\t14. Peticions refusades");
		System.out.println("\t15. Usuaris amb valoracio superior a 'x'");
		System.out.println("\t16. Servei mes intercanviat");
		System.out.println("\t17. Sortir");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}

	/**
	 * Métode que carrega fitxers
	 */
	public static void opcio1(Scanner fitxerProductes, Scanner fitxerIntercanvis, LlistaProductes productes, LlistaPeticionsIntercanvi intercanvis) {

		//productes = readProductes(fitxerProductes);
		//intercanvis = readIntercanvis(fitxerIntercanvis);
	}

	/**
	 * Métode que printeja per pantalla la llista indicada
	 * @param LlistaPeticionsIntercanvi
	 * @param LlistaProductes
	 * @param LlistaUsuaris
	 */
	public static void opcio2(LlistaPeticionsIntercanvi i, LlistaProductes p, LlistaUsuaris u) {
		String llistaAMostrar;
		System.out.println("Introdueix la llista que vols mostrar (serveis, bens, peticions, usuaris): \n");
		llistaAMostrar = teclat.nextLine();
		if (llistaAMostrar.toLowerCase().equals("bens")) {

			System.out.println(p.toStringBens());

		} else if (llistaAMostrar.toLowerCase().equals("serveis")) {

			System.out.println(p.toStringServeis());

		} else if (llistaAMostrar.toLowerCase().equals("peticions")) {

			System.out.println(i.toString());

		} else if (llistaAMostrar.toLowerCase().equals("usuaris")) {

			System.out.println(u.toString());

		}
	}

	/**
	 * Métode que printeja per pantalla les ofertes de serveis actives
	 * @param LlistaProductes
	 */
	public static void opcio3(LlistaProductes serveis) {
		System.out.println(serveis.serveisActius());
	}

	/**
	 * Métode que printeja per pantalla els productes actius
	 * @param LlistaProductes
	 */
	public static void opcio4(LlistaProductes bens) {
		System.out.println(bens.bensActius());
	}

	/**
	 * Métode que afegeix una nova oferta de serveis
	 */
	public static void opcio5() {

	}

	/**
	 * Métode que afegeix un nou producte a intercanviar
	 */
	public static void opcio6() {

	}

	/**
	 * Métode que afegeix una petició d'intercanvi
	 */
	public static void opcio7() {

	}

	/**
	 * Métode que accepta o refusa una petició d'intercanvi
	 */
	public static void opcio8() {

	}

	/**
	 * Métode que dona d'alta un usuari
	 */
	public static void opcio9() {

	}

	/**
	 * Métode que dona de baixa un bé o producte fisic i
	 * l'elimina de la llista
	 */
	public static void opcio10() {

	}

	/**
	 * Métode que desactiva un servei sense esborrarlo de la llista
	 */
	public static void opcio11() {

	}

	/**
	 * Métode que mostra les peticions d'intercanvi a respondre
	 */
	public static void opcio12() {

	}

	/**
	 * Métode que mostra les peticions d'intercanvi accpetades
	 */
	public static void opcio13() {

	}

	/**
	 * Métode que mostra les peticions d'intercanvi refusades
	 */
	public static void opcio14() {

	}

	/**
	 * Métode que mostra els usuaris que tenen valoracions
	 * superiors a les indicades
	 */
	public static void opcio15() {

	}

	/**
	 * Métode que mostra el servei amb mes intercanvis i el núm
	 * de ells
	 */
	public static void opcio16() {

	}

	/**
	 * Métode que surt de l'aplicació i pregunta a l'usuari si vol
	 * escriure les noves dades introduides o deixar el fitxer com
	 * estava
	 */
	public static int opcio17(int opcio) {

		return (opcio++);
	}

	/**
	 * Métode que llegieix el fitxer que conté els productes i retorna una llista
	 * amb els mateixos
	 * 
	 * @param fitxerProductes
	 * @return LlistaProductes
	 */
	public static LlistaProductes readProductes(Scanner fitxerProductes) {

		LlistaProductes aux = new LlistaProductes(MAX);

		while (fitxerProductes.hasNextLine()) {

			aux.afegirProducte(parseProductes(fitxerProductes.nextLine()));
		}

		return (aux);

	}

	/**
	 * Métode que transforma una linea en un Producte : be o servei
	 * 
	 * @param lineaProducte
	 * @return Producte
	 */
	public static Producte parseProductes(String lineaProducte) {

		Producte p;
		String codi, descripcio, tipus, dataOferta, fiOferiment;
		float amplada, alcada, fons, pes;

		Scanner atributtes = new Scanner(lineaProducte);
		atributtes.useDelimiter(";");

		codi = atributtes.next();
		descripcio = atributtes.next();
		tipus = atributtes.next();
		dataOferta = atributtes.next();

		if (tipus.toLowerCase().equals("be")) {

			// TODO controlar dataIntercanvi
			amplada = Float.parseFloat(atributtes.next());
			alcada = Float.parseFloat(atributtes.next());
			fons = Float.parseFloat(atributtes.next());
			pes = Float.parseFloat(atributtes.next());

			Be aux = new Be(codi, descripcio, tipus, dataOferta, amplada, alcada, fons, pes);
			p = aux.copia();

		} else if (tipus.toLowerCase().equals("servei")) {

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
	 * Métode que llegieix el fitxer que conté els intercanvis i retorna una llista
	 * amb els mateixos
	 * 
	 * @param fitxerPeticioIntercanvi
	 * @return LlistaPeticionsIntercanvi
	 */
	public static LlistaPeticionsIntercanvi readIntercanvis(Scanner fitxerPeticioIntercanvi) {

		LlistaPeticionsIntercanvi aux = new LlistaPeticionsIntercanvi(MAX);

		while (fitxerPeticioIntercanvi.hasNextLine()) {
			aux.AfegirPeticio(parseIntercanvis(fitxerPeticioIntercanvi.nextLine()));
		}
		return (aux);
	}

	/**
	 * Métode que transforma una linea del fitxer en una petició d'intercanvi
	 * 
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
