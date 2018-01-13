import java.util.Random;

public class Galaxy extends Phone{
	private boolean blewUp(){
		Random rand = new Random();

		if( rand.nextInt(1 - 0 + 1) + 0 == 0 ){
			return false;
		}else{
			return true;
		}
	}

	public Galaxy(int screenSize,int number,int batteryLevel,String brand,String carrier,String ringTone){
		super(screenSize,number,batteryLevel,brand,carrier,ringTone);
	}

	public void ring(){
		if( blewUp() ){
			System.out.println( "This phone is awful" );
		}else{
			System.out.println( ringTone );
		}
	}

	public void vibrate(){

	};
	public void hangup(){

	};
	public void answer(){
		
	};
}