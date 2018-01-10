public class Cat extends Animal{
	private String sound    = "meow";
	private String furColor = "brown";

	public void meow(){
		System.out.println( this.getName() + " says: " + this.getSound() );
	}

	public Cat(){

	}

	public Cat(int a,int b,String c,String d,boolean e,String f){
		super(a,b,c,d,e);
		// sound = f;		
	}
	
	public void setSound(String sound){
		this.sound = sound;
	}
	public String getSound(){
		return sound;
	}
	public void setFurColor(String furColor){
		this.furColor = furColor;
	}
	public String getFurColor(){
		return furColor;
	}
}