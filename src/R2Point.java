import java.util.Scanner;

public class R2Point {

    private int x, y;       

    public R2Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public R2Point() throws Exception {
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();  
    }
    
    public static double dist(R2Point a, R2Point b) {
        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
    public static double area(R2Point a, R2Point b, R2Point c) {
        return 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    }

    public static double upperarea(R2Point a, R2Point b, R2Point c) {
    	
    	double upx1=0, upx2=0, tan=0, uparea = 0.0, allarea = 0.0;
    	
    	if(!(a.y > 0) && !(b.y > 0) && c.y > 0) {
			if(c.x == a.x) {upx1 = c.x;}
			else {
				tan = (c.y - a.y) / (c.x - a.x);
				upx1 = -(a.y / tan) + a.x;
			}
			if(c.x == b.x) {upx2 = c.x;}
			else {
				tan = (c.y - b.y) / (c.x - b.x);
				upx2 = -(b.y / tan) + b.x;
			}
    		uparea =  0.5*(((upx1-c.x)*c.y)-((upx2-c.x)*c.y));
    	}
    	else if(!(b.y > 0) && !(c.y > 0) && a.y > 0) {
    		if(a.x == b.x) {upx1 = a.x;}
    		else {
				tan = (a.y - b.y) / (a.x - b.x);
				upx1 = -(b.y / tan) + b.x;
			}
    		if(a.x == c.x) {upx2 = a.x;}
    		else {
				tan = (a.y - c.y) / (a.x - c.x);
				upx2 = -(c.y / tan) + c.x;
			}
    		uparea = 0.5*((upx1-a.x)*a.y-(upx2-a.x)*(a.y));
    	}
    	else if(!(a.y > 0) && !(c.y > 0) && b.y > 0) {
    		if(b.x == a.x) {upx1 = b.x;}
    		else {
				tan = (b.y - a.y) / (b.x - a.x);
				upx1 = -(a.y / tan) + a.x;
			}
    		if(b.x == c.x) {upx2 = b.x;}
    		else {
				tan = (b.y - c.y) / (b.x - c.x);
				upx2 = -(c.y / tan) + c.x;
			}
    		uparea = 0.5*((upx1-b.x)*b.y-(upx2-b.x)*(b.y));
    	}    
    	///
    	else if(a.y > 0 && b.y > 0 && !(c.y > 0)) {
    		allarea = 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    		if(a.x == c.x) {upx1 = a.x;}
    		else {
				tan = (c.y - a.y) / (c.x - a.x);
				upx1 = -(c.y / tan) + c.x;
			}
    		if(b.x == c.x) {upx2 = b.x;}
    		else {
				tan = (c.y - b.y) / (c.x - b.x);
				upx2 = -(c.y / tan) + c.x;
			}
    		uparea =  allarea - (0.5*((upx1-c.x)*c.y-(upx2-c.x)*(c.y)));
    	}
    	else if(b.y > 0 && c.y > 0 && !(a.y > 0)) {
    		allarea = 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    		if(b.x == a.x) {upx1 = b.x;}
    		else {
				tan = (a.y - b.y) / (a.y - b.x);
				upx1 = -(a.y / tan) + a.x;
			}
    		if(c.x == a.x) {upx2 = a.x;}
    		else {
				tan = (a.y - c.y) / (a.y - c.x);
				upx2 = -(a.y / tan) + a.x;
			}
    		uparea = allarea - (0.5*((upx1-a.x)*a.y-(upx2-a.x)*(a.y)));
    	}
    	else if(a.y > 0 && c.y > 0 && !(b.y > 0)) {
    		allarea = 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    		if(a.x == b.x) {upx1 = a.x;}
    		else {
				tan = (b.y - a.y) / (b.x - a.x);
				upx1 = -(b.y / tan) + b.x;
			}
    		if(c.x == b.x) {upx2 = c.x;}
    		else {
				tan = (b.y - c.y) / (b.x - c.x);
				upx2 = -(b.y / tan) + b.x;
			}
    		uparea = allarea - (0.5*((upx1-b.x)*b.y-(upx2-b.x)*(b.y)));
    	}
    	else if (!(a.y < 0) && !(b.y < 0) && !(c.y < 0)) {
    		uparea =0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    	}
    	else if (a.y < 0 && b.y < 0 && c.y < 0) {
    		uparea = 0.0;
    	}
    	return uparea;
    }
    
    public static boolean equal(R2Point a, R2Point b) {
        return a.x==b.x && a.y==b.y;
    }
    public static boolean isTriangle(R2Point a, R2Point b, R2Point c) {
        return area(a, b, c) != 0.0; 
    }
    public boolean inside(R2Point a, R2Point b) {
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x) &&
                (a.y <= y && y <= b.y || a.y >= y && y >= b.y);

    }
    public boolean light(R2Point a, R2Point b) {
        double s = area(a, b, this);
        return s < 0.0 || ( s == 0.0 && ! inside(a, b));
    }
   
    public int getx() {
    	return x;
    }
    
    public int gety() {
    	return y;
    }
}