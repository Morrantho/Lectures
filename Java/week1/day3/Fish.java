public class Fish extends Animal implements CanSwim{

	public Fish(){

	}

	public Fish(String name, int numLegs, String species, String gender, String diet){
		super(name,numLegs,species,gender,diet);
	}

	public Animal eat(){
		System.out.println("*bloop bloop*");
		return this;
	}

	public void swim(){
		System.out.println("*Glides through the water gracefully and swishing*");
	}
}