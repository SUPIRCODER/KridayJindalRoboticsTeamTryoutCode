package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

public class ClawSubsystem extends SubsystemBase {
  private final Solenoid clawSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  //assumes port 0 and is using Pneumtaics Module Type: CTREPCM
  private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

  public ClawSubsystem() {
    compressor.enableDigital();
  }

  public void openClaw() {
    clawSolenoid.set(true);
  }

  public void closeClaw() {
    clawSolenoid.set(false);
  }

  public boolean ClawValue() {
    return clawSolenoid.get();
  }
}
