package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedStrafe extends Command {
	DriveSubsystem driveSubsystem;
	double time;
	double motorSpeed;
	boolean finished;
	boolean rightStrafing;
    public TimedStrafe(boolean strafeRight,double seconds, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    	time = seconds;
    	motorSpeed= speed;
    	rightStrafing = strafeRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.strafeRight(rightStrafing ? motorSpeed :-motorSpeed);
    	Timer.delay(time);
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setAllMotors(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
