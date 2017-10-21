package backend.board;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public interface GeneralObject{
	public double moveForward();
	
	public double moveBackwards();
	
	public double turnLeft();
	
	public double turnRight();
	
	public double setAngle();
	
	public double setPostion();
	
	public double setHome();
	
	public double clearScreen();
	
	public double Hide();
	
	public double Show();	
}