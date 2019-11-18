import java.awt.*;

public class Polygon extends Deq implements Figure {

    private double s, p, ups;
    private int ax, ay, bx, by, cx, cy, tx = 0, ty = 0;
    private Color color;
    
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
        ups += Math.abs(R2Point.upperarea(a, b, t));
    }
    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);

        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
                
        ups = Math.abs(R2Point.upperarea(a, b, c));
        
        ax = a.getx();
        ay = a.gety();
        bx = b.getx();
        by = b.gety();
        cx = c.getx();
        cy = c.gety();
    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }
    
    public double upperarea() {
    	return ups;
    }
    
    public Figure add(R2Point t) {
        int i;
        tx = t.getx();
        ty = t.gety();

        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());

        if (i>0) {
            R2Point x;
            grow(back(), front(), t);

            
            
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);

            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        return this;
    }
    
    public void draw(Graphics g) {
    	this.color = new Color(0,0,150);
    	g.setColor(this.color);
    	g.fillOval(395+ax, 295-ay, 10, 10);  
    	g.fillOval(395+bx, 295-by, 10, 10);
    	g.fillOval(395+cx, 295-cy, 10, 10);
    	
    	g.setColor(new Color(255,0,0));
    	g.drawLine(400+ax, 300-ay, 400+bx, 300-by);
    	g.drawLine(400+bx, 300-by, 400+cx, 300-cy);
    	
    	g.setColor(new Color(0,0,0));
    	g.drawLine(0, 300, 800, 300);
    	g.drawLine(400, 0, 400, 600);    	
    	    	
    		g.setColor(this.color);
    		g.fillOval(395+tx, 295-ty, 10, 10);
    		g.drawLine(400+cx, 300-cy, 400+tx, 300-ty);    	
    }

}
