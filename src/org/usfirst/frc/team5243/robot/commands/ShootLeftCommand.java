package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootLeftCommand extends Command {
	private ShootingSubsystem shootSubsystem;
    public ShootLeftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	shootSubsystem = Robot.leftShootingSubsystem;
    	requires(shootSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shootSubsystem.shoot(.79);//ideal speed according to preious tests
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
    	shootSubsystem.shoot(0);
    }
}
