import java.awt.*;

public interface Figure{
	
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public double upperarea();   
    public void draw(Graphics g);
}
