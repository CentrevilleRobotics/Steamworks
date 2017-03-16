package org.usfirst.frc.team5243.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public sta0`tic int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;


	public final static int FrontLeft = 1;
	public final static int FrontRight = 2;
	public final static int BackLeft = 3;
	public final static int BackRight  = 4;

	public final static int leftStick = 0;
	public final static int rightStick = 1;
	
	public final static int liftMotor = 7;
	
	public final static int ultrasonicFront = 1;
	public final static int ultrasonicBack = 2;
	
	//NOT CORRECT VALUES FOR RELAYS
	public final static int lightFront = 0;
	public final static int lightBack = 1;
	
	public final static int gearSolenoid = 1;
	
	public final static int greenLight = 3;
	
	
	public static boolean MecanumDrive = true;
	
	public static boolean Loading = false;
	public final static int compressor = 0;
	
	public final static int solenoidPort1 = 0;
	public final static int solenoidPort2 = 1;
	
	public final static int light = 2;
	

}