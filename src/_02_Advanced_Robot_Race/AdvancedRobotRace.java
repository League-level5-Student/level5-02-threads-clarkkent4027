package _02_Advanced_Robot_Race;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	static boolean b = true;
	static Random Randy = new Random();
	static int winner = 0;
	static Robot[] racers = new Robot[4];

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {

		for (int i = 0; i < racers.length; i++) {
			racers[i] = new Robot();
		}

		racers[0].setSpeed(5);
		racers[1].setSpeed(5);
		racers[2].setSpeed(5);
		racers[3].setSpeed(5);

		racers[0].moveTo(100, 550);
		racers[1].moveTo(350, 550);
		racers[2].moveTo(600, 550);
		racers[3].moveTo(850, 550);

		racers[0].setPenColor(Color.CYAN);
		racers[1].setPenColor(Color.GREEN);
		racers[2].setPenColor(Color.PINK);
		racers[3].setPenColor(Color.BLACK);

		racers[0].penDown();
		racers[1].penDown();
		racers[2].penDown();
		racers[3].penDown();

		Thread r1 = new Thread(() -> wins(racers[0]));
		Thread r2 = new Thread(() -> wins(racers[1]));
		Thread r3 = new Thread(() -> wins(racers[2]));
		Thread r4 = new Thread(() -> wins(racers[3]));

		r1.start();
		r2.start();
		r3.start();
		r4.start();

		while (b == true) {
			for (int i = 0; i < racers.length; i++) {
				if (racers[i].getY() < 50) {
					b = false;
					winner = i + 1;
					JOptionPane.showMessageDialog(null, "YAY!!! Bot " + winner + " won!!!");
					break;
				}
			}
		}
	}

	public static void wins(Robot r) {
		while (r.getY() > 50) {
			r.move(Randy.nextInt(50));
		}
	}

}