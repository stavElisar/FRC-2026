package frc.Subsystem;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.units.measure.Power;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private TalonFX RightMaster;
    private TalonFX RightSlave;
    private TalonFX LeftMaster;
    private TalonFX LeftSlave;




    public Shooter() {
        RightMaster = new TalonFX(14);
        RightSlave = new TalonFX(15);

        LeftMaster = new TalonFX(12);
        LeftSlave = new TalonFX(11);

        RightSlave.setControl(new Follower(RightMaster.getDeviceID(), MotorAlignmentValue.Opposed));
        LeftSlave.setControl(new Follower(LeftMaster.getDeviceID(), MotorAlignmentValue.Opposed));


    
}

    public Command leftMaster( double speed) {
        return new RunCommand(() -> RightMaster.set(speed), this);
    }

    public Command rightMaster(double speed) {
        return new RunCommand(() -> LeftMaster.set(speed), this);
    }


    public Command setAllShooter(double speed) {
        return run(() -> {
            RightMaster.set(speed);
            LeftMaster.set(speed);
        });

    }
}

