import java.util.Scanner;

public class Adventure{
	private Scanner input;
	private String text;

	public Adventure(){
		input = new Scanner(System.in);
		text = "";

		while(!text.equals("quit")){
			text = input.nextLine();
			System.out.println("Text: "+text);
		}
	}

	public static void main(String[] args){
		new Adventure();
	}
}
