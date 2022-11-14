package edu.pacific.comp55.starter; 

import java.util.ArrayList;


public class house {
	public static Room DiningHall;
	public static Room Apothecary;
	public static Room Kitchen;
	public static Room WineCellar;
	public static Room GreenHouse;
	public static Room TheStudy;
	public static Room Armory;
	public static Room Workshop;
	public static Room TheCliff;
	public static Room Dungeon;
	public static Room Balcony;
	public static Room Outdoors_1;
	public static Room Outdoors_2;
	public static Room Outdoors_3;
	public static Room Outdoors_4;
	public static Room Hallway;
	public static Room Bedroom_1;
	public static Room Bedroom_2;
	public static Room Bedroom_3;
	public static Room Bedroom_4;
	public static Room Bedroom_5;
	public static Room Bedroom_6;
	public static Room Bedroom_7;
	public static Room Bedroom_8;
	public static Room Bedroom_9;
	public static Room Bedroom_10;
	static int currentPG;
	ArrayList<Partygoer> allPartygoers;
	//sets the time of the house
		private int time;
		
		public ArrayList<Room> busRoute(int beginning, int end) {
			ArrayList<Room> route = new ArrayList<Room>();
			//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
			if (beginning == 1 && end == 2) {
				
				route.add(Study);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 1 && end == 3) {
				
				route.add(Balcony);
				route.add(Armory);
			}
			if (beginning == 1 && end == 4) {
				
				route.add(Study);
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 1 && end == 5) {
				
				route.add(Study);
				route.add(DiningHall);
				route.add(GreenHouse);
				route.add(Outdoors_4);
				route.add(Outdoors_3);
			}
			if (beginning == 2 && end == 1) {
				
				route.add(DiningHall);
				route.add(Study);
				route.add(Apothecary);
			}
			if (beginning == 2 && end == 3) {
				
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 2 && end == 4) {
				
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 2 && end == 5) {
				
				route.add(DiningHall);
				route.add(Kitchen);
				route.add(Outdoors_2);
				route.add(Outdoors_1);
				route.add(Outdoors_3);
			}
			if (beginning == 3 && end == 1) {
				
				route.add(Balcony);
				route.add(Apothecary);
			}
			if (beginning == 3 && end == 2) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 3 && end == 4) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 3 && end == 5) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(GreenHouse);
				route.add(Apothecary);
			}
			if (beginning == 4 && end == 1) {
				
				route.add(DiningHall);
				route.add(Study);
				route.add(Apothecary);
			}
			if (beginning == 4 && end == 2) {
				
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 4 && end == 3) {
				
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 4 && end == 5) {
				
				route.add(Outdoors_2);
				route.add(Outdoors_1);
				route.add(Outdoors_3);
			}
			if (beginning == 5 && end == 1) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(Study);
				route.add(Apothecary);
			}
			if (beginning == 5 && end == 2) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 5 && end == 3) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 5 && end == 4) {
				
				route.add(Outdoors_1);
				route.add(Outdoors_2);
				route.add(Kitchen);
			}
			return route;
		}
		
		//checks when it's night or day 
		private static Boolean isDark;
		
		public void nextPlayer() {
			if(currentPG == 9) {
				currentPG = 0;
				allPartygoers.get(currentPG).takeTurn();
			}
		}
		
		//the number of dead people
		private int deadpeople;
		
		//The partygoer whose turn it currently is.
		Partygoer currPlayer;
		
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public Boolean getIsDark() {
			return isDark;
		}
		public void setIsDark(Boolean isDark) {
			this.isDark = isDark;
		}
		public int getDeadpeople() {
			return deadpeople;
		}
		public void setDeadpeople(int deadpeople) {
			this.deadpeople = deadpeople;
		}
		//For each arraylist in each room. .add the room
		
		public static void main(String[] args) {
			ArrayList<String> House = new ArrayList<String>();
			DiningHall = new Room(null, isDark, null, null, null, null, currentPG);
			Apothecary = new Room(null, isDark, null, null, null, null, currentPG);
			Kitchen = new Room(null, isDark, null, null, null, null, currentPG);
			WineCellar = new Room(null, isDark, null, null, null, null, currentPG);
			GreenHouse = new Room(null, isDark, null, null, null, null, currentPG);
			TheStudy = new Room(null, isDark, null, null, null, null, currentPG);
			Armory = new Room(null, isDark, null, null, null, null, currentPG);
			Workshop = new Room(null, isDark, null, null, null, null, currentPG);
			Dungeon = new Room(null, isDark, null, null, null, null, currentPG);
			Outdoors_1 = new Room(null, isDark, null, null, null, null, currentPG);
			Outdoors_2 = new Room(null, isDark, null, null, null, null, currentPG);
			Outdoors_3 = new Room(null, isDark, null, null, null, null, currentPG);
			Outdoors_4 = new Room(null, isDark, null, null, null, null, currentPG);
		    Bedroom_1 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_2 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_3 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_4 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_5 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_6 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_7 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_8 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_9 = new Room(null, isDark, null, null, null, null, currentPG);
			Bedroom_10 = new Room(null, isDark, null, null, null, null, currentPG);
			TheCliff = new Room(null, isDark, null, null, null, null, currentPG);	
			System.out.println(House);
		}
}
