public class ConvexTest {

    public static void main(String[] args) throws Exception {    	         
        Convex convex = new Convex();  
        Window W = new Window(convex);
        
        while (true) {        	
            convex.add(new R2Point());                          	
            
            System.out.println("S = " + convex.area() + " | P = " + convex.perimeter() + "| Upper S = " + convex.upperarea());                             
            W.invalidate();
        	W.validate();
        	W.repaint();
        }               
    }
}
