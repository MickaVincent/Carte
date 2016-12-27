package window;

import csvToArray.PointInteret;
import graphique.JListCustom;
import javafx.scene.control.SplitPane;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by VINCENT MICKAEL on 26/12/2016.
 */
public class FenetreInfo extends JFrame {
    private JSplitPane splittedPane;
    private JList listTop;
    private JScrollPane scrollerTop;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public FenetreInfo(java.util.List l){
        setWindow();
        //DefaultListModel<String> model = new DefaultListModel<String>(jl);
        DefaultListModel<String> model = new DefaultListModel<String>();
        listTop = new JList<>(model);
        for(Object p : l)
            ((DefaultListModel)listTop.getModel()).addElement(p);
        setPanes();
    }

    public void setWindow() {
        setTitle("Plus d'informations");
        setSize(800, 600);
        setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
        setResizable(false);
        //setModal(true);
        setVisible(true);
    }
    public void setPanes(){
        splittedPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splittedPane.setEnabled(false);

        scrollerTop = new JScrollPane();
        scrollerTop.setPreferredSize(new Dimension(800, 300));
        System.out.println("Liste dans FenetreInfo" + listTop.getModel());

        listTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listTop.setLayoutOrientation(JList.VERTICAL);

        this.listTop.setCellRenderer(new JListCustom());
        scrollerTop.setViewportView(this.listTop);
        splittedPane.setTopComponent(scrollerTop);



        JPanel panelBottom = new JPanel();
        splittedPane.setBottomComponent(panelBottom);
        add(splittedPane);
    }
}
