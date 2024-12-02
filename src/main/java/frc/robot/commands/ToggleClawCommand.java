package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawSubsystem;

public class ToggleClawCommand extends Command {
  private final ClawSubsystem clawSubsystem;

  public ToggleClawCommand(ClawSubsystem subsystem) {
    this.clawSubsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    // Toggle the claw state
    if (clawSubsystem.ClawValue()) {
      clawSubsystem.closeClaw();
    } else {
      clawSubsystem.openClaw();
    }
  }

  @Override
  public boolean isFinished() {
    return true; // Command finishes immediately after execution
  }
}