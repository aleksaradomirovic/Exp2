

public class Character {
	String name;
	Inventory inv;
	public Character(String name) {
		this.name = name;
		inv = new Inventory(this);
	}
	
	void update() {
		
	}
}
