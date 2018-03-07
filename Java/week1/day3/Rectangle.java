public class Rectangle extends Shape{
	public static int counter = 0;

	public Rectangle(int x,int y,int w,int h){
		super(x,y,w,h);
		this.w *= 2;
	}
}
