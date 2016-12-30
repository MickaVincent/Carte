package window;

import parser.MonumentHistorique;
import parser.MonumentList;
import parser.Musee;
import parser.PointInteret;
import graphique.JListCustom;
import parser.Research;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvincent on 20/12/16.
 */
public class FenetreResearch extends JDialog {

    public static boolean isNumeric(String str)
    {
        return str.matches("\\d+");
    }

    private String[] tabMonuments = {"Musee", "Monument Historique", "Les deux"};
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b0, b1;
    private JLabel lbl1, lbl2, lbl3;
    private JTextField fieldRecherche;
    private JList listResearch;
    private String choice1, choice2;
    private JComboBox<String> comboBox, comboBoxCriteres;
    private JScrollPane scroll;
    private GridBagLayout lyt;
    private List<PointInteret> listComplete;
    private List<Musee> listMusee;
    private List<MonumentHistorique> listMonumentsHisto;
    private List<PointInteret> selectedElements;
    private List<Musee> newListM;
    private List<MonumentHistorique> newListH;
    private List<PointInteret> newListB;
    private List<PointInteret> returnList;

    public FenetreResearch(){

        setLists();
        setSize(350, 250);
        lyt = new GridBagLayout();

        setLayout(lyt);
        setModal(true);
        setResizable(false);
        setTitle("Recherche Avancée");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setWidgets();
        setListeners();
        this.setLayout(lyt);
        choice1 = "Musee";
        choice2 = "Adresse";
    }

    private List<MonumentHistorique> castMH(List<PointInteret> lpi){
        List<MonumentHistorique> res = new ArrayList<MonumentHistorique>();
        for (PointInteret item : lpi){
            res.add((MonumentHistorique)item);
        }
        return res;
    }

    private List<Musee> castM(List<PointInteret> lpi){
        List<Musee> res = new ArrayList<Musee>();
        for (PointInteret item : lpi){
            res.add((Musee)item);
        }
        return res;
    }

    private List<PointInteret> castPI(List<MonumentHistorique> mh){
        List<PointInteret> res = new ArrayList<PointInteret>();
        for (MonumentHistorique item : mh){
            res.add(item);
        }
        return res;
    }

    private List<PointInteret> castPi(List<Musee> m){
        List<PointInteret> res = new ArrayList<PointInteret>();
        for (Musee item : m){
            res.add(item);
        }
        return res;
    }

    private void setLists() {
        listComplete = MonumentList.getFullList();

        listMonumentsHisto = MonumentList.getMonumentHistoriqueList();

        listMusee = MonumentList.getMuseesList();

        selectedElements = new ArrayList<>();
        returnList = new ArrayList<>();
    }

