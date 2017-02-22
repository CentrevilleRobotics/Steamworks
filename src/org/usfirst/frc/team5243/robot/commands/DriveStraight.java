package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	DriveSubsystem driveSubsystem;
	Ultrasonic ultrasonic;
	boolean frontUltrasonic;
	boolean insideTheDistance;
	double distance;
	
	public DriveStraight(boolean frontUltra, boolean insideTheDistance, double distance) {
		driveSubsystem = Robot.driveSubsystem;
		frontUltrasonic = frontUltra;
		if (frontUltra) {
			ultrasonic = Robot.sensorSubsystem.getFrontUltra();
		} else {
			ultrasonic = Robot.sensorSubsystem.getBackUltra();
		}
		this.insideTheDistance = insideTheDistance;
		this.distance = distance;

		requires(driveSubsystem);
		requires(Robot.sensorSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		driveSubsystem.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Math.abs(driveSubsystem.getGyroAngle())>3){
			if(driveSubsystem.getGyroAngle()>3)
				driveSubsystem.turnLeft(.25);
			else
				driveSubsystem.turnRight(.25);
		}else{
			if (frontUltrasonic) {
				if (drivingFrom) {
					driveSubsystem.setAllMotors(-.75);
				} else {
					if (drivingFrom) {
						driveSubsystem.setAllMotors(.75);
					} else {
						driveSubsystem.setAllMotors(-.75);
					}
				}
			} 
		}
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (insideTheDistance) {
			return ultrasonic.getRangeInches() < distance;
		} else {
			return ultrasonic.getRangeInches() > distance;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		driveSubsystem.setAllMotors(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
