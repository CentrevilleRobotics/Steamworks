package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionRedHopper extends CommandGroup {

	public VisionRedHopper() {
		System.out.println("RedHopper auton running");
		addSequential(new DriveStraight(false, false, 120)); //Drive forward 120 inches
		addSequential(new TurnDegrees(60)); //turn to face the gear lift
		addSequential(new DriveUntil(4, true)); //go till the lift
		addSequential(new ToggleGearDoor()); //drops the gear
    	addSequential(new Wait(3)); //waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //retract the gear door 
		addSequential(new DriveStraight(true, false, 36)); //Moves backward 36 inches 
		addSequential(new TurnDegrees(-60)); //Turns toward the hopper
		addSequential(new DriveStraight(false, false, 165)); //Drives toward the hopper
		addSequential(new TurnDegrees(-90)); // Turn to face the hopper directly
		addSequential(new DriveUntil(10, true)); //drive forward to press the hopper

	}
}
