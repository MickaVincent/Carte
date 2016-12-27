package window;

import csvToArray.MonumentList;
import csvToArray.Musee;
import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by mvincent on 20/12/16.
 */
public class FenetreResearch extends JDialog {
    private String[] tabMonuments = {"Musee", "Monument Historique", "Les deux"};
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b1, b2;
    private JLabel lbl1;
    private String choice1, choice2, choice3;
    private JComboBox<String> comboBox;
    public FenetreResearch(){
        setSize(350, 250);
        this.setLayout(new FlowLayout());
        setModal(true);
        setResizable(false);
        setTitle("Recherche Avancée");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setWidgets();
        setListeners();
        setVisible(true);
    }

    public void setWidgets() {
        lbl1 = new JLabel("Type de structure recherché :");
        comboBox = new JComboBox(tabMonuments);
        this.add(lbl1);
        this.add(comboBox);
    }
    public void setListeners(){
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice1 = (String) comboBox.getSelectedItem();
                System.out.println("Choice Changed : " + choice1);
                //if(choice1.equals())
            }
        });
    }
}
