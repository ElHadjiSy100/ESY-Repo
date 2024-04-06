package ESY_Assignment4_Complete;
import java.util.*;

public class Plot {
	private int x; 
	private int y;
	private int width; 
	private int depth; 

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1; 
		this.depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width; 
		this.depth = depth; 
	}
	
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y; 
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	public boolean encompasses(Plot plot){
		return (this.x <= plot.x &&  this.y <= plot.y && this.x + width >= plot.x + plot.width && this.y + depth >= plot.y + plot.depth);
	}
	
	public boolean overlaps(Plot plot) {
		int rightX = this.x + this.width;
		int leftX = this.x; 
		int bottomY = this.y;
		int topY = this.y + this.depth; 
		
		if(plot.x + plot.width > leftX && plot.x < rightX && (plot.y + plot.depth > bottomY || plot.y < topY)) {
			return true;
		}
		return false;
	}

	public void setX(int x) {
		this.x = x; 
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y; 
	}

	public int getY() {
		return y;
	}

	public void setDepth(int depth) {
		this.depth = depth; 
	}

	public int getDepth() {
		return depth; 
	}

	public void setWidth(int width) {
		this.width = width; 
	}

	public int getWidth() {
		return width;
	}

	public String toString() {
		return "" + x + "," + y + "," + width + "," + depth;
	}

}

