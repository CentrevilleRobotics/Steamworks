package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.Shoot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/* CREATING BUTTONS
	 One type of button is a joystick button which is any button on a
	 joystick.
	 You create one by telling it which joystick it's on and which button
	 number it is.
	 Joystick stick = new Joystick(port);
	   Button button = new JoystickButton(stick, buttonNumber); */
	Joystick leftStick;
	Joystick rightStick;
	Button QuickSandIncrease;
	Button QuickSandDecrease;
	Button shooter;
	Button ShootingQuickSandDecrease;
	Button ShootingQuickSandIncrease;
	

	 /*There are a few additional built in buttons you can use. Additionally,
	 by subclassing Button you can create custom triggers and bind those to
	 commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	*/
	public void init(){
		leftStick = new Joystick(RobotMap.leftStick);
		rightStick = new Joystick(RobotMap.rightStick);
		
		QuickSandDecrease = new JoystickButton(leftStick,8);
		QuickSandIncrease = new JoystickButton(leftStick,9);
		
		shooter = new JoystickButton(rightStick,3);
		ShootingQuickSandDecrease = new JoystickButton(rightStick,4);
		ShootingQuickSandIncrease = new JoystickButton(rightStick,5);		
		
		shooter.whileHeld(new Shoot(1.0));
	}
	public Joystick getLeftStick(){
		return leftStick;
	}
	public Joystick getRightStick(){
		return rightStick;
	}
}
