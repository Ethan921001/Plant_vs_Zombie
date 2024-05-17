package test;

import java.awt.Image;
import javax.swing.*;

public class GifTest {
	private String imgsrc;
	private ImageIcon icon;
	private Image image;
	
	public GifTest(String src) {
		this.imgsrc=src;
		this.icon=new ImageIcon(src);
		this.image=new ImageIcon(src).getImage();
	}
	
	public ImageIcon get_icon() {
		return this.icon;
	}
	
	public String get_imgsrc() {
		return this.imgsrc;
	}
	
	public Image get_image() {
		return image;
	}
}
