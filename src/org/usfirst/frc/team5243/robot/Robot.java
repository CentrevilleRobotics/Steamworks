package org.usfirst.frc.team5243.robot;

import org.usfirst.frc.team5243.robot.commands.DriveFromDistance;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.LoadingSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.networktables.ConnectionInfo;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


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
	public static ShootingSubsystem rightShooterSubsystem;
	public static ShootingSubsystem leftShooterSubsystem;
	public static ClimbSubsystem climbingSubsystem;
	public static LoadingSubsystem loadingSubsystem;
	public static SensorSubsystem sensorSubsystem;
	Command autonomousCommand;
	private SendableChooser autonomousCommandChooser;
	NetworkTable table;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		oi = new OI();
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.calibrateGyro();
		        
        NetworkTable.shutdown();
        NetworkTable.setClientMode();
        System.out.println("Client Mode set");
        NetworkTable.setIPAddress("10.52.43.30");
        System.out.println("IP Address set");
        NetworkTable.initialize();
        System.out.println("NT init");
		table = NetworkTable.getTable("Smart");
		
		rightShooterSubsystem = new ShootingSubsystem(RobotMap.shooterRight);
		leftShooterSubsystem = new ShootingSubsystem(RobotMap.shooterLeft);
		oi.init();

		autonomousCommandChooser = new SendableChooser();
		autonomousCommandChooser.addDefault("Default Program", new DriveFromDistance(36));
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
        autonomousCommand = (Command) autonomousCommandChooser.getSelected();
        
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
		SmartDashboard.putNumber("Shoot Speed", leftShooterSubsystem.getSpeed());
		
		SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
		SmartDashboard.putNumber("Gyro Rate: ", driveSubsystem.getGyroRate());
		
	}
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
