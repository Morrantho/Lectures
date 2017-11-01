public class Animal{
	private String name;
	private int numLegs;
	private String species;
	private String gender;
	private String diet;

	public Animal(){

	}

	public Animal(String name, int numLegs, String species, String gender, String diet){
		this.name=name;
		this.numLegs=numLegs;
		this.species=species;
		this.gender=gender;
		this.diet=diet;
	}

	public Animal(String name,int numLegs){
		this.name=name;
		this.numLegs=numLegs;
	}

	public void walk(){
		System.out.println("*Muffled Footsteps*");
	}

	public void sleep(){
		System.out.println("*Zzzzzzzz*");
	}

	public void eat(){
		System.out.println("*nom nom*");
	}

	public void setName(String value){
		this.name=value;
	}
	public void setSpecies(String value){
		this.species=value;
	}
	public void setGender(String value){
		this.gender=value;
	}
	public void setDiet(String value){
		this.diet=value;
		
	}
	public void setNumLegs(int value){
		this.numLegs=value;
	}

	public String getName(){
		return this.name;
	}
	public String getSpecies(){
		return this.species;
	}
	public String getGender(){
		return this.gender;
	}
	public String getDiet(){
		return this.diet;		
	}
	public int getNumLegs(){
		return this.numLegs;
	}

}