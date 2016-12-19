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
    private JRadioButton rb1, rb2;

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

        JLabel imageFond = new JLabel(new ImageIcon("res"+File.separator+"fondCarte.jpg"));
        ImageIcon icon = null;
        icon = mgr.mapResources.get("gare");

        JLabel img = new JLabel(icon);

        rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);
        Dimension dim = new Dimension(widthCarte, heightCarte);

        imageFond.setHorizontalAlignment(JLabel.LEFT);


        Container cont = new Container();
        cont.setLayout(null);
        imageFond.setBounds(0, 0, widthCarte, heightCarte);
        imageFond.repaint();

        cont.add(imageFond);
        cont.setMinimumSize(dim);
        splitPane.setLeftComponent(cont);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        panelRight.add(rb1);
        panelRight.add(rb2);
        panelRight.add(img);

        splitPane.setRightComponent(panelRight);
        splitPane.setDividerLocation(0.25);


        setContentPane(splitPane);
    }

    private void setWindowParameters(){
        setSize(widthCarte+500, heightCarte);
    }
}
