package graphique;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mvincent on 20/12/16.
 */
public class searchWindow extends JDialog {
    private Dimension screenSize;
    private BoxLayout layout = new BoxLayout(this, 0);
    private JButton b1, b2;
    private JComboBox comboBox;
    public searchWindow(){
        setSize(350, 250);
        setModal(true);
        setResizable(false);
        setTitle("Recherche Avancée");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setWidgets();
        setVisible(true);
    }

    public void setWidgets() {
        String[] tabChoix;
        comboBox = new JComboBox(Strings);
    }

}
