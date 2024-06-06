package Game;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.system.GameStage;
import model.system.MusicPlayer;
import controller.button.*;

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
            setLayout(null);            
            
            StartButton button = new StartButton();
            add(button);
            //System.out.println("stage : " + stage);
          
            setTitle("Game");
            setSize(1200, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            BackgroundFrame str_Game = new Game().new BackgroundFrame();
            str_Game.setVisible(true);
        });
    }
}