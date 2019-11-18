import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

	private Convex f;
	    
	    public Window()
	    {        		    		        	      
	    }
	    
	    public Window(Convex f)
	    {
	        this();
	        this.f = f;
	        this.setSize(800,600);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    }
	
	    @Override
	    public void paint(Graphics g)
	    {
	    	
	        f.draw(g);
	    }       
}
