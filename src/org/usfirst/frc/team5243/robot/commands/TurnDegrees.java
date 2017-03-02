package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDegrees extends Command {
	//declaration of subsystem dependencies and variables
	DriveSubsystem driveSubsystem;
	double startDegree;
	double turnDegrees;
	
    public TurnDegrees(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    	turnDegrees = degrees;
    }
    
    // Called just before this Command runs the first time
    //initializes start degrees to current gyro angle
    protected void initialize() {
    	startDegree = driveSubsystem.getGyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    //turns until turnDegrees is reached
    protected void execute() {
    	if (turnDegrees < 0) {
    		driveSubsystem.turnLeft(.4);
    	}
    	else if (turnDegrees > 0) {
    		driveSubsystem.turnRight(.4);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    //ends when turnDegrees has been reached
    protected boolean isFinished() {
        return Math.abs(driveSubsystem.getGyroAngle() - startDegree) >= Math.abs(turnDegrees);
    }

    // Called once after isFinished returns true
    //turns off all motors
    protected void end() {
    	driveSubsystem.setAllMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
