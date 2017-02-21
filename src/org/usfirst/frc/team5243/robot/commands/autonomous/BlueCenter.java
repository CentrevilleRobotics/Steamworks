package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueCenter extends CommandGroup {

    public BlueCenter() {
        
    	System.out.println("BlueCenter auton running");
    	addSequential(new DriveStraight(true,true,4)); //Moves to the gear lift in the middle of the airship
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the gear door    	
    	addSequential(new DriveStraight(true,false,36)); //Moves back 36 to clear the barriers
    	addSequential(new TurnDegrees(45)); //Turns to face the boiler
    	addSequential(new DriveStraight(true, true, 3)); //Moves up 3 away from the boiler
    	addSequential(new StrafeCommand(true,true, 52)); //Strafes until lined up with reflective tape on the boiler
    }
}                                                      