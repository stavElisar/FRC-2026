package frc.Subsystem;

import static edu.wpi.first.units.Units.Degrees;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hood extends SubsystemBase {
    private TalonFX rightHood; 
    private TalonFX leftHood;

    public Hood() {
        rightHood = new TalonFX(Constants.HOOD_CONSTANTS.HOOD_RIGHT_ANGLE);
        leftHood = new TalonFX(Constants.HOOD_CONSTANTS.HOOD_LEFT_ANGLE);
    }

    public Command setRightHood(int angle) {
        return new RunCommand(() -> rightHood.setPosition(Degrees.of(angle)));
    }

    public Command setLeftHood(int angle) {
        return new RunCommand(() -> leftHood.setPosition(Degrees.of(angle)));
    }

   public Command setAllHoods(int angle) {
        return this.run(() -> {
            rightHood.setPosition(Degrees.of(angle));
            leftHood.setPosition(Degrees.of(angle));
        });
    }
   @Override
    public void periodic() {
    Logger.recordOutput("Hood/powerLeftMotor", leftHood.getSupplyCurrent().getValueAsDouble());
    Logger.recordOutput("Hood/powerRightMotor", rightHood.getSupplyCurrent().getValueAsDouble());
}
}

