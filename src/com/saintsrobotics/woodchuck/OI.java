package com.saintsrobotics.woodchuck;

import edu.wpi.first.wpilibj.Joystick;

/** Operator Interface. Gets input from joysticks. */
public class OI {
    
    
    // Xbox Controller
    Joystick driveStick = new Joystick(0);
    
    public enum Axis {
        // XBOX
        LX, LY, RX, RY, LT, RT, TRIGGERS
    }
    
    public enum Button {
        // XBOX
        A, B, X, Y, RB, LB, START, SELECT, R3, L3,
    }
    
    /**
     * Gets the current state of a button.
     * 
     * @param stick The joystick the button is on.
     * @param button The button to get the state of.
     * @return true if the button is down, false if it's up.
     */
    public boolean getButton(Button button) {
        Joystick joystick = getStick(stick);
        return joystick.getButton(button.ordinal());
    }
    
    /**
     * Gets the current value of an axis. Small values
     * are deadzoned to zero.
     * 
     * @param stick The joystick the axis is on.
     * @param axis The axis to get the state of.
     * @return The value of the axis, -1.0 to 1.0.
     */
    public double getAxisValue(Stick stick, Axis axis) {
        double val = getRawAxis(getStick(stick), axis);
        return Math.abs(val) < 0.13 ? 0 : val;
    }
    
    /** Gets a raw non-deadzoned axis value, utility. */
    private double getRawAxis(Axis axis) {
        if(axis == TRIGGERS) 
            return joystick.getRawAxis(3) - joystick.getRawAxis(2);
        return joystick.getRawAxis(axis.ordinal());

    }
}