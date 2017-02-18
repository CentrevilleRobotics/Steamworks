package org.usfirst.frc.team5243.robot;

import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.autonomous.BlueBoiler;
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
	public static VisionSubsystem visionSubsystem;
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
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.calibrateGyro();
		driveSubsystem.commandInitializer();
		
		sensorSubsystem = new SensorSubsystem();
		gearSubsystem = new GearSubsystem();
		
		solenoidSubsystem = new SolenoidSubsystem();
		
		leftShootingSubsystem = new ShootingSubsystem(RobotMap.shooterLeft);
		rightShootingSubsystem = new ShootingSubsystem(RobotMap.shooterRight);
		
		visionSubsystem = new VisionSubsystem();
		loadingSubsystem = new LoadingClimbingSubsystem();
		System.out.println("Subsystems initialized");
		
		
		oi.init();
		System.out.println("OI initialized");
		autonomousCommandChooser = new SendableChooser<Command>();
		autonomousCommandChooser.addDefault("Boiler Red Side", null);
		autonomousCommandChooser.addObject("Hopper Red Side", null);
		autonomousCommandChooser.addObject("Center Red Side", null);
		autonomousCommandChooser.addObject("Boiler Blue Side", new BlueBoiler());
		autonomousCommandChooser.addObject("Hopper Blue Side", null);
		autonomousCommandChooser.addObject("Center Blue Side", null);
		System.out.println("Auton command chooser initialized");
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
    	new DriveUntil(5,true);
    	
        //autonomousCommand = (Command) autonomousCommandChooser.getSelected();
        
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
		SmartDashboard.putNumber("Gyro Rate: ", driveSubsystem.getGyroRate());
		SmartDashboard.putNumber("Ultrasonic Front: ", sensorSubsystem.getUltrasonicFrontValue());
	}
	
    /**
     * This function is called periodically during test mode
     */
	
    public void testPeriodic() {
        LiveWindow.run();
    }
}
