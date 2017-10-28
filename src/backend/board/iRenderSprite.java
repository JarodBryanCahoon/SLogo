package backend.board;

public interface iRenderSprite {
	double getX();
	
	double getY();
	
	boolean isPenDown();
	
	boolean isVisible();
		
	double getAngle();
	
	int getId();
	
	RenderMath getMath();
	
	void setX(double X);
	
	void setY(double Y);
	
	void setPenDown(boolean isPenDown);
	
	void setVisible(boolean isVisible);
	
	void setAngle(double angle);
}
