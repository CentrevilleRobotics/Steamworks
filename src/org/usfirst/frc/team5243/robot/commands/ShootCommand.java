package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends Command {
	private ShootingSubsystem shootSubsystem;
    public ShootCommand(boolean useLeftShooter) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
    	/*if (RobotMap.ZAxisShooting) {
    		shootSubsystem.shoot(0.5 * Robot.oi.getLeftStick().getZ() + 0.5);
    	} else {*/
        	shootSubsystem.shoot(.79);//ideal speed according to previous tests
    	//}
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
