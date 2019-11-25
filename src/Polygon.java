import java.awt.*;

public class Polygon extends Deq implements Figure {

    private double s, p, ups;
    private int ax, ay, bx, by, cx, cy, tx = 0, ty = 0;
    private Color color;
    private int xarray1[] = new int[100];
    private int yarray1[] = new int[100];
    private int xarray2[] = new int[100];
    private int yarray2[] = new int[100];
    int ch = 0;
    
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
        	int n1 = 0;
        	int n2 = 0;        	
            R2Point x;
            grow(back(), front(), t);                     
            for (x = popFront(); t.light(x, front()); x = popFront()) {
                grow(x, front(), t );                
                xarray1[n1] = x.getx() + 400;
                yarray1[n1] = 300 - x.gety();
                xarray1[n1+1] = front().getx() + 400;
                yarray1[n1+1] = 300 - front().gety();
                xarray1[n1+2] = t.getx() + 400;
                yarray1[n1+2] = 300 - t.gety();
                n1 = n1 + 3;
            }
            pushFront(x);

            for (x = popBack(); t.light(back(), x); x = popBack()) {
                grow(back(), x, t);
                xarray2[n2] = back().getx() + 400;
                yarray2[n2] = 300 - back().gety();
                xarray2[n2+1] = x.getx() + 400;
                yarray2[n2+1] = 300 - x.gety();
                xarray2[n1+2] = t.getx() + 400;
                yarray2[n1+2] = 300 - t.gety();
                n2 = n2 + 3;
            }
            pushBack(x);

            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
            
            ch = 1;
        }
        return this;
    }
    
    public void draw(Graphics g) {
    	
    	g.setColor(new Color(0,0,0));
    	g.drawLine(0, 300, 800, 300);
    	g.drawLine(400, 0, 400, 600); 
    	
    	int xpoints[] = {400+ax, 400+bx, 400+cx};
    	int ypoints[] = {300-ay, 300-by, 300-cy};
    	int n = 3;
    	this.color = new Color(0,0,150);
    	g.setColor(this.color);    	
    	g.fillPolygon(xpoints, ypoints, n);
    	    	    	   	    	
    	int xpoints2[] = {400+ax, 400+bx, 400+cx, 400+tx};
    	int ypoints2[] = {300-ay, 300-by, 300-cy, 300-ty};    	
    	
    	if(ch != 0) {
    		
    	int n2 = 4;
    	
    	g.fillPolygon(xpoints2, ypoints2, n2);    	  
    	
    	int l = xarray1.length - 1;
    	g.fillPolygon(xarray1, yarray1, l);
    	
    	int l2 = xarray2.length - 1;
    	g.fillPolygon(xarray2, yarray2, l2);    	
    	}

    }
}
