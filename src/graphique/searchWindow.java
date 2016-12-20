package graphique;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mvincent on 20/12/16.
 */
public class searchWindow extends JDialog {
    private Dimension screenSize;
    public searchWindow(){
        setSize(350, 250);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);



        setVisible(true);
    }

}
