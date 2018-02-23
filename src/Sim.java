

import javax.swing.JFrame;

public class Sim {
	JFrame frame;
	SetupPanel panel;
	GamePanel screen;
	public Sim() {
		frame = new JFrame();
		panel = new SetupPanel(this);
		screen = new GamePanel(this, panel.players);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void setup() {
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	void startGame() {
		frame.remove(panel);
		screen.updatePlayers(panel.players);
		frame.add(screen);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new Sim().setup();
	}
}
