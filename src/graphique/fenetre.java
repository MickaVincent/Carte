package graphique;

import csvToArray.MonumentList;
import csvToArray.Musee;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.sun.deploy.trace.Trace.flush;

public class fenetre extends JFrame{
    private Dimension screenSize;
    private int widthCarte;
    private int heightCarte;
    private resManager mgr = resManager.getInstance();
    private Container contLeft;
    private JPanel panelRight;
    private JButton but1;
    private JRadioButton rb1, rb2;
    private JScrollPane scroll;
    private java.util.List<Musee> listMuseums = null;
    private JList<String> listDeroulante;
    private JSplitPane splitPane;

    public fenetre(){
        this.setTitle("Cartographie de la Franche-Comte");
        this.setResizable(false);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        createWidget();
        setWindowParameters();
        setListener();

        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setVisible(true);
        scroll.setVisible(false);
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
        splitPane.setEnabled(false);

        //Instanciation panel droite/Set

        panelRight = new JPanel();
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //Instanciation des widget du panel Droite

        scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(530, heightCarte-10));

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

        scroll.setViewportView(listDeroulante);

        rb1 = new JRadioButton("Musee", false);
        rb1.setVerticalAlignment(JRadioButton.TOP);

        rb2 = new JRadioButton("Monuments Historique", false);
        rb2.setVerticalAlignment(JRadioButton.TOP);

        but1 = new JButton("Recherche Avancée");
        JLabel label = new JLabel(mgr.mapResources.get("gare"));

        panelRight.add(rb1);
        panelRight.add(rb2);
        panelRight.add(but1);
        panelRight.add(scroll);

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
        setSize(widthCarte+540, heightCarte);
    }
    private void setListener(){
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb1.isSelected()){
                    System.out.println("rb1/Musée a été trigger");
                    if(listMuseums == null){
                        listMuseums = MonumentList.getMuseesList();
                        for(Musee mus : listMuseums){
                            ((DefaultListModel)listDeroulante.getModel()).addElement(mus.getNom());
                        }
                        sortJList(listDeroulante);
                        scroll.setVisible(true);
                    }else{
                        scroll.setVisible(true);
                    }
                }else{
                    scroll.setVisible(false);
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
        listDeroulante.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    System.out.println(listDeroulante.getSelectedValuesList());
                }
            }
        });
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWindow wind = new searchWindow();
            }
        });
    }
    public void sortJList(JList list){
        ListModel model = list.getModel();
        int n = model.getSize();
        String[] data = new String[n];
        for(int i = 0; i < n; i++){
            data[i] = (String) model.getElementAt(i);
        }
        Arrays.sort(data);
        list.setListData(data);
    }
}
