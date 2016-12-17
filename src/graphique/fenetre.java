package graphique;

import javax.swing.*;
import java.awt.*;

public class fenetre extends JFrame{
    public fenetre(){
        createWidget();
        setVisible(true);

    }

    private void createWidget() {
        JRadioButton rb1 = new JRadioButton("Musee", false);
        JRadioButton rb2 = new JRadioButton("Monuments Historique", false);
    }
    private void setListener(){

    }
    private void setWindowParameters(){

    }
}
