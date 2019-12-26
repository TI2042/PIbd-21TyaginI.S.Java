import java.awt.Color;
import java.awt.Graphics;

public interface IGuns {
	
	void PrintGuns(HardDirection countGun, Graphics g, Color colorGun);
	void SetPos(int x, int y);
	void PrintGun(Graphics g, Color color,int posXgun,int posYgun);
}
