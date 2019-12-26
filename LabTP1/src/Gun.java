import java.awt.Color;
import java.awt.Graphics;


public abstract class Gun implements Transport{

	protected int _startPosX;
    protected int _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    public int MaxSpeed;
    public Color MainColor;
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawGun(Graphics g);
    public abstract void MoveTransport(Direction direction);
}
