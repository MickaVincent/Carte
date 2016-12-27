package window;

import javax.swing.*;

import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Hamor on 27/12/2016.
 */
public class FenetreError extends JDialog{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel label;
    private JButton ok;

    public void setWindow() {
        setTitle("Erreur");
        setSize(300, 300);
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
        setResizable(false);
        setAlwaysOnTop(true);
        setModal(true);
        setVisible(true);
    }

    //TODO FAIRE CA BEAU AVEC BOUTON POUR FERMER LA FENETRE
    public void setText(){
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner au minimum\n" + "un élément de la liste.","Erreur",
                JOptionPane.ERROR_MESSAGE);
//        label = new JLabel("Erreur !\n Merci de selectionner des éléments.");
//        label.setRequestFocusEnabled(true);
//        //ok = new JButton("D'accord");
//        add(label);
//        //add(ok);

    }

    FenetreError(){
        //setWindow();
        setText();
        /*
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setTitle("My First Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Welcome");
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
        */
    }
}
