package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
//import org.usfirst.frc.team5243.robot.commands.ShootLeftCommand;
//import org.usfirst.frc.team5243.robot.commands.ShootRightCommand;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionRedBoiler extends CommandGroup {

    public VisionRedBoiler() {
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
    	
    	System.out.println("RedBoiler auton running");
    	addSequential(new DriveStraight(true,false,120));
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveUntil(4, true));
    	addSequential(new ToggleGearDoor(true));
    	addSequential(new Wait(3));
    	addSequential(new ToggleGearDoor(true));
    	addSequential(new DriveStraight(true,false,12));
    	addSequential(new TurnDegrees(-15));
    	addSequential(new DriveUntil(3, false));
    	
    }
}



