package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ShootCommand;
import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionBlueCenter extends CommandGroup {

    public VisionBlueCenter() {
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
    	addSequential(new DriveUntil(4, true)); //drive up to gear peg
    	addSequential(new ToggleGearDoor()); //extend gear actuator
    	addSequential(new Wait(3)); //wait 3 seconds
    	addSequential(new ToggleGearDoor()); //retract gear actuator
    	addSequential(new DriveStraight(true,false,80)); //TODO evaluate this command
    	addSequential(new TurnDegrees(45)); //turn to face boiler
    	addSequential(new StrafeCommand(false,false, 60)); //strafe until lined up with boiler
    	addSequential(new DriveUntil(3, true)); //drive to boiler
    	
    	addParallel(new ShootCommand(true)); //shoot with leftShooter
    	addSequential(new ShootCommand(false)); //shoot with rightShooter

    	
    	
    }
}