import java.awt.Graphics;

public interface Transport {
	
	void SetPosition(int x, int y, int width, int height);
	void MoveTransport(Direction direction);
    void DrawGun(Graphics g);
    int Get_StartPosX();
    int Get_StartPosY();
}
