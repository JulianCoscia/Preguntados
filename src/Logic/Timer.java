package Logic;

public class Timer extends Thread{
	private static final int STEP = 1000;
	private int secondsPerQuestion;
	private int secondsRemaining;
	private boolean paused;
	private Game myGame;
	
	public Timer(int secondsPerQuestion, Game game) {
		this.secondsPerQuestion = secondsPerQuestion;
		paused = true;
		myGame = game;
	}

	//____________________ Methods ____________________
	/**
	 * Resets the timer to the default time established.
	 */
	public void resetTimer() {
		secondsRemaining = secondsPerQuestion;
		paused = true;
	}
	
	/**
	 * Stops the timer.
	 */
	public void pauseTimer() {
		paused = true;
	}
	
	/**
	 * Starts the timer.
	 */
	public void startTimer() {
		paused = false;
		
	 if (!this.isAlive()) {
            this.start();
        }
	}
	
	/**
	 * @return the seconds remaining.
	 */
	public int getRemainingSeconds() {
		return secondsRemaining;
	}
	
	public void run() {
		while(!paused && secondsRemaining > 0) {
			try {
				Thread.sleep(STEP);
				secondsRemaining--;
				myGame.aSecondPassed(secondsRemaining);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
