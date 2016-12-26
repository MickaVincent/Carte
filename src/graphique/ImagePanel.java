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
 * Created by VINCENT MICKAEL on 26/12/2016.
 */
public class ImagePanel extends JPanel {

    private File mapFichier = new File("res" + File.separator + "fondCarte.jpg");
    private int widthCarte;
    private int heightCarte;
    private BufferedImage imgMap = null;
    private resManager resMgr = resManager.getInstance();
    private List<PointInteret> selectedElements = null;
        public ImagePanel(){
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
            Dimension dim = new Dimension(widthCarte, heightCarte);
            this.setPreferredSize(dim);
            this.setMinimumSize(dim);
        }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgMap, 0, 0, widthCarte, heightCarte, this);

        if(selectedElements != null){
            for(PointInteret interestPoint : selectedElements){
                g.drawImage(resMgr.getIcon(interestPoint.getCategorie()), 0, 0, this);
            }
        }

    }

    public void  updateDisplayedElements(java.util.List<PointInteret> myList){
        selectedElements = myList;
    }

    public int getWidthCarte() {
        return widthCarte;
    }

    public int getHeightCarte() {
        return heightCarte;
    }
}