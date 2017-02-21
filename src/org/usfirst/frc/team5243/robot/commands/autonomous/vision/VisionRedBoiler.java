package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
import org.usfirst.frc.team5243.robot.commands.ShootCommand;
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
    	System.out.println("RedBoiler auton running");
    	addSequential(new DriveStraight(true,false,120)); //Drives forward for 120 inches
    	addSequential(new TurnDegrees(-60)); // Turn to face the gear lift
    	addSequential(new DriveUntil(4, true)); // Drive up to the gear lift
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the door 
    	addSequential(new DriveStraight(true,false,12)); // Move back 36 inches to clear the barriers
    	addSequential(new TurnDegrees(-15)); //Turns to face the boiler
    	addSequential(new DriveUntil(3, false)); //Moves to shooting location
    	
    	//turn on shooters
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));
    	
    }
}



