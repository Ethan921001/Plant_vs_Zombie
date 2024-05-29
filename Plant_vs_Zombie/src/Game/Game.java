package Game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.system.GameStage;
import model.system.MusicPlayer;

public class Game {
	
    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image image) {
            this.backgroundImage = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public class BackgroundFrame extends JFrame {
        public BackgroundFrame() {
            ImageIcon icon = new ImageIcon("Images\\Backgrounds\\str_game_background.png");
            Image image = icon.getImage();

            BackgroundPanel backgroundPanel = new BackgroundPanel(image);
            setContentPane(backgroundPanel);
            setLayout(new BorderLayout());

            JButton button = new JButton("Click Me");

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
						BackgroundFrame.this.setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("An error occurred: " + ex.getMessage());
                    }
                }
            });

            add(button, BorderLayout.SOUTH);

            setTitle("Game");
            setSize(1200, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args) {
        BackgroundFrame str_Game = new Game().new BackgroundFrame();
        str_Game.setVisible(true);
    }
}