package window;

import csvToArray.MonumentHistorique;
import csvToArray.MonumentList;
import csvToArray.Musee;
import csvToArray.PointInteret;
import graphique.JListCustom;
import search.research;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvincent on 20/12/16.
 */
public class FenetreResearch extends JDialog {

    private String[] tabMonuments = {"Musee", "Monument Historique", "Les deux"};
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b1, b2;
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
    //TODO PARSER LA MAP ELEMENT PAR ELEMENT ET RANGER DANS LE TRUC DE RENVOIS
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
        comboBoxCriteres.setSelectedIndex(0);

        c.gridx = 1;
        c.gridy = 1;

        this.add(comboBoxCriteres, c);

        lbl3 = new JLabel("Mot Clé à utiliser : ");
        fieldRecherche = new JTextField("Entrer mot clé");

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

        b1 = new JButton("Afficher les résultats");
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
                List<PointInteret> ptInt = listResearch.getSelectedValuesList();
                returnList = ptInt;
                dispose();
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
                //listResearch.setSelectionInterval(0, listResearch.getModel().getSize());
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
                //listResearch.setSelectionInterval(0, listResearch.getModel().getSize());
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
            newListM = research.getWithAdresse(recherche, listMusee);
            for(Musee mus : newListM){
                selectedElements.add(mus);
            }
        }else{
            if(choice1.equals("MonumentHistorique")){
                if(choice2.equals("Reference")){
                    newListH = research.getWithReference(recherche, listMonumentsHisto);
                }
                if(choice2.equals("Designation")){
                    newListH = research.getWithDesignation(recherche, listMonumentsHisto);
                }
                if(choice2.equals("Categorie")){
                    newListH = research.getWithCategorie(recherche, listMonumentsHisto);
                }
                for(MonumentHistorique mh : newListH){
                    selectedElements.add(mh);
                }
            }else{
                if(choice1.equals("Les deux")){
                    if(choice2.equals("Nom")){
                        newListB = research.getWithName(recherche, listComplete);
                    }
                    if(choice2.equals("Commune")){
                        newListB = research.getWithCommune(recherche, listComplete);
                    }
                    if(choice2.equals("Numéro INSEE")){
                        newListB = research.getWithInsee(Integer.parseInt(recherche), listComplete);
                    }
                    if(choice2.equals("Code Postal")){
                        newListB = research.getWithCP(Integer.parseInt(recherche), listComplete);
                    }
                    for(PointInteret pt : newListB){
                        selectedElements.add(pt);
                    }
                }
            }
        }
    }
}
