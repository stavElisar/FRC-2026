package frc.robot;

public final class Constants {
    public static final class INTAKE_CONSTANTS {
        public static final int MASTER_INTAKE_MOTOR = 25;
        public static final int SLAVE_INTAKE_MOTOR = 23; 
        public static final int SHOULDER_INTAKE_MOTOR = 9;

        public static final double kP = 0.002;
        public static final double kI = 0.05;
        public static final double kD = 0.02;

        public static final double OPEN_POSE = -32;
        public static final double CLOSE_POSE = 0;
    }

    public static final class INDEXER_CONSTANTS{ 
        public static final int INDEXER_MOTOR_UPPER = 17;
        public static final int INDEXER_MOTOR_ROLLER = 18; 
        public static final int INDEXER_MOTOR_DORITO = 13;
    }

    public static final class SHOOTER_CONSTANTS{
        public static final int SHOOTER_LEFT_SLAVE = 11;
        public static final int SHOOTER_LEFT_MASTER = 12;
        public static final int SHOOTER_RIGHT_SLAVE = 15;
        public static final int SHOOTER_RIGHT_MASTER = 14;
    }

    public static final class HOOD_CONSTANTS{
        public static final int HOOD_LEFT_ANGLE = 16;
        public static final int HOOD_RIGHT_ANGLE = 10;
    }   
}
