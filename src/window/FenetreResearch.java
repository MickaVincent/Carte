package window;

import csvToArray.MonumentList;
import csvToArray.Musee;
import graphique.JListCustom;
import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by mvincent on 20/12/16.
 */
public class FenetreResearch extends JDialog {
    private String[] tabMonuments = {"Musee", "Monument Historique", "Les deux"};
    private String[] listChoix = null;
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b1, b2;
    private JLabel lbl1, lbl2, lbl3;
    private JTextField fieldRecherche;
    private JList listResearch;
    private String choice1, choice2;
    private JComboBox<String> comboBox, comboBoxCriteres;
    private JScrollPane scroll;
    public FenetreResearch(){
        listChoix = new String[2];
        setSize(350, 350);
        GridBagLayout lyt = new GridBagLayout();

        this.setLayout(lyt);
        setModal(true);
        setResizable(false);
        setTitle("Recherche Avancée");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setWidgets();
        setListeners();

        choice1 = "Musee";
        choice2 = "Adresse";
    }

    public void setWidgets() {

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;

        lbl1 = new JLabel("Type de structure recherché :");
        this.add(lbl1, c);

        c.gridx = 1;
        c.gridy = 0;

        comboBox = new JComboBox(tabMonuments);
        comboBox.setSelectedItem("Musee");
        this.add(comboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        lbl2 = new JLabel("Critères de recherche : ");
        this.add(lbl2, c);

        comboBoxCriteres = new JComboBox<>();
        comboBoxCriteres.addItem("Adresse");
        comboBoxCriteres.setSelectedIndex(0);



        this.add(comboBoxCriteres, c);

        lbl3 = new JLabel("Mot Clé à utiliser : ");
        fieldRecherche = new JTextField("Entrer mot clé");

        this.add(lbl3, c);
        this.add(fieldRecherche, c);


        listResearch = new JList();
        listResearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listResearch.setLayoutOrientation(JList.VERTICAL);

        scroll = new JScrollPane();
        listResearch.setCellRenderer(new JListCustom());
        scroll.setViewportView(listResearch);

        this.add(scroll, c);

        b1 = new JButton("Demarrer la Recherche");
        this.add(b1, c);

    }
    public void setListeners(){
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice1 = (String) comboBox.getSelectedItem();
                System.out.println("Choice 1 Changed : " + choice1);
                if(choice1.equals("Musee")){
                    comboBoxCriteres.removeAllItems();
                    comboBoxCriteres.addItem("Adresse");
                    comboBoxCriteres.setSelectedItem("Adresse");
                }
                if(choice1.equals("Les deux")){
                    comboBoxCriteres.removeAllItems();
                    comboBoxCriteres.addItem("Nom");
                    comboBoxCriteres.addItem("Commune");
                    comboBoxCriteres.addItem("Numéro INSEE");
                    comboBoxCriteres.addItem("Code Postal");
                    comboBoxCriteres.setSelectedItem("Nom");

                }
                if(choice1.equals("Monument Historique")){
                    comboBoxCriteres.removeAllItems();
                    comboBoxCriteres.addItem("Designation");
                    comboBoxCriteres.addItem("Catégorie");
                    comboBoxCriteres.addItem("Réference");
                    comboBoxCriteres.setSelectedItem("Designation");
                }
            }
        });
        comboBoxCriteres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice2 = (String)comboBoxCriteres.getSelectedItem();
                System.out.println("Choice 2 Changed : " + choice2);
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listChoix[0] = choice1;
                listChoix[1] = choice2;
                dispose();
            }
        });
    }
    public String[] showDialog() {
        setVisible(true);
        return listChoix;
    }
}
