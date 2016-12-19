package main;

import csvToArray.MonumentList;
import csvToArray.PointInteret;

import java.io.File;
import java.util.List;

public class Main {

	static String pathMusee;
	static String pathMonument;

	private static void setPath(){
		pathMusee = "res" + File.separator + "Musee.csv";
		pathMonument = "res" + File.separator + "MonumentsHistoriquesFrancheComte.csv";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setPath();
		System.out.println("MIKA EST MAUVAIS LOL !");
		System.out.println("OUAIS TG GROS CON!");

		//fenetre window = new fenetre();
/*
		Parse p1 = new Parse(new File("res\\Musee.csv"));
		while(!p1.isFinished()) {
			System.out.println(p1.nextField());
		}

		Parse p2 = new Parse(new File("res\\MonumentsHistoriquesFrancheComte.csv"));
		while(!p2.isFinished()) {
			System.out.println(p2.nextField());
		}
*/
		MonumentList ml = new MonumentList(pathMusee, pathMonument);
		List<PointInteret> m = ml.getFullList();
		for(int i = 0; i < m.size(); i++){
			System.out.println(m.get(i));
		}

	}

}
