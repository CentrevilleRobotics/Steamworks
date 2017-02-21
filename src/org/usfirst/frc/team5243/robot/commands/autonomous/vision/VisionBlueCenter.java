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
      
    	System.out.println("BlueCenter auton running");
    	addSequential(new DriveUntil(4, true)); //Moves to the gear lift in the middle of the airship
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the gear door
    	addSequential(new DriveStraight(true,false,80)); //Moves back 36 inches to clear the barriers
    	addSequential(new TurnDegrees(45)); //Turns to face the boiler
    	addSequential(new StrafeCommand(false,false, 60)); //Moves up 3 away from the boiler
    	addSequential(new DriveUntil(3, true)); //Strafes until lined up with reflective tape on the boiler
    	
    	// Turns on the shooters
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));    	

    	
    	
    }
}