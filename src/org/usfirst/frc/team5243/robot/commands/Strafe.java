package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Strafe extends Command {
	DriveSubsystem driveSubsystem;
	double speed;
	double starttime;
	double runtime;
    public Strafe(double rightSpeed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	runtime = time;
    	
    	driveSubsystem = Robot.driveSubsystem;
    	speed = rightSpeed;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	starttime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.strafeRight(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(System.currentTimeMillis()-starttime) >= runtime;
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
