import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Spring;

public class GunPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	AntiaircraftGun gun;
	
	public GunPanel(AntiaircraftGun antiGun) 
	{
		gun = antiGun;		
	}

    public void paint(Graphics g) {
		super.paint(g);	
		gun.DrawGun(g);
	}
   
}
