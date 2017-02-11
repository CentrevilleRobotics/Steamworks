package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootRightCommand extends Command {
	

	double speed;
	ShootingSubsystem shootingSubsystem;
	
    public ShootRightCommand(double shootingSpeed) {
    	shootingSubsystem = Robot.rightShooterSubsystem; 
    	requires(shootingSubsystem);
    	speed = shootingSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shootingSubsystem.shoot(speed * (0.5 * Robot.oi.getLeftStick().getZ()+0.5));
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
    	shootingSubsystem.shoot(0.0);
    }
}