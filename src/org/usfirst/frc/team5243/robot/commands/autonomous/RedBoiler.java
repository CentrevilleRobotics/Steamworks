package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
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
public class RedBoiler extends CommandGroup {

    public RedBoiler() {
      
    	
    	System.out.println("RedBoiler auton running");
    	// Sequence of commands
    	addSequential(new DriveStraight(true,false,120)); //Drives forward for 120 inches
    	addSequential(new TurnDegrees(-60)); // Turn to face the gear lift
    	addSequential(new DriveStraight(true,true,4)); // Drive up to the gear lift
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the door 
    	addSequential(new DriveStraight(true,false,36)); // Move back 36 inches to clear the barriers
    	addSequential(new TurnDegrees(-15)); //Turns to face the boiler
    	addSequential(new DriveStraight(true, true, 3)); //Moves to shooting location
    	
    	// Turns on the shooters at the same time
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));
    }
}



