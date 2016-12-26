package graphique;

import javafx.scene.control.SplitPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VINCENT MICKAEL on 26/12/2016.
 */
public class FenetreInfo extends JFrame {
    private JSplitPane splittedPane;
    private JList listTop;
    private JScrollPane scrollerTop;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public FenetreInfo(){
        setWindow();
        setPanes();
    }

    public void setWindow() {
        setTitle("Plus d'informations");
        setSize(800, 600);
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
        setResizable(false);

        setVisible(true);
    }
    public void setPanes(){
        splittedPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splittedPane.setEnabled(false);

        scrollerTop = new JScrollPane();
        scrollerTop.setPreferredSize(new Dimension(800, 300));

        DefaultListModel<String> model = new DefaultListModel<String>();

        listTop = new JList<>(model);
        listTop.setSelectionModel(new DefaultListSelectionModel());

        listTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listTop.setLayoutOrientation(JList.VERTICAL);

        listTop.setCellRenderer(new JListCustom());
        scrollerTop.setViewportView(listTop);

        splittedPane.setTopComponent(scrollerTop);



        JPanel panelBottom = new JPanel();

        splittedPane.setBottomComponent(panelBottom);
        add(splittedPane);
    }
}
