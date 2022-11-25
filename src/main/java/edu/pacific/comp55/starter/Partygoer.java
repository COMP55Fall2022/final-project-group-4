package edu.pacific.comp55.starter;
import java.util.ArrayList;
import java.util.HashSet;


public class Partygoer {
	
	ArrayList<Room> currentRoute;
	Goal currGoal;
	Room currroom;
	house thehouse;
	String identity;
	Boolean isPlayer;
	Boolean isDetective;
	Boolean isKiller;
	ArrayList<Goal> allPossibleGoals;
	ArrayList<item> Inventory; //need to set a cap of 4
	
	public Partygoer(String identity, Boolean isKiller, Boolean isDetective, Room startingRoom, house thehouse) {
		this.identity = identity;
		this.isKiller = isKiller;
		this.isDetective = isDetective;
		this.currroom = startingRoom;
		this.thehouse = thehouse;
	}
	
	public static void placeinRoom(Partygoer p, Room r) {
		p.currroom = r;
		r.occupants.add(p);
	}
	
	//This function calls moveonRoute, which will move the character and return true if there is a current route.
	//If moveonRoute is false, the player AI will instead check the room for their goal.
	public void takeTurn() {
		if (isPlayer == true) {
			this.playerTurn();
		}
		else {
			if (moveOnRoute()) {
				
			}
		}
	}
	
	//This is the function that waits for the player to click on something to do something
	//This will instead just take an integer to choose an action in the text version.
	public void playerTurn() {
		
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
	this.endTurn();
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
		int int1 = 0;
		int int2 = 0;
		for (int i=0; i<currroom.adjacentRooms.size(); i++) {
			if (currroom.adjacentRooms.get(i).getBusStop() != 0) {
				currentRoute.add(currroom.adjacentRooms.get(i));
				int1 = currroom.adjacentRooms.get(i).getBusStop();
				}
		for (int o=0; o<destination.adjacentRooms.size(); o++) {
				if (destination.adjacentRooms.get(o).getBusStop() != 0) {
					int2 = destination.adjacentRooms.get(o).getBusStop();
				}
			}	//Checks the nearest bus stop, and adds the bus route plus the destination to the route.	
		}
		ArrayList<Room> busRoute = thehouse.busRoute(int1, int2);
		for (int p=0; p<busRoute.size(); p++) {
			currentRoute.add(busRoute.get(p));
		}
		currentRoute.add(destination);
	}
}

public Boolean moveOnRoute() {
	if (currentRoute.get(0) != null) {
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
	System.out.println("Show route from dining hall to balcony " + testHouse.allPartygoers.get(0).currentRoute);
	testHouse.allPartygoers.get(0).testMoveOnRoute();
	
}

public void testMoveOnRoute() {
while(this.currentRoute.size() > 0) {
	System.out.print("Should be true: " + (this.moveOnRoute()) + "\n");
	System.out.print("Current Room: " + (currroom.theHouse.RoomtoString(currroom)) + "\n");
	if (this.currentRoute.size() == 0) {
	System.out.print("Current Room: " + (currroom.theHouse.RoomtoString(currroom)) + "\n");
	}
}
}

public boolean checkItem(item inputItem) {
	return Inventory.contains(inputItem);
}

public String getGoal() {
	// TODO Auto-generated method stub
	return null;
}



}

