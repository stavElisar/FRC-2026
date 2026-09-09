// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Subsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeShoulder extends SubsystemBase {
  private TalonFX shoulder;

  



  /** Creates a new IntakeShould. */
  public IntakeShoulder() {
    shoulder = new TalonFX(Constants.INTAKE_CONSTANTS.SHOULDER_INTAKE_MOTOR);
    
  
  }
  
  public Command setSpeed(double speed){
        return new RunCommand(() -> shoulder.set(speed),this);
  }
  
  public Command setPosition(double ticks){
        return new RunCommand(() -> shoulder.setPosition(ticks),this);

  
  }

  
  

  
 

  


  // public void goToTarget(int target) {
  //   shoulder.setPosition(target);
  // }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
