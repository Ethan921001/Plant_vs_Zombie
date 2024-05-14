package test;

import javax.swing.*;

public class GifTest {
	private String imgsrc;
	private ImageIcon icon;
	
	public GifTest(String src) {
		this.imgsrc=src;
		this.icon=new ImageIcon(src);
	}
	
	public ImageIcon get_icon() {
		return this.icon;
	}
	
	public String get_imgsrc() {
		return this.imgsrc;
	}
}
