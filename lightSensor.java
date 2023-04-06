package data;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.Button;

public class lightSensor extends Thread {
	DataExchange DEObj;
	private EV3ColorSensor lightSensor;
	private SampleProvider sampleProvider;

	public lightSensor(DataExchange DE) {
		DEObj = DE;
		lightSensor = new EV3ColorSensor(SensorPort.S4);
		sampleProvider = lightSensor.getRedMode();
	}

	public void run() {
		Button.waitForAnyPress();
		Delay.msDelay(500);

		while (!Button.ESCAPE.isDown()) {
			float[] sample = new float[sampleProvider.sampleSize()];
			sampleProvider.fetchSample(sample, 0);
			float light = sample[0];
			// Print the light intensity value
//			System.out.println("Light intensity: " + sample[0]);

			if (DEObj.getCMD() == 0) {
				// Example of using the light sensor to detect black
				if (light < 0.06) {
					DEObj.setLIS(1);
				}

				// Example of using the light sensor to detect white
				if (light > 0.13) {
					DEObj.setLIS(2);
				}
			}

			if (DEObj.getCMD() == 1 && light < 0.06) {
				DEObj.setCMD(0);

			}
		}
	}
}
