package window;

import csvToArray.MonumentList;
import csvToArray.Musee;
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
    private JLabel lbl1, lbl2;
    private String choice1, choice2;
    private JComboBox<String> comboBox, comboBoxCriteres;
    public FenetreResearch(){
        listChoix = new String[2];
        setSize(350, 250);
        this.setLayout(new FlowLayout());
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
        lbl1 = new JLabel("Type de structure recherché :");
        comboBox = new JComboBox(tabMonuments);
        comboBox.setSelectedItem("Musee");

        this.add(lbl1);
        this.add(comboBox);

        lbl2 = new JLabel("Critères de recherche : ");

        comboBoxCriteres = new JComboBox<>();
        comboBoxCriteres.addItem("Adresse");
        comboBoxCriteres.setSelectedIndex(0);


        this.add(lbl2);
        this.add(comboBoxCriteres);
        b1 = new JButton("Demarrer la Recherche");
        this.add(b1);
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
