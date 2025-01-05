package de.rfgs.jario;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel
{ 
	public MyPanel (){
		super();
	}
	
	@Override
	public void paintComponent(Graphics g){
		
	super.paintComponent(g);
	
	for(int xu=0;xu<ZeichenObjekt.zeichenobjekte.size();xu++){
		ZeichenObjekt.zeichenobjekte.get(xu).zeichneObjekt(g);
		
		}
	g.setColor(Color.white);
	repaint();
	}

}
