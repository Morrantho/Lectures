public class AnimalTest{

	public static void main(String[] args){
		Animal bird = new Animal("Big",2);


		Animal tiger = new Animal();
		tiger.setName("Tony");
		tiger.setSpecies("Tiger");
		tiger.setGender("Male");
		tiger.setDiet("Cereal Killer");
		tiger.setNumLegs(4);

		// System.out.println(tiger.getName());
		// System.out.println(tiger.getSpecies());
		// System.out.println(tiger.getGender());
		// System.out.println(tiger.getDiet());
		// System.out.println(tiger.getNumLegs());

		Bird pigeon = new Bird("Walter",2,"Pigeon","Male","Herbivore",true);
		pigeon.eat();
	}
}