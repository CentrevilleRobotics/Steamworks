package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.ShootCommand;
//import org.usfirst.frc.team5243.robot.commands.ShootLeftCommand;
import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedCenter extends CommandGroup {

    public RedCenter() {
    	// Sequence of commands
    	System.out.println("RedCenter auton running");
    	addSequential(new DriveStraight(true,true,4)); //Drives to the gear lift location
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the door
    	addSequential(new DriveStraight(true,false,36)); // Moves backwards 36 inches to clear the barriers
    	addSequential(new TurnDegrees(135)); // Turns to face the boiler
    	addSequential(new DriveStraight(true, true, 3)); //Moves up 3 inches away from the boiler
    	addSequential(new StrafeCommand(true,true, 52)); //Strafes until lined up with reflective tape on the boiler
    	
    	// Turns on the shooters
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));
    }
}



