package org.usfirst.frc.team5243.robot.subsystems;


import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    //declares motor CANTalon as shooter
	CANTalon shooter;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//initializes shooter
    public ShootingSubsystem(boolean leftShooter){
    	if(leftShooter){
    		shooter = new CANTalon(RobotMap.shooterLeft);
    	} else {
    		shooter = new CANTalon(RobotMap.shooterRight);
    		shooter.setInverted(true);
    	}
	}
	
    //sets speed for shooter
	public void shoot(double speed){
		shooter.set(speed);
		//System.out.println("shooter: " + shooter.getSpeed());

	}
	
	//returns speed of shooter
	public double getSpeed(){
		return shooter.getSpeed();
	}
	
    public void initDefaultCommand() {
    }
}

