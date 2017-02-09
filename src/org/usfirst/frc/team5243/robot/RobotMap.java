package org.usfirst.frc.team5243.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//These ports are placeholders :)
	public static int frontLeft = 1;
	public static int backLeft = 2;
	public static int backRight = 3;
	public static int frontRight = 4;
	
	public static int leftStick = 0;
	public static int rightStick = 1;
	
	public static int shooterLeft = 5;
	public static int shooterRight = 6;

	public static int liftMotor = 8;
	public static int loadMotor = 10;
	
	public static int minicim = 9;
	
	public final static double ShootingSpeed = .79;
}