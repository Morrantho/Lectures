import java.util.ArrayList;

public class Shape{
	public static ArrayList<Shape> shapes = new ArrayList<Shape>();

	public int x;
	public int y;
	public int w;
	public int h;

	public Shape(int x,int y,int w,int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		Shape.shapes.add(this);
	}

	public void print(){
		System.out.println("X: "+this.x+" Y:"+this.y+" W: "+this.w+" H:"+this.h);
	}

	public static void main(String[] args) {

		new Shape(64,64,32,32);
		new Rectangle(16,16,64,64);

		for(Shape s: Shape.shapes){

			if(s.getClass().getSimpleName().equals("Rectangle")){
				Rectangle.counter++;
			}

			s.print();
		}

		System.out.println("Number Of Rectangles:"+Rectangle.counter );

		// for(int i=0; i<Shape.shapes.size();i++){
		// 	Shape s = shapes.get(i);
		// }
	}
}
