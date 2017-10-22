package backend.Utilities;
import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author Jarod Cahoon
 * My masterpiece
 */
public class Logic{
	
	public static double sum(double a, double b){
		return a+b;
	}
	
	public static double difference(double a, double b){
		return a-b;
	}
	
	public static double product(double a, double b) {
		return a*b;
	}
	
	public static double quotient(double a, double b) {
		return a/b;
	}
	
	public static double remainder(double a, double b) {
		return a%b;
	}
	
	public static double minus(double a) {
		return -a;
	}
	
	public static double random(double a) {
		return ThreadLocalRandom.current().nextDouble(0, a + 1);
	}
	
	public static double sin(double a) {
		return Math.sin(Math.toDegrees(a));
	}
	
	public static double cos(double a) {
		return Math.cos(Math.toDegrees(a));
	}
	
	public static double tan(double a) {
		return Math.tan(Math.toDegrees(a));
	}
	
	public static double atan(double a) {
		return Math.atan(Math.toDegrees(a));
	}
	
	public static double log(double a) {
		return Math.log(a);
	}
	
	public static double pow(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	
	public static double pi() {
		return Math.PI;
	}
	
	public static int isLess(double a, double b){
		return (a<b) ? 1:0;
	}
	
	public static int isGreater(double a, double b) {
		return (a>b) ? 1:0;
	}
	
	public static int isEqual(double a, double b) {
		return (a == b) ? 1:0;
	}
	
	public static int notEqual(double a, double b) {
		return (a != b) ? 1:0;
	}
	
	public static int and(double a, double b) {
		return (a != 0 && b != 0) ? 1:0;
	}
	
	public static int or(double a, double b) {
		return (a != 0 || b != 0) ? 1:0;
	}
	
	public static int not(double a) {
		return (a == 0) ? 1:0;
	}
}
