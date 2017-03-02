package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeCommand extends Command {
	//declaration of variables and required subsystems
	DriveSubsystem driveSubsystem;
	SensorSubsystem sensorSubsystem;
	boolean frontUltra;
	double distance;
	boolean strafeRight;
    public StrafeCommand(boolean strafeRight, boolean frontUltra, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.distance = distance;
    	this.strafeRight = strafeRight;
    	this.frontUltra = frontUltra;
    	driveSubsystem = Robot.driveSubsystem;
    	sensorSubsystem = Robot.sensorSubsystem;
    	requires(sensorSubsystem);
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    //strafes robot left or right depending on strafeRight boolean passed in as parameter
    protected void execute() {
    	if (strafeRight) {
    		driveSubsystem.strafeRight(.75);
    	}
    	else {
    		driveSubsystem.strafeLeft(.75);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    //TODO Phil, please replace this with what this check does
    protected boolean isFinished() {
    	if(frontUltra){
            return Math.abs(Robot.sensorSubsystem.getFrontUltra().getRangeInches() - distance) < 4;    		
    	}else{
            return Math.abs(Robot.sensorSubsystem.getBackUltra().getRangeInches() - distance) < 4;    		
    	}
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
