package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.MecanumDriveCommand;
import org.usfirst.frc.team5243.robot.commands.TankDriveCommand;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	//declares motors (CANTalons), gyro, 
	CANTalon frontLeft;
    CANTalon backLeft;
    CANTalon frontRight;
    CANTalon backRight;
    RobotDrive robotDrive;
    ADXRS450_Gyro gyro;
    
    MecanumDriveCommand mecanumDrive;
    TankDriveCommand tankDrive;
    
    //initializes motors(CANTalon), gyro,
    public DriveSubsystem(){
    	System.out.println("DriveSubsystem Constructor");
    	frontLeft = new CANTalon(RobotMap.FrontLeft);
    	frontRight = new CANTalon(RobotMap.FrontRight);
    	backLeft = new CANTalon(RobotMap.BackLeft);
    	backRight = new CANTalon(RobotMap.BackRight);
    	robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	robotDrive.setSafetyEnabled(false);
		gyro = new ADXRS450_Gyro();
		
		frontRight.setVoltageRampRate(12);
    	backRight.setVoltageRampRate(12);
    	frontLeft.setVoltageRampRate(12);
    	backLeft.setVoltageRampRate(12);
    	
		frontRight.setInverted(true);
    	backRight.setInverted(true);
    	frontLeft.setInverted(false);
    	backLeft.setInverted(false);
    	System.out.println("DriveSS Constructor ended");
    	
    	
    }
    public void resetGyro(){
    	gyro.reset();
    }
    //initializes command for mecanum drive & tank drive
    public void commandInitializer(){
		mecanumDrive = new MecanumDriveCommand();
		tankDrive = new TankDriveCommand();		
    }
    
    public void strafeRight(double speed) {
    	frontRight.set(-speed);
    	frontLeft.set(speed);
    	backLeft.set(-speed);
    	backRight.set(speed);
    }
    public void strafeLeft(double speed) {
    	strafeRight(-speed);
    }
    
    public void calibrateGyro() {
    	gyro.calibrate();
    }
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    public double getGyroRate(){
    	return gyro.getRate();
    }
    public void tankDrive(){ // tank drive
    	robotDrive.tankDrive(-Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getY());
    }
    public void mecanumDrive(){ // mecanum drive
    	/*frontRight.setInverted(true);
    	backRight.setInverted(true);*/
    	robotDrive.mecanumDrive_Cartesian(-Robot.oi.getLeftStick().getX(),Robot.oi.getLeftStick().getY(),Robot.oi.getLeftStick().getRawAxis(2) ,gyro.getAngle());
    }
    public void turnLeft(double speed){
    	frontLeft.set(-speed);
    	backLeft.set(-speed);
    	frontRight.set(speed);
    	backRight.set(speed);    	
    }
    public void turnRight(double speed){
    	frontLeft.set(speed);
    	backLeft.set(speed);
    	frontRight.set(-speed);
    	backRight.set(-speed);
    }
    public void setAllMotors(double speed){
    	frontLeft.set(speed);
    	frontRight.set(speed);
    	backLeft.set(speed);
    	backRight.set(speed);
    }
    public void initDefaultCommand() {
       setDefaultCommand(mecanumDrive);
    }
    public void changeDefaultCommand() {
    	if(getDefaultCommand().equals(mecanumDrive)) setDefaultCommand(tankDrive);
    	else setDefaultCommand(mecanumDrive);
    }
    public RobotDrive getDrive() {
    	return robotDrive;
    }
    public void stop(){
    	robotDrive.drive(0, 0);
    }
    public double getFrontLeftSpeed() {
    	return frontLeft.getSpeed();
    }
    public double getBackLeftSpeed() {
    	return backLeft.getSpeed();
    }
    public double getFrontRightSpeed() {
    	return frontRight.getSpeed();
    }
    public double getBackRightSpeed() {
    	return backRight.getSpeed();
    }
}
