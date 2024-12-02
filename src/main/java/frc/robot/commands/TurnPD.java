//created because turn 180 degrees with hard coding is bad
//encoders can also be used to turn, but I chose to use proportional
//and derivative to turn
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDriveSubsystem;

public class TurnPD extends Command {
  private ArcadeDriveSubsystem arcadeDrive;
  private double targetAngle;

  private final double kP = 1.3;
  private final double kD = 0.4;

  private double previousError = 0;

  public TurnPD(ArcadeDriveSubsystem aD, double a) {
    arcadeDrive = aD;
    targetAngle = a;

    addRequirements(arcadeDrive);
  }

  @Override
  public void initialize() {
    arcadeDrive.resetGyro();
  }
  @Override
  public void execute() {
    double currentAngle = arcadeDrive.getGyroAngle(); 
    double error = targetAngle - currentAngle; 
    double derivative = error - previousError; 

    double correction = (error * kP) + (derivative * kD);

    arcadeDrive.setArcadeSpeeds(0, correction); 

    previousError = error; 
  }

  @Override
  public boolean isFinished() {
    return Math.abs(targetAngle - arcadeDrive.getGyroAngle()) < 0.5;
  }

  @Override
  public void end(boolean interrupted) {
    arcadeDrive.stopMotors();// Stop motors when done
  }
}
