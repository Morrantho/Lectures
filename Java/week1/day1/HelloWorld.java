import java.util.ArrayList;

public class HelloWorld{
	public static int num = 123;
	public static long bigNumber = 136189236L;
	public static boolean hasFavoriteMovie = false;
	public static double price  = 59.99D;
	public static float myPrice = 12.99F;
	public static char myGrade = 'A'; 
	public static String myString = "Hey!";

	public static String[] myList = {
		"asdasd",
		"qieyioyu",
		"qw7ieuqwe",
		"qwtequwe"
	};

	public static ArrayList<String> students = new ArrayList<String>();

	public static void main(String[] args){
		students.add("Brian");
		students.add("John");
		students.add("Seth");
		students.add("Sam");

		// for(int i = 0;i < myList.length; i++){
		// 	System.out.println( myList[i] );
		// }

		// System.out.println("------------------------");

		// for(String item: myList){
		// 	System.out.println( item );
		// }


		for(int i = 0; i < students.size(); i++){
			System.out.println( students.get(i) );
		}

		System.out.println("------------------------");

		for(String student: students){
			System.out.println( student );
		}
	}
}