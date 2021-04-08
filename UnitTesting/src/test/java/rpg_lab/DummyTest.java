package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 13;
    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() throws Exception {
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked(){
        int attack = 5;
        aliveDummy.takeAttack(attack);
        assertEquals(HEALTH - attack, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyFailsWhenAttacked(){
        deadDummy.takeAttack(5);
    }

    @Test
    public void testDeadDummyGivesExperience(){
        int actualExperience = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actualExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveExperience(){
        aliveDummy.giveExperience();
    }
}