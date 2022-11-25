package edu.pacific.comp55.starter; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class house {
	public Room DiningHall;
	public Room Apothecary;
	public Room Kitchen;
	public Room WineCellar;
	public Room GreenHouse;
	public Room TheStudy;
	public Room Armory;
	public Room Workshop;
	public Room TheCliff;
	public Room Dungeon;
	public Room Balcony;
	public Room Outdoors_1;
	public Room Outdoors_2;
	public Room Outdoors_3;
	public Room Outdoors_4;
	public Room Hallway;
	public Room Bedroom_1;
	public Room Bedroom_2;
	public Room Bedroom_3;
	public Room Bedroom_4;
	public Room Bedroom_5;
	public Room Bedroom_6;
	public Room Bedroom_7;
	public Room Bedroom_8;
	public Room Bedroom_9;
	public Room Bedroom_10;
	public Room Morgue;
	static int currentPG;
	ArrayList<Partygoer> allPartygoers;
	//sets the time of the house
		private int time;
		
		GoalSets goalsets;
		
		public ArrayList<Room> busRoute(int beginning, int end) {
			ArrayList<Room> route = new ArrayList<Room>();
			//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
			if (beginning == 1 && end == 2) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 1 && end == 3) {
				
				route.add(Balcony);
				route.add(Armory);
			}
			if (beginning == 1 && end == 4) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 1 && end == 5) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(GreenHouse);
				route.add(Outdoors_4);
				route.add(Outdoors_3);
			}
			if (beginning == 2 && end == 1) {
				
				route.add(DiningHall);
				route.add(TheStudy);
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
				route.add(TheStudy);
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
				route.add(TheStudy);
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
		
		public void adjacentRooms() {
				this.DiningHall.adjacentRooms.add(Kitchen);
				this.DiningHall.adjacentRooms.add(GreenHouse);
				this.DiningHall.adjacentRooms.add(Hallway);
				this.DiningHall.adjacentRooms.add(TheStudy);
				this.DiningHall.adjacentRooms.add(Workshop);
			
			
				this.Apothecary.adjacentRooms.add(TheStudy);
				this.Apothecary.adjacentRooms.add(Balcony);
				this.Apothecary.adjacentRooms.add(Morgue);
				
				this.Morgue.adjacentRooms.add(Apothecary);
				
				this.Kitchen.adjacentRooms.add(DiningHall);
				this.Kitchen.adjacentRooms.add(GreenHouse);
				this.Kitchen.adjacentRooms.add(Outdoors_2);
				this.Kitchen.adjacentRooms.add(WineCellar);
			
				this.WineCellar.adjacentRooms.add(Kitchen);
				
				this.GreenHouse.adjacentRooms.add(Kitchen);
				this.GreenHouse.adjacentRooms.add(DiningHall);
				this.GreenHouse.adjacentRooms.add(Outdoors_4);
			
				this.TheStudy.adjacentRooms.add(DiningHall);
				this.TheStudy.adjacentRooms.add(Apothecary);
			
				this.Armory.adjacentRooms.add(Workshop);
				this.Armory.adjacentRooms.add(Dungeon);
				this.Armory.adjacentRooms.add(Balcony);
			
				this.Workshop.adjacentRooms.add(Armory);
				this.Workshop.adjacentRooms.add(DiningHall);
	
				this.Dungeon.adjacentRooms.add(Armory);
			
				this.Outdoors_1.adjacentRooms.add(Outdoors_2);
				this.Outdoors_1.adjacentRooms.add(Outdoors_3);
				this.Outdoors_1.adjacentRooms.add(TheCliff);

				this.Outdoors_2.adjacentRooms.add(Outdoors_1);
				this.Outdoors_2.adjacentRooms.add(Outdoors_4);
				this.Outdoors_2.adjacentRooms.add(Kitchen);
			
				this.Outdoors_3.adjacentRooms.add(TheCliff);
				this.Outdoors_3.adjacentRooms.add(Outdoors_1);
				this.Outdoors_3.adjacentRooms.add(Outdoors_4);
			
				this.Outdoors_4.adjacentRooms.add(Outdoors_3);
				this.Outdoors_4.adjacentRooms.add(Outdoors_2);
				this.Outdoors_4.adjacentRooms.add(GreenHouse);
		
				this.Bedroom_1.adjacentRooms.add(Hallway);
				this.Bedroom_2.adjacentRooms.add(Hallway);
				this.Bedroom_3.adjacentRooms.add(Hallway);
				this.Bedroom_4.adjacentRooms.add(Hallway);
				this.Bedroom_5.adjacentRooms.add(Hallway);
				this.Bedroom_6.adjacentRooms.add(Hallway);
				this.Bedroom_7.adjacentRooms.add(Hallway);
				this.Bedroom_8.adjacentRooms.add(Hallway);
				this.Bedroom_9.adjacentRooms.add(Hallway);
				this.Bedroom_10.adjacentRooms.add(Hallway);
		
			
				this.TheCliff.adjacentRooms.add(Outdoors_1);
				this.TheCliff.adjacentRooms.add(Outdoors_3);

				this.Hallway.adjacentRooms.add(Bedroom_1);
				this.Hallway.adjacentRooms.add(Bedroom_2);
				this.Hallway.adjacentRooms.add(Bedroom_3);
				this.Hallway.adjacentRooms.add(Bedroom_4);
				this.Hallway.adjacentRooms.add(Bedroom_5);
				this.Hallway.adjacentRooms.add(Bedroom_6);
				this.Hallway.adjacentRooms.add(Bedroom_7);
				this.Hallway.adjacentRooms.add(Bedroom_8);
				this.Hallway.adjacentRooms.add(Bedroom_9);
				this.Hallway.adjacentRooms.add(Bedroom_10);
				this.Hallway.adjacentRooms.add(DiningHall);
				this.Hallway.adjacentRooms.add(Balcony);
				
				this.Balcony.adjacentRooms.add(Armory);
				this.Balcony.adjacentRooms.add(Hallway);
				this.Balcony.adjacentRooms.add(Apothecary);

		}
		
		public String RoomtoString(Room room) {
			if (room==DiningHall) {
				return "Dining Hall";
			}
			else if (room==Apothecary) {
				return "Apothecary";
			}
			else if (room==Kitchen) {
				return "Kitchen";
			}
			else if (room==WineCellar) {
				return "Wine Cellar";
			}
			else if (room==GreenHouse) {
				return "Greenhouse";
			}
			else if (room==TheStudy) {
				return "Study";
			}
			else if (room==Armory) {
				return "Armory";
			}
			else if (room==Workshop) {
				return "Workshop";
			}
			else if (room==Dungeon) {
				return "Dungeon";
			}
			else if (room==Outdoors_1) {
				return "Outdoors 1";
			}
			else if (room==Outdoors_2) {
				return "Outdoors 2";
			}
			else if (room==Outdoors_3) {
				return "Outdoors 3";
			}
			else if (room==Outdoors_4) {
				return "Outdoors 4";
			}
			else if (room==Bedroom_1) {
				return "Bedroom 1";
			}
			else if (room==Bedroom_2) {
				return "Bedroom 2";
			}
			else if (room==Bedroom_3) {
				return "Bedroom 3";
			}
			else if (room==Bedroom_4) {
				return "Bedroom 4";
			}
			else if (room==Bedroom_5) {
				return "Bedroom 5";
			}
			else if (room==Bedroom_6) {
				return "Bedroom 6";
			}
			else if (room==Bedroom_7) {
				return "Bedroom 7";
			}
			else if (room==Bedroom_8) {
				return "Bedroom 8";
			}
			else if (room==Bedroom_9) {
				return "Bedroom 9";
			}
			else if (room==Bedroom_10) {
				return "Bedroom 10";
			}
			else if (room==TheCliff) {
				return "Cliff";
			}
			else if (room==Hallway) {
				return "Hallway";
			}
			else if (room==Morgue) {
				return "Morgue";
			}
			return null;
		}
		
		public house() {
			//ArrayList<String> House = new ArrayList<String>();
			this.time = 1;
			this.isDark = false;
			this.goalsets = new GoalSets();
			this.DiningHall = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Apothecary = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 1);
			this.Kitchen = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 4);
			this.WineCellar = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.GreenHouse = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.TheStudy = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Armory = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 3);
			this.Workshop = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Dungeon = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Outdoors_1 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Outdoors_2 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Outdoors_3 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 5);
			this.Outdoors_4 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
		    this.Bedroom_1 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_2 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_3 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_4 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_5 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_6 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_7 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_8 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_9 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Bedroom_10 = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.TheCliff = new Room(null, this, isDark, new ArrayList<Convos>(), null, new ArrayList<Room>(), new HashSet<Partygoer>(), 0);
			this.Hallway = new Room(null, this, isDark,new ArrayList<Convos>(),null,new ArrayList<Room>(),new HashSet<Partygoer>(),2);
			this.Morgue = new Room(null, this, isDark,new ArrayList<Convos>(),null,new ArrayList<Room>(),new HashSet<Partygoer>(),0);
			adjacentRooms();
		}
}
