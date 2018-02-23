

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SetupPanel extends JPanel {
	JButton addChar, play;
	JLabel names;
	Sim s;
	int status;
	static final int STATUS_SETUP = 0, STATUS_GAME = 1;
	ArrayList<Character> players = new ArrayList<Character>();
	ArrayList<String> playerNames = new ArrayList<String>();
	public SetupPanel(Sim s) {
		addChar = new JButton("Add new character");
		play = new JButton("Play");
		names = new JLabel();
		this.s = s;
		setup();
	}
	
	void setup() {
		status = STATUS_SETUP;
		this.add(names);
		this.add(addChar);
		this.add(play);
		addChar.addActionListener(new addNameHandler());
		play.addActionListener(new playHandler());
	}
	
	void updateSetup() {
		playerNames.clear();
		for(int i = 0; i < players.size(); i++) {
			playerNames.add(players.get(i).name);
		}
		names.setText(String.join(", ", playerNames));
		s.frame.pack();
	}
	
	class addNameHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			players.add(new Character(JOptionPane.showInputDialog("Input New Character Name: ")));
			updateSetup();
		}
	}
	class playHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(players.size() > 1) {
				status = STATUS_GAME;
				s.startGame();
			} else {
				JOptionPane.showMessageDialog(null, "You don't have enough players.");
			}
		}
	}
}
