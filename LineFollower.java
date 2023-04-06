package data;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lejos.hardware.Button;

public class LineFollower extends Thread {
	DataExchange DEObj;
	private EV3LargeRegulatedMotor motorA;
	private EV3LargeRegulatedMotor motorB;
	//Calling lego robot motors
	public LineFollower(DataExchange DE) {
		DEObj = DE;
		motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	}
	//Starting a program when press any button on a robot
	public void run() {
		System.out.println("Press any button to start");
		Button.waitForAnyPress();
		Delay.msDelay(500);

		while (!Button.ESCAPE.isDown()) {
		
			if (DEObj.getCMD() == 0) {

				if (DEObj.getLIS() == 1) {
					motorB.setSpeed(200);
					motorB.forward();
					motorA.setSpeed(60);
					motorA.forward();
				}

				if (DEObj.getLIS() == 2) {
					motorA.forward();
					motorA.setSpeed(200);
					motorB.forward();
					motorB.setSpeed(60);
				}
			}
			//Motor code
			if (DEObj.getCMD() == 1 && DEObj.getLIS() ==1) {
				DEObj.setCMD(0);
			}
			if (DEObj.getCMD() == 1) {
				motorB.forward();
				motorA.backward();
				Delay.msDelay(500);
				motorA.setSpeed(220);
				motorB.setSpeed(220);
				motorA.forward();
				motorB.forward();
				Delay.msDelay(1500);
				motorB.setSpeed(120);
				motorA.setSpeed(250);
				motorB.forward();
				motorA.forward();
				Delay.msDelay(2500);
				motorB.setSpeed(200);
				motorA.setSpeed(60);
				motorB.forward();
				motorA.forward();
				Delay.msDelay(400);
				DEObj.setCMD(0);
				DEObj.setLIV(2);
			}
			//Dodging obstacle when sees it
			if (DEObj.getCMD() == 3) {
				motorB.stop();
				motorA.stop();
				motorB.setSpeed(400);
				motorA.setSpeed(400);
				motorB.forward();
				motorA.backward();
				Delay.msDelay(2000);
				motorB.stop();
				motorA.stop();
				DEObj.setCMD(5);
			}

		}

	}
}
