package main;

import csvToArray.MonumentList;
import csvToArray.Musee;
import window.FenetreMain;
import graphique.resManager;

import java.io.File;
import java.io.IOException;
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

		resManager mngr = resManager.getInstance();
		try {
			mngr.loadResources("res" + File.separator+"pictogrammes");
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPath();
		System.out.println("MIKA EST MAUVAIS LOL !");
		System.out.println("OUAIS TG GROS CON!");

		FenetreMain window = new FenetreMain();

		System.out.println("Parsing resource map");
		mngr.parseMap();
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
		List<Musee> mu = MonumentList.getMuseesList();

//		List<PointInteret> m = MonumentList.getFullList();
//		for(int i = 0; i < m.size(); i++){
//			System.out.print(m.get(i));
//			System.out.println(m.get(i).getClass());
//		}
	}

}
