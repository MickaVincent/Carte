package main;

import parser.MonumentList;
import parser.Musee;
import window.FenetreMain;
import graphique.ResManager;

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

		ResManager mngr = ResManager.getInstance();
		try {
			mngr.loadResources("res" + File.separator+"pictogrammes");
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPath();

		FenetreMain window = new FenetreMain();


	}

}
