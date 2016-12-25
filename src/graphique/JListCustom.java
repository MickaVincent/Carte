package graphique;

import csvToArray.MonumentHistorique;
import csvToArray.Musee;
import csvToArray.PointInteret;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by VINCENT MICKAEL on 25/12/2016.
 */
public class JListCustom extends JLabel implements ListCellRenderer<PointInteret>, Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends PointInteret> list, PointInteret value, int index, boolean isSelected, boolean cellHasFocus) {
        String name = value.getNom();

        setText(name);
        return this;
    }
}
