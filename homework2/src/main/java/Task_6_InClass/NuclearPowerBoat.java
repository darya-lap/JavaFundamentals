package Task_6_InClass;

@Boat(nameOfBoat = "Dmitry Donskoi", leader = "Petrov V.V.", isSailing = true)

public class NuclearPowerBoat {
    private EngineOfNuclearPowerBoat engine;

    NuclearPowerBoat(){
        engine = new EngineOfNuclearPowerBoat();
    }

    public EngineOfNuclearPowerBoat getEngine(){
        return engine;
    }

    class EngineOfNuclearPowerBoat{
        boolean run;
        EngineOfNuclearPowerBoat(){
            run = false;
        }
        public void startRun(){
            run = true;
        }
        public boolean isRun(){
            return run;
        }
    }
}
