package edu.pacific.comp55.starter;
import java.util.*;
import acm.graphics.GImage;

public class Room {
//Instance variables
HashSet<Room> adjacentRooms;
//The bus stops are 1-5. If the room is not a bus stop, this is 0.
//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
int BusStop;

item[] looseStuff;

HashSet<Partygoer> occupants;
public int getBusStop() {
	return BusStop;
}
}



