package Task_6_InClass;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NuclearPowerBoatTest {

    @Test
    public void StartTest(){
        NuclearPowerBoat boat = new NuclearPowerBoat();
        boat.getEngine().startRun();
        assertEquals(boat.getEngine().isRun(), true);
    }
}
