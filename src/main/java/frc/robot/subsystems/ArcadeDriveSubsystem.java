// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;

import com.kauailabs.navx.frc.AHRS; //assuming the usage of NavX gyro
import com.revrobotics.*;

public class ArcadeDriveSubsystem extends SubsystemBase {
  private CANSparkMax rightLeader = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax rightFollower = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax leftLeader = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax leftFollower = new CANSparkMax(3, MotorType.kBrushless);
  private final AHRS gyro = new AHRS(SPI.Port.kMXP); //assuming the usage of NavX gyro
  public DifferentialDrive drive;
  //assume channel ports
  private Joystick robotcontroller = new Joystick(0);
  //assuming the controller port is 0.
  public ArcadeDriveSubsystem() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    leftLeader.restoreFactoryDefaults();
    rightLeader.restoreFactoryDefaults();
    leftFollower.restoreFactoryDefaults();
    rightFollower.restoreFactoryDefaults();
    leftLeader.setSafetyEnabled(true);
    leftLeader.setExpiration(.1);
    leftLeader.feed();
    
    leftFollower.setSafetyEnabled(true);
    leftFollower.setExpiration(.1);
    leftFollower.feed();
    
    rightLeader.setSafetyEnabled(true);
    rightLeader.setExpiration(.1);
    rightLeader.feed();
    
    rightFollower.setSafetyEnabled(true);
    rightFollower.setExpiration(.1);
    rightFollower.feed();
    leftLeader.addFollower(leftFollower);
    rightLeader.addFollower(rightFollower);
    rightLeader.setInverted(true);
    rightFollower.setInverted(true);
    drive = new DifferentialDrive(leftLeader, rightLeader);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadedrive(double leftpercent, double rightpercent){
    leftLeader.set(leftpercent);
    rightLeader.set(rightpercent);
  }
  public void setArcadeSpeeds(double forward, double turn) {
    double leftSpeed = forward + turn;
    double rightSpeed = forward - turn;

    leftLeader.set(leftSpeed);
    rightLeader.set(rightSpeed);
  }

  public void stopMotors() {
    rightLeader.stopMotor();
    leftLeader.stopMotor();
  }
  public double getGyroAngle() {
    return gyro.getAngle();
  }
  public void resetGyro() {
    gyro.reset(); // Reset the gyro angle
  }
}
