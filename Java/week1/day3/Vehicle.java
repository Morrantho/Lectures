public abstract class Vehicle implements Drivable{
	private String make;
	private String model;
	private int speed;
	private double cost;
	private String sound;
	private int direction;

	public void setDirection(int dir){
		direction = dir;
	}
	public int getDirection(){
		return direction;
	}

	public void setMake(String make){
		this.make = make;
	}
	public String getMake(){
		return make;
	}

	public void setModel(String model){
		this.model = model;
	}
	public String getModel(){
		return model;
	}

	public void setCost(double cost){
		this.cost=cost;
	}
	public double getCost(){
		return cost;
	}

	public void setSound(String snd){
		this.sound = snd;
	}
	public String getSound(){
		return sound;
	}

	public void accelerate(int a){
		this.speed += a;
		System.out.println("The vehicle accelerated by: "+a);
		System.out.println("Total Speed: "+this.speed);
	}
	public void decelerate(int a){
		this.speed -= a;
		System.out.println("The vehicle decelrrated by: "+a);
		System.out.println("Total Speed: "+this.speed);
	}

	public static void main(String[] args){
		Vehicle merc = new Mercedes( 75000.0D, "Beep", 0);
		merc.accelerate(10);
		merc.decelerate(5);
		merc.steer(90);
		merc.honk("Honk!");
	}
}