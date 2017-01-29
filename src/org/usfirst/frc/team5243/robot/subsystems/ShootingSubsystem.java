package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    
	Victor shooter;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public ShootingSubsystem(){
		shooter = new Victor(RobotMap.shooter);
	}
	
	public void shooting(double speed){
		shooter.set(speed);
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

