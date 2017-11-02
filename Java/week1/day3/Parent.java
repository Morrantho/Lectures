public class Parent{
	public Parent(){
		System.out.println("Im a Parent.");	
	}

	public void talk(){
		System.out.println("Hey there.");
	}

	public static void main(String[] args){
		// Parent parent         = new Parent();
		// Parent child          = new Child();
		// child.talk();
		// ((Child) child).scream();  
		// GrandChild grandChild = new GrandChild();

		// System.out.println();

		// Bird parrot = new Bird();
		// parrot.eat().fly();

		Animal nemo = new Fish();
		// nemo.eat();
		// nemo.swim();
		// ((Bird) nemo).fly();
	}
}