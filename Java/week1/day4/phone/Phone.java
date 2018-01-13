public abstract class Phone{
	public int screenSize;
	public int number;
	public int batteryLevel;
	public String brand;
	public String carrier;
	public String ringTone;

	public abstract void vibrate();
	public abstract void hangup();
	public abstract void answer();
	public abstract void ring();

	public Phone(int screenSize,int number,int batteryLevel,String brand,String carrier,String ringTone){
		this.screenSize = screenSize;
		this.number = number;
		this.batteryLevel = batteryLevel;
		this.brand = brand;
		this.carrier = carrier;
		this.ringTone=ringTone;
	}
	
	public static void main(String[] args) {
		Galaxy s5 = new Galaxy(6,123,70,"Samsung","Verizon","Buzzzzzz");
		Galaxy s6 = new Galaxy(6,456,50,"Samsung","Verizon","Bizzzzz");
		IPhone sixS = new IPhone(6,789,80,"Apple","AT&T","Zing");

		s5.ring();
		sixS.answer();
	}
}