package graphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fenetre extends JFrame{
    private int widthCarte;
    private int heightCarte;
    private resManager mgr = resManager.getInstance();
    private Container contLeft;
    private JPanel panelRight;
    private JRadioButton rb1, rb2;
    private JSplitPane splitPane;
    public fenetre(){
        this.setResizable(false);
        createWidget();
        setWindowParameters();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createWidget() {

        //Instanciation des widgets du panel Gauche

        JLabel imageFond = new JLabel(new ImageIcon("res"+File.separator+"fondCarte.jpg"));
        imageFond.setHorizontalAlignment(JLabel.LEFT);
        widthCarte = imageFond.getIcon().getIconWidth();
        heightCarte = imageFond.getIcon().getIconHeight();
        imageFond.setBounds(0, 0, widthCarte, heightCarte);
        imageFond.repaint();


        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //Instanciation panel droite/Set

        panelRight = new JPanel();
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));

        //Instanciation des widget du panel Droite

        rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);

        JLabel label = new JLabel(mgr.mapResources.get("gare"));
        panelRight.add(rb1);
        panelRight.add(rb2);
        panelRight.add(label);
        //Instanciation/Set du panel gauche

        contLeft = new Container();
        contLeft.setLayout(null);

        Dimension dim = new Dimension(widthCarte, heightCarte);
        contLeft.setMinimumSize(dim);
        contLeft.add(imageFond);

        splitPane.setLeftComponent(contLeft);
        splitPane.setRightComponent(panelRight);

        setContentPane(splitPane);
    }

    private void setWindowParameters(){
        setSize(widthCarte+500, heightCarte);
    }
    private void setListener(){
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb1.isSelected()){

                }
            }
        });
        rb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb2.isSelected()){

                }
            }
        });
    }
}
