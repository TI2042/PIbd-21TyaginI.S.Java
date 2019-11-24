import java.awt.Color;
import java.awt.Graphics;

public class AntiaircraftGun {

	private int StartX;
    private int StartY;
    private int PictureWight;
    private int PictureHight;
    private int GunWidth = 100;
    private int GunHidth = 60;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;
    public Color DopColor ;
    public int countGun=0;
    public boolean FrontArmor;// передняя броня
    public boolean MuzzleBraker;// дульный тормоз
    public boolean Radar;//радар
    
    public AntiaircraftGun(int maxSped ,float weight,Color mainColor, Color dopColor,
        boolean frontArmor, boolean muzzleBraker, boolean radar)
    {
        MaxSpeed = maxSped;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        FrontArmor = frontArmor;
        MuzzleBraker = muzzleBraker;
        Radar = radar;
    }
    
    public void SetPosition(int x, int y, int width, int height)
    {
        StartX = x;
        StartY = y;
        PictureWight = width;
        PictureHight = height;
    }
    
    public void MoveGun(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Right:
                if (StartX + step < PictureWight - GunWidth)
                {
                    StartX += step;
                }
                break;
            case Left:
                if (StartX - step > 0)
                {
                    StartX -= step;
                }
                break;
            case Up:
                if (StartY - step > 0)
                {
                    StartY -= step;
                }
                break;
            case Down:
                if (StartY + step < PictureHight - GunHidth)
                {
                    StartY += step;
                }
                break;              
        }
    }
   
    public void numberOfGuns(HardDirection direction)
    {      
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

    }
    public void DrawGun(Graphics g)
    {
        g.setColor(MainColor);
        
        int [] trapX= {StartX-40,StartX+40,StartX+45,StartX-45};
        int [] trapY= {StartY+10,StartY+10,StartY+25,StartY+25};
        g.fillPolygon( trapX,trapY,trapX.length);
       
        g.setColor(Color.BLACK);
        g.fillOval( StartX - 30, StartY + 20, 15, 15);
        g.fillOval( StartX + 20, StartY + 20, 15, 15);
        g.fillRect( StartX, StartY, 10, 10);

        int StartGX=StartX;
        int StartGY=StartY;
        for(int i=0;i<countGun;i+=2)
        {
        	int [] gunsX= {StartGX+ 5,StartGX+25,StartGX+30,StartGX+35,StartGX+38,StartGX+18};
	        int [] gunsY= {StartGY-10,StartGY-35,StartGY-32,StartGY-38,StartGY-35,StartGY-10};
	        g.fillPolygon( gunsX,gunsY,gunsX.length);
	        g.setColor(Color.GRAY);
	        g.drawLine(StartGX+12,StartGY-10 ,StartGX+30,StartGY-32);
	        if (MuzzleBraker)
	        {
	            g.setColor(Color.GRAY);
	            
	            int [] mBX= {StartGX+25,StartGX+35,StartGX+30,StartGX+40};
	            int [] mBY= {StartGY-35,StartGY-45,StartGY-32,StartGY-42};
	            g.fillPolygon( mBX,mBY,mBX.length);
	            int [] mBX2= {StartGX+35,StartGX+45,StartGX+38,StartGX+48};
	            int [] mBY2= {StartGY-38,StartGY-48,StartGY-35,StartGY-45};
	            g.fillPolygon( mBX2,mBY2,mBX2.length);
	        }
	        g.setColor(Color.BLACK);
	        StartGY+=10;
	        StartGX+=10;	        
        }              
        if (Radar)
        {          
            g.fillArc((int)StartX + 10, (int)StartY - 25, 10, 10, 250, 180);
        }

        if (FrontArmor)
        {
            g.setColor(DopColor);            
            int [] armorX= {StartX,StartX+20,StartX+35,StartX+15};
            int [] armorY= {StartY-15,StartY-15,StartY+10,StartY+10};
            g.fillPolygon( armorX,armorY,armorX.length);
        }       
    }
}

