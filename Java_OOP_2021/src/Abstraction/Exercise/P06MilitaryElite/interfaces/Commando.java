package Abstraction.Exercise.P06MilitaryElite.interfaces;

import Abstraction.Exercise.P06MilitaryElite.modules.CommandoImpl;

import java.util.LinkedHashSet;

public interface Commando extends SpecialisedSoldier{
    void addMission(CommandoImpl.Mission mission);
    LinkedHashSet<CommandoImpl.Mission> getMissions();
}
