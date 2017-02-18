package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearDoorCommand extends Command {
	GearSubsystem gearSubsystem;
    public GearDoorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	gearSubsystem = Robot.gearSubsystem;
    	requires(gearSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gearSubsystem.openDoor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	gearSubsystem.closeDoor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	gearSubsystem.closeDoor();
    }
}