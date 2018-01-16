package com.project.ninjaGold.models;

import java.util.Date;
import java.util.Random;

public class Activity{
	private String location;
	private int gold;
	private String color;
	private String text;
	private Date date;
	private Random random;

	public Activity(String location,int min,int max){
		this.location = location;
		this.random = new Random();
		this.date = new Date();
		randomize(min,max);
		generate();
	}

	public Activity(){

	}

	public int range(int min, int max){
		return random.nextInt( (max - min) + 1 )+min;
	}

	public void randomize(int min, int max){
		this.gold = range(min,max);
	}

	public void generate(){
		this.text = "You entered a ";

		if(gold > 0){
			this.text += location + " and earned "+gold+" ("+date+")";
			this.color = "green";
		}else{
			this.text += location + " and lost "+gold+" ("+date+")";
			this.color = "red";
		}
	}

	public void setLocation(String location){this.location=location;}
	public void setGold(int gold){this.gold=gold;}
	public void setColor(String color){this.color=color;}
	public void setText(String text){this.text=text;}
	public void setDate(Date date){this.date=date;}

	public String getLocation(){return location;}
	public int getGold(){return gold;}
	public String getColor(){return color;}
	public String getText(){return text;}
	public Date getDate(){return date;}
}
