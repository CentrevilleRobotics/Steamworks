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
    	frontLeft = new CANTalon(RobotMap.FrontLeft);
    	frontRight = new CANTalon(RobotMap.FrontRight);
    	backLeft = new CANTalon(RobotMap.BackLeft);
    	backRight = new CANTalon(RobotMap.BackRight);
    	robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	robotDrive.setSafetyEnabled(false);
		gyro = new ADXRS450_Gyro();
		
		frontRight.setVoltageRampRate(24);
    	backRight.setVoltageRampRate(24);
    	frontLeft.setVoltageRampRate(24);
    	backLeft.setVoltageRampRate(24);
		
		frontRight.setInverted(true);
    	backRight.setInverted(true);
    	frontLeft.setInverted(false);
    	backLeft.setInverted(false);
    	
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
    	System.out.println(mecanumDrive);
        robotDrive.mecanumDrive_Cartesian(-Robot.oi.getLeftStick().getX(),Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getX(),gyro.getAngle());
    }
    
    public void driveStraight(double distance) {
    	frontLeft.set(distance);
    	frontRight.set(distance);
    	backLeft.set(distance);
    	backRight.set(distance);
    }
    public void turn(double y){
    	frontLeft.set(-y);
    	frontRight.set(y);
    	backLeft.set(-y);
    	backRight.set(y);
    }
    public void turnLeft(double speed){
    	frontLeft.set(speed);
    	backLeft.set(speed);
    	frontRight.set(speed);
    	backRight.set(speed);    	
    }
    public void turnRight(double speed){
    	frontLeft.set(-speed);
    	backLeft.set(-speed);
    	frontRight.set(speed);
    	backRight.set(speed);
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
    public void driveBackwards(){
    	frontRight.set(-1);
    	frontLeft.set(-1);
    	backRight.set(-1);
    	backLeft.set(-1);
    }
    public RobotDrive getDrive() {
    	return robotDrive;
    }
    public void stop(){
    	robotDrive.drive(0, 0);
    }
    public CANTalon getFrontLeft(){
    	return frontLeft;
    }
    public CANTalon getBackLeft(){
    	return backLeft;    	
    }
    public CANTalon getFrontRight(){
    	return frontRight;    	
    }
    public CANTalon getBackRight(){
    	return backRight;
    }
}