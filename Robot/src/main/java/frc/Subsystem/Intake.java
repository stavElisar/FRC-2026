package frc.Subsystem;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private TalonFX mastake;
  private TalonFX inslave; 
  
  /** Creates a new Intake. */
  public Intake() {
    mastake = new TalonFX(25);
    inslave = new TalonFX(23);

    inslave.setControl(new Follower(mastake.getDeviceID(), MotorAlignmentValue.Opposed));
  }
 
  
  public Command spintake(double power) {
    return new RunCommand(() -> mastake.set(power), this);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
