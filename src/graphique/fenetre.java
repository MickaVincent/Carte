package graphique;

import csvToArray.MonumentList;
import csvToArray.Musee;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.sun.deploy.trace.Trace.flush;

public class fenetre extends JFrame{
    private int widthCarte;
    private int heightCarte;
    private resManager mgr = resManager.getInstance();
    private Container contLeft;
    private JPanel panelRight;
    private JRadioButton rb1, rb2;

    private java.util.List<Musee> listMuseums;
    private JList<String> listDeroulante;
    private JSplitPane splitPane;
    //private MonumentList monumentList = new MonumentList("res"+File.separator+"Musee.csv", "res"+File.separator+"MonumentsHistoriquesFrancheComte.csv");

    public fenetre(){
        this.setResizable(false);
        //monumentList.getFullList();
        createWidget();
        setWindowParameters();
        setListener();

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
        panelRight.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        //Instanciation des widget du panel Droite

        DefaultListModel<String> model = new DefaultListModel<>();
        listDeroulante = new JList<>(model);
        listDeroulante.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listDeroulante.setMinimumSize(new Dimension(200, 200));
        listDeroulante.setMaximumSize(new Dimension(200, 200));
        listDeroulante.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        listDeroulante.setLayoutOrientation(JList.VERTICAL);
        listDeroulante.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(listDeroulante);
        listScroller.setPreferredSize(new Dimension(250, 80));

        rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);


        JLabel label = new JLabel(mgr.mapResources.get("gare"));

        panelRight.add(rb1);
        panelRight.add(rb2);
        //panelRight.add(label);
        panelRight.add(listDeroulante);
        //panelRight.add(listScroller);
        //Instanciation/Set du panel gauche

        contLeft = new Container();
        contLeft.setLayout(null);

        Dimension dim = new Dimension(widthCarte, heightCarte);
        contLeft.setMinimumSize(dim);
        contLeft.add(imageFond);
        //contLeft.add(label);

        splitPane.setLeftComponent(contLeft);
        splitPane.setRightComponent(panelRight);

        setContentPane(splitPane);
    }

    private void setWindowParameters(){
        setSize(widthCarte+525, heightCarte);
    }
    private void setListener(){
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb1.isSelected()){
                    System.out.println("rb1/Musée a été trigger");

                    listMuseums = MonumentList.getMuseesList();
                    for(Musee mus : listMuseums){
                        ((DefaultListModel)listDeroulante.getModel()).addElement(mus.getNom());
                    }

                }else{
                    ((DefaultListModel)listDeroulante.getModel()).removeAllElements();
                }
            }
        });
        rb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb2.isSelected()){
                    System.out.println("rb2 a été trigger");
                }
            }
        });
    }
}
