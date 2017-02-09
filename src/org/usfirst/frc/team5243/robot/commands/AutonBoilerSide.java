package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The {@link CommandGroup} class that runs the {@link Robot}
 * to drop off a gear at the gear station and setup for shooting
 * fuel at the boiler.
 * 
 * @see CommandGroup
 * @see Robot
 */
public class AutonBoilerSide extends CommandGroup {
    /**
     * 
     */
    public  AutonBoilerSide() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//go straight till in line with the airspace boundary
    	//turn right till facing the gear drop off
    	//go straight till close enough to drop gear
    	//drop gear
    	//move back till clear of borders
    	//turn to face boiler
    	//go straight until in range to shoot
    	//shoot into top until time runs out
    	
    	requires(Robot.drivetrain);
    	requires(Robot.rightShooter);
    	requires(Robot.leftShooter);
    	requires(Robot.gearHandler);
    	
    	addSequential(new DriveStraight(156));
    	addSequential(new Turn(135));
    	addSequential(new DriveStraight(22));
    	addSequential(new DropGear());
    	addSequential(new DriveStraight(-22));
    	addSequential(new Turn(45));
    	addSequential(new DriveStraight(156));
    	addSequential(new ShootLeft(1.0));
    	addParallel(new ShootRight(1.0));
    	
    }
}
