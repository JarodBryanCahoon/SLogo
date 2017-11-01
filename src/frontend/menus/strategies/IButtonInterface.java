package frontend.menus.strategies;

/**
 * An interface that allows implementing classes to use a user inputted text in a certain way
 * @author Albert
 *
 */
public interface IButtonInterface {
	/**
	 * Uses user inputted text in a to be specified manner
	 * @param text	user inputted text
	 */
	void useText(String text);
}
