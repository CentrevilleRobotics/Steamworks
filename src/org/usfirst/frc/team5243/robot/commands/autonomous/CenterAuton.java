package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAuton extends CommandGroup {
    public CenterAuton() {
        System.out.println("Starting center auton");
    	addSequential(new DriveStraight(false,false,22));
    	addSequential(new Wait(1));
    	addSequential(new ToggleGearDoor(true));
    	addSequential(new ToggleGearDoor(true));
    }
}