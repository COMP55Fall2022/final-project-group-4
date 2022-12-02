package edu.pacific.comp55.starter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class Partygoer {
	
	ArrayList<Room> currentRoute;
	Goal currGoal;
	int busynum;
	int aggronum;
	Room currroom;
	house thehouse;
	String identity;
	Boolean isPlayer;
	Boolean isDetective;
	Boolean isKiller;
	Boolean Bloodied;
	Boolean Dead;
	Scanner userinput;
	GoalSets newGoalSets;
	Random rando;
	ArrayList<Goal> allPossibleGoals;
	ArrayList<item> Inventory; //need to set a cap of 4
	//BusyCounter
	
	
	public Partygoer(String identity, Boolean isKiller, Boolean isDetective, Room startingRoom, house thehouse) {
		this.identity = identity;
		this.isKiller = isKiller;
		this.isDetective = isDetective;
		this.currroom = startingRoom;
		this.thehouse = thehouse;
		for (int i=0; i<4; i++) {
		this.Inventory.add(null);
		}
	}
	
	public static void placeinRoom(Partygoer p, Room r) {
		p.currroom = r;
		r.occupants.add(p);
	}
	
	public void addItem(item addeditem, ArrayList<item> source) {
				if ((source == this.Inventory && source.size() < 4) || (source == this.currroom.looseStuff && this.currroom.looseStuff.size() < 5)) {
				source.add(addeditem);
				}
			else {
				discardItem(addeditem, source);
			}
		}
	
	public void discardItem(item inputitem, ArrayList<item> source) {
		if (isPlayer == true && source != currroom.looseStuff) {
			System.out.print("Choose Item to discard \n");
			System.out.print("1. " + source.get(0).toString());
			System.out.print("2. " + source.get(1).toString());
			System.out.print("3. " + source.get(2).toString());
			System.out.print("4. " + source.get(3).toString());
			System.out.print("5. " + "Keep your items, drop " + inputitem.toString() + " instead");
			String response = userinput.nextLine();
			if (response == "1") {
				source.remove(source.get(0));
				source.add(inputitem);
				addItem(inputitem, currroom.looseStuff);
			}
			else if (response == "2") {
				source.remove(source.get(1));
			}
			else if (response == "3") {
				source.remove(source.get(2));
			}
			else if (response == "4") {
				source.remove(source.get(3));
			}
			else if (response == "5") {
			addItem(inputitem, currroom.looseStuff);
			}
			else {
				discardItem(inputitem, source);
			}
		}
			else {
				source.remove(rando.nextInt(source.size()));
				source.add(inputitem);
				}
		}
	
	//This function calls moveonRoute, which will move the character and return true if there is a current route.
	//If moveonRoute is false, the player AI will instead check the room for their goal.
	public void takeTurn() {
		if (isPlayer == true) {
			this.playerTurn();
		}
		else {
			if (currGoal == null) {
				pickGoal();
			}
			if (doGoal()) {
				endTurn();
				return;
			}
			if(currentRoute.size() == 0) {
			Route(GoalInterpLocation(currGoal));
			}
			moveOnRoute(GoalInterpLocation(currGoal));
			endTurn();
			return;
		}
	}
	
	public Boolean doGoal() {
		if (currGoal == Goal.BREWING_ANTIDOTE_APOTH || currGoal == Goal.BREWING_ANTIDOTE_CELLAR || 
				currGoal == Goal.BREWING_ANTIDOTE_WITCH || currGoal == Goal.BREWING_KO_APOTH || 
				currGoal == Goal.BREWING_KO_CELLAR || currGoal == Goal.BREWING_KO_WITCH || 
				currGoal == Goal.BREWING_PERFUME_APOTH || 
				currGoal == Goal.BREWING_PERFUME_CELLAR || currGoal == Goal.BREWING_PERFUME_WITCH || 
				currGoal == Goal.BREWING_POISON_APOTH || currGoal == Goal.BREWING_POISON_CELLAR || 
				currGoal == Goal.BREWING_POISON_WITCH) {
			if (currroom == thehouse.WineCellar || currroom == thehouse.Apothecary || currroom == thehouse.Outdoors_1) {
				busynum = this.thehouse.Brewing(this);
				return true;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.GET_FRAGRANT_PLANT_GREENHOUSE || currGoal == Goal.GET_NOXIOUS_PLANT_GREENHOUSE || currGoal == Goal.GET_POISONOUS_PLANT_GREENHOUSE || currGoal == Goal.GET_MEDICINAL_PLANT_GREENHOUSE) {
			if (currroom == thehouse.GreenHouse) {
				busynum = thehouse.getPlant(this);
				return true;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.DRINKING_CELLAR || currGoal == Goal.DRINKING_HALL || currGoal == Goal.DRINKING_KITCHEN) {
			if (currroom == thehouse.WineCellar || currroom == thehouse.Kitchen || currroom == thehouse.DiningHall) {
			thehouse.Drinking(this);
			return true;
			}
			else {
			return false;
			}
		}
		else if (currGoal == Goal.CRAFTING_BOMB || currGoal == Goal.CRAFTING_LOCKPICK || currGoal == Goal.CRAFTING_LOCKPICK) {
			if (currroom == thehouse.Workshop) {
			thehouse.Crafting(this);
				}
			else {
				return false;
				}
			}
		else if (currGoal == Goal.RANSACK) {
			addItem(Ransack(), Inventory);
			return true;
		}
		else if (currGoal == Goal.EATING) {
			if (currroom == thehouse.DiningHall) {
			thehouse.eat(this);
			return true;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.OOHSHINY) {
		if (currroom.looseStuff.isEmpty()) {
			return false;
		}
		else {
			Inventory.add(currroom.looseStuff.get(rando.nextInt(currroom.looseStuff.size())));
			return true;
		}
		}
		else if (currGoal == Goal.POISON_FOOD) {
			if (Inventory.contains(item.TREE_FROG_VENOM) || Inventory.contains(item.POISON)) {
				if (currroom == thehouse.Kitchen) {
					thehouse.poisonFood();
					return true;
				}
				else {
					return false;
				}
			}
				else {
					int check = rando.nextInt(2);
					if (check == 0) {
					currGoal = Goal.GET_POISONOUS_PLANT_GREENHOUSE;
					}
					if (check == 1) {
					currGoal = Goal.GET_POISONOUS_PLANT_OUTDOORS;
					}
					return doGoal();
				}
		}
			else if (currGoal == Goal.ASSAULT) {
				aggronum = 5;
			}
		}
		
		public void onTheHunt() {
			if(currroom.occupants.size() == 2) {
				Partygoer target;
				if (currroom.occupants.get(0) == this) {
					assault(this, currroom.occupants.get(1));
				}
				else {
					assault(this, currroom.occupants.get(0));
				}
				aggronum = 0;
				currGoal = Goal.CLEANUP;
			}
			else {
				aggronum--;
			}
		}

		public void assault(Partygoer attacker, Partygoer defender) {
			int attackerstr = 0;
			int defenderstr = 0;
			if (attacker.Inventory.contains(item.RIFLE)) {
				attackerstr = 4;
			}
			else if (attacker.Inventory.contains(item.PISTOL)) {
				attackerstr = 3;
			}
			else if (attacker.Inventory.contains(item.SWORD) ) {
				attackerstr = 2;
			}
			else if (attacker.Inventory.contains(item.KNIFE1) || attacker.Inventory.contains(item.KNIFE2) || attacker.Inventory.contains(item.KNIFE3) || attacker.Inventory.contains(item.KNIFE4)) {
			attackerstr = 1;	
			}
			if (attacker.isKiller && attackerstr == 1) {
				attackerstr = 2;
			}
			if (defender.Inventory.contains(item.RIFLE)) {
				defenderstr = 4;
			}
			else if (defender.Inventory.contains(item.PISTOL)) {
				defenderstr = 3;
			}
			else if (defender.Inventory.contains(item.SWORD) ) {
				defenderstr = 2;
			}
			else if (defender.Inventory.contains(item.KNIFE1) || defender.Inventory.contains(item.KNIFE2) || defender.Inventory.contains(item.KNIFE3) || defender.Inventory.contains(item.KNIFE4)) {
			defenderstr = 1;	
			}
			if (defender.isKiller && defenderstr == 1) {
				defenderstr = 2;
			}
			
			if (defenderstr > attackerstr) {
				attacker.Dead = true;
				defender.Bloodied = true;
				defender.currGoal = Goal.CLEANUP;
				Fact newFact = new Fact(thehouse.factcounter);
				thehouse.factcounter++;
				newFact.setInstigator(defender);
				newFact.setTheEvent("murder");
				newFact.motive = Goal.DEFENSIVE_KILL;
				newFact.victims.add(attacker);
				newFact.thetime = thehouse.getTime();
				newFact.incriminating = false;
				newFact.Room = currroom;
			}
			else if (defenderstr <= attackerstr) {
				defender.Dead = true;
				attacker.Bloodied = true;
				attacker.currGoal = Goal.CLEANUP;
				Fact newFact = new Fact(thehouse.factcounter);
				thehouse.factcounter++;
				newFact.setInstigator(attacker);
				newFact.setTheEvent("murder");
				newFact.motive = Goal.DEFENSIVE_KILL;
				newFact.victims.add(defender);
				newFact.thetime = thehouse.getTime();
				newFact.incriminating = false;
				newFact.Room = currroom;
			}
		}
		
		
		public item Ransack() {
			busynum = 3;
			int check = rando.nextInt(4);
			if (currroom == thehouse.DiningHall) {
				if (check == 0) {
					return item.BRIMSTONE;
				}
				if (check == 1) {
					return item.BISMUTH;
				}
				if (check == 2) {
					return item.BROKEN_KEY;
				}
				if (check == 3) {
					return item.COBWEB;
				}
			}
		else if (currroom == thehouse.Balcony) {
				if (check == 0) {
					return item.HEMLOCK;
				}
				if (check == 1) {
					return item.MONEY;
				}
				if (check == 2) {
				return item.JADE_STONE;
				}
				if (check == 3) {
				return item.SPIDER;
				}
			}
		else if (currroom == thehouse.Apothecary) {
			if (check == 0) {
				return item.ANTIDOTE;
			}
			if (check == 1) {
				return item.BANDAGE;
			}
			if (check == 2) {
			return item.SEDATIVES;
			}
			if (check == 3) {
			return item.CHLOROFORM;
			}
		}
			else if (currroom == thehouse.TheStudy) {
				if (check == 0) {
					return item.RITES_OF_THE_HORSEMAN;
				}
				if (check == 1) {
					return item.FAE_JOKE_BOOK;
				}
				if (check == 2) {
				return item.THE_7_RITES_OF_RUIN;
				}
				if (check == 3) {
				return item.FAMILIARS;
				}
			}
				else if (currroom == thehouse.Morgue) {
					if (check == 0) {
						return item.FEMUR;
					}
					if (check == 1) {
						return item.RAT;
					}
					if (check == 2) {
					return item.SKULL;
					}
					if (check == 3) {
					return item.GOAT_HEAD;
					}
				}
			else if (currroom == thehouse.Armory) {
				if (check == 0) {
					return item.TORCH;
				}
				if (check == 1) {
					return item.OLD_PICTURE;
				}
				if (check == 2) {
				return item.DAGGER;
				}
				if (check == 3) {
				return item.SWORD;
				}
			}
				else if (currroom == thehouse.Dungeon) {
					if (check == 0) {
						return item.FEMUR;
					}
					if (check == 1) {
						return item.BISMUTH;
					}
					if (check == 2) {
					return item.RAT;
					}
					if (check == 3) {
					return item.SKULL;
					}
				}
				else if (currroom == thehouse.Workshop) {
					if (check == 0) {
						return item.WRENCH;
					}
					if (check == 1) {
						return item.SCREWDRIVER;
					}
					if (check == 2) {
					return item.BROKEN_KEY;
					}
					if (check == 3) {
					return item.TORCH;
					}
				}
				else if (currroom == thehouse.Bedroom_1 || currroom == thehouse.Bedroom_2 || currroom == thehouse.Bedroom_3 || currroom == thehouse.Bedroom_4 || currroom == thehouse.Bedroom_5 || currroom == thehouse.Bedroom_6 || currroom == thehouse.Bedroom_7 || currroom == thehouse.Bedroom_8 || currroom == thehouse.Bedroom_9 || currroom == thehouse.Bedroom_10) {
						if (check == 0) {
							return item.COBWEB;
						}
						if (check == 1) {
							return item.GOAT_HEAD;
						}
						if (check == 2) {
						return item.DOLL;
						}
						if (check == 3) {
						return item.SPIDER;
						}
				}
				else if (currroom == thehouse.Hallway) {
					if (check == 0) {
						return item.WRENCH;
					}
					if (check == 1) {
						return item.SCREWDRIVER;
					}
					if (check == 2) {
					return item.BROKEN_KEY;
					}
					if (check == 3) {
					return item.TORCH;
					}
				}
					else if (currroom == thehouse.WineCellar) {
						if (check == 0) {
							return item.RAT;
						}
						if (check == 1) {
							return item.OIL;
						}
						if (check == 2) {
						return item.LANTERN;
						}
						if (check == 3) {
						return item.CLOVE_OF_GARLIC;
						}
					}
					else if (currroom == thehouse.Kitchen) {
						if (check == 0) {
							return item.CLOVE_OF_GARLIC;
						}
						if (check == 1) {
							return item.COFFEE;
						}
						if (check == 2) {
						return item.RAT;
						}
						if (check == 3) {
						return item.ROACH;
						}
			}
					else if (currroom == thehouse.GreenHouse) {
						if (check == 0) {
							return item.FRAGRANT_PLANT;
						}
						if (check == 1) {
							return item.NIGHTSHADE;
						}
						if (check == 2) {
						return item.NOXIOUS_PLANT;
						}
						if (check == 3) {
						return item.HEMLOCK;
						}
					}
						else if (currroom == thehouse.Outdoors_1) {
							if (check == 0) {
								return item.EYE_OF_NEWT;
							}
							if (check == 1) {
								return item.DEMON_TOOTH;
							}
							if (check == 2) {
							return item.CLOVE_OF_GARLIC;
							}
							if (check == 3) {
							return item.THE_7_RITES_OF_RUIN;
							}
						}
							else if (currroom == thehouse.Outdoors_2) {
								if (check == 0) {
									return item.ROACH;
								}
								if (check == 1) {
									return item.RAT;
								}
								if (check == 2) {
								return item.SPIDER;
								}
								if (check == 3) {
								return item.FROG;
								}
							}
								else if (currroom == thehouse.Outdoors_3) {
									if (check == 0) {
										return item.JADE_STONE;
									}
									if (check == 1) {
										return item.BISMUTH;
									}
									if (check == 2) {
									return item.BRIMSTONE;
									}
									if (check == 3) {
									return item.COBALT;
									}
								}
								else if (currroom == thehouse.Outdoors_4) {
										if (check == 0) {
											return item.BROKEN_KEY;
										}
										if (check == 1) {
											return item.FAMILIARS;
										}
										if (check == 2) {
										return item.URN;
										}
										if (check == 3) {
										return item.SKULL;
										}
									}
								else if (currroom == thehouse.TheCliff) {
									if (check == 0) {
										return item.THE_DEMONS_LEGEND;
									}
									if (check == 1) {
										return item.SKULL;
									}
									if (check == 2) {
									return item.FEMUR;
									}
									if (check == 3) {
									return item.SENTIMENTAL_PEN;
									}
								}
								
									return item.RAT;
								
					}
		
	
	
	//This is the function that waits for the player to click on something to do something
	//This will instead just take an integer to choose an action in the text version.
	public void playerTurn() {
		Scanner input = new Scanner(System.in);
		ArrayList<Method> methodList = new ArrayList<Method>();
	}
	
	//This function will tell the house to move on to the next character.
	public void endTurn() {
		thehouse.nextPlayer();
	}
	
public static void main(String[] args) {
testMove();
}

	public Boolean isDetective() {
		return isDetective;
	}

	public Boolean isKiller() {
		return isKiller;
	}
	
	public Boolean isPlayer() {
		return isPlayer;
	}

	public String getIdentity() {
		return identity;
	}

	
//Every turn, the partygoer will call moveOnRoute, which will move the character and return true if the route has rooms.
//If moveOnRoute returns false, the ai will call route, which will call move if the character is adjacent.
//If the destination is not adjacent, route will generate a path to the destination, and store it in the ArrayList.
 public void Move(Room destination) {
	currroom.occupants.remove(this);
	this.currroom = destination;
	destination.occupants.add(this);
}

public void Route(Room destination) {
	currentRoute = new ArrayList<Room>(); 
	//Checks to see if they are standing in the room
	if (currroom == destination) {
		System.out.print("Already there!");
		return;
	}
	else if (currroom.adjacentRooms.contains(destination)){
		System.out.print("It's nearby!");
		currentRoute.add(destination);
		return;
		}
	else {
		System.out.print("Need to take the bus...");
		int int1 = thehouse.getBusStop(currroom);
		int int2 = thehouse.getBusStop(destination);
	//Checks the nearest bus stop, and adds the bus route plus the destination to the route.	
		ArrayList<Room> busRoute = thehouse.busRoute(int1, int2);
		for (int p=0; p<busRoute.size(); p++) {
			currentRoute.add(busRoute.get(p));
		}
		if (currentRoute.contains(destination) == false) {
			currentRoute.add(destination);
		}
	}
}

public Boolean moveOnRoute(Room destination) {
	if (currentRoute.get(0) == null) {
		System.out.print("Null destination. Wandering.");
		Move(currroom.adjacentRooms.get(rando.nextInt(currroom.adjacentRooms.size())));
		currentRoute.remove(currentRoute.get(0));
		return true;
	}
	else if (currroom.adjacentRooms.contains(destination)) {
		System.out.print("It's right here!");
		currentRoute.remove(destination);
		Move(destination);
		return true;
	}
	else if (currentRoute.size() != 0) {
	Room daroom = currentRoute.get(0);
	currentRoute.remove(currentRoute.get(0));
	Move(daroom);
	return true;
	}
	else {
		return false;
	}
	
}

public static void testMove() {
	System.out.println("Testing move() function");
	house testHouse = new house();
	testHouse.allPartygoers.get(0);
	testHouse.allPartygoers.get(0).Route(testHouse.Balcony);
	System.out.println("Show route from dining hall to balcony " );
	for (int i=0; i < testHouse.allPartygoers.get(0).currentRoute.size(); i++) {
		System.out.print(testHouse.RoomtoString(testHouse.allPartygoers.get(0).currentRoute.get(i)) + ", ");
	}
	System.out.print("\n");
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.Balcony);
	System.out.print("Now to cliff!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.TheCliff);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.TheCliff);
	System.out.print("Now to dungeon!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.Dungeon);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.Dungeon);
	System.out.print("Now to wine cellar!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.WineCellar);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.WineCellar);
}

public void testMoveOnRoute(Room destination) {
while(this.currentRoute.size() > 0 || currentRoute.get(0) != null || this.currroom != destination) {
	System.out.print("Should be true: " + (this.moveOnRoute(destination)) + "\n");
	System.out.print("Current Room: " + (currroom.theHouse.RoomtoString(currroom)) + "\n");
	if (this.currroom == destination) {
	System.out.print("Ended because we got to the destination!");
	return;
	}
	if (this.currentRoute.size() == 0) {
	System.out.print("Ended because route array has no values.");
	return;
	}
	if (this.currentRoute.get(0) == null) {
	System.out.print("Ended because first value in array is null.");
	this.currentRoute = new ArrayList<Room>();
	}
}
	if (currroom == destination) {
		System.out.print("Made it!");
	}
	else {
		System.out.print("Did not make it.");
	}
}

public boolean checkItem(item inputItem) {
	return Inventory.contains(inputItem);
}

public void pickGoal() {
	// TODO Auto-generated method stub
	allPossibleGoals = new ArrayList<Goal>();
	for (int i=0;i<newGoalSets.innocuous.size();i++) {
		allPossibleGoals.add(newGoalSets.innocuous.get(i));
	}
	for (int a=0;a<newGoalSets.sociable.size();a++) {
		allPossibleGoals.add(newGoalSets.sociable.get(a));
	}
	for (int b=0;b<newGoalSets.drinking.size();b++) {
		allPossibleGoals.add(newGoalSets.drinking.get(b));
	}
	for (int c=0;c<newGoalSets.poisonous.size();c++) {
		allPossibleGoals.add(newGoalSets.poisonous.get(c));
	}
	for (int d=0;d<newGoalSets.gathering.size();d++) {
		allPossibleGoals.add(newGoalSets.gathering.get(d));
	}
	for (int e=0;e<newGoalSets.murderous.size();e++) {
		allPossibleGoals.add(newGoalSets.murderous.get(e));
	}
	for (int f=0;f<newGoalSets.rituals.size();f++) {
		allPossibleGoals.add(newGoalSets.rituals.get(f));
	}
	currGoal = allPossibleGoals.get(rando.nextInt(allPossibleGoals.size()));
}

public Room GoalInterpLocation(Goal goal) {
	currGoal = goal;
	if (goal==Goal.BREWING_POISON_WITCH||goal==Goal.BREWING_ANTIDOTE_WITCH||goal==Goal.BREWING_PERFUME_WITCH||goal==Goal.BREWING_KO_WITCH) {
		return thehouse.Outdoors_1;
	}
	else if (goal==Goal.BREWING_POISON_CELLAR||goal==Goal.BREWING_ANTIDOTE_CELLAR||goal==Goal.BREWING_PERFUME_CELLAR||goal==Goal.BREWING_KO_CELLAR
			||goal==Goal.POISON_WINE_CELLAR||goal==Goal.GATHER_ALCOHOL||goal==Goal.DRINKING_CELLAR) {
		return thehouse.WineCellar;
	}
	else if (goal==Goal.BREWING_POISON_APOTH||goal==Goal.BREWING_ANTIDOTE_APOTH||goal==Goal.BREWING_PERFUME_APOTH||goal==Goal.BREWING_KO_APOTH) {
		return thehouse.Apothecary;
	}
	else if (goal==Goal.CRAFTING_LOCKPICK||goal==Goal.CRAFTING_PISTOL||goal==Goal.CRAFTING_BOMB) {
		return thehouse.Workshop;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_GREENHOUSE||goal==Goal.GET_POISONOUS_PLANT_GREENHOUSE||goal==Goal.GET_NOXIOUS_PLANT_GREENHOUSE) {
		return thehouse.GreenHouse;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_OUTDOORS) {
		return thehouse.Outdoors_2;
	}
	else if (goal==Goal.GET_NOXIOUS_PLANT_OUTDOORS) {
		return thehouse.Outdoors_3;
	}
	else if (goal==Goal.GET_POISONOUS_PLANT_OUTDOORS) {
		return thehouse.Outdoors_4;
	}
	else if (goal==Goal.POISON_WINE_KITCHEN||goal==Goal.DRINKING_KITCHEN||goal==Goal.POISON_FOOD) {
		return thehouse.Kitchen;
	}
	else if (goal==Goal.DRINKING_HALL||goal==Goal.LOOSEN_CHANDELIER) {
		return thehouse.DiningHall;
	}
	else if (goal==Goal.BALCONY_STALKER||goal==Goal.LOOSEN_BALCONY) {
		return thehouse.Balcony;
	}
	else if (goal==Goal.CLIFF_STALKER) {
		return thehouse.TheCliff;
	}
	return null;
}



}

