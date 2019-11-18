import java.awt.*;

public class Segment implements Figure {

    private R2Point p, q;
    private int px, py, qx, qy;
    private Color color;
    
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
        px=p.getx();
        py=p.gety();
        qx=q.getx();
        qy=q.gety();
    }
    public double perimeter() {
        return R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public double upperarea() {
    	return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    public void draw(Graphics g) {
    	this.color = new Color(0,0,150);
    	g.setColor(this.color);
    	g.fillOval(395+px, 295-py, 10, 10);  
    	g.fillOval(395+qx, 295-qy, 10, 10);
    	g.setColor(new Color(255,0,0));
    	g.drawLine(400+px, 300-py, 400+qx, 300-qy);
    	g.setColor(new Color(0,0,0));
    	g.drawLine(0, 300, 800, 300);
    	g.drawLine(400, 0, 400, 600);    	
    }
}
