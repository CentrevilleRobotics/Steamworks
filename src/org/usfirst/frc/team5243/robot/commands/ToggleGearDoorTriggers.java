package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearDoorTriggers extends Command {
	
	GearSubsystem gearSubsystem;
	public ToggleGearDoorTriggers(){
		gearSubsystem = Robot.gearSubsystem;
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.leftTriggerPressed = true;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.leftTriggerPressed = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.leftTriggerPressed = false;
    }
}
