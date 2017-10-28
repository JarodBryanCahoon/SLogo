package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.Node;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Product implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Product(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne*myNumTwo;
	}
}