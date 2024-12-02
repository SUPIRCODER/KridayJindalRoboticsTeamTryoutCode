// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Intake.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RunIntake extends Command {
    private final IntakeSubsystem intakeSubsystem;
    private final double power;

    /**
     * Creates a new RunIntake command.
     *
     * @param intakeSubsystem The intake subsystem that will be controlled.
     * @param power The power value to set for the intake motor. Positive for forward, negative for backward.
     */
    public RunIntake(IntakeSubsystem is, double power) {
        intakeSubsystem = is;
        this.power = power;

        // Declare subsystem dependencies
        addRequirements(intakeSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // You can log, reset, or perform any setup actions here if necessary
    }

    // Called repeatedly while the command is scheduled
    @Override
    public void execute() {
        intakeSubsystem.runIntake(power);
    }

    // Called once the command ends or is interrupted
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.runIntake(0); // Stop the intake motor when the command ends
    }

    // Returns true when the command should end (if applicable)
    @Override
    public boolean isFinished() {
        // The command could continue running until manually interrupted, so return false
        return false;
    }
}
