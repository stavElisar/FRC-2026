package frc.Subsystem;

import java.lang.management.ThreadInfo;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
    private TalonFX dorito; 
    private TalonFX roller;
    private TalonFX upper; 
 
    public Indexer() {
        dorito = new TalonFX(Constants.INDEXER_CONSTANTS.INDEXER_MOTOR_DORITO);
        roller = new TalonFX(Constants.INDEXER_CONSTANTS.INDEXER_MOTOR_ROLLER);
        upper = new TalonFX(Constants.INDEXER_CONSTANTS.INDEXER_MOTOR_UPPER);
    }

    public Command runDorito(double power) {
        return new RunCommand(() -> dorito.set(power),this);
    }

    public Command runRoller(double power) {
        return new RunCommand(() -> roller.set(power),this);
    }

    public Command runUpper(double power) {
        return new RunCommand(() -> upper.set(power),this);
    }

    public Command setAllIndexer(double power) {
    return this.run(() -> {
        dorito.set(power);
        upper.set(power);
        roller.set(power);
        });
    }   
}