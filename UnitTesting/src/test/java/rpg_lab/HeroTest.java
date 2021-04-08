package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

//    private static class TestWeapon implements Weapon{
//        @Override
//        public int getAttackPoints() {
//            return 0;
//        }
//
//        @Override
//        public int getDurabilityPoints() {
//            return 0;
//        }
//
//        @Override
//        public void attack(Target target) {
//
//        }
//    }
//
//    private static class TestTarget implements Target{
//
//        @Override
//        public int getHealth() {
//            return 0;
//        }
//
//        @Override
//        public void takeAttack(int attackPoints) {
//
//        }
//
//        @Override
//        public int giveExperience() {
//            return 13;
//        }
//
//        @Override
//        public boolean isDead() {
//            return false;
//        }
//    }



    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled(){
       Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("JavaWizard", weapon);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(13);

        hero.attack(target);
        assertEquals(13, hero.getExperience());
    }

}