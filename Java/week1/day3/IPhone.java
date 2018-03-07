import java.util.Random;

public class IPhone extends Phone{
	public IPhone(String name,String model, String carrier, String os, double price,String number){
		super(name,model,carrier,os,price,number);
	}

	public IPhone(){

	}

	public void answer(){
		System.out.println(this.getOS());

		Random rand = new Random();

		if(rand.nextInt(10)+1 > 5){
			System.out.println("*Phone explodes*");
		}else{
			System.out.println("*Steve Jobs salutes you*");
		}
	};

	public void textMessage(Phone phone,String message){
		if( phone.getOS().equals(this.getOS()) ){
			System.out.println(
				phone.getNumber()+": "+message+" says "+phone.getName()
			);
		}else{
			System.out.println("Your phone must be: "+phone.getOS()+" compatible to use this feature.");
		}
	};

	public void call(Phone phone){

	};

	public void specs(){

	};

	public String voicemail(){
		return "";
	};
}
