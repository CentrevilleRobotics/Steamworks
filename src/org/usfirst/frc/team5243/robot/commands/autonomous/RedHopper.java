package org.usfirst.frc.team5243.robot.commands.autonomous;

import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedHopper extends CommandGroup {

    public RedHopper() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	
    	addSequential(new DriveStraight(false,false,120));
    	addSequential(new TurnDegrees(60));
    	addSequential(new DriveStraight(true, true, 4));
    	addSequential(new DriveStraight(true, false, 36));
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveStraight(true,false,165));
    	addSequential(new TurnDegrees(-90));
    	addSequential(new DriveStraight(true,true,10));
    	
   
    }
		   //addSequential(new DriveStraight(117));
    	
    	
    }




