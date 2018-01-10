public class Mercedes extends Vehicle{
	public int direction;

	public Mercedes(double cost,String sound, int direction){
		setCost( cost * 2 );		
		setSound("BEEEEEP!");
		setDirection(direction);
		
		System.out.println( getCost() );
	}

	public void steer(int dir){
		if(dir < 0 || dir > 360){return;}
		direction = dir;

		System.out.println(" The mercedes is turning at a radius of:"+ direction);
	}	

	public void honk(String snd){
		setSound( snd );
		System.out.println("The expensive Mercedes says: "+ snd);
	}
}