package edu.pacific.comp55.starter; 

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;



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
	ArrayList<item> knifeset;
	public Random rando;
	Boolean foodPoisoned;
	Boolean gameEnd;
	public int factcounter;
	static int currentPG;
	ArrayList<Partygoer> allPartygoers;
	public int TheTime;
	//sets the time of the house
		public int time;
		//decides what endScreen is displayed.
		int endType;
		GoalSets goalsets;
		
		public static void main(String args[]) {
			start();
		}
		
		public static void start() {
			house thehouse = new house();
			thehouse.allPartygoers.get(0).isPlayer = true;
			thehouse.allPartygoers.get(0).isDetective = true;
			int killernum = thehouse.rando.nextInt(9);
			thehouse.allPartygoers.get(killernum+1).isKiller = true;
			thehouse.allPartygoers.get(killernum+1).Inventory.add(item.KNIFE);
			thehouse.characterSelect();
			thehouse.RunGame();
		}
		
		public void characterSelect() {
			int response = 0;
			System.out.print("1. Gertrude Biblio - Genius Librarian\n");
			System.out.print("2. Frank - Robust Sommelier\n");
			System.out.print("3. Constable Smithy - Furtive Lawman\n");
			System.out.print("4. Doctor Reiklen - Surgeon Extraordinaire\n");
			System.out.print("5. Ariana Stocracy - Alluring Socialite\n");
			System.out.print("6. bob\n");
			System.out.print("7. Maximillian - Disarming Politician\n");
			System.out.print("8. Jake of the West - Bounty Hunter\n");
			System.out.print("9. Chad - Millio- no, Billionaire\n");
			System.out.print("10. Todd - Local Teen\n");
			response = in.nextInt();
<<<<<<< HEAD
=======
			System.out.print(response);
			/*try {
				response = reader.nextInt();
			}
			catch(Exception InputMismatchException) {
				characterSelect();
			}
			/*finally {*/
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
				if (response < 1 || response > 10) {
				characterSelect();	
				}
				else {
					ArrayList<String> identities =  new ArrayList<String>();
					ArrayList<Partygoer> partyholder = new ArrayList<Partygoer>();
					identities.add("Gertrude Biblio");
					identities.add("Frank");
					identities.add("Constable Smithy");
					identities.add("Doctor Reiklen");
					identities.add("Ariana");
					identities.add("bob");
					identities.add("Maximillian");
					identities.add("Jake");
					identities.add("Chad");
					identities.add("Todd");
					allPartygoers.get(0).identity = identities.get(response-1);
					partyholder.add(allPartygoers.get(0));
					allPartygoers.remove(0);
					while (allPartygoers.size() != 0) {
						int checknum = rando.nextInt(allPartygoers.size());
<<<<<<< HEAD
						allPartygoers.get(0).identity = identities.get(checknum);
						partyholder.add(allPartygoers.get(0));
						allPartygoers.remove(allPartygoers.get(0));
=======
						allPartygoers.get(checknum).identity = identities.get(checknum);
						partyholder.add(allPartygoers.get(checknum));
						allPartygoers.remove(checknum);
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
						identities.remove(checknum);
					}
					allPartygoers = partyholder;
				}
			}
			
