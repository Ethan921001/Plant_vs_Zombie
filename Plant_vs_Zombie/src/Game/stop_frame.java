package Game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.Game.BackgroundPanel;
import controller.button.Button;
import controller.button.Start_btn;

public class stop_frame extends JFrame{
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
	 
	 public stop_frame() {
		 ImageIcon icon = new ImageIcon("");
         Image image = icon.getImage();

         BackgroundPanel backgroundPanel = new BackgroundPanel(image);
         setContentPane(backgroundPanel);         
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         
         setVisible(false);
         setSize(200, 100);
         setAlwaysOnTop(true);
	 }
	 
	 
}
