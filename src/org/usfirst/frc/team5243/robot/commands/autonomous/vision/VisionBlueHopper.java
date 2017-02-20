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

    	addSequential(new DriveStraight(false,false,120));
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveUntil(4, true));
    	addSequential(new ToggleGearDoor());
    	addSequential(new Wait(3));
    	addSequential(new ToggleGearDoor());

    	addSequential(new DriveStraight(true, false, 36));
    	addSequential(new TurnDegrees(60));
    	addSequential(new DriveStraight(false,false,165));
    	addSequential(new TurnDegrees(90));

    	
    	
    	
    }
}



