package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    Victor frontLeft;
    Victor backLeft;
    Victor frontRight;
    Victor backRight;
    RobotDrive robotdrive;
    Joystick left;
    Joystick right;
    
    public DriveSubsystem(Joystick leftStick, Joystick rightStick){
    	frontLeft = new Victor(RobotMap.frontLeft);
    	frontRight = new Victor(RobotMap.frontRight);
    	backLeft = new Victor(RobotMap.backLeft);
    	backRight = new Victor(RobotMap.backRight);
    	robotdrive = new RobotDrive(backLeft, frontLeft, backRight, frontRight);
    	left = leftStick;
    	right = rightStick;
    	
    }
    public void tankDrive(){
    	robotdrive.tankDrive(left, right);
    }
    
    public void turn(double y){
    	frontLeft.set(-y);
    	frontRight.set(y);
    	backLeft.set(-y);
    	backRight.set(y);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    public void stop(){
    	robotdrive.drive(0, 0);
    }
    public Victor getFrontLeft(){
    	return frontLeft;
    }
}

