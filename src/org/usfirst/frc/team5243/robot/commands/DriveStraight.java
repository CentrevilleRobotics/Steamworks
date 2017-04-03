package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	//declaration of variables
	DriveSubsystem driveSubsystem;
	Ultrasonic ultrasonic;
	boolean frontUltrasonic;
	boolean drivingFrom;
	double distance;

	//constructor
	public DriveStraight(boolean frontUltra, boolean drivingFrom, double distance) {
		driveSubsystem = Robot.driveSubsystem;
		frontUltrasonic = frontUltra;
		if (frontUltra) {
			ultrasonic = Robot.sensorSubsystem.getFrontUltra();
		} else {
			ultrasonic = Robot.sensorSubsystem.getBackUltra();
		}
		this.drivingFrom = drivingFrom;
		this.distance = distance;

		requires(driveSubsystem);
		requires(Robot.sensorSubsystem);
	}

	// Called just before this Command runs the first time
	//resets gyro to prevent command from working incorrectly
	protected void initialize() {
		//driveSubsystem.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	//continually checks if robot is off course as determined by the gyro angle
	protected void execute() {
		System.out.println("gyro " + driveSubsystem.getGyroAngle());
		System.out.println("Ultrasonic " + ultrasonic.getRangeInches());
		if (frontUltrasonic) {
			// front side
			if (drivingFrom) {
				driveSubsystem.improvedStraight(.3);
			}
			else{
				driveSubsystem.improvedStraight(-.3);
			}
		}
		else {
			// back side
			if (drivingFrom) {
				driveSubsystem.improvedStraight(-.3);
			} else {
				driveSubsystem.improvedStraight(.3);
			}
		}
	}
	// Make this return true when this Command no longer needs to run execute()
	//finishes when ultrasonic value is at the distance
	protected boolean isFinished() {
		if (drivingFrom) {
			return ultrasonic.getRangeInches() > distance;
		} else {
			return ultrasonic.getRangeInches() < distance;
		}
	}

	// Called once after isFinished returns true
	//turns off all motors
	protected void end() {
		driveSubsystem.improvedStraight(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
