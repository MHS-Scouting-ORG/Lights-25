// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Lights;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Lights redlightdistrict = new Lights();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);
      private final JoystickButton unicornBarf = new JoystickButton(m_driverController, XboxController.Button.kX.value);
      private final JoystickButton purpleStick = new JoystickButton(m_driverController, XboxController.Button.kA.value);
      private final JoystickButton bumblEbee = new JoystickButton(m_driverController, XboxController.Button.kY.value);
      private final JoystickButton blindhoe = new JoystickButton(m_driverController, XboxController.Button.kB.value);
      private final JoystickButton num_5 = new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value);
      private final JoystickButton num_6 = new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value);
      private final JoystickButton num_7 = new JoystickButton(m_driverController, XboxController.Button.kLeftStick.value);





  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
   
    unicornBarf.onTrue(new InstantCommand(() -> redlightdistrict.toggleIdleStatus()));
    purpleStick.onTrue(new InstantCommand(() -> redlightdistrict.algeaIntake()));
    bumblEbee.onTrue(new InstantCommand(() -> redlightdistrict.coralIntake()));
    blindhoe.onTrue(new InstantCommand(() -> redlightdistrict.off()));
    num_5.onTrue(new InstantCommand(() -> redlightdistrict.scored()));
    num_6.onTrue(new InstantCommand(() -> redlightdistrict.reefTracking()));
    num_7.onTrue(new InstantCommand(() -> redlightdistrict.processorTracking()));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}