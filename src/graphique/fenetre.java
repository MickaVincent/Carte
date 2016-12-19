package graphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fenetre extends JFrame{
    private int widthCarte;
    private int heightCarte;

    public fenetre(){
        this.setResizable(false);
        createWidget();
        setWindowParameters();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createWidget() {
        resManager mgr = resManager.getInstance();
        System.out.println(mgr.mapResources.size());
        widthCarte = (new ImageIcon("res/fondCarte.jpg")).getIconWidth();
        heightCarte = (new ImageIcon("res/fondCarte.jpg")).getIconHeight();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        JLabel imageFond = new JLabel(new ImageIcon("res/fondCarte.jpg"));
        ImageIcon icon = mgr.mapResources.get("gare");
        JLabel img = new JLabel(icon);

        JRadioButton rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        JRadioButton rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);
        Dimension dim = new Dimension(widthCarte, heightCarte);

        imageFond.setHorizontalAlignment(JLabel.LEFT);
        imageFond.setMinimumSize(dim);
        imageFond.setMaximumSize(dim);
        imageFond.setPreferredSize(dim);

        splitPane.setLeftComponent(imageFond);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        panelRight.add(rb1);
        panelRight.add(rb2);
        panelRight.add(img);

        splitPane.setRightComponent(panelRight);
        splitPane.setDividerLocation(0.25);


        setContentPane(splitPane);
    }

    private void setListener(){

    }
    private void setWindowParameters(){
        setSize(widthCarte+500, heightCarte);
    }
}
