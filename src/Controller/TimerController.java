package Controller;


import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class TimerController {

    boolean countDown = true;

    private long startTime;

    public TimerController() {
        resetTimer();
    }

    public void resetTimer() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis() - startTime;
    }

    public boolean getCountdown() { return countDown; }

    public void startTimerAnimation(Label timeLabel) {

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (countDown) {

                    if (getCurrentTime() > 3000) {
                        countDown = false;
                        resetTimer();
                    }
                    else if (getCurrentTime() > 2000) {
                        timeLabel.setText("1");
                    }
                    else if (getCurrentTime() > 1000) {
                        timeLabel.setText("2");
                    }
                    else {
                        timeLabel.setText("3");
                    }

                }
                else {

                    long t = getCurrentTime();
                    long milliSecs = t % 1000;
                    long seconds = ((t - milliSecs) / 1000) % 60;
                    long minutes = t / 60000;

                    timeLabel.setText((minutes < 10 ? "0" : "") + Long.toString(minutes) + ":" + (seconds < 10 ? "0" : "") + Long.toString(seconds) + ":" + Long.toString(milliSecs));

                }



            }

        }.start();

    }




}
