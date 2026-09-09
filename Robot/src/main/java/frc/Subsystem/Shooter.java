package frc.Subsystem;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    private TalonFX rightMaster;
    private TalonFX rightSlave;
    private TalonFX leftMaster;
    private TalonFX leftSlave;

    public Shooter() {
        rightMaster = new TalonFX(Constants.SHOOTER_CONSTANTS.SHOOTER_RIGHT_MASTER);
        rightSlave = new TalonFX(Constants.SHOOTER_CONSTANTS.SHOOTER_RIGHT_SLAVE);

        leftMaster = new TalonFX(Constants.SHOOTER_CONSTANTS.SHOOTER_LEFT_MASTER);
        leftSlave = new TalonFX(Constants.SHOOTER_CONSTANTS.SHOOTER_LEFT_SLAVE);

        rightSlave.setControl(new Follower(rightMaster.getDeviceID(), MotorAlignmentValue.Opposed));
        leftSlave.setControl(new Follower(leftMaster.getDeviceID(), MotorAlignmentValue.Opposed));
    }

    public Command leftMaster( double speed) {
        return new RunCommand(() -> rightMaster.set(speed), this);
    }

    public Command rightMaster(double speed) {
        return new RunCommand(() -> leftMaster.set(speed), this);
    }

    public Command setAllShooter(double speed) {
        return run(() -> {
            rightMaster.set(speed);
            leftMaster.set(speed);
        });
    }
}

