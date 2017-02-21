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
    	//Lists Sequence of commands
    	addSequential(new DriveStraight(false, false,120));//Moves 120 inches forward from start pos
    	addSequential(new TurnDegrees(60));//Turns to face the gear lift on the left side of the airship
    	addSequential(new DriveUntil(3, true));//Drives to the lift
    	addSequential(new ToggleGearDoor());//Drops the gear
    	addSequential(new Wait(3));//waits for 3 seconds to give the pilot time to lift the gear
    	addSequential(new ToggleGearDoor());//Retracts the gear door    	
    	addSequential(new DriveStraight(true,false,12));//Moves back 36 to clear the barriers
    	addSequential(new TurnDegrees(-15));//Turns left to face the boiler head on
    	addSequential(new DriveUntil(3, false)); //Moves to shooting location
    	
    	//Turns on both shooters at the same time
    	addParallel(new ShootCommand(true));
    	addSequential(new ShootCommand(false));    	
    }
}
