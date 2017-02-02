package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    
	CANTalon shooterLeft;
	CANTalon shooterRight;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public ShootingSubsystem(){
		shooterLeft = new CANTalon(RobotMap.shooterLeft);
		shooterRight = new CANTalon(RobotMap.shooterRight);
	}
	
	public void shooting(double speed){
		shooterLeft.set(speed);
		System.out.println("Left shooter: " + shooterLeft.getSpeed());
		shooterRight.set(speed);
		System.out.println("Right shooter: " + shooterRight.getSpeed());
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

