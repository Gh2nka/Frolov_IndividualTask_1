import java.awt.*;

public class Point implements Figure {

    private R2Point p;   
    private Color color;
    private int x, y;
    
    public Point(R2Point p) {
        this.p = p;  
        x = p.getx();
        y = p.gety();
    }
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public double upperarea() {
    	return 0.0;
    }
    public Figure add(R2Point q) {
        if (!R2Point.equal(p,q)) return new Segment(p, q);
        else return this;
    }        
    public void draw(Graphics g) {    
    	this.color = new Color(0,0,0);    	    	   	   
    	g.setColor(this.color);
    	g.drawLine(0, 300, 800, 300);
    	g.drawLine(400, 0, 400, 600);    
    }
}          