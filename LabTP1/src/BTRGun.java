import java.awt.Color;
import java.awt.Graphics;



public class BTRGun extends Gun{

	public BTRGun(int maxSpeed, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        MainColor = mainColor;
    }
	private final static int GunWidth = 90;
    private final static int GunHeight = 10;
	@Override
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed;
        switch (direction)
        {        
            case Right:
                if (_startPosX + step < _pictureWidth - GunWidth + 15)
                {
                    _startPosX += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step > 15)
                {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - GunHeight)
                {
                    _startPosY += step;
                }
                break;
        } 
    }
	public void DrawGun(Graphics g){
		 g.setColor(Color.green);
	        int [] BTRX= {_startPosX-35,_startPosX+35,_startPosX+25,_startPosX-25};
	        int [] BTRY= {_startPosY+10,_startPosY+10,_startPosY-10,_startPosY-10};
	        g.fillPolygon( BTRX,BTRY,BTRX.length);
		
	        g.setColor(MainColor);
	        
	        int [] trapX= {_startPosX-40,_startPosX+40,_startPosX+45,_startPosX-45};
	        int [] trapY= {_startPosY+10,_startPosY+10,_startPosY+25,_startPosY+25};
	        g.fillPolygon( trapX,trapY,trapX.length);
	       
	        g.setColor(Color.BLACK);
	        g.fillOval( _startPosX - 30, _startPosY + 20, 15, 15);
	        g.fillOval( _startPosX + 20, _startPosY + 20, 15, 15);
	        g.fillRect( _startPosX, _startPosY, 10, 10);
	        g.fillRect( _startPosX+20, _startPosY-13, 20, 10);
    }

	public int Get_StartPosX() {
		return _startPosX;
	}

	public int Get_StartPosY() {
		return _startPosY;
	}

}
