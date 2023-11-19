package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot woody = new Robot(350, 300);
		Robot buzz = new Robot(500, 550);
		Robot jessie = new Robot(650, 300);
		Robot hamm = new Robot(800, 550);
		Robot boPeep = new Robot(950, 300);

		woody.setPenColor(Color.BLUE);
		buzz.setPenColor(Color.YELLOW);
		jessie.setPenColor(Color.BLACK);
		hamm.setPenColor(Color.GREEN);
		boPeep.setPenColor(Color.RED);

		woody.setSpeed(200);
		buzz.setSpeed(200);
		jessie.setSpeed(200);
		hamm.setSpeed(200);
		boPeep.setSpeed(200);

		woody.setPenWidth(5);
		buzz.setPenWidth(5);
		jessie.setPenWidth(5);
		hamm.setPenWidth(5);
		boPeep.setPenWidth(5);

		woody.penDown();
		buzz.penDown();
		jessie.penDown();
		hamm.penDown();
		boPeep.penDown();

		Thread r1 = new Thread(() -> circle(woody));
		Thread r2 = new Thread(() -> circle(buzz));
		Thread r3 = new Thread(() -> circle(jessie));
		Thread r4 = new Thread(() -> circle(hamm));
		Thread r5 = new Thread(() -> circle(boPeep));

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}

	public static void circle(Robot r) {
		for (int i = 0; i < 360; i++) {
			r.move(3);
			r.turn(1);
		}
	}
}
