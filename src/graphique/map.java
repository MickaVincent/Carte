package graphique;

import csvToArray.PointInteret;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Hamor on 25/12/2016.
 */
public class map extends JPanel{

    private File mapFichier = new File("res" + File.separator + "fondCarte.jpg");
    private int widthCarte;
    private int heightCarte;
    private float xMin = 5.25f;
    private float xMax = 7.23f;
    private float yMin = 46.23f;
    private float yMax = 48.183f;
    private static Container cont;

    private BufferedImage imgMap = null;

    //Constructeur ial, devra surement être changé si on passe en buffered image
    private map(){


        try {
            heightCarte = ImageIO.read(mapFichier).getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            widthCarte = ImageIO.read(mapFichier).getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imgMap = new BufferedImage(widthCarte, heightCarte, BufferedImage.TYPE_INT_ARGB);

        try {
            imgMap =ImageIO.read(mapFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        JLabel imageFond = new JLabel(new ImageIcon("res"+ File.separator+"fondCarte.jpg"));
        imageFond.setHorizontalAlignment(JLabel.LEFT);
        widthCarte = imageFond.getIcon().getIconWidth();
        System.out.println(widthCarte);
        heightCarte = imageFond.getIcon().getIconHeight();
        imageFond.setBounds(0, 0, widthCarte, heightCarte);
        imageFond.repaint();
*/
    //    cont = new JPanel();
    //    cont.setLayout(null);

    //    Dimension dim = new Dimension(widthCarte, heightCarte);
    //    cont.setMinimumSize(dim);
    //    cont.setMaximumSize(dim);
    //    cont.add(imageFond);
    //    cont.repaint();
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
            //c.add(new JLabel(mgr.getIcon(p.getCategorie())));
            System.out.println(p.getNom());
        }
        System.out.println();

        c.repaint();
        return c;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgMap, 0, 0, widthCarte, heightCarte, this);
    }
}
