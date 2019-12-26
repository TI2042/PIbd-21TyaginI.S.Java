import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GunPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Transport gun;
	private IGuns guns;
	
	public void setGun(Transport gun) {
		this.gun = gun;
	}
	
	public void setGuns(IGuns guns) {
		this.guns = guns;
	}

    public void paint(Graphics g) {
		super.paint(g);	
		
		if(gun != null && guns == null)
			gun.DrawGun(g);
		else if(gun != null && guns != null) {
			gun.DrawGun(g);
			guns.PrintGuns( HardDirection.Six,g, Color.green);
		}
    }
}
