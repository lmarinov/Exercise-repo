package Abstraction.Exercise.P06MilitaryElite;

import Abstraction.Exercise.P06MilitaryElite.interfaces.*;
import Abstraction.Exercise.P06MilitaryElite.modules.*;
import Abstraction.Exercise.P06MilitaryElite.modules.CommandoImpl.Mission;
import Abstraction.Exercise.P06MilitaryElite.modules.EngineerImpl.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiers = new ArrayList<>();

        String line = "";

        while (!"End".equals(line = bufferedReader.readLine())) {
            Soldier currentSoldier = null;
            String[] tokens = line.split("\\s+");
            String soldierType = tokens[0].substring(0, 1);
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;
            String corp;


            try {
                switch (soldierType) {
                    case "P":
                        salary = Double.parseDouble(tokens[4]);
                        currentSoldier = new PrivateImpl(id, firstName, lastName, salary);
                        break;
                    case "L":
                        salary = Double.parseDouble(tokens[4]);
                        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                        for (int i = 5; i < tokens.length; i++) {
                            for (Soldier soldier : soldiers) {
                                if (soldier.getId() == Integer.parseInt(tokens[i])) {
                                    lieutenantGeneral.addPrivate((Private) soldier);
                                }
                            }
                        }

                        currentSoldier = lieutenantGeneral;

                        break;
                    case "C":
                        salary = Double.parseDouble(tokens[4]);
                        corp = tokens[5];

                        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corp);

                        for (int i = 6; i < tokens.length; i+=2) {
                            String codeName = tokens[i];
                            String state = tokens[i + 1];

                            try {
                                commando.addMission(new Mission(codeName, state));
                            } catch (IllegalStateException ignored) {
                            }
                        }

                        currentSoldier = commando;
                        break;
                    case "E":
                        salary = Double.parseDouble(tokens[4]);
                        corp = tokens[5];

                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corp);

                        for (int i = 6; i < tokens.length; i+=2) {
                            String partName = tokens[i];
                            int hoursWorked = Integer.parseInt(tokens[i + 1]);
                            engineer.addRepair(new Repair(partName, hoursWorked));
                        }

                        currentSoldier = engineer;

                        break;
                    case "S":
                        String codeNumber = tokens[4];

                        currentSoldier = new SpyImpl(id, firstName, lastName, codeNumber);
                        break;
                }
            } catch (IllegalStateException ignored) {
            }

            if (currentSoldier != null) {
                soldiers.add(currentSoldier);
            }
        }

        soldiers.forEach(System.out::println);

    }
}
