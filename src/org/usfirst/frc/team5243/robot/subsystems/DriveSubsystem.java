package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor frontLeft;
	private Victor frontRight;
	private Victor backLeft;
	private Victor backRight;
	private RobotDrive drivetrain;
	
	public DriveSubsystem() {
		frontLeft = new Victor(RobotMap.FrontLeft);
		frontRight = new Victor(RobotMap.FrontRight);
		backLeft = new Victor(RobotMap.BackLeft);
		backRight = new Victor(RobotMap.BackRight);
		drivetrain = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    
    public void tankDrive() {
    	drivetrain.tankDrive(Robot.oi.getLeftStick().getY(), Robot.oi.getRightStick().getY());
    }
    
    public void setSafetyEnabled() {
    	drivetrain.setSafetyEnabled(false);
    }
}

