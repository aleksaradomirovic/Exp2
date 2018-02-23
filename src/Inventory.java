

import java.util.ArrayList;

public class Inventory {
	Character player;
	ArrayList<String> inv = new ArrayList<String>();
	public Inventory(Character c) {
		player = c;
	}
	
	public void addItem(String item) {
		inv.add(item);
	}
	public void removeItem(String item) {
		inv.remove(item);
	}
}