<<<<<<< HEAD
=======
				
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
		
		public void RunGame() {
			int i = 0; 
			while (gameEnd == false) { 
			allPartygoers.get(i).takeTurn();
			time++;
			//if the killer is dead, endType = 1, and end is true
			if (allPartygoers.get(i).isKiller == true && allPartygoers.get(i).Dead == true) {
				endType = 1;
				gameEnd = true;
			}
			//if the killer is arrested, endType = 2, and end is true
			if (allPartygoers.get(i).isKiller == true && allPartygoers.get(i).isArrested == true) {
				endType = 2;
				gameEnd = true;
			}
			//if the player is dead, endType = 3, and end is true
			if (allPartygoers.get(i).isPlayer == true && allPartygoers.get(i).Dead == true) {
				endType = 3;
				gameEnd = true;
			}
			int deadcount = 0;
			for (int j = 0; j < allPartygoers.size(); j++) {
<<<<<<< HEAD
				if (allPartygoers.get(j).Dead == true) {
=======
				if (allPartygoers.get(j).Dead == false) {
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
					deadcount++;
				}
			}
			if (deadcount == 5) {
				endType = 4;
				gameEnd = true;
			}
<<<<<<< HEAD
			if(i==9) {i=0;} 
			else {i++;}
=======
			if (i==9) {i=0;}
			else {
				i++;
			time++;	
			} 
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
			}
			endGame(endType);
		}
		
		
		public void endGame(int choice) {
			//TO DO ENDSCREENS
		}
		
		public ArrayList<Room> busRoute(int beginning, int end) {
			ArrayList<Room> route = new ArrayList<Room>();
			//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottom left is stop 5.
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
		
		//the number of dead people
		public int deadpeople;
		
		//The partygoer whose turn it currently is.
		Partygoer currPlayer;
		private boolean chandelierLoose;
		
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public Boolean getIsDark() {
			return isDark;
		}

		public int getDeadpeople() {
			return deadpeople;
		}
		public void setDeadpeople(int deadpeople) {
			this.deadpeople = deadpeople;
		}
		
		public void printScoreBoard() {
			for (int i=0; i<10; i++) {
				System.out.print(allPartygoers.get(i).identity + " Status: ");
				if (allPartygoers.get(i).Dead) {
					System.out.print("DEAD ");
				}
				else {
					System.out.print("Alive. ");
				}
			System.out.print("Inventory: ");
			for (int o=0; o<allPartygoers.get(i).Inventory.size(); o++) {
				System.out.print(allPartygoers.get(i).Inventory.get(o).toString() + ", ");
			}
			System.out.print("\n");
			if (allPartygoers.get(i).Dead) {
			System.out.print("Current Goal: Being dead \n");
			}
			else {
				System.out.print("Current Goal: " + allPartygoers.get(i).currGoal.toString() + "\n");
				}
			}
		}
		
		public void adjacenrooms() {
				this.DiningHall.adjacentRooms.add(this.Kitchen);
				this.DiningHall.adjacentRooms.add(this.GreenHouse);
				this.DiningHall.adjacentRooms.add(this.Hallway);
				this.DiningHall.adjacentRooms.add(this.TheStudy);
				this.DiningHall.adjacentRooms.add(this.Workshop);
			for (int i=0; i<DiningHall.adjacentRooms.size(); i++) {
				System.out.print(RoomtoString(DiningHall.adjacentRooms.get(i)));
			}
			
				this.Apothecary.adjacentRooms.add(this.TheStudy);
				this.Apothecary.adjacentRooms.add(this.Balcony);
				this.Apothecary.adjacentRooms.add(this.Morgue);
				
				this.Morgue.adjacentRooms.add(this.Apothecary);
				
				this.Kitchen.adjacentRooms.add(this.DiningHall);
				this.Kitchen.adjacentRooms.add(this.GreenHouse);
				this.Kitchen.adjacentRooms.add(this.Outdoors_2);
				this.Kitchen.adjacentRooms.add(this.WineCellar);
			
				this.WineCellar.adjacentRooms.add(this.Kitchen);
				
				this.GreenHouse.adjacentRooms.add(this.Kitchen);
				this.GreenHouse.adjacentRooms.add(this.DiningHall);
				this.GreenHouse.adjacentRooms.add(this.Outdoors_4);
			
				this.TheStudy.adjacentRooms.add(this.DiningHall);
				this.TheStudy.adjacentRooms.add(this.Apothecary);
			
				this.Armory.adjacentRooms.add(this.Workshop);
				this.Armory.adjacentRooms.add(this.Dungeon);
				this.Armory.adjacentRooms.add(this.Balcony);
			
				this.Workshop.adjacentRooms.add(this.Armory);
				this.Workshop.adjacentRooms.add(this.DiningHall);
	
				this.Dungeon.adjacentRooms.add(this.Armory);
			
				this.Outdoors_1.adjacentRooms.add(this.Outdoors_2);
				this.Outdoors_1.adjacentRooms.add(this.Outdoors_3);
				this.Outdoors_1.adjacentRooms.add(this.TheCliff);

				this.Outdoors_2.adjacentRooms.add(this.Outdoors_1);
				this.Outdoors_2.adjacentRooms.add(this.Outdoors_4);
				this.Outdoors_2.adjacentRooms.add(this.Kitchen);
			
				this.Outdoors_3.adjacentRooms.add(this.TheCliff);
				this.Outdoors_3.adjacentRooms.add(this.Outdoors_1);
				this.Outdoors_3.adjacentRooms.add(this.Outdoors_4);
			
				this.Outdoors_4.adjacentRooms.add(this.Outdoors_3);
				this.Outdoors_4.adjacentRooms.add(this.Outdoors_2);
				this.Outdoors_4.adjacentRooms.add(this.GreenHouse);
		
				this.Bedroom_1.adjacentRooms.add(this.Hallway);
				this.Bedroom_2.adjacentRooms.add(this.Hallway);
				this.Bedroom_3.adjacentRooms.add(this.Hallway);
				this.Bedroom_4.adjacentRooms.add(this.Hallway);
				this.Bedroom_5.adjacentRooms.add(this.Hallway);
				this.Bedroom_6.adjacentRooms.add(this.Hallway);
				this.Bedroom_7.adjacentRooms.add(this.Hallway);
				this.Bedroom_8.adjacentRooms.add(this.Hallway);
				this.Bedroom_9.adjacentRooms.add(this.Hallway);
				this.Bedroom_10.adjacentRooms.add(this.Hallway);
		
			
				this.TheCliff.adjacentRooms.add(this.Outdoors_1);
				this.TheCliff.adjacentRooms.add(this.Outdoors_3);

				this.Hallway.adjacentRooms.add(this.Bedroom_1);
				this.Hallway.adjacentRooms.add(this.Bedroom_2);
				this.Hallway.adjacentRooms.add(this.Bedroom_3);
				this.Hallway.adjacentRooms.add(this.Bedroom_4);
				this.Hallway.adjacentRooms.add(this.Bedroom_5);
				this.Hallway.adjacentRooms.add(this.Bedroom_6);
				this.Hallway.adjacentRooms.add(this.Bedroom_7);
				this.Hallway.adjacentRooms.add(this.Bedroom_8);
				this.Hallway.adjacentRooms.add(this.Bedroom_9);
				this.Hallway.adjacentRooms.add(this.Bedroom_10);
				this.Hallway.adjacentRooms.add(this.DiningHall);
				this.Hallway.adjacentRooms.add(this.Balcony);
				
				this.Balcony.adjacentRooms.add(this.Armory);
				this.Balcony.adjacentRooms.add(this.Hallway);
				this.Balcony.adjacentRooms.add(this.Apothecary);

		}
		
		public int getBusStop(Room room) {
			int result = 0;
			if (room == Apothecary || room == Morgue || room == TheStudy) {
				return 1;
			}
			else if (room == Balcony) {
				return rando.nextInt(3)+1;
			}
			else if (room == Armory || room == Dungeon || room == Workshop) {
				return 3;
			}
			else if (room == DiningHall) {
				int randocheck = rando.nextInt(2);
				if (randocheck == 0) {
					return 2;
				}
				if (randocheck == 1) {
					return 4;
				}
			}
			else if (room == Bedroom_1 || room == Bedroom_2 || room == Bedroom_3 || room == Bedroom_4 || room == Bedroom_5 || room == Bedroom_6 || room == Bedroom_7 || room == Bedroom_8 || room == Bedroom_9 || room == Bedroom_10) {
				return 2;
			}
			else if (room == Kitchen || room == WineCellar || room == GreenHouse || room == Outdoors_2) {
				return 4;
			}
			else if (room == Outdoors_1 || room == Outdoors_3 || room == Outdoors_4 || room == TheCliff) {
				return 5;
			}
			if (result == 0) {
				System.out.print("No bus stop found.");
			}
			return result;
		}
		
		public String RoomtoString(Room room) {
			if (room==DiningHall) {
				return "Dining Hall";
			}
			else if (room == Balcony) {
				return "Balcony";
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
			this.factcounter = 0;
			this.gameEnd = false;
			this.rando = new Random();
			this.goalsets = new GoalSets();
			this.knifeset = new ArrayList<item>();
			this.knifeset.add(item.KNIFE);
			this.knifeset.add(item.KNIFE);
			this.gameEnd = false;
			this.knifeset.add(item.KNIFE);
			this.allPartygoers = new ArrayList<Partygoer>();
			this.DiningHall = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
<<<<<<< HEAD
			this.Balcony = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Apothecary = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 1);
			this.Kitchen = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 4);
			this.WineCellar = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.GreenHouse = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.TheStudy = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Armory = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 3);
			this.Workshop = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Dungeon = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Outdoors_1 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Outdoors_2 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Outdoors_3 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 5);
			this.Outdoors_4 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
		    this.Bedroom_1 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_2 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_3 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_4 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_5 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_6 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_7 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_8 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_9 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Bedroom_10 = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.TheCliff = new Room(new ArrayList<item>(), this,  new ArrayList<Partygoer>(), 0);
			this.Hallway = new Room(new ArrayList<item>(), this,new ArrayList<Partygoer>(),2);
			this.Morgue = new Room(new ArrayList<item>(), this,new ArrayList<Partygoer>(),0);
			adjacenrooms();
