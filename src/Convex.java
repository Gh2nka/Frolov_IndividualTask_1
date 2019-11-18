import java.awt.*;

public class Convex {

    private Figure fig;

    public Convex() {
        fig = new Void();
    }
    public void add(R2Point p) {
        fig = fig.add(p);              
    }
    public double area() {
        return fig.area();
    }
    public double perimeter() {
        return fig.perimeter();
    }

    public double upperarea() {
    	return fig.upperarea();
    }
    public void draw(Graphics g)  {
    	fig.draw(g);
    }
}
