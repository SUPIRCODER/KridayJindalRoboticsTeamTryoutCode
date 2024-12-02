// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems.Intake;


public interface IntakeIO {
    void setPower(double power);
    void updateInputs(IntakeIOInputs inputs); 
    boolean isGamePieceDetected(); 

    class IntakeIOInputs {
        public boolean gamePieceDetected = false; 
    }
}
