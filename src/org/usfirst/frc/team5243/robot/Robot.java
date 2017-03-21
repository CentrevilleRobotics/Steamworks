package org.usfirst.frc.team5243.robot;
import org.usfirst.frc.team5243.robot.commands.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.autonomous.DriveToBaseline;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionBlueHopper;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedBoiler;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedCenter;
import org.usfirst.frc.team5243.robot.commands.autonomous.vision.VisionRedHopper;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.ClimbingSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem driveSubsystem;
	public static SensorSubsystem sensorSubsystem;
	public static GearSubsystem gearSubsystem;
	public static VisionSubsystem visionSubsystem;
	public static ClimbingSubsystem loadingSubsystem;
	
	Command autonomousCommand;
	SendableChooser<Boolean> useVision;
	SendableChooser<String> redBlue;
	SendableChooser<String> autonPosition;
	SendableChooser<Command> autoChooser;
//	private boolean useVisionAutons = true;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		oi = new OI();
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.calibrateGyro();
		driveSubsystem.commandInitializer();

		sensorSubsystem = new SensorSubsystem();
		gearSubsystem = new GearSubsystem();
		
		try{
			visionSubsystem = new VisionSubsystem();
		}catch(Exception ex){
			ex.printStackTrace(); 
			//useVisionAutons = false;
		}
		loadingSubsystem = new ClimbingSubsystem();
		oi.init();
		
		autoChooser = new SendableChooser<Command>();
		initAutonChoosers();
		
		updateSmartDashboard();
		//CameraServer.getInstance().startAutomaticCapture("cam0", 0); // May cause problems
	}
	public void updateSmartDashboard(){
		SmartDashboard.putNumber("Front Ultrasonic ", sensorSubsystem.getUltrasonicFrontValue());
		SmartDashboard.putNumber("Back Ultrasonic ", sensorSubsystem.getUltrasonicBackValue());
		
		SmartDashboard.putNumber("Front Left Motor ", driveSubsystem.getFrontLeftSpeed());
		SmartDashboard.putNumber("Back Left Motor ", driveSubsystem.getBackLeftSpeed());
		SmartDashboard.putNumber("Front Right Motor ", driveSubsystem.getFrontRightSpeed());
		SmartDashboard.putNumber("Back Right Motor ", driveSubsystem.getBackRightSpeed());
		
		
		SmartDashboard.putNumber("Lift/Climb Speed ", loadingSubsystem.getClimbSpeed());
		
		SmartDashboard.putNumber("Front Offset X ", visionSubsystem.getFrontOffsetX());
		SmartDashboard.putNumber("Front Offset Y ", visionSubsystem.getFrontOffsetY());
		SmartDashboard.putNumber("Rear Offset X ", visionSubsystem.getRearOffsetX());
		SmartDashboard.putNumber("Rear Offset Y ", visionSubsystem.getRearOffsetY());	
	}
	public void initAutonChoosers(){
		useVision = new SendableChooser<>();
		redBlue = new SendableChooser<>();
		autonPosition = new SendableChooser<>();
		
		useVision.addDefault("No Vision", false);
		useVision.addObject("Use Vision", true);
		
		redBlue.addDefault("Red Alliance", "Red alliance");
		redBlue.addDefault("Blue Alliance" , "Blue alliance");
		
		autonPosition.addDefault("CenterPosition", "Center position");
		autonPosition.addDefault("BoilerPosition", "Boiler position");
		autonPosition.addDefault("HopperPosition", "Hopper position");
		
		SmartDashboard.putData("Autonomous Chooser", autonPosition);
		SmartDashboard.putData("Vision Chooser", useVision);
		SmartDashboard.putData("RedBlueChooser", redBlue);
		
		autoChooser.addDefault("DriveStraight", new DriveStraight(true,true,10));

		autoChooser.addObject("VisionRedCenter", new VisionRedCenter());
		autoChooser.addObject("VisionRedCenter", new VisionRedBoiler());
		autoChooser.addObject("VisionRedCenter", new VisionRedHopper());
		autoChooser.addObject("VisionCenter", new VisionBlueCenter());
		autoChooser.addObject("VisionCenter", new VisionBlueHopper());
		autoChooser.addObject("VisionCenter", new VisionBlueBoiler());
		
	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousInit() {
		//gearSubsystem.closeDoor();
		/*if(useVision.getSelected()){
			if(redBlue.getSelected().equals("Red alliance")){
				if(autonPosition.getSelected().equals("Center position")){
					autonomousCommand = new VisionRedCenter();
				}else if(autonPosition.getSelected().equals("Boiler position")){
					autonomousCommand = new VisionRedBoiler();
				}else{
					autonomousCommand = new VisionRedHopper();
				}
			}else{
				if(autonPosition.getSelected().equals("Center position")){
					autonomousCommand = new VisionBlueCenter();
				}else if(autonPosition.getSelected().equals("Boiler position")){
					autonomousCommand = new VisionBlueBoiler();
				}else{
					autonomousCommand = new VisionBlueHopper();
				}
			}
		}else{
			if(redBlue.getSelected().equals("Red alliance")){
				if(autonPosition.getSelected().equals("Center position")){
					autonomousCommand = new RedCenter();
				}else if(autonPosition.getSelected().equals("Boiler position")){
					autonomousCommand = new RedBoiler();
				}else{
					autonomousCommand = new RedHopper();
				}
			}else{
				if(autonPosition.getSelected().equals("Center position")){
					autonomousCommand = new BlueCenter();
				}else if(autonPosition.getSelected().equals("Boiler position")){
					autonomousCommand = new BlueBoiler();
				}else{
					autonomousCommand = new BlueHopper();
				}
			}
		}*/
		if(autonomousCommand == null) autonomousCommand = new DriveToBaseline();
        autonomousCommand.start();
        
    }
	
    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		//System.out.println(sensorSubsystem.getUltrasonicFrontValue());
		//updateSmartDashboard();
        
    }

    public void teleopInit() {
    	if (autonomousCommand != null) autonomousCommand.cancel();
    	gearSubsystem.enableCompressor();
    	gearSubsystem.retractPiston();
    }
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}
	
    /**
     * This function is called periodically during test mode
     */
	
    public void testPeriodic() {
        LiveWindow.run();
    }
}
