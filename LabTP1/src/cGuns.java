import java.awt.Color;
import java.awt.Graphics;

public class cGuns implements IGuns {
	private int posXgun;
	private int posYgun;
    public int countGun=4;	
    
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
		 	 
		
		if (direction== direction.Two )
		{
			for(int i=0;i<2;i+=2) {
			 		 PrintGun(g,Color.BLACK,posXgun,posYgun);
			 		 posYgun+=10;
			 		 posYgun+=10;	
			 	 }
		}
		else if (direction== direction.Four )
		{
			for(int i=0;i<4;i+=2) {
			 		 PrintGun(g,Color.BLACK,posXgun,posYgun);
			 		 posYgun+=10;
			 		 posYgun+=10;	
			 	 }
		}
		else if (direction== direction.Six )
		{
			for(int i=0;i<6;i+=2) {
			 		 PrintGun(g,Color.BLACK,posXgun,posYgun);
			 		 posYgun+=10;
			 		 posYgun+=10;	
			}
		}
	}
}
