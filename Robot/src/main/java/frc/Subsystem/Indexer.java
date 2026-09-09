package frc.Subsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {

   private TalonFX dorito; 
    private TalonFX roller;
    private TalonFX upper; 
 
   
    public Indexer() {
        dorito = new TalonFX(13);
        roller = new TalonFX(18);
        upper = new TalonFX(17);

    }

    public Command runMotor(double power) {
        return new RunCommand(() -> dorito.set(power), this);

    }

    public Command runRoller(double power) {
        return new RunCommand(() -> roller.set(power), this);
    }

    public Command runUpper(double power) {
        return new RunCommand(() -> upper.set(power), this);
    }

    public Command setAllIndexer(double power) {
        return new ParallelCommandGroup(
            new RunCommand(() -> dorito.set(power)),
            new RunCommand(() -> upper.set(power)),
            new RunCommand(() -> roller.set(power))
        );
    }

    

}