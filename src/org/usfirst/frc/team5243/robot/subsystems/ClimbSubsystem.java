package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
    
	private CANTalon minicim;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public ClimbSubsystem(){
		minicim = new CANTalon(RobotMap.minicim);
	}
	public void setSpeed(double speed){
		minicim.set(speed);
	}
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

