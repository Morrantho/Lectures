import java.util.Random;

public class IPhone extends Phone{
	public IPhone(int screenSize,int number,int batteryLevel,String brand,String carrier,String ringTone){
		super(screenSize,number,batteryLevel,brand,carrier,ringTone);
	}

	public boolean tookPicture(){
		Random rand = new Random();

		if( rand.nextInt(1 - 0 + 1) + 0 == 0 ){
			return false;
		}else{
			return true;
		}		
	}

	public void ring(){
		System.out.println( "IPhone rings: "+ringTone );
	}

	public void vibrate(){
		
	}

	public void hangup(){
		
	}

	public void answer(){
		if( tookPicture() ){
			System.out.println("*Your IPhone secretly takes a picture of you without your consent.");
		}else{
			System.out.println( "You answered your IPhone." );
		}	
	}
}