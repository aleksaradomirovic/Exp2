

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	int day;
	Sim game;
	JButton events, nextTurn;
	ArrayList<Character> players;
	ArrayList<String> event;
	Events eventList;
	public GamePanel(Sim s, ArrayList<Character> p) {
		game = s;
		players = p;
		events = new JButton("Show Events");
		nextTurn = new JButton("Next Turn");
		event = new ArrayList<String>();
		eventList = new Events();
		setup();
	}
	
	void setup() {
		this.add(events);
		this.add(nextTurn);
		events.addActionListener(new showEventHandler());
		nextTurn.addActionListener(new nextTurnHandler());
	}
	
	public void updatePlayers(ArrayList<Character> p) {
		players = p;
	}
	
	void nextTurn() {
		event.clear();
		event.add("Day "+day+" Events:");
		event.add("");
		int ev = new Random().nextInt(players.size()*5)+players.size();
		for(int i = 0; i < ev; i++) {
			event(players.get(new Random().nextInt(players.size())));
		}
		day++;
		showEvents();
	}
	
	void showEvents() {
		JOptionPane.showMessageDialog(null, String.join("\n", event));
	}
	
	void event(Character c) {
		event.add(c.name+" "+eventList.events[new Random().nextInt(eventList.events.length)]);
	}
	
	class nextTurnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			nextTurn();
			System.out.println("New Day: "+day);
		}
	}
	class showEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			showEvents();
		}
	}
}
