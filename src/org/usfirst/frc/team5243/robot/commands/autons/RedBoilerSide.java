package org.usfirst.frc.team5243.robot.commands.autons;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ShootLeftCommand;
import org.usfirst.frc.team5243.robot.commands.ShootRightCommand;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedBoilerSide extends CommandGroup {

    public RedBoilerSide() {
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
    	
    	requires(Robot.driveSubsystem);
    	requires(Robot.leftShooterSubsystem);
    	requires(Robot.rightShooterSubsystem);
    	requires(Robot.sensorSubsystem);
    	
    	//sets an order for the autonomous commands and the degrees and distances needed for each
//    	addSequential(new DriveStraight(120, true));
//    	addSequential(new TurnDegrees(-60));
//    	addSequential(new DriveUntil(1, true));
//    	addSequential(new DriveStraight(-36, false));
//    	addSequential(new TurnDegrees(-15));
//    	addSequential(new TurnDegrees(-60));
    	//adds a shooting command for both shooters to run at the same time with a motor speed of 1 
    	//once the previous commands have finished
    	addSequential(new ShootLeftCommand(1.0));
    	addParallel(new ShootRightCommand(1.0));
    }
}
