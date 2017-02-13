package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveFromDistance extends Command {
	SensorSubsystem sensorSubsystem;
	DriveSubsystem driveSubsystem;
	double distance;
    public DriveFromDistance(double distFromBackSensor) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	distance = distFromBackSensor;
    	
    	sensorSubsystem = Robot.sensorSubsystem;
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    	requires(sensorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.setAllMotors(.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return sensorSubsystem.ultrasonicSampleBack() > distance;
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
