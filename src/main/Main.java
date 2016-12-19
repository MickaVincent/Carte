package main;

import csvToArray.Parse;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MIKA EST MAUVAIS LOL !");
		System.out.println("OUAIS TG GROS CON!");

		//fenetre window = new fenetre();
		Parse p = new Parse(new File("C:\\Users\\Hamor\\Desktop\\Carte\\res\\Musee.csv"));
		while(!p.isFinished()) {
			System.out.println(p.nextField());
		}
	}

}
