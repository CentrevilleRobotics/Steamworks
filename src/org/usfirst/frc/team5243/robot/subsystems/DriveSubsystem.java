package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.MecanumDrive;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
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
    ADXRS450_Gyro gyro;
    
    public DriveSubsystem(Joystick leftStick, Joystick rightStick){
    	frontLeft = new Victor(RobotMap.frontLeft);
    	frontRight = new Victor(RobotMap.frontRight);
    	backLeft = new Victor(RobotMap.backLeft);
    	backRight = new Victor(RobotMap.backRight);
    	robotdrive = new RobotDrive(backLeft, frontLeft, backRight, frontRight);
    	left = leftStick;
    	right = rightStick;
		gyro = new ADXRS450_Gyro();
    }
    public void calibrateGyro() {
    	gyro.calibrate();
    }
    
    public void tankDrive(){ // tank drive
    	robotdrive.tankDrive(left, right);
    }

    public void mecanumDrive(){ // mecanum drive
        robotdrive.mecanumDrive_Cartesian(left.getX(),left.getY(),right.getX(),gyro.getAngle());
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
    	setDefaultCommand(new MecanumDrive());
    }
    public void changeDefaultCommand(Command command) {
    	setDefaultCommand(command);
    }
    public void stop(){
    	robotdrive.drive(0, 0);
    }
}

