package de.rfgs.jario;

public class Enemy {
	
public int arrayX;
public int arrayY;
public int hp ; 
public BildObjekt gegnerSprite;
public int gegnerID ;





public Enemy(int arrayX, int arrayY) {

	this.arrayX = arrayX;
	this.arrayY = arrayY;
	this.gegnerSprite=new BildObjekt(arrayX*Level.blockGröße ,arrayY*Level.blockGröße ,"gegner"+gegnerID+"png");
}






public int getArrayX() {
	return arrayX;
}






public void setArrayX(int arrayX) {
	this.arrayX = arrayX;
}






public int getArrayY() {
	return arrayY;
}






public void setArrayY(int arrayY) {
	this.arrayY = arrayY;
}






public int getHp() {
	return hp;
}






public void setHp(int hp) {
	this.hp = hp;
}
	

	
	
	
	
	
	
	
}
