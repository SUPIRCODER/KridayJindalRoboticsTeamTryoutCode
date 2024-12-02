// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeIOTalon implements IntakeIO {
    private WPI_TalonSRX motor;
    private ColorSensor colorSensor;

    public IntakeIOTalon(int motorPort, ColorSensor c) {
        motor = new WPI_TalonSRX(motorPort); //no defined motor port given
        colorSensor = c;
    }

    @Override
    public void setPower(double power) {
        motor.set(power);
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.gamePieceDetected = isGamePieceDetected();
    }

    @Override
    public boolean isGamePieceDetected() {
        return colorSensor.detectsGamePiece();
    }
}

