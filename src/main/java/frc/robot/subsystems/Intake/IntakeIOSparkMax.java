package frc.robot.subsystems.Intake;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeIOSparkMax implements IntakeIO {
    private CANSparkMax motor;
    private ColorSensor colorSensor;

    public IntakeIOSparkMax(int motorPort, ColorSensor c) { //no defined motor port given
        motor = new CANSparkMax(motorPort, MotorType.kBrushless);
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
