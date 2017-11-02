public class Bird extends Animal implements CanFly{

	public Bird(){

	}

	public Bird(String name, int numLegs, String species, String gender, String diet){
		super(name,numLegs,species,gender,diet);
	}

	public Bird eat(){
		System.out.println("*Peck peck*");
		return this;
	}

	public Bird fly(){
		System.out.println("*flap flap*");
		return this;
	}
}