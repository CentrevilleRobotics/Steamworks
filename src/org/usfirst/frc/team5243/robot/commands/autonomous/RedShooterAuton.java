package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.ShootCommand;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedShooterAuton extends CommandGroup {
	//emergency auton created after robot reconstruction
    public RedShooterAuton() {
    	addSequential(new DriveStraight(false, true, 4)); //drive slightly away from starting wall
        addSequential(new TurnDegrees(-90)); //turn left 90 degrees
        addSequential(new DriveStraight(true, false, 62)); //drive to boiler
        addSequential(new TurnDegrees(45)); //turn to face boiler
        addParallel(new ShootCommand(true)); //shoot using leftShooter
        addSequential(new ShootCommand(false)); //shoot using rightShooter
    }
}
