package github.devNie.graphics;

import javax.swing.*;

import github.devNie.constants.Constants.GAME;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;


public class Window {
    private static final JFrame window = new JFrame("Pong!");

    public static void create() {
        window.setMinimumSize(new Dimension(GAME.WIDTH.getValue(), GAME.HEIGHT.getValue()));
        window.setSize(window.getMinimumSize());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setIconImage(new ImageIcon("Resources/icon.png").getImage());
        window.setLayout(new GridBagLayout());
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setVisible(true);
    }

    public static JFrame getFrame() {
        return window;
    }

    private static void newButton(JPanel panel, GridBagConstraints gbc, JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setSize(100,20);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {    // add sfx
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                button.setForeground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                button.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setForeground(Color.BLACK);
            }
        });

        panel.add(button, gbc);
    }


    public static void setMenu() {
        window.getContentPane().removeAll();

        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50,0,0,0);

        // add tittle
        ImageIcon icon = new ImageIcon(new ImageIcon("Resources/icon.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel title = new JLabel(" Pong!", icon, JLabel.LEADING);
        Map<TextAttribute, Object> attributes = new HashMap<>();   // text attribute mapping
        attributes.put(TextAttribute.TRACKING, 0.5);    // adding tracking
        title.setFont(new Font("Arial",Font.BOLD,30).deriveFont(attributes));
        menu.add(title,gbc);

        // add buttons

        JButton start = new JButton("Start");
        newButton(menu, gbc, start);

        // add separator
        gbc.insets.top = 25;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.DARK_GRAY);
        separator.setBackground(Color.DARK_GRAY);
        menu.add(separator, gbc);

        JButton about = new JButton("About");
        newButton(menu, gbc, about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAbout();
            }
        });


        window.add(menu);
        window.pack();
        window.repaint();
    }

    public static void setAbout() {
        window.getContentPane().removeAll();

        JPanel about = new JPanel();
        about.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50,0,0,0);


        JLabel aboutText = new JLabel();
        aboutText.setFont(new Font("Arial",Font.PLAIN,20));
        aboutText.setText("<html>This project is an improvement to my previous pong style game project.<br>" +
                "It incorporates, to my reckoning, only Swing.<br><br>" +
                "Project by devNie</html>");

        about.add(aboutText, gbc);


        gbc.insets.top = 25;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.DARK_GRAY);
        separator.setBackground(Color.DARK_GRAY);

        about.add(separator, gbc);


        JButton back = new JButton("Back");
        newButton(about, gbc, back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMenu();
            }
        });


        window.add(about);
        window.pack();
        window.repaint();
    }

}
