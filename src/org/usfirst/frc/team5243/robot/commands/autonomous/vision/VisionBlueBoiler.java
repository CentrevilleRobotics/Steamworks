package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ShootCommand;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionBlueBoiler extends CommandGroup {

    public VisionBlueBoiler() {
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
    	
    	addSequential(new DriveStraight(false, false,120)); //drives to wall until it is 120 inches away
    	addSequential(new TurnDegrees(60)); //turns right 60 degrees to face gear peg
    	addSequential(new DriveUntil(3, true)); //drive until 3 inches away from peg using camera
    	addSequential(new ToggleGearDoor()); //extend gear actuator
    	addSequential(new Wait(3)); //wait 3 seconds
    	addSequential(new ToggleGearDoor()); //retract gear actuator
    	addSequential(new DriveStraight(true,false,12)); //drive back away from gear peg
    	addSequential(new TurnDegrees(-15)); //turn to face boiler
    	addSequential(new DriveUntil(3, false)); //drive to boiler
    	
    	addParallel(new ShootCommand(true)); //shoot with leftShooter
    	addSequential(new ShootCommand(false)); //shoot with rightShooter
    }
}
