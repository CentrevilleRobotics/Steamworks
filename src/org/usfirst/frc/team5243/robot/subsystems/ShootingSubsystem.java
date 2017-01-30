package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    
	Victor shooterLeft;
	Victor shooterRight;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public ShootingSubsystem(){
		shooterLeft = new Victor(RobotMap.shooterLeft);
		shooterRight = new Victor(RobotMap.shooterRight);
	}
	
	public void shooting(double speed){
		shooterLeft.set(speed);
		shooterRight.set(speed);
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

