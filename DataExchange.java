package data;

public class DataExchange {
	
	private boolean obstacleDetected = false;
	
	private int CMD = 0;
	private int LIV = 1;
	private int LIS = 0;

//Code that exchanges data between threads
public DataExchange(){
}
	public void setObstacleDetected(boolean status) {
		obstacleDetected = status;
	}
	
	public boolean getObstacleDetected() {
		return this.obstacleDetected;
		
	}
	public void setLIS (int command) {
		LIS = command;
	}
	public int getLIS() {
		return LIS;
	}
	
	public void setLIV (int command) {
		LIV = command;
	}
	public int getLIV() {
		return LIV;
	}
	
	public void setCMD(int command) {
		CMD = command;
	}
	
	public int getCMD() {
		return CMD;
	}
}
