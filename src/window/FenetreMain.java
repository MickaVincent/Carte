package window;

import parser.MonumentHistorique;
import parser.MonumentList;
import parser.Musee;
import parser.PointInteret;
import graphique.ImagePanel;
import graphique.JListCustom;
import graphique.ResManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class FenetreMain extends JFrame{
    private Dimension screenSize;
    private ResManager mgr = ResManager.getInstance();
    private List<PointInteret> elementsSelectionnes = null;
    private Container contLeft;
    private JPanel panelRight;
    private JButton but1, but2;
    private JRadioButton rb1, rb2;
    private JScrollPane scroll;
    private java.util.List<Musee> listMuseums = MonumentList.getMuseesList();
    private java.util.List<MonumentHistorique> listMonuments = MonumentList.getMonumentHistoriqueList();
    private JList listDeroulante;
    private JSplitPane splitPane;
    private ImagePanel panelGauche;

    public FenetreMain(){
        this.setTitle("Cartographie de la Franche-Comte");
        this.setResizable(false);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panelGauche = new ImagePanel();

        setWindowParameters();
        createWidget();
        setListener();

        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setVisible(true);

        scroll.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createWidget() {

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setEnabled(false);

        //Instanciation panel droite/Set

        panelRight = new JPanel();
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //Instanciation des widget du panel Droite

        scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(530, panelGauche.getHeightCarte()-27));

        DefaultListModel<String> model = new DefaultListModel<String>();

        listDeroulante = new JList<>(model);
        listDeroulante.setSelectionModel(new DefaultListSelectionModel(){
            @Override
            public void setSelectionInterval(int index0, int index1)
            {
                if(listDeroulante.isSelectedIndex(index0))
                {
                    listDeroulante.removeSelectionInterval(index0, index1);
                }
                else
                {
                    listDeroulante.addSelectionInterval(index0, index1);
                }
            }
        });
        listDeroulante.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listDeroulante.setLayoutOrientation(JList.VERTICAL);

        ResManager man = ResManager.getInstance();

        listDeroulante.setCellRenderer(new JListCustom());
        scroll.setViewportView(listDeroulante);

        rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);

        but1 = new JButton("Recherche Avancée");
        but2 = new JButton("Plus d'informations");
        Dimension dim = but1.getPreferredSize();
        but1.setPreferredSize(new Dimension(150, (int) dim.getHeight()));
        but2.setPreferredSize(new Dimension(164, (int)dim.getHeight()));

        panelRight.add(rb1);
        panelRight.add(rb2);
        panelRight.add(but1);
        panelRight.add(but2);
        panelRight.add(scroll);
        //this.add(new iconDrawer(mgr.getIcon("musee"), 0, 0));
        //panelRight.paintComponents(panelRight.getGraphics());

        //Instanciation/Set du panel gauche

        //splitPane.setLeftComponent(map.getContainer());

        splitPane.setLeftComponent(panelGauche);
        //splitPane.getLeftComponent().repaint();
        splitPane.setRightComponent(panelRight);

        setContentPane(splitPane);
    }

    public void refresh(List<PointInteret> elementsSelectionnes){
        panelGauche.updateDisplayedElements(elementsSelectionnes);
        splitPane.setLeftComponent(panelGauche);
        setContentPane(splitPane);
    }

    private void setWindowParameters(){
        //setSize(800, maMap.getHeightCarte()+30);
        setSize(930, panelGauche.getHeightCarte()+30);
    }
    private void setListener(){
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb1.isSelected()){
                    if(rb2.isSelected()) {
                        rb2.setSelected(false);
                    }
                    panelGauche.flushDisplayedElements();
                    ((DefaultListModel)listDeroulante.getModel()).removeAllElements();
                    for(Musee mus : listMuseums){
                        ((DefaultListModel)listDeroulante.getModel()).addElement(mus);
                    }
                    scroll.setVisible(true);
                }else{
                scroll.setVisible(false);
                }
            }
        });
        rb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb2.isSelected()){
                    if (rb1.isSelected()){
                        rb1.setSelected(false);
                    }
                    panelGauche.flushDisplayedElements();
                    ((DefaultListModel)listDeroulante.getModel()).removeAllElements();
                    for(MonumentHistorique monHistorique : listMonuments){
                            ((DefaultListModel)listDeroulante.getModel()).addElement(monHistorique);
                    }
                    scroll.setVisible(true);
                }else{
                    scroll.setVisible(false);
                }
            }
        });
        listDeroulante.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    elementsSelectionnes = listDeroulante.getSelectedValuesList();
                    refresh(elementsSelectionnes);
                }
            }
        });
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGauche.flushDisplayedElements();
                ((DefaultListModel)listDeroulante.getModel()).removeAllElements();

                if(rb1.isSelected()) rb1.setSelected(false);
                if(rb2.isSelected()) rb2.setSelected(false);
                FenetreResearch wind = new FenetreResearch();
                List<PointInteret> choix = wind.showDialog();

                for(PointInteret ptr  : choix){
                    ((DefaultListModel)listDeroulante.getModel()).addElement(ptr);
                }
                listDeroulante.setSelectionInterval(0, listDeroulante.getModel().getSize()-1);
                elementsSelectionnes = listDeroulante.getSelectedValuesList();
                refresh(elementsSelectionnes);
                scroll.setVisible(true);
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((listDeroulante.getSelectedValuesList().size())==0){
                    FenetreError fenError = new FenetreError();
                }else{
                    FenetreInfo fenInfo = new FenetreInfo(listDeroulante.getSelectedValuesList());
                }
            }
        });
    }
}
