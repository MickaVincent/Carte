package graphique;

import csvToArray.PointInteret;

import javax.swing.*;
import java.awt.*;
import java.io.File;

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

    public static Container getContainer(DefaultListModel<String> model){
        Container c = getContainer();
        /*
        Mettre du bordel ici avec une liste de PointInteret
        si c'est une instance de Musee, rajouter un icone Musee a la position
        Sinon, rajouter une icone en fonction de la désignation de monumentHistorique
         */
        return c;
    }
}