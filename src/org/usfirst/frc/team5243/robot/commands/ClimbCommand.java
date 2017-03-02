package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.LoadingClimbingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	//declaration of required subsystems
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
    //sets climb motor to power 1
    protected void execute() {
    	loadSubsystem.setLiftMotor(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    //turns off climb motor
    protected void end() {
    	loadSubsystem.setLiftMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    //turns off climb motor
    protected void interrupted() {
    	loadSubsystem.setLiftMotor(0);
    }
}
