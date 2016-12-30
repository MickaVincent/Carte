package graphique;

import parser.PointInteret;

import javax.swing.*;
import java.awt.*;

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

        if (isSelected) {
            setBackground(list.getSelectionBackground());
//            setBackground(new Color(64, 180, 220));
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setText(name);
        setOpaque(true);
        return this;
    }
}
