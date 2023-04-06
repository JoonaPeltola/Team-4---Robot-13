package data;

import lejos.hardware.Button;

public class RunClass {
	private static DataExchange DE;
	private static LineFollower LFObj;
	private static ObstacleDetector ODObj;
	private static lightSensor LSObj;
	


	public static void main(String[] args) {
		
		DE = new DataExchange();
		ODObj = new ObstacleDetector(DE);
		LFObj = new LineFollower(DE);
		LSObj = new lightSensor(DE);

		
		
		LSObj.start();
		ODObj.start();
		LFObj.start();

		

		while(!Button.ESCAPE.isDown()) {
			
		}
		
		System.exit(0);
		
	}
}