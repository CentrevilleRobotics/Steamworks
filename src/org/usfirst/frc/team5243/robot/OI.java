package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.LoadFuelCommand;
import org.usfirst.frc.team5243.robot.commands.ShootLeftCommand;
import org.usfirst.frc.team5243.robot.commands.ShootRightCommand;
import org.usfirst.frc.team5243.robot.commands.SwitchDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//CREATING BUTTONS
	//One type of button is a joystick button which is any button on a
	//joystick.
	//You create one by telling it which joystick it's on and which button
	//number it is.
	//Joystick stick = new Joystick(port);
	//Button button = new JoystickButton(stick, buttonNumber); */
	
	//Joysticks
	Joystick leftStick;
	Joystick rightStick;
	
	//Shooter
	Button shooterLeft;
	Button shooterRight;
	Button ShootingQuickSandDecrease;
	Button ShootingQuickSandIncrease;
	
	//SwitchDrive
	Button SwitchDrive;
	
	//TestWheels
	Button testFrontLeft;
	Button testBackLeft;
	Button testFrontRight;
	Button testBackRight;
	
	//LoadFuel
	Button loadFuel;
	
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
		//initializes joysticks
		leftStick = new Joystick(RobotMap.leftStick);
		rightStick = new Joystick(RobotMap.rightStick);
	
		//initializes shooting variables
		shooterRight = new JoystickButton(rightStick,1);
		shooterRight.whileHeld(new ShootRightCommand(.79));
		
		shooterLeft = new JoystickButton(leftStick, 1);
		shooterLeft.whileHeld(new ShootLeftCommand(.79));
		
		//intializes SwitchDrive
		SwitchDrive = new JoystickButton(rightStick, 8);
		SwitchDrive.whenPressed(new SwitchDriveCommand());
		
		//Initializes load variable
		loadFuel = new JoystickButton(rightStick, 7);
		loadFuel.whenPressed(new LoadFuelCommand());
	}	
	
	//Getters for Joysticks
	public Joystick getLeftStick(){
		return leftStick;
	}
	public Joystick getRightStick(){
		return rightStick;
	}
}