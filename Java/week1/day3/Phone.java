public abstract class Phone implements Ringable{
	private String name;
	private String model;
	private String carrier;
	private String os;
	private double price;
	private String number;

	public Phone(){

	}

	public Phone(String name,String model, String carrier, String os, double price,String number){
		this.os = os;
		this.name = name;
		this.model = model;
		this.carrier = carrier;
		this.price = price;
		this.number = number;
	}

	public void setModel(String model){
		this.model = model;
	}
	public void setCarrier(String carrier){
		this.carrier = carrier;
	}
	public void setOS(String os){
		this.os = os;
	}
	public void setPrice(double price){
		this.price = price;
	}

	public String getModel(){
		return model;
	}
	public String getCarrier(){
		return carrier;
	}
	public String getOS(){
		return os;
	}
	public double getPrice(){
		return price;
	}
	public String getNumber(){
		return number;
	}
	public String getName(){
		return name;
	}

	public static void main(String[] args) {
		IPhone noble = new IPhone("Noble","IPhoneX","Sprint","iOS",999.99,"8765321786");
		IPhone godwin = new IPhone("Godwin","IPhoneX","T-Mobile","iOS",999.99,"167823651");

		noble.textMessage(godwin,"Sometimes I text myself, idk about you.");
		godwin.textMessage(noble,"You good?");
	}
}
