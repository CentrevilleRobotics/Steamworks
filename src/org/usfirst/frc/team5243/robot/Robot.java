package org.usfirst.frc.team5243.robot;
import org.usfirst.frc.team5243.robot.commands.autonomous.BlueBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.BlueCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.BlueHopper;
import org.usfirst.frc.team5243.robot.commands.autonomous.RedBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.RedCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.RedHopper;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueHopper;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedHopper;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.LoadingClimbingSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SolenoidSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem driveSubsystem;
	public static SensorSubsystem sensorSubsystem;
	public static GearSubsystem gearSubsystem;
	public static SolenoidSubsystem solenoidSubsystem;
	public static ShootingSubsystem rightShootingSubsystem;
	public static ShootingSubsystem leftShootingSubsystem;
//	public static VisionSubsystem visionSubsystem;
	public static LoadingClimbingSubsystem loadingSubsystem;
	
	Command autonomousCommand;
	SendableChooser<Command> autonomousCommandChooser;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		oi = new OI();
		System.out.println("DriveSS constructor");
		driveSubsystem = new DriveSubsystem();
		System.out.println("DriveSS gyro calibration");
		driveSubsystem.calibrateGyro();
		System.out.println("DriveSS Mecanum and Tank drive init");
		driveSubsystem.commandInitializer();

		System.out.println("sensorSubsystem constructor");
		sensorSubsystem = new SensorSubsystem();
		System.out.println("gearSubsystem constructor");
		gearSubsystem = new GearSubsystem();
		System.out.println("solenoidSubsystem consructor");		
		solenoidSubsystem = new SolenoidSubsystem();
		
		leftShootingSubsystem = new ShootingSubsystem(true);
		rightShootingSubsystem = new ShootingSubsystem(false);
		
		//visionSubsystem = new VisionSubsystem();
		loadingSubsystem = new LoadingClimbingSubsystem();
		System.out.println("Subsystems initialized, starting oi.init()");
		oi.init();
		System.out.println("OI initialized");
		autonomousCommandChooser = new SendableChooser<>();
		autonomousCommandChooser.addDefault("Boiler Red Side", new RedBoiler());
		autonomousCommandChooser.addObject("Hopper Red Side", new RedHopper());
		autonomousCommandChooser.addObject("Center Red Side", new RedCenter());
		autonomousCommandChooser.addObject("Boiler Blue Side", new BlueBoiler());
		autonomousCommandChooser.addObject("Hopper Blue Side", new BlueHopper());
		autonomousCommandChooser.addObject("Center Blue Side", new BlueCenter());
		
		autonomousCommandChooser.addObject("Vision Blue Boiler", new VisionBlueBoiler());
		autonomousCommandChooser.addObject("Vision Blue Center", new VisionBlueCenter());
		autonomousCommandChooser.addObject("Vision Blue Hopper", new VisionBlueHopper());
		autonomousCommandChooser.addObject("Vision Red Boiler", new VisionRedBoiler());
		autonomousCommandChooser.addObject("Vision Red Center", new VisionRedCenter());
		autonomousCommandChooser.addObject("Vision Red Hopper", new VisionRedHopper());
		SmartDashboard.putData("Auton Chooser", autonomousCommandChooser);
		System.out.println("Auton command chooser initialized");
		
		System.out.println("smart dashboard placements in robot init");
		SmartDashboard.putNumber("Front Ultrasonic ", sensorSubsystem.getUltrasonicFrontValue());
		SmartDashboard.putNumber("Back Ultrasonic ", sensorSubsystem.getUltrasonicBackValue());
		
		SmartDashboard.putNumber("Front Left Motor ", driveSubsystem.getFrontLeftSpeed());
		SmartDashboard.putNumber("Back Left Motor ", driveSubsystem.getBackLeftSpeed());
		SmartDashboard.putNumber("Front Right Motor ", driveSubsystem.getFrontRightSpeed());
		SmartDashboard.putNumber("Back Right Motor ", driveSubsystem.getBackRightSpeed());
		
		SmartDashboard.putNumber("Actuator Position ", gearSubsystem.getAngle());
		
		SmartDashboard.putBoolean("Solenoid(Light) Status ", solenoidSubsystem.getSolenoidStatus());
		
		SmartDashboard.putNumber("Lift/Climb Speed ", loadingSubsystem.getLiftSpeed());
		
