// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

public class IntakeIOSim implements IntakeIO {
    private boolean gamePieceDetected = false;
    private double currentPower = 0.0;

    @Override
    public void setPower(double power) {
        currentPower = power;
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.gamePieceDetected = gamePieceDetected;
    }

    @Override
    public boolean isGamePieceDetected() {
        return gamePieceDetected;
    }
}