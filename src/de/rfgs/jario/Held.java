/*package de.rfgs.jario;      22.06.2018

public class Held {
	
public int hp = 3;
public int xPosition = Level.blockGröße ;
public int yPosition = Level.blockGröße ;
public boolean moved = true;
public int originalMovementDelay = 2;
public int currentMovementDelay = originalMovementDelay;
public BildObjekt heldSprite;
public Level level;

public Held(int hp, int xPosition, int yPosition, int originalMovementDelay , Level level) {
	
	this.hp = hp;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	this.originalMovementDelay = originalMovementDelay;
	this.level=level;
	this.heldSprite=new BildObjekt(Level.blockGröße ,Level.blockGröße ,"Mario_small.png");
	
	BildObjekt heldSprite=new BildObjekt(Level.blockGröße ,Level.blockGröße ,"Mario_small.png");
}




	public void keyPressed(char pressedChar){
		if(moved){
			
			
			switch(pressedChar){
			case 'w' : yPosition -= Level.blockGröße ;
					heldSprite.y -= Level.blockGröße ;
					level.bereich.repaint();
					moved = false;
			break;
			case 's' : yPosition += Level.blockGröße;
					heldSprite.y += Level.blockGröße ;
					level.bereich.repaint();
					moved = false;
			break;
			case 'a' : xPosition -= Level.blockGröße;
					heldSprite.x -= Level.blockGröße ;
					level.bereich.repaint();
					moved = false;
			break;
			case 'd' : xPosition += Level.blockGröße;
					heldSprite.x += Level.blockGröße ;
			   		level.bereich.repaint();
			   		moved = false;
	}
	
		}
	
}
}*/

