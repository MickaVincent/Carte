package graphique;

import csvToArray.PointInteret;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;

/**
 * Created by Hamor on 25/12/2016.
 */
public class map {

    private int widthCarte;
    private int heightCarte;
    private float xMin = 5.25f;
    private float xMax = 7.23f;
    private float yMin = 46.23f;
    private float yMax = 48.183f;
    private static Container cont;


    //Constructeur initial, devra surement être changé si on passe en buffered image
    private map(){
        JLabel imageFond = new JLabel(new ImageIcon("res"+ File.separator+"fondCarte.jpg"));
        imageFond.setHorizontalAlignment(JLabel.LEFT);
        widthCarte = imageFond.getIcon().getIconWidth();
        System.out.println(widthCarte);
        heightCarte = imageFond.getIcon().getIconHeight();
        imageFond.setBounds(0, 0, widthCarte, heightCarte);
        imageFond.repaint();

        cont = new Container();
        cont.setLayout(null);

        Dimension dim = new Dimension(widthCarte, heightCarte);
        cont.setMinimumSize(dim);
        cont.setMaximumSize(dim);
        cont.add(imageFond);

    }

    private static map INSTANCE = new map();

    //Getter
    public int getHeightCarte() {
        return heightCarte;
    }

    public int getWidthCarte() {
        return widthCarte;
    }

    public static map getINSTANCE(){
        return INSTANCE;
    }

    public static Container getContainer(){
        return cont;
    }

    //TODO une fonction qui permettra d'avoir la position x et la position y de l'icone
    //TODO voir si une structure est necessaire.

    //Get the new container when a list been passed in argument
    //the returned container will contain icon of element present in myList
    public static Container getContainer(java.util.List<PointInteret> myList){
        Container c = getContainer();
        resManager mgr = resManager.getInstance();
        for (PointInteret p : myList){
//            if(p instanceof csvToArray.Musee){
//                c.add(new JLabel(mgr.getMapResources().get("musee")));
//            }else if(p instanceof csvToArray.MonumentHistorique){
//                System.out.println(mgr.getIcon((p.getCategorie().toLowerCase())));
//                c.add(new JLabel(mgr.getIcon((p.getCategorie().toLowerCase()))));
//            }
            c.add(new JLabel(mgr.getIcon(p.getCategorie())));
            System.out.println(p.getNom());
        }
        System.out.println();

        c.repaint();
        return c;
    }
}
