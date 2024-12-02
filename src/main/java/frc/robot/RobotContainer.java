// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.AutonCommand;
import frc.robot.commands.RunIntake;
import frc.robot.commands.ToggleClawCommand;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Intake.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ColorSensor colorSensor1 = new ColorSensor(null);
  private ArcadeDriveSubsystem driveSubsystem = new ArcadeDriveSubsystem();
  private final ClawSubsystem clawSubsystem = new ClawSubsystem();
  private Joystick robotcontroller = new Joystick(0);
  private IntakeSubsystem intake = new IntakeSubsystem(null);
  private JoystickButton bButton = new JoystickButton(robotcontroller, 2);
  // assuming port is 0.
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    intake = new IntakeSubsystem(new IntakeIOSparkMax(1,colorSensor1));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, () -> robotcontroller.getRawAxis(1),
        () -> robotcontroller.getRawAxis(2)));
        bButton.toggleOnTrue(new ToggleClawCommand(clawSubsystem));
    // assumes left joystick axis is 1
    // assumes right joystick axis is 2
    CommandScheduler.getInstance().setDefaultCommand(
            intake,
            new RunIntake(intake, 0.5) // Run intake forward
        );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutonCommand(driveSubsystem);
  }
}
