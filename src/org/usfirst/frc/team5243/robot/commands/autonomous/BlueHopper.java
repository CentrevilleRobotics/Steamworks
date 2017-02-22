package org.usfirst.frc.team5243.robot.commands.autonomous;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueHopper extends CommandGroup {

    public BlueHopper() {
    	System.out.println("BlueHopper auton running");

    	addSequential(new DriveStraight(false,false,120));
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveStraight(true, true, 4));
    	addSequential(new Wait(3));
    	addSequential(new DriveStraight(true, false, 36));
    	addSequential(new TurnDegrees(60));
    	addSequential(new DriveStraight(true,false,165));
    	addSequential(new TurnDegrees(90));
    	addSequential(new DriveStraight(true,true,10));

    	
    	
    	
    }
}



