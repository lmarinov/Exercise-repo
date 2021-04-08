package Inheritance.Exercise.P03PlayersAndMonsters.hero;

public class Main {
    public static void main(String[] args) {
        MuseElf museElf = new MuseElf("MuseElf", 15);
        SoulMaster soulMaster = new SoulMaster("SoulMaster", 22);
        BladeKnight bladeKnight = new BladeKnight("BladeMaster", 31);

        System.out.println(museElf);
        System.out.println(soulMaster);
        System.out.println(bladeKnight);
    }
}
