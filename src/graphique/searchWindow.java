package graphique;

import csvToArray.MonumentList;
import csvToArray.Musee;
import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by mvincent on 20/12/16.
 */
public class searchWindow extends JDialog {
    private String[] tabMonuments = {"Musee", "Monument Historique", "Les deux"};
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b1, b2;
    private JLabel lbl1;
    private JComboBox<String> comboBox;
    public searchWindow(){
        setSize(350, 250);
        this.setLayout(new FlowLayout());
        setModal(true);
        setResizable(false);
        setTitle("Recherche Avancée");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        lbl1 = new JLabel("Type de structure recherché :");
        comboBox = new JComboBox(tabMonuments);
        this.add(lbl1);
        this.add(comboBox);
        /*DefaultListModel<String> model = new DefaultListModel<String>();

        java.util.List<Musee> maListe = MonumentList.getMuseesList();
        JList jlist = new JList<>(model);
        JScrollPane pane = new JScrollPane();
        for(Musee mus : maListe){
            ((DefaultListModel)jlist.getModel()).addElement(mus);
        }

        //list.add()
        jlist.setCellRenderer(new JListCustom());
        pane.setViewportView(jlist);
        this.add(pane);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setWidgets();
        */setVisible(true);
    }

    public void setWidgets() {
        //String[] tabChoix;
        //comboBox = new JComboBox(Strings);
    }

}
