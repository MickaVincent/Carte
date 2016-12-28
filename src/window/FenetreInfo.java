package window;

import csvToArray.PointInteret;
import graphique.JListCustom;
import javafx.scene.control.SplitPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;

/**
 * Created by VINCENT MICKAEL on 26/12/2016.
 */
public class FenetreInfo extends JDialog {
    private JSplitPane splittedPane;
    private JList listTop;
    private JScrollPane scrollerTop;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private PointInteret p;
    private JLabel lblNom, lblNumInsee, lblLong, lblLat, lblDesc, lblDepart, lblComm;
    public FenetreInfo(java.util.List l){
        setWindow();
        //DefaultListModel<String> model = new DefaultListModel<String>(jl);
        DefaultListModel<String> model = new DefaultListModel<String>();
        listTop = new JList<>(model);
        listTop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //listTop.setCellRenderer(new JListCustom());
        for(Object p : l)
            ((DefaultListModel)listTop.getModel()).addElement(p);
        setListener();
        setLabels();
        setPanes();
    }


    //Setter
    //TODO faire une classe listener ?
    private void setListener(){
        listTop.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                //Correspond a un PointInteret se faisant selectionné
                if(e.getValueIsAdjusting()){
                    p = (PointInteret) listTop.getSelectedValue();
                    printInformations(p);
                    //refresh(elementsSelectionnes);
                }
            }
        });
    }
    private void setLabels(){
        lblComm = new JLabel();
        lblNom = new JLabel();
        lblDesc = new JLabel("Description: ");
        lblNumInsee = new JLabel("Numero INSEE : ");
        lblLong = new JLabel("Longitude : ");
        lblLat = new JLabel("Latitude : ");
        lblDepart = new JLabel("Departement : ");
    }
    private void printInformations(PointInteret p) {
        JPanel paneInfo = new JPanel();
        paneInfo.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 20;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;

        Dimension d = new Dimension(800, 80);

        lblNom.setText("Nom : " + p.getNom());

        paneInfo.add(lblNom, c);

        c.gridx = 0;
        c.gridy = 1;
        lblLong.setText("Longitude : " + p.getLongitude());
        paneInfo.add(lblLong, c);

        c.gridx = 0;
        c.gridy = 2;
        lblLat.setText("Latitude : " + p.getLatitude());
        paneInfo.add(lblLat, c);

        c.gridx = 0;
        c.gridy = 3;
        lblNumInsee.setText("Num Insee : " + p.getNumInsee());
        paneInfo.add(lblNumInsee, c);

        c.gridx = 0;
        c.gridy = 4;
        lblDepart.setText("Departement : " + p.getDepartement());
        paneInfo.add(lblDepart, c);

        c.gridx = 0;
        c.gridy = 5;
        lblComm.setText("Commune : " + p.getCommune());
        paneInfo.add(lblComm, c);

        c.gridx = 0;
        c.gridy = 6;
        c.ipady = 0;
        JTextArea txtDesc = new JTextArea(20, 15);
        txtDesc.setLineWrap(true);
        txtDesc.setWrapStyleWord(true);
        txtDesc.setText("Description : " + p.getDescription());
        txtDesc.setPreferredSize(new Dimension(800, 200));
        txtDesc.setMinimumSize(new Dimension(800, 200));
        txtDesc.setEditable(false);
        txtDesc.setBackground(this.getBackground());

        paneInfo.add(txtDesc, c);

        paneInfo.setMinimumSize(new Dimension(800, 300));
        paneInfo.setPreferredSize(new Dimension(800, 300));
        splittedPane.setBottomComponent(paneInfo);
        repaint();
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
        splittedPane.setDividerLocation(300);
        scrollerTop = new JScrollPane();
        scrollerTop.setPreferredSize(new Dimension(800, 300));
        System.out.println("Liste dans FenetreInfo" + listTop.getModel());

        listTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        listTop.setLayoutOrientation(JList.VERTICAL);

        this.listTop.setCellRenderer(new JListCustom());
        scrollerTop.setViewportView(this.listTop);

        splittedPane.setTopComponent(scrollerTop);


        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelBottom.setMinimumSize(new Dimension(800, 300));
        panelBottom.setPreferredSize(new Dimension(800, 300));

        splittedPane.setBottomComponent(panelBottom);

        add(splittedPane);

        pack();
    }
}
