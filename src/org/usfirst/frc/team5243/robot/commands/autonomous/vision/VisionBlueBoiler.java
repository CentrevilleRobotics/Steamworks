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
    	
    	
    	addSequential(new DriveStraight(false, false,120));
    	addSequential(new TurnDegrees(60));
    	addSequential(new DriveUntil(3, true));
    	addSequential(new ToggleGearDoor());
    	addSequential(new Wait(3));
    	addSequential(new ToggleGearDoor());    	
    	addSequential(new DriveStraight(true,false,12));
    	addSequential(new TurnDegrees(-15));
    	addSequential(new DriveUntil(3, false));
    	
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));    	
    }
}
