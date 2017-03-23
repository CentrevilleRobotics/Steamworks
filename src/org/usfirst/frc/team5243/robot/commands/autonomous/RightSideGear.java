package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.ToggleGearDoor;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;
import org.usfirst.frc.team5243.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSideGear extends CommandGroup {
    public RightSideGear() {
    	addSequential(new DriveStraight(true,false,120));
    	addSequential(new TurnDegrees(-60));
    	addSequential(new CenterAuton());
    }
}
