package Abstraction.Exercise.P06MilitaryElite.interfaces;

import Abstraction.Exercise.P06MilitaryElite.modules.EngineerImpl;

import java.util.LinkedHashSet;

public interface Engineer extends SpecialisedSoldier{
    LinkedHashSet<EngineerImpl.Repair> getRepairs();
    void addRepair(EngineerImpl.Repair repair);
}