    public void setWidgets() {

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        //lyt.setConstraints(this, c);

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
        comboBoxCriteres.addItem("Nom");
        comboBoxCriteres.addItem("Commune");
        comboBoxCriteres.addItem("Numéro INSEE");
        comboBoxCriteres.addItem("Code Postal");
        comboBoxCriteres.setSelectedIndex(0);

        c.gridx = 1;
        c.gridy = 1;

        this.add(comboBoxCriteres, c);

        lbl3 = new JLabel("Mot clé à utiliser : ");
        fieldRecherche = new JTextField("");
        fieldRecherche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(fieldRecherche.getText().equals("Entrer mot clé"))
                fieldRecherche.setText("");
            }
        });

        c.gridx = 0;
        c.gridy = 2;

        this.add(lbl3, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(fieldRecherche, c);

        DefaultListModel<String> model = new DefaultListModel<String>();
        listResearch = new JList<>(model);
        listResearch.setSelectionModel(new DefaultListSelectionModel(){
            @Override
            public void setSelectionInterval(int index0, int index1)
            {
                if(listResearch.isSelectedIndex(index0))
                {
                    listResearch.removeSelectionInterval(index0, index1);
                }
                else
                {
                    listResearch.addSelectionInterval(index0, index1);
                }
            }
        });
        listResearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listResearch.setLayoutOrientation(JList.VERTICAL);


        scroll = new JScrollPane();
        listResearch.setCellRenderer(new JListCustom());
        scroll.setViewportView(listResearch);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 95;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 3;

        this.add(scroll, c);

        for(PointInteret pt : listComplete){
            ((DefaultListModel)listResearch.getModel()).addElement(pt);
        }

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default

        c.insets = new Insets(0,30,0,30);  //top padding
        c.gridx = 0;
        c.gridy = 6;

        b0 = new JButton("Tout sélectionner");
        b1 = new JButton("Afficher les résultats");
        //this.add(b0, c);
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
                    comboBoxCriteres.addItem("Nom");
                    comboBoxCriteres.addItem("Commune");
                    comboBoxCriteres.addItem("Numéro INSEE");
                    comboBoxCriteres.addItem("Code Postal");
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
                    comboBoxCriteres.addItem("Nom");
                    comboBoxCriteres.addItem("Commune");
                    comboBoxCriteres.addItem("Numéro INSEE");
                    comboBoxCriteres.addItem("Code Postal");
                    comboBoxCriteres.addItem("Designation");
                    comboBoxCriteres.addItem("Catégorie");
                    comboBoxCriteres.addItem("Réference");
                    comboBoxCriteres.setSelectedItem("Designation");
                }
                ((DefaultListModel)listResearch.getModel()).removeAllElements();
                selectedElements.removeAll(selectedElements);
                listResearch.setVisible(true);
                checkSelection(fieldRecherche.getText());
                for(PointInteret pt : selectedElements){
                    ((DefaultListModel) listResearch.getModel()).addElement(pt);
                }

                listResearch.setVisible(true);
            }
        });
        comboBoxCriteres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice2 = (String)comboBoxCriteres.getSelectedItem();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<PointInteret> ptInt = listResearch.getSelectedValuesList();
                returnList = ptInt;
                dispose();
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listResearch.setSelectionInterval(0, listResearch.getModel().getSize()-1);
            }
        });

        fieldRecherche.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ((DefaultListModel)listResearch.getModel()).removeAllElements();
                selectedElements.removeAll(selectedElements);
                listResearch.setVisible(true);
                checkSelection(fieldRecherche.getText());
                for(PointInteret pt : selectedElements){
                    ((DefaultListModel) listResearch.getModel()).addElement(pt);
                }

                listResearch.setVisible(true);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                ((DefaultListModel)listResearch.getModel()).removeAllElements();
                selectedElements.removeAll(selectedElements);
                listResearch.setVisible(true);
                checkSelection(fieldRecherche.getText());
                for(PointInteret pt : selectedElements){
                    ((DefaultListModel) listResearch.getModel()).addElement(pt);
                }
                listResearch.setVisible(true);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }
    public List<PointInteret> showDialog() {
        setVisible(true);
        return returnList;
    }
    public void checkSelection(String recherche){
        if(choice1.equals("Musee")){
            if(choice2.equals("Nom")){
                newListM = castM(Research.getWithName(recherche, castPi(listMusee)));
            }
            if(choice2.equals("Commune")){
                newListM = castM(Research.getWithCommune(recherche, castPi(listMusee)));
            }
            if(choice2.equals("Numéro INSEE") && isNumeric(recherche)){
                newListM = castM(Research.getWithInsee(Integer.parseInt(recherche), castPi(listMusee)));
            }
            if(choice2.equals("Code Postal") && isNumeric(recherche)){
                newListM = castM(Research.getWithCP(Integer.parseInt(recherche), castPi(listMusee)));
            }if (choice2.equals("Adresse")) {
                newListM = Research.getWithAdresse(recherche, listMusee);
            }
            if (newListM != null) {
                for (Musee mus : newListM) {
                    selectedElements.add(mus);
                }
            }
        }else{
            if(choice1.equals("Monument Historique")){
                if(choice2.equals("Réference")){
                    newListH = Research.getWithReference(String.valueOf(recherche), listMonumentsHisto);
                }
                if(choice2.equals("Designation")){
                    newListH = Research.getWithDesignation(recherche, listMonumentsHisto);
                }
                if(choice2.equals("Catégorie")){
                    newListH = Research.getWithCategorie(recherche, listMonumentsHisto);
                }
                if(choice2.equals("Nom")){
                    newListH = castMH(Research.getWithName(recherche, castPI(listMonumentsHisto)));
                }
                if(choice2.equals("Commune")){
                    newListH = castMH(Research.getWithCommune(recherche, castPI(listMonumentsHisto)));
                }
                if(choice2.equals("Numéro INSEE") && isNumeric(recherche)){
                    newListH = castMH(Research.getWithInsee(Integer.parseInt(recherche), castPI(listMonumentsHisto)));
                }
                if(choice2.equals("Code Postal") && isNumeric(recherche)){
                    newListH = castMH(Research.getWithCP(Integer.parseInt(recherche), castPI(listMonumentsHisto)));
                }
                if (newListH != null) {
                    for (MonumentHistorique mh : newListH) {
                        selectedElements.add(mh);
                    }
                }
            }else{
                if(choice1.equals("Les deux")){
                    if(choice2.equals("Nom")){
                        newListB = Research.getWithName(recherche, listComplete);
                    }
                    if(choice2.equals("Commune")){
                        newListB = Research.getWithCommune(recherche, listComplete);
                    }
                    if(choice2.equals("Numéro INSEE") && isNumeric(recherche)){
                        newListB = Research.getWithInsee(Integer.parseInt(recherche), listComplete);
                    }
                    if(choice2.equals("Code Postal") && isNumeric(recherche)){
                        newListB = Research.getWithCP(Integer.parseInt(recherche), listComplete);
                    }
                    if (newListB != null) {
                        for (PointInteret pt : newListB) {
                            selectedElements.add(pt);
                        }
                    }
                }
            }
        }
    }
}
