package org.usfirst.frc.team5243.robot.commands.autonomous.vision;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.DriveUntil;
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
public class VisionRedCenter extends CommandGroup {

    public VisionRedCenter() {
    	System.out.println("RedCenter auton running");
    	addSequential(new DriveUntil(4, true)); //Drives to the gear lift location
    	addSequential(new ToggleGearDoor()); //Drops the gear
    	addSequential(new Wait(3)); //Waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor()); //Retracts the door
    	addSequential(new DriveStraight(true,false,36)); // Moves backwards 36 inches to clear the barriers
    	addSequential(new TurnDegrees(-45)); // Turns to face the boiler
    	addSequential(new StrafeCommand(true,false, 60)); //Moves up 3 inches away from the boiler
    	addSequential(new DriveUntil(3, false));//Strafes until lined up with reflective tape on the boiler
    	
    	
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));    	
    }
}



