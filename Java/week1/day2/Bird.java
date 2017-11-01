public class Bird extends Animal{
	private boolean canFly;


	public Bird(){

	}

	public Bird(String name, int numLegs, String species, String gender, String diet,boolean canFly){
		super(name,numLegs,species,gender,diet);
		this.canFly=canFly;
	}

	public void setCanFly(boolean canFly){
		this.canFly=canFly;
	}

	public boolean getCanFly(){
		return this.canFly;
	}

	public void fly(){
		if(this.canFly){
			System.out.println("*Flap flap*");
		}else{
			System.out.println("*Flop flop*");
		}
	}

	public void eat(){
		super.eat();
		System.out.println("*Peck peck*");
	}
}