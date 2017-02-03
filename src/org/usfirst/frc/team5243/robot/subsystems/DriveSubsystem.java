package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.MecanumDrive;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSubsystem extends Subsystem {

	CANTalon frontLeft;
    CANTalon backLeft;
    CANTalon frontRight;
    CANTalon backRight;
    RobotDrive robotDrive;
    ADXRS450_Gyro gyro;
    
    MecanumDrive mecanumDrive;
    TankDrive tankDrive;
    
    public DriveSubsystem(){
    	frontLeft = new CANTalon(RobotMap.frontLeft);
    	frontRight = new CANTalon(RobotMap.frontRight);
    	backLeft = new CANTalon(RobotMap.backLeft);
    	backRight = new CANTalon(RobotMap.backRight);
    	robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	robotDrive.setSafetyEnabled(false);
		gyro = new ADXRS450_Gyro();
		
		frontRight.setInverted(true);
    	backRight.setInverted(true);
    	frontLeft.setInverted(false);
    	backLeft.setInverted(false);
    }
    public void commandInitializer(){
		mecanumDrive = new MecanumDrive();
		tankDrive = new TankDrive();
    }
    public void calibrateGyro() {
    	gyro.calibrate();
    }
    
    public void tankDrive(){ // tank drive
    	robotDrive.tankDrive(-Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getY());
    }

    public void mecanumDrive(){ // mecanum drive
    	/*frontRight.setInverted(true);
    	backRight.setInverted(true);*/
        robotDrive.mecanumDrive_Cartesian(-Robot.oi.getLeftStick().getX(),Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getX(),gyro.getAngle());
    }
    
    public void turn(double y){
    	frontLeft.set(-y);
    	frontRight.set(y);
    	backLeft.set(-y);
    	backRight.set(y);
    }
    public void initDefaultCommand() {
       setDefaultCommand(mecanumDrive);
    }
    public void changeDefaultCommand() {
    	if(RobotMap.MecanumDrive){
    		setDefaultCommand(mecanumDrive);
    		System.out.println("Changed to Mecanum Drive");
    	}else{
    		setDefaultCommand(tankDrive);
    		System.out.println("Changed to tank drive");
    	}
    }
    public void stop(){
    	robotDrive.drive(0, 0);
    }
}

















