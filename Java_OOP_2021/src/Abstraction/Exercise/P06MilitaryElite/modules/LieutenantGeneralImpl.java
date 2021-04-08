package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.LieutenantGeneral;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Private;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Soldier;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral,Private, Soldier {
    private TreeSet<Private> listOfPrivatesUnderCommand;
    private static final TreeSet<Private> DEFAULT_LIST_OF_PRIVATES = new TreeSet<>((first, second) -> second.getId() - first.getId());

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.setListOfPrivatesUnderCommand();
    }

    private void setListOfPrivatesUnderCommand() {
        this.listOfPrivatesUnderCommand = LieutenantGeneralImpl.DEFAULT_LIST_OF_PRIVATES;
    }

    @Override
    public TreeSet<Private> getListOfPrivatesUnderCommand() {
        return this.listOfPrivatesUnderCommand;
    }

    @Override
    public void addPrivate(Private priv){
        this.listOfPrivatesUnderCommand.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        for (Private soldier : this.listOfPrivatesUnderCommand) {
            output.append("  ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
