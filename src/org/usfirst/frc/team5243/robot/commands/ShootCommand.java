package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {
	private ShootingSubsystem shootSubsystem;
    public ShootCommand(boolean useLeftShooter) {
        //checks which shooter to use
    	if(useLeftShooter){
    		shootSubsystem = Robot.leftShootingSubsystem;
    	}else{
    		shootSubsystem = Robot.rightShootingSubsystem;
    	}
    	requires(shootSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shootSubsystem.shoot(1);
    	shootSubsystem.setAgitator(0.5);
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
    	//makes it turn the shooter off
    	shootSubsystem.shoot(0);
    }
}
