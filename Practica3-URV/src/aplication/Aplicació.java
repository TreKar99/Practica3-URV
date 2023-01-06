package aplication;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

import classes.*;
import lists.LlistaPeticionsIntercanvi;
import lists.LlistaProductes;
import lists.LlistaUsuaris;
import gui.*;

public class Aplicació extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel botons = new JPanel();
	private JButton b1 = new JButton("Boto1");
	private JButton b2 = new JButton("Boto2");
	private JButton b3 = new JButton("Boto3");
	private JButton b4 = new JButton("Boto4");

	public Aplicació(String titol) {
		super(titol);
		this.setLocation(400, 200);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setLayout(new BorderLayout());

		// Afegim els botons al panell
		botons.setLayout(new FlowLayout());
		botons.add(b1); botons.add(b2); botons.add(b3); botons.add(b4);
		this.add(botons, BorderLayout.NORTH);
		setVisible(true);
	}

	public void addListeners(LlistaPeticionsIntercanvi inter, LlistaUsuaris usuaris, int ind) {
		AccionBoton1 ac1 = new AccionBoton1(this, inter);
		b1.addActionListener(ac1);
		AccionBoton2 ac2 = new AccionBoton2(this, usuaris, inter, ind);
		b2.addActionListener(ac2);
		AccionBoton3 ac3 = new AccionBoton3(this, usuaris, ind);
		b3.addActionListener(ac3);
		AccionBoton4 ac4 = new AccionBoton4(this, usuaris, ind);
		b4.addActionListener(ac4);

	}

	static final int MAX = 5000;
	static Scanner teclat = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// Lectura dels fitxers de productes i intercanvis
		BufferedReader fitxerProductes = new BufferedReader(new FileReader("productesTest.txt"));
		FileWriter fileProducte = new FileWriter("productesTest.txt", true);
		BufferedWriter escriuProductes = new BufferedWriter(fileProducte);

		BufferedReader fitxerPeticioIntercanvi = new BufferedReader(new FileReader("intercanvisTest.txt"));
		FileWriter fileIntercanvi = new FileWriter("intercanvisTest.txt", true);
		BufferedWriter escriuPeticionsIntercanvi = new BufferedWriter(fileIntercanvi);

		LlistaProductes llistaProductes = readProductes(fitxerProductes);
		LlistaPeticionsIntercanvi llistaIntercanvis = readIntercanvis(fitxerPeticioIntercanvi);

		LlistaUsuaris llistaUsuaris = new LlistaUsuaris(100);
		readData(llistaUsuaris);
		
		// Per accedir a qualsevol de les funcionalitats l’usuari ha d’indicar el seu codi	
		String nom = JOptionPane.showInputDialog("Indica el teu codi d'usuari per accedir");
		while (nom == null || nom.equals("") || (llistaUsuaris.buscarUsuari(nom) == -1)) {
			// Missatge d'error.
			JOptionPane.showMessageDialog(null, "Usuari no trobat!", "ERROR", JOptionPane.ERROR_MESSAGE);
			nom = JOptionPane.showInputDialog("Indica el nom del usuari ");
		}
		
		int indUsuari = llistaUsuaris.buscarUsuari(nom);
		Aplicació p = new Aplicació("Xarxa d'intercanvis"); 		
		p.addListeners(llistaIntercanvis, llistaUsuaris, indUsuari);

		// Menú de consola
		mostraMenu();
		int opcio = Integer.parseInt(teclat.nextLine());
		while ((opcio < 18) && (opcio > 0)) {
			switch (opcio) {
				case 1:
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
					opcio5(llistaProductes, escriuProductes);
					break;
				case 6:
					opcio6(llistaProductes, escriuProductes);
					break;
				case 7:
					opcio7(llistaUsuaris, llistaIntercanvis, llistaProductes, escriuPeticionsIntercanvi);
					break;
				case 8:
					opcio8(llistaIntercanvis);
					break;
				case 9:
					opcio9(llistaUsuaris);
					break;
				case 10:
					opcio10(llistaProductes);
					break;
				case 11:
					opcio11(llistaProductes);
					break;
				case 12:
					opcio12(llistaIntercanvis);
					break;
				case 13:
					opcio13(llistaIntercanvis);
					break;
				case 14:
					opcio14(llistaIntercanvis);
					break;
				case 15:
					opcio15(llistaIntercanvis);
					break;
				case 16:
					opcio16(llistaIntercanvis);
					break;
				case 17:
					escriuPeticionsIntercanvi.close();
					opcio17(opcio, llistaUsuaris);
					break;
				case 18:
					break;
			}

			mostraMenu();
			opcio = Integer.parseInt(teclat.nextLine());
			System.out.println("Opció introduida");

		}
	}

	/**
	 * Métode que mostra el menú d'opcions per consola
	 */
	public static void mostraMenu() {
		System.out.println("\n\nOpcions del menu:");
		//System.out.println("\n\t1. Carregar fitxers");
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
		System.out.println("\t17. Guardar dades");
		System.out.println("\t18. Sortir");
		System.out.print("\n\t\t\tIndica opcio:\n");
	}

	/**
	 * Métode que carrega fitxers
	 */
	public static void opcio1(Scanner fitxerProductes, Scanner fitxerIntercanvis, LlistaProductes productes,
			LlistaPeticionsIntercanvi intercanvis) {

		// productes = readProductes(fitxerProductes);
		// intercanvis = readIntercanvis(fitxerIntercanvis);
	}

	/**
	 * Métode que printeja per pantalla la llista indicada
	 * 
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
	 * 
	 * @param LlistaProductes
	 */
	public static void opcio3(LlistaProductes serveis) {
		System.out.println(serveis.serveisActius());
	}

	/**
	 * Métode que printeja per pantalla els productes actius
	 * 
	 * @param LlistaProductes
	 */
	public static void opcio4(LlistaProductes bens) {
		System.out.println(bens.bensActius());
	}

	/**
	 * Métode que afegeix una nova oferta de serveis
	 * 
	 * @throws IOException
	 */
	public static void opcio5(LlistaProductes p, BufferedWriter escriu) throws IOException {

		Servei aux;
		String codiTeclat, descTeclat, dataOfertaTeclat, fiOferimentTeclat;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		System.out.println("Introudeix el codi del servei");
		codiTeclat = teclat.nextLine();
		System.out.println("Introudeix la descripció del servei");
		descTeclat = teclat.nextLine();
		dataOfertaTeclat = dtf.format(now);
		System.out.println("Introudeix la data fi del del servei");
		fiOferimentTeclat = teclat.nextLine();

		aux = new Servei(codiTeclat, descTeclat, dataOfertaTeclat, fiOferimentTeclat);

		p.afegirProducte(aux);

		escriu.newLine();
		escriu.write(codiTeclat + ";" + descTeclat + ";servei;" + dataOfertaTeclat + ";" + fiOferimentTeclat);
		escriu.flush();

	}

	/**
	 * Métode que afegeix un nou producte a intercanviar
	 */
	public static void opcio6(LlistaProductes p, BufferedWriter escriu) throws IOException {
		Be aux;
		String codiTeclat, descTeclat, dataOfertaTeclat;
		float amplada, alcada, fons, pes;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		System.out.println("Introudeix el codi del be");
		codiTeclat = teclat.nextLine();
		System.out.println("Introudeix la descripció del be");
		descTeclat = teclat.nextLine();
		dataOfertaTeclat = dtf.format(now);
		System.out.println("Introudeix la amplada del producte");
		amplada = Float.parseFloat(teclat.nextLine());
		System.out.println("Introudeix la alçada del producte");
		alcada = Float.parseFloat(teclat.nextLine());
		System.out.println("Introudeix la fondaria del producte");
		fons = Float.parseFloat(teclat.nextLine());
		System.out.println("Introudeix la pes del producte");
		pes = Float.parseFloat(teclat.nextLine());

		aux = new Be(codiTeclat, descTeclat, dataOfertaTeclat, amplada, alcada, fons, pes);
		p.afegirProducte(aux);

		escriu.newLine();
		escriu.write(codiTeclat + ";" + descTeclat + ";be;" + dataOfertaTeclat + ";" + amplada + ";" + alcada + ";"
				+ fons + ";" + pes);
		escriu.flush();

	}

	/**
	 * Métode que afegeix una petició d'intercanvi
	 * 
	 * @throws IOException
	 */
	public static void opcio7(LlistaUsuaris llistaUsuaris, LlistaPeticionsIntercanvi llistaIntercanvis,
			LlistaProductes llistaProductes, BufferedWriter escriu) throws IOException {
		String codi, usuariEmisor, usuariRemitent, producteRebre, producteOferit;
		boolean existeix;
		int nota;

		System.out.println("Introdueix el codi de la peticio que vols crear");
		codi = teclat.nextLine();

		do {
			System.out.println("Escriu l'usuari de l'emisor (alies)");
			usuariEmisor = teclat.nextLine();
			existeix = llistaUsuaris.usuariExisteix(usuariEmisor);
		} while (!existeix);

		do {
			System.out.println("Escriu l'usuari del remitent (alies)");
			usuariRemitent = teclat.nextLine();
			existeix = llistaUsuaris.usuariExisteix(usuariRemitent);
		} while (!existeix);

		do {
			System.out.println("Escriu el codi del producte que vols rebre");
			producteRebre = teclat.nextLine();
			existeix = llistaProductes.existeixProducte(producteRebre);
		} while (!existeix);

		do {
			System.out.println("Escriu el codi del producte que ofeixies");
			producteOferit = teclat.nextLine();
			existeix = llistaProductes.existeixProducte(producteOferit);
		} while (!existeix);

		do {
			System.out.println("Escriu la teva valoracio del producte que rebras (0-5)");
			nota = Integer.parseInt(teclat.nextLine());
		} while ((nota > 6) && (nota < 0));

		PeticioIntercanvi aux = new PeticioIntercanvi(codi, usuariEmisor, usuariRemitent, producteRebre,
				producteOferit);
		llistaIntercanvis.afegirPeticio(aux);
		aux.setValoracioEmisor(nota);

		escriu.newLine();
		escriu.write(codi + ";" + usuariEmisor + ";" + usuariRemitent + ";" + producteRebre + ";" + producteOferit
				+ ";false;" + nota + ";-1;false");
		escriu.flush();

	}

	/**
	 * Métode que accepta o refusa una petició d'intercanvi
	 */
	public static void opcio8(LlistaPeticionsIntercanvi intercanvis) throws IOException {

		// BufferedReader file = new BufferedReader(new
		// FileReader("intercanvisTest.txt"));
		Scanner file = new Scanner(new File("intercanvisTest.txt"));
		StringBuffer inputBuffer = new StringBuffer();
		String codiIntercanvi, frase, codiAux, inpString;
		int nota = -1, posaux = -1, puntComa;
		boolean accepta = false;

		do {
			System.out.println("Introdueix el codi de la peticio que vols aceptar o refusar");
			codiIntercanvi = teclat.nextLine();
			posaux = intercanvis.existeixCodiIntercanvi(codiIntercanvi);
		} while (posaux == -1);

		System.out.println("Vols acceptar o refusar aquesta peticio? (Y/N)");
		if (teclat.nextLine().equalsIgnoreCase("y")) {
			do {
				System.out.println("Quina es la teva valoració del producte que has rebut? (0-5)");
				nota = Integer.parseInt(teclat.nextLine());
			} while ((nota > 6) && (nota < 0));
			accepta = true;
			intercanvis.acceptaIntercanvi(codiIntercanvi, nota);

		} else if (teclat.nextLine().equalsIgnoreCase("n")) {
			intercanvis.refusaIntercanvi(codiIntercanvi);
		}

		while (file.hasNextLine()) {
			frase = file.nextLine();
			puntComa = frase.indexOf(';', 0);
			codiAux = frase.substring(0, puntComa);
			if (codiAux.equals(codiIntercanvi)) {
				if (accepta) {
					inputBuffer.append(intercanvis.getLlista()[posaux].toStringAceptada());
				} else {
					inputBuffer.append(intercanvis.getLlista()[posaux].toStringRefusada());
				}
			} else {
				inputBuffer.append(frase);
			}
			if (file.hasNextLine())
				inputBuffer.append("\n");
		}

		inpString = inputBuffer.toString();

		FileOutputStream fileOut = new FileOutputStream("intercanvisTest.txt");
		fileOut.write(inpString.getBytes());
		fileOut.close();
		file.close();

	}

	/**
	 * Métode que dona d'alta un usuari
	 */
	public static void opcio9(LlistaUsuaris llistaUsuaris) {
		String alies, email;
		int codipostal;

		do {
			System.out.println("Alies del teu usuari");
			alies = teclat.nextLine();
		} while (llistaUsuaris.usuariExisteix(alies));

		System.out.println("Escriu el teu email");
		email = teclat.nextLine();
		System.out.println("Escriu el teu codi postal");
		codipostal = Integer.parseInt(teclat.nextLine());

		Usuari aux = new Usuari(alies, email, codipostal);
		llistaUsuaris.afegirUsuari(aux);
	}

	/**
	 * Métode que dona de baixa un bé o producte fisic i
	 * l'elimina de la llista
	 */
	public static void opcio10(LlistaProductes llista) throws IOException {

		Scanner file = new Scanner(new File("productesTest.txt"));
		StringBuffer inputBuffer = new StringBuffer();
		String codi, frase, codiAux, inpString;
		int puntComa;
		boolean desactivat = false;
		System.out.println("Introdueix el be a eliminar");
		codi = teclat.nextLine();
		if (llista.eliminarProducte(codi)) {
			System.out.println("Producte eliminat");
			desactivat = true;
		} else {
			System.out.println("Producte no eliminat");
		}
		if (desactivat) {

			while (file.hasNextLine()) {
				frase = file.nextLine();
				puntComa = frase.indexOf(';', 0);
				codiAux = frase.substring(0, puntComa);
				if (!codiAux.equals(codi)) {
					inputBuffer.append(frase);
				} else {
					inputBuffer.append(frase + ";ELIMINAT");
				}
				if (file.hasNextLine())
					inputBuffer.append("\n");
			}

			inpString = inputBuffer.toString();

			FileOutputStream fileOut = new FileOutputStream("productesTest.txt");
			fileOut.write(inpString.getBytes());
			fileOut.close();

		}
		file.close();
	}

	/**
	 * Métode que desactiva un servei sense esborrarlo de la llista
	 */
	public static void opcio11(LlistaProductes llista) throws IOException {

		Scanner file = new Scanner(new File("productesTest.txt"));
		StringBuffer inputBuffer = new StringBuffer();
		String codi, frase, codiAux, inpString;
		int i, puntComa;
		boolean desactivat = false;

		System.out.println("Introdueix el servei a desactivar");
		codi = teclat.nextLine();
		i = llista.buscarProducte(codi);
		if (i != -1 && llista.getProducte(i).getTipus().equals("servei")) {
			llista.getProducte(i).desactivar();
			System.out.println("El servicio " + codi + " se ha desactivado");
			desactivat = true;
		} else {
			System.out.println("El servicio " + codi + " no se ha encontrado");
		}

		if (desactivat) {

			while (file.hasNextLine()) {
				frase = file.nextLine();
				puntComa = frase.indexOf(';', 0);
				codiAux = frase.substring(0, puntComa);
				if (codiAux.equals(codi)) {
					inputBuffer.append(llista.getProducte(i).toStringFitxer());
				} else {
					inputBuffer.append(frase);
				}
				if (file.hasNextLine())
					inputBuffer.append("\n");
			}

			inpString = inputBuffer.toString();

			FileOutputStream fileOut = new FileOutputStream("productesTest.txt");
			fileOut.write(inpString.getBytes());
			fileOut.close();

		}
		file.close();
	}

	/**
	 * Métode que mostra les peticions d'intercanvi a respondre
	 */
	public static void opcio12(LlistaPeticionsIntercanvi intercanvis) {
		System.out.println(intercanvis.toStringPerRespondre());
	}

	/**
	 * Métode que mostra les peticions d'intercanvi accpetades
	 */
	public static void opcio13(LlistaPeticionsIntercanvi intercanvis) {
		System.out.println(intercanvis.toStringAcceptades());
	}

	/**
	 * Métode que mostra les peticions d'intercanvi refusades
	 */
	public static void opcio14(LlistaPeticionsIntercanvi intercanvis) {
		System.out.println(intercanvis.toStringRefusades());
	}

	/**
	 * Métode que mostra els usuaris que tenen valoracions
	 * superiors a les indicades
	 */
	public static void opcio15(LlistaPeticionsIntercanvi intercanvis) {
		int llindar;
		System.out.println("Introdueix el llindar");
		do
			llindar = Integer.parseInt(teclat.nextLine());
		while (llindar < 0 || llindar > 5);
		System.out.println("Los usuarios son: " + intercanvis.usuarisLlindar(llindar));
	}

	/**
	 * Métode que mostra el servei amb mes intercanvis i el núm
	 * de ells
	 */
	public static void opcio16(LlistaPeticionsIntercanvi intercanvis) {
		System.out.println("El servei mes intercanviat es: " + intercanvis.serveiMesIntercanviat());
	}

	/**
	 * Métode que pregunta a l'usuari si vol
	 * escriure les noves dades introduides o deixar el fitxer com
	 * estava
	 */
	public static void opcio17(int opcio, LlistaUsuaris usuaris) {

		String resposta;

		do {
			System.out.println("Vols guardar les dades introduides anteriorment? (y/n)");
			resposta = teclat.nextLine();
		} while (!(resposta.equalsIgnoreCase("y") || resposta.equalsIgnoreCase("n")));

		if (resposta.equalsIgnoreCase("y")) {
			storeData(usuaris);
		}
	}

	/**
	 * Métode que llegieix el fitxer que conté els productes i retorna una llista
	 * amb els mateixos
	 * 
	 * @param fitxerProductes
	 * @return LlistaProductes
	 * @throws IOException
	 */
	public static LlistaProductes readProductes(BufferedReader fitxerProductes) throws IOException {

		LlistaProductes aux = new LlistaProductes(MAX);
		String frase;

		frase = fitxerProductes.readLine();
		while (frase != null) {
			if (parseProductes(frase) != null) {
				aux.afegirProducte(parseProductes(frase));
			}
			frase = fitxerProductes.readLine();
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
		String codi, descripcio, tipus, dataOferta, fiOferiment, dataIntercanvi;
		float amplada, alcada, fons, pes;

		Scanner atributtes = new Scanner(lineaProducte);
		atributtes.useDelimiter(";");

		codi = atributtes.next();
		descripcio = atributtes.next();
		tipus = atributtes.next();
		dataOferta = atributtes.next();

		if (tipus.toLowerCase().equals("be")) {

			amplada = Float.parseFloat(atributtes.next());
			alcada = Float.parseFloat(atributtes.next());
			fons = Float.parseFloat(atributtes.next());
			pes = Float.parseFloat(atributtes.next());

			if (atributtes.hasNext()) {
				dataIntercanvi = atributtes.next();
				if (!atributtes.hasNext() && !dataIntercanvi.equals("ELIMINAT")) {
					Be aux = new Be(codi, descripcio, tipus, dataOferta, amplada, alcada, fons, pes, dataIntercanvi);
					p = aux.copia();
				} else {
					p = null;
				}
			} else {
				Be aux = new Be(codi, descripcio, tipus, dataOferta, amplada, alcada, fons, pes);
				p = aux.copia();
			}

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
	 * @throws IOException
	 */
	public static LlistaPeticionsIntercanvi readIntercanvis(BufferedReader fitxerPeticioIntercanvi) throws IOException {

		LlistaPeticionsIntercanvi aux = new LlistaPeticionsIntercanvi(MAX);
		String frase;

		frase = fitxerPeticioIntercanvi.readLine();
		while (frase != null) {

			aux.afegirPeticio(parseIntercanvis(frase));
			frase = fitxerPeticioIntercanvi.readLine();
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
		aux.setContestada(Boolean.parseBoolean(atributtes.next()));
		aux.setValoracioEmisor(Integer.parseInt(atributtes.next()));
		aux.setValoracioRemitent(Integer.parseInt(atributtes.next()));
		aux.setAfirmativa(Boolean.parseBoolean(atributtes.next()));

		atributtes.close();

		return (aux);
	}

	public static void readData(LlistaUsuaris list) {
		ObjectInputStream inputFile;
		Usuari[] aux = new Usuari[100];

		try {
			inputFile = new ObjectInputStream(new FileInputStream("usuaris.txt"));
			for (int i = 0; i < list.getLlista().length; i++) {
				aux[i] = ((Usuari) inputFile.readObject());
				if (aux[i] != null) {
					list.afegirUsuari(aux[i].copia());
				}
			}
			inputFile.close();
		} catch (IOException e) {
			System.out.println("Error en l'arxiu d'entrada. " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("Error, no es troba la classe Vehicle." + e);
		} catch (ClassCastException e) {
			System.out.println(
					"Error, el format de l'arxiu no és correcte per la definició actual de la classe Vehicle." + e);
		}
	}

	public static void storeData(LlistaUsuaris aux) {
		ObjectOutputStream outputFile;
		Usuari[] llista = aux.getLlista();
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream("usuaris.txt"));
			for (int i = 0; i < llista.length; i++) {
				outputFile.writeObject(llista[i]);
			}
			outputFile.close();
		} catch (IOException e) {
			System.out.println("Error en l'arxiu de sortida." + e);
		}
	}
}