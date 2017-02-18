package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignHighGoal extends Command {
	VisionSubsystem  visionSubsystem;
	DriveSubsystem driveSubsystem;
    public AlignHighGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	visionSubsystem = Robot.visionSubsystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (visionSubsystem.offsetIsGood("frontOffsetX")) {
    		if  (visionSubsystem.getFrontOffsetX() > 40) {
        		driveSubsystem.strafeRight(0.5d);
        	}
        	else if (visionSubsystem.getFrontOffsetX() < -40) {
        		driveSubsystem.strafeLeft(0.5d);
        	}
    	}
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
