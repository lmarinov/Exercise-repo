package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    public static final int ATTACK = 10;
    public static final int DURABILITY = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){
        this.axe = createAxe(ATTACK, DURABILITY);
        this.dummy = createDummy();
    }

    @Test
    public void testAxeConstructorShouldSetCorrectAttackAndDurability(){
        // 1A -> arrange

        // 2A -> Act
        Axe axe = createAxe(ATTACK, DURABILITY);

        // 3A -> Assert
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(ATTACK, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackShouldFailIfAxeHasZeroDurability(){
        Axe axe = createAxe(ATTACK, 0);
        axe.attack(dummy);
    }

    @Test
    public void testAxeLosesSingleDurabilityPointWhenAttackingDummy(){
        axe.attack(dummy);
        assertEquals(DURABILITY, axe.getDurabilityPoints() + 1);
    }

    private Axe createAxe(int attack, int durability){
        return new Axe(attack, durability);
    }

    private Dummy createDummy(){
        return new Dummy(100, 100);
    }
}