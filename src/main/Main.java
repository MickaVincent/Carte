package main;

import csvToArray.Monument;
import csvToArray.MonumentList;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		MonumentList ml = new MonumentList("res\\Musee.csv", "res\\MonumentsHistoriquesFrancheComte.csv");
		List<Monument> m = ml.getFullList();
		for(int i = 0; i < m.size(); i++){
			System.out.println(m.get(i));
		}

	}

}
