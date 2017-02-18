package org.usfirst.frc.team5243.robot.commands.autons;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueMiddleSide extends CommandGroup {

    public BlueMiddleSide() {
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
    	requires(Robot.sensorSubsystem);
    	
//    	addSequential(new DriveUntil(0, true));
//    	addSequential(new DriveStraight(-36, false));
//    	addSequential(new TurnDegrees(-135));
//    	addSequential(new DriveStraight(75.415, true));
    	//strafe until lined up with reflective tape
    	
    }
}
