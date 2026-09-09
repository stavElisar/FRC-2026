// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.Subsystem.Hood;
import frc.Subsystem.Indexer;
import frc.Subsystem.Intake;
import frc.Subsystem.IntakeShoulder;
import frc.Subsystem.Shooter;

public class RobotContainer {
  IntakeShoulder intakeShoulder;
  PS4Controller joystick;
  Indexer indexer;
  Shooter shooter;
  Intake intake; 
  Hood hood; 
  

  public RobotContainer() {
    
    intakeShoulder = new IntakeShoulder();
    joystick = new PS4Controller(1);
    indexer = new Indexer();
    shooter = new Shooter();
    intake = new Intake();
    hood = new Hood();

    intakeShoulder.setDefaultCommand(intakeShoulder.setPosition(Constants.INTAKE_CONSTANTS.OPEN_POSE));
    shooter.setDefaultCommand(shooter.setAllShooter(0));
    indexer.setDefaultCommand(indexer.setAllIndexer(0));
    hood.setDefaultCommand(hood.setAllHoods(0));
    configureBindings();
  }


  private void configureBindings() {
    new JoystickButton(joystick, 1).whileTrue(intake.spin(1));

    new JoystickButton(joystick, 2).whileTrue(intakeShoulder.setPosition(Constants.INTAKE_CONSTANTS.OPEN_POSE));
    new JoystickButton(joystick, 3).whileTrue(intakeShoulder.setPosition(Constants.INTAKE_CONSTANTS.CLOSE_POSE));
    
    new JoystickButton(joystick, 4).whileTrue(indexer.setAllIndexer(0.5));

    new JoystickButton(joystick, 5).whileTrue(shooter.setAllShooter(1));

    new JoystickButton(joystick, 6).whileTrue(hood.setAllHoods(15));
    // new JoystickButton(joystick, 5).whileTrue(indexer.runRoller(Constants.INDEXER_CONSTANTS.INDEXER_MOTOR_ROLLER));
    // new JoystickButton(joystick, 6).whileTrue(indexer.runUpper(Constants.INDEXER_CONSTANTS.INDEXER_MOTOR_UPPER));
  }

  public Command getAutonomousacCommand() {
    return Commands.print("No autonomous command configured");
  }
}
