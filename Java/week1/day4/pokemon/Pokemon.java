import java.util.ArrayList;

public class Pokemon{
	private String name      = "";
	private String type      = "";
	private int health       = 0;
	private static int count = 0;
	private static ArrayList<Pokemon> pokemen = new ArrayList<Pokemon>();

	public Pokemon(String name,String type,int health){
		this.name=name;
		this.type=type;
		this.health=health;
		count++;
	
		pokemen.add( this );
	}

	public void setName(String name){this.name=name;}
	public void setType(String type){this.type=type;}
	public void setHealth(int hp){health = hp;}
	public String getName(){return name;}
	public String getType(){return type;}
	public int getHealth(){return health;}
	
	public static String getCount(){
		return "There are "+ count+" pokemon in the wild.";
	}

	public static ArrayList<Pokemon> getEmAll(){
		return pokemen;
	}
}