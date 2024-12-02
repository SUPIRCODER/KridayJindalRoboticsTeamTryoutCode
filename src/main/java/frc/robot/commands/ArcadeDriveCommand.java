// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDriveSubsystem;

public class ArcadeDriveCommand extends Command {
  /** Creates a new ArcadeDriveCommand. */
  private ArcadeDriveSubsystem driveSubsystem;
  private DoubleSupplier ySup;
  private DoubleSupplier xSup;

  public ArcadeDriveCommand(ArcadeDriveSubsystem d, DoubleSupplier t, DoubleSupplier r){
    driveSubsystem = d;
    ySup = t;
    xSup = r;
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    driveSubsystem.arcadedrive(ySup.getAsDouble(),xSup.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