//		SmartDashboard.putNumber("Front Offset X ", visionSubsystem.getFrontOffsetX());
//		SmartDashboard.putNumber("Front Offset Y ", visionSubsystem.getFrontOffsetY());
//		SmartDashboard.putNumber("Rear Offset X ", visionSubsystem.getRearOffsetX());
//		SmartDashboard.putNumber("Rear Offset Y ", visionSubsystem.getRearOffsetY());
		
		SmartDashboard.putNumber("Left Shooter Speed ", leftShootingSubsystem.getSpeed());
		SmartDashboard.putNumber("Right Shooting Speed ", rightShootingSubsystem.getSpeed());
		System.out.println("SmartDashboard placement in robotInit done");
	}
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousInit() {
//    	new DriveUntil(5,true);
		autonomousCommand = autonomousCommandChooser.getSelected();
    	if(autonomousCommand == null) autonomousCommand = new RedCenter();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		System.out.println(sensorSubsystem.getUltrasonicFrontValue());

        SmartDashboard.putNumber("Front Ultrasonic ", sensorSubsystem.getUltrasonicFrontValue());
		SmartDashboard.putNumber("Back Ultrasonic ", sensorSubsystem.getUltrasonicBackValue());
		
		SmartDashboard.putNumber("Front Left Motor ", driveSubsystem.getFrontLeftSpeed());
		SmartDashboard.putNumber("Back Left Motor ", driveSubsystem.getBackLeftSpeed());
		SmartDashboard.putNumber("Front Right Motor ", driveSubsystem.getFrontRightSpeed());
		SmartDashboard.putNumber("Back Right Motor ", driveSubsystem.getBackRightSpeed());
		
		SmartDashboard.putNumber("Actuator Position ", gearSubsystem.getAngle());
		
		SmartDashboard.putBoolean("Solenoid(Light) Status ", solenoidSubsystem.getSolenoidStatus());
		
		SmartDashboard.putNumber("Lift/Climb Speed ", loadingSubsystem.getLiftSpeed());
		
//		SmartDashboard.putNumber("Front Offset X ", visionSubsystem.getFrontOffsetX());
//		SmartDashboard.putNumber("Front Offset Y ", visionSubsystem.getFrontOffsetY());
//		SmartDashboard.putNumber("Rear Offset X ", visionSubsystem.getRearOffsetX());
//		SmartDashboard.putNumber("Rear Offset Y ", visionSubsystem.getRearOffsetY());
		
		SmartDashboard.putNumber("Left Shooter Speed ", leftShootingSubsystem.getSpeed());
		SmartDashboard.putNumber("Right Shooting Speed ", rightShootingSubsystem.getSpeed());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        gearSubsystem.closeDoor();
    }
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
		SmartDashboard.putNumber("Gyro Rate: ", driveSubsystem.getGyroRate());
		
		SmartDashboard.putNumber("Front Ultrasonic ", sensorSubsystem.getUltrasonicFrontValue());
		SmartDashboard.putNumber("Back Ultrasonic ", sensorSubsystem.getUltrasonicBackValue());
		
		SmartDashboard.putNumber("Front Left Motor ", driveSubsystem.getFrontLeftSpeed());
		SmartDashboard.putNumber("Back Left Motor ", driveSubsystem.getBackLeftSpeed());
		SmartDashboard.putNumber("Front Right Motor ", driveSubsystem.getFrontRightSpeed());
		SmartDashboard.putNumber("Back Right Motor ", driveSubsystem.getBackRightSpeed());
		
		SmartDashboard.putNumber("Actuator Position ", gearSubsystem.getAngle());
		
		SmartDashboard.putBoolean("Solenoid(Light) Status ", solenoidSubsystem.getSolenoidStatus());
		
		SmartDashboard.putNumber("Lift/Climb Speed ", loadingSubsystem.getLiftSpeed());
		SmartDashboard.putNumber("Loading Speed ", loadingSubsystem.getLoadSpeed());
		
//		SmartDashboard.putNumber("Front Offset X ", visionSubsystem.getFrontOffsetX());
//		SmartDashboard.putNumber("Front Offset Y ", visionSubsystem.getFrontOffsetY());
//		SmartDashboard.putNumber("Rear Offset X ", visionSubsystem.getRearOffsetX());
//		SmartDashboard.putNumber("Rear Offset Y ", visionSubsystem.getRearOffsetY());
//		
		SmartDashboard.putNumber("Left Shooter Speed ", leftShootingSubsystem.getSpeed());
		SmartDashboard.putNumber("Right Shooting Speed ", rightShootingSubsystem.getSpeed());
	}
	
    /**
     * This function is called periodically during test mode
     */
	
    public void testPeriodic() {
        LiveWindow.run();
    }
}