=======
			this.Balcony = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Apothecary = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 1);
			this.Kitchen = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 4);
			this.WineCellar = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.GreenHouse = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.TheStudy = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Armory = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 3);
			this.Workshop = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Dungeon = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Outdoors_1 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Outdoors_2 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Outdoors_3 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 5);
			this.Outdoors_4 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
		    this.Bedroom_1 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_2 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_3 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_4 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_5 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_6 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_7 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_8 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_9 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Bedroom_10 = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.TheCliff = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(), 0);
			this.Hallway = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(),2);
			this.Morgue = new Room(new ArrayList<item>(), this, new ArrayList<Partygoer>(),0);
			adjacentRooms();
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-4.git
			this.endType = 0;
			this.deadpeople = 0;
			this.foodPoisoned = false;
			this.chandelierLoose = false;
			this.factcounter = 0;
			this.allPartygoers = new ArrayList<Partygoer>();
			for (int i =0; i<10; i++) {
				this.allPartygoers.add(new Partygoer(this.DiningHall, this));
			}
			
		}
		
		//***COPIED ALL THE FUNCTIONS FROM CONVOS.JAVA TO HOUSE.JAVA PASTED BELOW THIS COMMENT***
			Scanner in = new Scanner(System.in); //for brewing and crafting, everything else will just click and it happens //partygoer, room and fact also need scanner
			int userChoice;
			String input;
			//Facts should be formatted like "_stabbing_" for madlibs
			//also need to work on evidence

			public boolean KitchenWinePoison;
			public boolean CellarWinePoison;
			
			/*public Convos(house House) {
				this.House = House;
			}*/
			
			public Boolean Brewing(Partygoer user) {
				if (user.isPlayer) {
					System.out.print("Choose an option:");
						System.out.print("1) Poison: 6 turns");
						System.out.print("2) Antidote: 4 turns");
						System.out.print("3) Perfume: 2 turns");
						userChoice = in.nextInt();
						System.out.println("You entered " + userChoice);
				if (userChoice == 1 || user.currGoal == Goal.BREWING_POISON_WITCH 
						|| user.currGoal == Goal.BREWING_POISON_CELLAR 
						|| user.currGoal == Goal.BREWING_POISON_APOTH) {
					if (user.Inventory.contains(item.HEMLOCK) || user.Inventory.contains(item.NIGHTSHADE)) {
				
						System.out.print("1) Poison: 6 turns");	
					Fact inputfact = new Fact(factcounter);
					factcounter++;
					inputfact.instigator = user;
					inputfact.Room = user.currroom;
					inputfact.time=TheTime; 
					inputfact.theevent="brewing";
					inputfact.incriminating=true;
					user.currroom.clues.add(inputfact);
					user.busynum = 6;
					
					}
					else{
						System.out.print("Poison: Requires poisonous plants");
					
					}
					if (userChoice==2 || user.currGoal == Goal.BREWING_ANTIDOTE_APOTH || 
						user.currGoal == Goal.BREWING_ANTIDOTE_WITCH || user.currGoal == Goal.BREWING_ANTIDOTE_CELLAR) {
						if(user.Inventory.contains(item.MEDICINAL_PLANT)) {
							System.out.print("2) Antidote: 4 turns");
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="brewing";
							inputfact.incriminating=false;
							user.currroom.clues.add(inputfact);
							user.busynum = 4;

						}
						else{
							System.out.print("Antidote: Requires medicinal Plants");
						}
					}
					if (userChoice==3 || user.currGoal == Goal.BREWING_PERFUME_CELLAR || user.currGoal == Goal.BREWING_PERFUME_APOTH || user.currGoal ==Goal.BREWING_PERFUME_WITCH) {
						if(user.Inventory.contains(item.FRAGRANT_PLANT)){
							System.out.print("3) Perfume: 2 turns");
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="brewing";
							inputfact.incriminating=false;
							user.currroom.clues.add(inputfact);
							user.busynum = 2;
						}
						System.out.print("3) Perfume: 2 turns");

					}
					else{
						System.out.print("Perfume: Requires Fragrant Plants");
					}
				}
			}
				return true;
			}
				
			
				
			//knife set, has four knives, each PLAYER can only take one. knife1 goes to killer, then we have knife2,3,4 available for the game
			public void
			Knifeset(Partygoer user) {
				if(user.isPlayer) {
					System.out.print("Choose an option\n");
					System.out.print("1) Grab Knife: 1 turns\n");
					System.out.print("2) Don't grab knife\n");
					userChoice = in.nextInt();
					System.out.println("You entered " + userChoice + "\n");
				}
					if (userChoice == 1 || user.currGoal == Goal.GET_KNIFE) {
						Fact inputfact = new Fact(factcounter);
						factcounter++;
						inputfact.instigator = user;
						inputfact.Room = user.currroom;
						inputfact.time=TheTime; 
						inputfact.theevent="knife";
						inputfact.incriminating=false;
						user.currroom.clues.add(inputfact);
					}
					else {
						System.out.print("Knife: Did not grab knife");
					}
			}
			//NOTE: DO NOT ADD A CHECK FOR LOCATION
			//STICK EVERYTHING IN CONVOS INTO HOUSE
			//copy and paste this to house and change variables to match house
			
			//drinking, should give strength and charisma but reduce dexterity. For now just a boolean check, no effect on player
			//eating, in dining hall, should change hungry from no to yes
				public void eat(Partygoer user) {
					if (user.isPlayer){
						System.out.print("Choose an option");
						if (user.currroom == Kitchen || user.currroom == WineCellar) System.out.print("1) Drink: 1 turns");
						if (user.currroom == DiningHall) System.out.print("2) Eat: 2 turns");
						userChoice = in.nextInt();
						System.out.println("You entered " + userChoice);
					}
						if (userChoice == 1 || user.currGoal == Goal.DRINKING) {
								Fact inputfact = new Fact(factcounter);
								factcounter++;
								inputfact.instigator = user;
								inputfact.Room = user.currroom;
								inputfact.time=TheTime; 
								inputfact.theevent="drinking";
								inputfact.incriminating=false;
								if (chandelierLoose) {
									user.Dead = true;
									if (user.isPlayer) {System.out.print("A deep creak, a sudden snap, an earth-shaking shatter, and you were dead.");}
									inputfact.theevent = "chandelier smash";
								}
								else if (KitchenWinePoison) {
								user.Dead = true;
								if (user.isPlayer) {System.out.print("With a bloodcurdling wheeze, and a twist of your insides, you collapse, dead...");}
								inputfact.victims.add(user);
								inputfact.theevent = "poisoned wine";
								user.currroom.clues.add(inputfact);
								}
								
							}
						if (userChoice == 2 || user.currGoal == Goal.EATING) {
							if (user.isPlayer) {System.out.print("2) Eat: 2 turns");}
								Fact inputfact = new Fact(factcounter);
								factcounter++;
								inputfact.instigator = user;
								inputfact.Room = user.currroom;
								inputfact.time=TheTime; 
								inputfact.theevent="eating";
								inputfact.incriminating=false;
								if (foodPoisoned) {
									user.Dead = true;
									inputfact.victims.add(user);
									if (user.isPlayer) {System.out.print("With a disgusting cough, and a filling of your lungs, you collapse, dead.");}
									inputfact.theevent = "poisoned food";
									user.currroom.clues.add(inputfact);
								}
				
							}
						}
				
			//for drinking and eating give them a message that tells the user maybe you shouldn't eat or drink so much, there's a killer on the loose
			//workbench, in workshop, where you can build a pistol should take a lot of turns and will be suspicious
			public Boolean workbench(Partygoer user) {
				if (user.isPlayer){
					System.out.print("Choose an option");
					System.out.print("1) Build Pistol: 5 turns");
					if (user.Inventory.contains(item.BROKEN_KEY)) {System.out.print("2. Fix Key: 3 turns.");}
					userChoice = in.nextInt();
					System.out.println("You entered " + userChoice);
				}
					if (userChoice == 1 || user.currGoal == Goal.ASSAULT) {
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="pistol";
							inputfact.incriminating=true;
							user.currroom.clues.add(inputfact);
						}
						else if(user.currGoal == Goal.CRAFTING_PISTOL) {
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="pistol";
							inputfact.incriminating=false;
							user.currroom.clues.add(inputfact);
							user.busynum = 5;
						}
						else if (userChoice == 2 || user.currGoal == Goal.FIX_KEY){
							fix_key(user);
						}
					return true;
				}


			//in workshop, broken_key you can fix to get to the armory, get in the gun case and get the rifle
			public Boolean fix_key(Partygoer user) {
						if (user.Inventory.contains(item.BROKEN_KEY)) {
							System.out.print("1) Fix Key: 1 turns");
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="fixed the key";
							inputfact.incriminating=false;
							user.currroom.clues.add(inputfact);
							user.Inventory.remove(item.BROKEN_KEY);
							user.addItem(item.FIXED_KEY, user.Inventory);
						}
						else{
							if (user.isPlayer) {System.out.print("Fix Key: Did not fix key");};
						}
						return true;
					}

			//riflecase, checks if you have a fixed_key then you can get the rifle
			public Boolean riflecase(Partygoer user) {
				if (user.isPlayer) {
					System.out.print("Choose an option");
					System.out.print("1) Open Riflecase: 1 turns");
					userChoice = in.nextInt();
					System.out.println("You entered " + userChoice);
					if (userChoice == 1 || user.currGoal == Goal.GET_RIFLE) {
						if (user.Inventory.contains(item.FIXED_KEY)) {
							System.out.print("1) Open Riflecase: 1 turns");
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="rifle";
							inputfact.incriminating=false;
							user.currroom.clues.add(inputfact);
							user.addItem(item.RIFLE, user.Inventory);
						}
						else{
							System.out.print("Open Riflecase: Did not open riflecase");
						}
					}
				}
				return true;
			}
			//conversation interactions between partygoers, will be in partygoer.java, like pushing someone off a cliff when you click them
			//Chandelier in dining hall, you can loosen, with either a wrench or a screwdriver(not both)
			public void chandelier(Partygoer user) {
				if (user.isPlayer) {
					System.out.print("Choose an option");
					System.out.print("1) Loosen Chandelier: 1 turns");
					userChoice = in.nextInt();
					System.out.println("You entered " + userChoice);
					if (userChoice == 1) {
						if (user.Inventory.contains(item.WRENCH)) {
							System.out.print("1) Loosen Chandelier: 1 turns");
							Fact inputfact = new Fact(factcounter);
							factcounter++;
							inputfact.instigator = user;
							inputfact.Room = user.currroom;
							inputfact.time=TheTime; 
							inputfact.theevent="chandelier";
							inputfact.incriminating=true;
							user.currroom.clues.add(inputfact);
						}
						else{
							System.out.print("Loosen Chandelier: Did not loosen chandelier");
						}
					}
				}
			}

			public Boolean poisoning(Partygoer user) {
				if (user.Inventory.contains(item.POISON) && user.currGoal == Goal.POISON_FOOD && user.currroom == Kitchen) {
					if (user.isPlayer) {
						System.out.print("1. Poison the food?");
						System.out.print("2. Poison the wine?");
						userChoice = in.nextInt();
						factcounter++;
						Fact poisonFact = new Fact(factcounter);
						poisonFact.instigator = user;
						if (userChoice == 1) {
							foodPoisoned = true;
							
						}
						if (userChoice == 2) {
							KitchenWinePoison = true;
						}
					}
					if(userChoice == 1 || user.currGoal == Goal.POISON_FOOD) {
						foodPoisoned = true;
					}
				}
				return true;
			}
}
