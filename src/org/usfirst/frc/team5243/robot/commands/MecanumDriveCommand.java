
package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MecanumDriveCommand extends Command {
	DriveSubsystem driveSubsystem;
    public MecanumDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    //runs MecanumDrive in DriveSubsystem
    protected void execute() {
    	driveSubsystem.mecanumDrive();
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
