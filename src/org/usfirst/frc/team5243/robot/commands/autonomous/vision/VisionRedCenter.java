package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionRedCenter extends CommandGroup {

    public VisionRedCenter() {
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
    	
    	System.out.println("RedCenter auton running");
    	addSequential(new DriveUntil(4, true));
    	addSequential(new ToggleGearDoor(true));
    	addSequential(new Wait(3));
    	addSequential(new ToggleGearDoor(true));
    	addSequential(new DriveStraight(true,false,36));
    	addSequential(new TurnDegrees(-45));
    	addSequential(new StrafeCommand(true,false, 60));
    	addSequential(new DriveUntil(3, false));
    	  	
    }
}



