import java.util.Scanner;

public class Adventure{
	private Scanner input;
	private String text;

	public Adventure(){
		input = new Scanner(System.in);
		text = "";

		while(!text.equals("quit")){
			text = input.nextLine();

			if(text.equals("left")){
				System.out.println("YOU WENT LEFT DOWN THE DARK SCARY ROAD.");
			}else if(text.equals("right")){
				System.out.println("YOU RAN INTO A TREE, GAME OVER!");
				text = "quit";
			}
		}
	}

	public static void main(String[] args){
		new Adventure();
	}
}