package de.rfgs.jario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Held  {
  
public int hp = 3;
public int xPosition = Level.blockGröße ;
public int yPosition = Level.blockGröße ;
public boolean moved = true;
public int originalMovementDelay = 2;
public int currentMovementDelay = originalMovementDelay;
public BildObjekt heldSprite;
public Level level;
public int dashCooldown = 10 ;
public int currentDashCooldown = 0;
public int dashRange = 3 ;
public int ausrichtung = 0;

public Held(int hp, int xPosition, int yPosition, int originalMovementDelay , Level level) {
  
	
  this.hp = hp;
  this.xPosition = xPosition;
  this.yPosition = yPosition;
  this.originalMovementDelay = originalMovementDelay;
  this.level=level;
  this.heldSprite=new BildObjekt(Level.blockGröße ,Level.blockGröße ,"userDown.png");
  
  //BildObjekt heldSpriteDown=new BildObjekt(Level.blockGröße ,Level.blockGröße ,"userDown.png");
 
//heldSprite=heldSpriteDown;


}




  public void keyPressed(boolean[] pressedKeyCodes){
    if(moved){
      
    	if(pressedKeyCodes[32] && currentDashCooldown == 0){
    		
    		
    		if(pressedKeyCodes[87]) { // W
    			for(int i = 0; i < dashRange ; i++ ) {
    				
    				if(keineKollision(level.map, 'w')) {
    	    	          yPosition -= Level.blockGröße;
    	    	          heldSprite.y -= Level.blockGröße ;
    	    	          level.bereich.repaint();
    	    	          moved = false; 
    	    	          currentDashCooldown = dashCooldown;
    				}
    			}
    			
    			
    		} else
    		if(pressedKeyCodes[83]) { // S
    			for(int i = 0; i < dashRange ; i++ ) {
    				
    				if(keineKollision(level.map, 's')) {
    	    	          yPosition += Level.blockGröße;
    	    	          heldSprite.y += Level.blockGröße ;
    	    	          level.bereich.repaint();
    	    	          moved = false; 
    	    	          currentDashCooldown = dashCooldown;
    	    		}	
    				
    			}
    			
    			
    		} else
    		if(pressedKeyCodes[65]) { // A
    			for(int i = 0; i < dashRange ; i++ ) {
    				
    				if(keineKollision(level.map, 'a')) {
    	    			xPosition -= Level.blockGröße;
    	    			heldSprite.x -= Level.blockGröße ;
    	    			level.bereich.repaint();
    	    			moved = false;
    	    			currentDashCooldown = dashCooldown;
    				}
    			}
    			
    			
    		} else
    		if(pressedKeyCodes[68]) { //D
    			for(int i = 0; i < dashRange ; i++ ) {
    				
    				if(keineKollision(level.map, 'd')) {
    	    	          xPosition += Level.blockGröße;
    	    	          heldSprite.x += Level.blockGröße ;
    	    	          level.bereich.repaint();
    	    	          moved = false; 
    	    	          currentDashCooldown = dashCooldown;
    	    		}
    				
    			}
    		}
    		
    		
    		
    		
    		}
    	}
    	
    	
    	
    	if(pressedKeyCodes[87]) { // W
    		if(keineKollision(level.map, 'w')) {
    	          yPosition -= Level.blockGröße;
    	          heldSprite.y -= Level.blockGröße ;
    	          level.bereich.repaint();
    	          moved = false; 
    		}     
    	} else
    	
    	if(pressedKeyCodes[83]) { // S
    		if(keineKollision(level.map, 's')) {
    	          yPosition += Level.blockGröße;
    	          heldSprite.y += Level.blockGröße ;
    	          level.bereich.repaint();
    	          moved = false; 
    		}
    	} else
    	
    	if(pressedKeyCodes[65]) { // A
    		if(keineKollision(level.map, 'a')) {
    			xPosition -= Level.blockGröße;
    			heldSprite.x -= Level.blockGröße ;
    			level.bereich.repaint();
    			moved = false;
    		}
    	} else
    	
    	if(pressedKeyCodes[68]) { //D
    		if(keineKollision(level.map, 'd')) {
    	          xPosition += Level.blockGröße;
    	          heldSprite.x += Level.blockGröße ;
    	          level.bereich.repaint();
    	          moved = false; 
    		}
    	} 
			
			if(pressedKeyCodes[38]){//arrow up
				/*BildObjekt heldSpriteUp=new BildObjekt(xPosition ,yPosition ,"userUp.png");
				  heldSprite=heldSpriteUp;*/
				
				  heldSprite.setHeldbild("userUp.png");
				  level.bereich.repaint();
				ausrichtung=1;
			}else
    			
    			if(pressedKeyCodes[40]){//arrow down
    				/*BildObjekt heldSpriteDown=new BildObjekt(xPosition ,yPosition ,"userDown.png");
    				 heldSprite=heldSpriteDown;*/
    				
    				heldSprite.setHeldbild("userDown.png");
    				level.bereich.repaint();
    				ausrichtung=0;
    				
    			}else
        			
        			if(pressedKeyCodes[39]){//arrow right
        				
        				/*BildObjekt heldSpriteRight=new BildObjekt(xPosition ,yPosition ,"userRight.png");
        				
        				
        				heldSprite=heldSpriteRight;*/
        				
        				
        				heldSprite.setHeldbild("userRight.png");
        				level.bereich.repaint();
        				ausrichtung=3;
        			}else
            			
            			if(pressedKeyCodes[37]){//arrow left
            				/*BildObjekt heldSpriteLeft=new BildObjekt(xPosition ,yPosition ,"userLeft.png");
            				*/
            				
            				
            				heldSprite.setHeldbild("userLeft.png");
            				level.bereich.repaint();
            				
            				ausrichtung=4;
            			}
  
      
    		
    	
}



  public boolean keineKollision(int[][] map, char direction) {
    boolean noCollision = true;
    
    switch(direction) {
    case 'w' : if(map[yPosition/Level.blockGröße-1][xPosition/Level.blockGröße]<1) { /*anstatt >0 -> <1*/
      noCollision = false;
    }
    break;
    case 'a' : if(map[yPosition/Level.blockGröße][xPosition/Level.blockGröße-1]<1) {
      noCollision = false;
    }
    break;
    case 's' : if(map[yPosition/Level.blockGröße+1][xPosition/Level.blockGröße]<1) {
      noCollision = false;
    }
    break;
    case 'd' : if(map[yPosition/Level.blockGröße][xPosition/Level.blockGröße+1]<1) {
      noCollision = false;
    }
    }
    
    
    return noCollision;
  }

 
}

