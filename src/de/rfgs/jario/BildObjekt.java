package de.rfgs.jario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BildObjekt extends ZeichenObjekt{
	private BufferedImage bild;
	public boolean leftLook=false;
	public String src;
	
	
	
	
	public BildObjekt(int x,int y,String src){
		super(x,y,16,16);
		 try {
	          this.src=src;
	           bild = ImageIO.read(new File("bilder/"+src));
	       } catch (IOException ex) {
	           System.out.println("Datei existiert nicht:" +ex.toString());
	           ex.printStackTrace();
	           //System.exit(0);
	       };
		
		
	}
	public BildObjekt(int x,int y,int w,int h,String src){
		super(x,y,w,h);
		 try {
	          
	           bild = ImageIO.read(new File("bilder/"+src));
	       } catch (IOException ex) {
	           System.out.println("Datei existiert nicht:" +ex.toString());
	           ex.printStackTrace();
	           //System.exit(0);
	       };
		
		
	}
	
	public BildObjekt(String src){ //bild gelesen und liste in zeichenobjekt hinzugefügt
		super(0,0,16,16);
		 try {
	          
	           bild = ImageIO.read(new File("bilder/"+src));
	       } catch (IOException ex) {
	           System.out.println("Datei existiert nicht:" +ex.toString());
	           ex.printStackTrace();
	           //System.exit(0);
	       };
		
		
	}
	
	
	public void setHeldbild(String src) {
		
		 try {
	          
	           bild = ImageIO.read(new File("bilder/"+src));
	       } catch (IOException ex) {
	           System.out.println("Datei existiert nicht:" +ex.toString());
	           ex.printStackTrace();
	           //System.exit(0);
	       };
	}
	
	public void getHeldBild(){
		return;
	}
	
	
	@Override
	public void zeichneObjekt(Graphics g){
		if(leftLook)
			{
			g.drawImage(bild, x+w,y,-w,h,null);
			}
		else{
			g.drawImage(bild, x,y,w,h,null);
		}
		
	}
	

}
