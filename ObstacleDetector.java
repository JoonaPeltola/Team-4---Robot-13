package data;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread {
	private DataExchange DEObj; 
	private EV3UltrasonicSensor us1;
	
	public ObstacleDetector (DataExchange DE) {
		DEObj = DE;
		us1 = new EV3UltrasonicSensor(SensorPort.S1);
	}
	

	public void run() {
//button
		Button.waitForAnyPress();

		final SampleProvider sp = us1.getDistanceMode();
		int distanceValue = 0;



		while (!Button.ESCAPE.isDown()) {
			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			distanceValue = (int) (sample[0] * 100);

			// System.out.println("Distance: " + distanceValue);


			//if distacnevalue is <16 CMD is set to 1
			if (distanceValue <= 15) {
				DEObj.setCMD(1);


			}
			

			
		//After second time seeing	
			if (distanceValue <=15 && DEObj.getLIV()==2) {
				DEObj.setCMD(3);
			}


		}

	}

}