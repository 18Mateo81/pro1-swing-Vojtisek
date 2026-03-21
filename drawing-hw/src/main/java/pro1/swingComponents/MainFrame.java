package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;
    private  int crossSize = 12;
    private  boolean ColoroByPosition = false;

    public MainFrame() {
        this.setTitle("PRO1 Drawing- upraveny pro ukol");
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 0));
        this.add(leftPanel, BorderLayout.WEST);

        JCheckBox colorfy = new JCheckBox("Barevnost :");
        colorfy.setSelected(ColoroByPosition);
        colorfy.addActionListener(e -> // Při změně checkboxu se přepne stav colorByPosition
                ColoroByPosition = colorfy.isSelected());
        leftPanel.add(colorfy);

        JSlider crosSize = new JSlider(0, 100, crossSize);
        crosSize.addChangeListener(e -> crossSize = crosSize.getValue());
        leftPanel.add(new JLabel("Křížek :"));
        leftPanel.add(crosSize);


        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.clearDrawable();
            }
        });
        leftPanel.add(resetButton);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                displayPanel.setDrawable(example(e.getX(), e.getY()));
            }
        });
    }

    private Drawable example(int x, int y) {
        String color = ColoroByPosition ? ColorUtils.getColorForPosition(x, y, displayPanel.getWidth(), displayPanel.getHeight()) : "#808080";  // Pokud je zapnuto, změní barvu podle pozice
        return new Cross(x - crossSize / 2, y - crossSize / 2, crossSize, color);
    }
}