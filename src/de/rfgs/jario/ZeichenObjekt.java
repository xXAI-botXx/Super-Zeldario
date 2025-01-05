package de.rfgs.jario;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ZeichenObjekt {
	static List<ZeichenObjekt> zeichenobjekte = new ArrayList<ZeichenObjekt>();
	public int x;
	public int y;
	
	public int ink=5;
	
	public double sc=1;
	public int  w;
	public int h;
	public boolean visible=true;
	public Color col=Color.green;
	private Color colors[] = {Color.green,Color.yellow,Color.blue,Color.orange,Color.gray,Color.red};
	
	public ZeichenObjekt(){
		//Konstruktor setzt default Werte
		x=0;
		y=0;
		w=10;
		h=10;
		zeichenobjekte.add(this);
	}
	
	public ZeichenObjekt(int xv,int yv){
		//Konstruktor setzt default Werte
		x=xv;
		y=yv;
		w=10;
		h=10;
		zeichenobjekte.add(this);
		
	}
	
	public ZeichenObjekt(int xv,int yv,int wv,int hv){
		//Konstruktor setzt default Werte
		x=xv;
		y=yv;
		w=wv;
		h=hv;
		zeichenobjekte.add(this);
		
	}
	
	public ZeichenObjekt(int xv,int yv,int wv,int hv,Color c){
		//Konstruktor setzt default Werte
		x=xv;
		y=yv;
		w=wv;
		h=hv;
		col=c;
		zeichenobjekte.add(this);
	}
	
	public ZeichenObjekt(int xv,int yv,Color c){
		//Konstruktor setzt default Werte
		x=xv;
		y=yv;
		w=10;
		h=10;
		col=c;
		zeichenobjekte.add(this);
		
	}
	
	public void readd(){
		zeichenobjekte.add(this);
	};
	
	public void randomize(int xv,int yv,int sv){
		//Werte werden zufällig verändert
		x=(int)(Math.random()*xv);
		y=(int)(Math.random()*yv);
		
		sc=Math.random()*sv;
		col=colors[(int)(Math.random()*5)];
		zeichenobjekte.add(this);
		
	}
	
	public void zeichneObjekt(Graphics g){
		//Farbe setzen
		g.setColor(col);
		//Rechteck zeichnen
		g.fillRect(x,y,(int)(w*sc),(int)(h*sc));
		
		
	}

}
