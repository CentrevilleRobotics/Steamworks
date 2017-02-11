package org.usfirst.frc.team5243.robot.subsystems;


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
    public ShootingSubsystem(int shootingPort){
		shooter = new CANTalon(shootingPort);
	}
	
    //sets speed for shooter
	public void shoot(double speed){
		shooter.set(speed);
		System.out.println("shooter: " + shooter.getSpeed());

	}
	
	//returns speed of shooter
	public double getSpeed(){
		return shooter.getSpeed();
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

