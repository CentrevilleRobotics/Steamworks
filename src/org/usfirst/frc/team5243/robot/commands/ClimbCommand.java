package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.LoadingClimbingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	private LoadingClimbingSubsystem loadSubsystem;
    public ClimbCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	loadSubsystem = Robot.loadingSubsystem;
    	requires(loadSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	loadSubsystem.setLiftMotor(-.5*Robot.oi.getRightStick().getRawAxis(3)+.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	loadSubsystem.setLiftMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	loadSubsystem.setLiftMotor(0);
    }
}
