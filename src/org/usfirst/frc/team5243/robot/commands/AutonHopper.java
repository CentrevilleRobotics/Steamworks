package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous program that drives the robot to the gear station, then presses
 * the hopper button in order to store fuel into the robot.
 * <p>
 * Commands are called to perform all the necessary movements of the robot with
 * final parameters.
 * 
 * @see CommandGroup
 * @see DriveStraight
 * @see Turn
 * @see DropKey
 * @see PushHopper
 */
public class AutonHopper extends CommandGroup {
	/**
	 * Main class constructor that runs the robot during the autonomous period.
	 * 
	 * The actions the robot does are:
	 * <ol>
	 * <li>Robot moves forward</li>
	 * <li>Robot turns to the left</li>
	 * <li>Robot drops a gear at the left gear station</li>
	 * <li>Robot turns around so it is facing opposite than it originally
	 * was</li>
	 * <li>Drive forward, towards the hopper</li>
	 * <li>Pressed the hopper button to release the fuel in the hopper</li>
	 * </ol>
	 * 
	 * @see CommandGroup#addSequential(edu.wpi.first.wpilibj.command.Command)
	 */
	public AutonHopper() {// DO NOT KILL HUMAN
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		requires(Robot.drivetrain);
		requires(Robot.hopperHandler);

		addSequential(new DriveStraight(165.5)); // Robot Moves Straight
		addSequential(new Turn(-90)); // Robot Turns Left
		addSequential(new DropGear()); // Robot Drops Key (Gear)
		addSequential(new Turn(180)); // Robot Turns 180 Degrees
		addSequential(new DriveStraight(36.125)); // Robot Moves Straight
		addSequential(new PushHopper()); // Pushes Hopper
		// addSequential(new StrafeRight(10in.));
	}
}
