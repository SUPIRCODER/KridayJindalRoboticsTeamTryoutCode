// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;
import frc.robot.subsystems.Intake.IntakeIO;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private IntakeIO io;
    private IntakeIO.IntakeIOInputs inputs = new IntakeIO.IntakeIOInputs();

    public IntakeSubsystem(IntakeIO inputoutput) {
        io = inputoutput;
    }

    public void runIntake(double power) {
        io.setPower(power);
    }
    public boolean isGamePieceDetected() {
        return inputs.gamePieceDetected;
    }

    public void periodic() {
        io.updateInputs(inputs);

        Logger.recordOutput("Intake/GamePieceDetected", inputs.gamePieceDetected);
    }
}


