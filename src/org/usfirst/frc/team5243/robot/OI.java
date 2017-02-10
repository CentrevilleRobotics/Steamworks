package org.usfirst.frc.team5243.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick leftStick;
	private Joystick rightStick;
	
	public void init() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
	}
    
    public Joystick getLeftStick() {
    	return leftStick;
    }
    
    public Joystick getRightStick() {
    	return rightStick;
    }
}

