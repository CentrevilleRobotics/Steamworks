package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.Lift;
import org.usfirst.frc.team5243.robot.commands.LoadFuel;
import org.usfirst.frc.team5243.robot.commands.ShootLeft;
import org.usfirst.frc.team5243.robot.commands.ShootRight;
import org.usfirst.frc.team5243.robot.commands.SwitchDrive;
import org.usfirst.frc.team5243.robot.commands.TestWheels;

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
	
	//Joysticks
	Joystick leftStick;
	Joystick rightStick;
	
	//QuickSand
	Button QuickSandIncrease;
	Button QuickSandDecrease;
	
	//Shooter
	Button shooterLeft;
	Button shooterRight;
	Button ShootingQuickSandDecrease;
	Button ShootingQuickSandIncrease;
	
	//SwitchDrive
	Button SwitchDrive;
	
	//Lift
	Button liftUp;
	Button liftDown;
	
	//TestWheels
	Button testFrontLeft;
	Button testBackLeft;
	Button testFrontRight;
	Button testBackRight;
	
	//LoadFuel
	Button load;
	
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

		QuickSandDecrease = new JoystickButton(leftStick,8);
		QuickSandIncrease = new JoystickButton(leftStick,9);
		
		//initializes shooting variables
		shooterRight = new JoystickButton(rightStick,1);
		ShootingQuickSandDecrease = new JoystickButton(rightStick,4);
		ShootingQuickSandIncrease = new JoystickButton(rightStick,5);		
		shooterRight.whileHeld(new ShootRight(.79));
		
		shooterLeft = new JoystickButton(leftStick, 1);
		shooterLeft.whileHeld(new ShootLeft(.79));
		
		//intializes SwitchDrive
		SwitchDrive = new JoystickButton(rightStick, 8);
		SwitchDrive.whenPressed(new SwitchDrive());
		
		//Initializes lifting variables
		liftUp = new JoystickButton(rightStick, 3);
		liftDown = new JoystickButton(rightStick, 2);
		
		liftUp.whileHeld(new Lift(0.5));
		liftDown.whileHeld(new Lift(-0.5));
		
		//Initializes testing variables
		testFrontLeft = new JoystickButton(leftStick, 6);
		testBackLeft = new JoystickButton(leftStick, 7);
		testFrontRight = new JoystickButton(leftStick, 11);
		testBackRight = new JoystickButton(leftStick, 10);
		
		testFrontLeft.whileHeld(new TestWheels("frontLeft", 0.5));
		testBackLeft.whileHeld(new TestWheels("backLeft", 0.5));
		testFrontRight.whileHeld(new TestWheels("frontRight", 0.5));
		testBackRight.whileHeld(new TestWheels("backRight", 0.5));
		
		//Initializes load variable
		load = new JoystickButton(rightStick, 7);
		
		load.whileHeld(new LoadFuel(1));
	}	
	
	//Getters for Joysticks
	public Joystick getLeftStick(){
		return leftStick;
	}
	public Joystick getRightStick(){
		return rightStick;
	}
}