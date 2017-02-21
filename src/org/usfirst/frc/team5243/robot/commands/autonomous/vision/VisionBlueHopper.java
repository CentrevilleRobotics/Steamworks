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
public class VisionBlueHopper extends CommandGroup {

    public VisionBlueHopper() {
    	System.out.println("BlueHopper auton running");

    	addSequential(new DriveStraight(false,false,120)); //Drives forward for 120
    	addSequential(new TurnDegrees(-60)); //Turns to face the gear lift on the left
    	addSequential(new DriveUntil(4, true));//Drives up to the gear lift
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor());//Retracts the door
    	addSequential(new DriveStraight(true, false, 36)); //Drives back 36 to clear the barriers
    	addSequential(new TurnDegrees(60)); //Turns to face the hopper
    	addSequential(new DriveStraight(false,false,165)); //Drives up to the hopper
    	addSequential(new TurnDegrees(90)); //Drives up to the hopper
    	addSequential(new DriveUntil(10, true)); //Drives into the hopper to drop the Fuel
    	
    	
    	
    }
}



