import java.awt.Color;
import java.awt.Graphics;

public class AntiaircraftGun extends BTRGun{
	
    public Color MainColor;
    public Color DopColor ;
    public int countGun=6;
    public boolean FrontArmor;// передняя броня
    public boolean MuzzleBraker;// дульный тормоз
    public boolean Radar;//радар
    IGuns guns;
    public AntiaircraftGun(int maxSpeed ,Color mainColor, Color dopColor,
        boolean frontArmor, boolean muzzleBraker, boolean radar, IGuns guns)
    {
    	super(maxSpeed, mainColor);       
        DopColor = dopColor;
        FrontArmor = frontArmor;
        MuzzleBraker = muzzleBraker;
        Radar = radar;
        this.guns=guns;
    }
    
    public void DrawGun(Graphics g)
    {
    	guns.SetPos(Get_StartPosX(),Get_StartPosY());
        super.DrawGun(g);

        int StartGX=_startPosX;
        int StartGY=_startPosY;
   	 	g.setColor(Color.BLACK);
        
       g.drawLine(StartGX+12,StartGY-10 ,StartGX+30,StartGY-32);
       for(int i=0;i<countGun;i+=2) {	   
	        if (MuzzleBraker)
	        {
	        
			   	int [] gunsX= {StartGX+ 5,StartGX+ 15,StartGX+25,StartGX+30,StartGX+35,StartGX+38,StartGX+35,StartGX+18};
			    int [] gunsY= {StartGY-10,StartGY-30,StartGY-35,StartGY-32,StartGY-38,StartGY-35,StartGY-20,StartGY-10};
			    g.fillPolygon( gunsX,gunsY,gunsX.length);
	            g.setColor(Color.GRAY);
	            
	            int [] mBX= {StartGX+25,StartGX+35,StartGX+30,StartGX+40};
	            int [] mBY= {StartGY-35,StartGY-45,StartGY-32,StartGY-42};
	            g.fillPolygon( mBX,mBY,mBX.length);
	            int [] mBX2= {StartGX+35,StartGX+45,StartGX+38,StartGX+48};
	            int [] mBY2= {StartGY-38,StartGY-48,StartGY-35,StartGY-45};
	            g.fillPolygon( mBX2,mBY2,mBX2.length);
	            g.setColor(Color.BLACK);
	            StartGX+=10;
		 		StartGY+=10;	
	        }	              
        }              
        if (Radar)
        {          
            g.fillArc((int)_startPosX + 10, (int)_startPosY - 25, 10, 10, 250, 180);
        }

        if (FrontArmor)
        {
            g.setColor(DopColor);            
            int [] armorX= {_startPosX,_startPosX+20,_startPosX+35,_startPosX+15};
            int [] armorY= {_startPosY-15,_startPosY-15,_startPosY+10,_startPosY+10};
            g.fillPolygon( armorX,armorY,armorX.length);
        } 
        guns.PrintGuns(HardDirection.Six, g, Color.BLACK);
    }
}

