package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearDoor extends Command {
	public static boolean leftStickPressed = RobotMap.leftTriggerPressed;
	
	//declares subsystem dependencies
	private GearSubsystem gearSubsystem;

	public ToggleGearDoor() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		gearSubsystem = Robot.gearSubsystem;
		requires(gearSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	//toggles gear door actuator
	protected void execute() {
		if(RobotMap.gearDoorExtended)
			gearSubsystem.retractPiston();
		else
			if(Robot.oi.getRightStick().getTrigger())
				gearSubsystem.extendPiston();
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
