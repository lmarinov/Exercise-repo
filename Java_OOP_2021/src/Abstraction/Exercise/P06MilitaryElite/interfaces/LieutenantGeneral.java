package Abstraction.Exercise.P06MilitaryElite.interfaces;

import Abstraction.Exercise.P06MilitaryElite.modules.PrivateImpl;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public interface LieutenantGeneral extends Private{
    TreeSet<Private> getListOfPrivatesUnderCommand();
    void addPrivate(Private priv);
}
