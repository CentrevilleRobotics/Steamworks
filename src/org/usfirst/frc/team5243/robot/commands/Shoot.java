package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class Shoot extends Command {
	
	double speed;
	
	ShootingSubsystem shooting;
    public Shoot(double shootingSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	shooting = Robot.shootingSubsystem; 
    	requires (shooting);
    	speed = shootingSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void start() {
    	shooting.shooting(speed);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooting.shooting(speed);
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
    }
}
