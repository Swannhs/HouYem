package com.example.demo;

/**
 * @(#)StopWatch.java
 *
 * StopWatch application
 *
 * This stop watch keeps track of time (up to hours not days) allowing the user
 * to start, stop, pause and resume the watch.
 *
 * This program can be used as the basis for updating a component
 * in a larget program based on elapsed time. i. e. You can replace the label
 * update in the Timer action listener with a different component.
 *
 * The heart of the program is a java Swing widget called Timer.
 * Timer is threaded and works in the background.
 *
 * Threads can be started, stopped and interruped and simulate parallel processing
 * by sharing the CPU with other processes.
 *
 * @author Kenneth L Moore Professor CCAC
 * @version 1.00 2011/5/11
 */

// for windowing
import java.awt.*;

// For the swing Timer
import javax.swing.Timer;

// for the JFrame, JButton, JLable components
import javax.swing.*;

// misc
import java.util.*;

// For the action listeners which allow buttons
// to respond to events.
// And which allows the Timer to communicate
// at a designated time interval.
import java.awt.event.*;

// JFrame gives the program windowing capability.
// ActionListener allows communication through events
public class StopWatch extends JFrame implements ActionListener{

    /*
     * Global variables needed to reference data in multiple
     * parts of the class.
     */

    // The component that shows the elapsed time.
    private JLabel displayTimeLabel;

    // The variables that keep track of start and stopTimerButton
    private long watchStart, watchEnd;

    // The Threaded Swing widget
    private Timer theChronometer;

    // Keeps track of time when pausing the Timer.
    private long pausedTime;

    // Lets the program know if starting or resuming
    private boolean paused = false;

    // Button that changes from "Start" to "Resume" depending on pause status.
    private JButton activateTimerButton;

    // run the program
    public static void main(String[] args) {

        // instantiate (create an instance in memory) a stop watch
        StopWatch s = new StopWatch();

        // by default frames are not visible
        s.setVisible(true);

        // center in window
        s.setLocationRelativeTo(null);
    }

    // default constructor, easily identified as such because it has no return type
    // and no parameters.
    public StopWatch(){

        // initialize
        super();
        setSize(400,150);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Stop Watch: Professor Kenneth Moore CCAC");

        // layout a display with a label at the top to display elapsed time
        // and a row of buttons to control the timer

        // define some fonts
        Font largeFontBOLD = new Font("Calibri", Font.BOLD,20);
        Font largeFontPLAIN = new Font("Calibri", Font.PLAIN,20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));

        activateTimerButton = new JButton("Start");// will display resume when the watch is paused
        JButton stopTimerButton = new JButton("Stop");
        JButton pauseTimerButton = new JButton("Pause");

        // register buttons to generate events when clicked
        activateTimerButton.addActionListener(this);
        stopTimerButton.addActionListener(this);
        pauseTimerButton.addActionListener(this);

        // the display for elapsed time
        displayTimeLabel = new JLabel("Stop Watch Application");
        displayTimeLabel.setHorizontalAlignment(JLabel.CENTER);

        // use a large font
        displayTimeLabel.setFont(largeFontPLAIN);
        activateTimerButton.setFont(largeFontBOLD);
        stopTimerButton.setFont(largeFontBOLD);
        pauseTimerButton.setFont(largeFontBOLD);

        //The JLabel background is transparent by default,
        //so changing the background color doesn't anything.
        //Set to Opaque to make visible
        displayTimeLabel.setOpaque(true);

        // The default colors available are often too "loud".
        // For example Color.yellow is very bright but my gold is more subtle.
        // by controling the Red, Blue and Green intensity
        // you can make up to 256 cubed or 16,777,216 custom colors.
        displayTimeLabel.setBackground(new Color(255,204,51));// gold
        displayTimeLabel.setForeground(new Color(153,0,0));// burgundy
        stopTimerButton.setBackground(new Color(0,150,0));// dark green
        stopTimerButton.setForeground(new Color(255,204,51));
        activateTimerButton.setBackground(new Color(0,150,0));
        activateTimerButton.setForeground(new Color(255,204,51));
        pauseTimerButton.setBackground(new Color(0,150,0));
        pauseTimerButton.setForeground(new Color(255,204,51));

        // add the components to the layout
        buttonPanel.add(activateTimerButton);
        buttonPanel.add(stopTimerButton);
        buttonPanel.add(pauseTimerButton);
        add(displayTimeLabel);
        add(buttonPanel);

        /*
         * The following code instantiates (creates an instance in memory) a Swing timer.
         *
         * If you have never seen code like this, it looks odd at first.
         *
         * What is being done is:
         *
         *   theChronometer = new Timer(1000, someActionListener);
         *
         *   where 1000 is a delay of 1000 miliseconds or 1 second and insead of
         *   defining someActionListener (which will get an event every second) in
         *   a separate part of the code, we define it inline.
         *
         */
        theChronometer =
                new Timer(1000,new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int seconds = (int)(System.currentTimeMillis()-watchStart)/1000;
                        int days = seconds / 86400;
                        int hours = (seconds / 3600) - (days * 24);
                        int min = (seconds / 60) - (days * 1440) - (hours * 60);
                        int sec = seconds % 60;
                        String s = new String(""+hours+" hours "+min+ " min "+sec+" sec");
                        displayTimeLabel.setText(s);
                    }
                });
    }


    // action performed for the button events
    public void actionPerformed(ActionEvent e){

        // invoke the Timer Thread stop command
        if(e.getActionCommand().equals("Stop")){theChronometer.stop();}

        // either start the Timer Thread at zero or pick up where paused.
        else if(e.getActionCommand().equals("Start") || e.getActionCommand().equals("Resume")){
            if(!paused){
                watchStart = System.currentTimeMillis();
                theChronometer.start();
            }
            else{
                watchStart = System.currentTimeMillis()+pausedTime;
                pausedTime = 0;
                theChronometer.start();
                paused = false;

                // set the button display to Start, it may have been Resume
                activateTimerButton.setText("Start");
            }
        }

        // there is no pause for Timer so we kludge one
        else if(e.getActionCommand().equals("Pause")){
            long now = System.currentTimeMillis();
            pausedTime -= (now - watchStart);
            theChronometer.stop();
            paused = true;

            // set the button display to Resume instead of Start
            activateTimerButton.setText("Resume");
        }
    }
}
