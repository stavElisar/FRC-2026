package frc.Subsystem;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private TalonFX master;
  private TalonFX slave; 
  
  /** Creates a new Intake. */
  public Intake() {
    master = new TalonFX(Constants.INTAKE_CONSTANTS.MASTER_INTAKE_MOTOR);
    slave = new TalonFX(Constants.INTAKE_CONSTANTS.SLAVE_INTAKE_MOTOR);

    slave.setControl(new Follower(master.getDeviceID(), MotorAlignmentValue.Opposed));
  }
 
  public Command spin(double power) {
    return new RunCommand(() -> master.set(power), this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
