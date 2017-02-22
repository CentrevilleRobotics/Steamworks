package org.usfirst.frc.team5243.robot.subsystems;


import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    //declares motor CANTalon as shooter
	CANTalon shooter;
	Victor agitator;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//initializes shooter
    public ShootingSubsystem(boolean leftShooter){
    	if(leftShooter){
    		shooter = new CANTalon(RobotMap.shooterLeft);
    		agitator = new Victor(RobotMap.agitatorLeft);
    	} else {
    		shooter = new CANTalon(RobotMap.shooterRight);
    		shooter.setInverted(true);
    		agitator = new Victor(RobotMap.agitatorRight);
    	}
	}
	
    //sets speed for shooter
	public void shoot(double speed){
		shooter.set(speed);
		//System.out.println("shooter: " + shooter.getSpeed());
	}
	
	public void setAgitator(double speed) {
		agitator.set(speed);
	}
	
	//returns speed of shooter
	public double getShooterSpeed(){
		return shooter.getSpeed();
	}
	
	public double getAgitatorSpeed() {
		return agitator.getSpeed();
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

