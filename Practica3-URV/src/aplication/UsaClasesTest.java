package aplication;

import java.io.*;
import java.util.Scanner;

import classes.*;
import lists.LlistaUsuaris;

public class UsaClasesTest {
    public static void main(String[] args) throws IOException{
			Scanner fitxerUsuaris = new Scanner(new File("elcolega.txt"));
			//ObjectOutputStream fitxerSortida = new ObjectOutputStream(new FileOutputStream("Densitat.bin"));


			LlistaUsuaris llistaUsers = new LlistaUsuaris(2);
			String usuari;

			while(fitxerUsuaris.hasNextLine()){
				usuari = fitxerUsuaris.nextLine();
				readUsuaris(usuari, llistaUsers);
				System.out.println(usuari);
			}


			fitxerUsuaris.close();
	
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
	public static void readProductes() {

	}
}


