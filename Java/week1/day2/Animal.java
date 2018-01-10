public class Animal{
	private int limbs = 0;	
	private int legs = 0;
	private String name = "";
	private String species = "";
	private boolean gender = false;

	public Animal(){

	}

	public Animal(int g,int h,String i,String j,boolean k){
		limbs = g;
		legs  = h;
		name  = i;
		species = j;
		gender = k;
	}

	public void setLimbs(int limbs){
		this.limbs = limbs;
	}
	public int getLimbs(){
		return limbs;
	}

	public void setLegs(int legs){
		this.legs = legs;
	}
	public int getLegs(){
		return legs;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}


	public void setSpecies(String species){
		this.species=species;
	}
	public String getSpecies(){
		return species;
	}

	public void setGender(boolean gender){
		this.gender = gender;
	}

	public String getGender(){
		if(gender){
			return "Male";
		}else{
			return "Female";
		}
	}
}