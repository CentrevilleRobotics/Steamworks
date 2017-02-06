package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climb extends Command {
	private ClimbSubsystem climbSubsystem;
	private double speed;
    public Climb(double climbingSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	climbSubsystem = Robot.climbSubsystem;
    	requires(climbSubsystem);
    	speed = climbingSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climbSubsystem.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climbSubsystem.setSpeed(0.0);
    }
}
