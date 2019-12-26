import java.awt.Color;
import java.awt.Graphics;


public class Guns  implements IGuns{

	private int posXgun;
	private int posYgun;
    public int countGun=2;	
    
	public void SetPos(int posX, int posY)
	{
		this.posXgun = posX;
		this.posYgun = posY;
		
	}
	
	public void PrintGun(Graphics g, Color colorGun,int posXgun,int posYgun) {
   	 	g.setColor(colorGun);
	   	int [] gunsX= {posXgun+ 5,posXgun+25,posXgun+30,posXgun+35,posXgun+38,posXgun+18};
	    int [] gunsY= {posYgun-10,posYgun-35,posYgun-32,posYgun-38,posYgun-35,posYgun-10};
	    g.fillPolygon( gunsX,gunsY,gunsX.length);
    }
	
	public void PrintGuns(HardDirection direction, Graphics g, Color colorGun) {
		 	 
		switch (direction)
        {
            case Two:
                countGun=2;
                break;
            case Four:
            	countGun=4;
                break;
            case Six:
            	countGun=6;
                break;                                
        }
			
		for(int i=0;i<countGun;i+=2) {
		 		 PrintGun(g,Color.BLACK,posXgun,posYgun);
		 		 posYgun+=10;
		 		 posYgun+=10;	
		 	 }
	}
}
