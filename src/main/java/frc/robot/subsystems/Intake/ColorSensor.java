package frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensor {
    private final ColorSensor colorSensor;

    public ColorSensor(I2C.Port i2cPort) {
        colorSensor = new ColorSensor(i2cPort);
    }

    public boolean detectsGamePiece() {
        Color detectedColor = colorSensor.getColor(); // it's throwing an error, but I couldn't find much on the documentation
        double colorThreshold = 0.5;
        return detectedColor.red > colorThreshold;
    }
}
