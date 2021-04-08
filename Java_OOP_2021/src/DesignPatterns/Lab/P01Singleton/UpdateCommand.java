package DesignPatterns.Lab.P01Singleton;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateCommand implements Command {
    private Datastore datastore;

    public UpdateCommand() {
        datastore = SingletonContainer.getDatastore();
    }

    @Override
    public String execute(String info) {
        List<String> params = Arrays.stream(info.split(". "))
                .map(str -> str.equals("null") ? "" : str)
                .collect(Collectors.toList());

        Address address = new Address()
                .setFirstName(params.get(0))
                .setLastName(params.get(1))
                .setEmail(params.get(2))
                .setPhone(params.get(3))
                .setCity(params.get(4))
                .setCountry(params.get(5))
                .setState(params.get(6))
                .setLine1(params.get(7))
                .setLine2(params.get(8))
                .setPostalCode(params.get(9));

        datastore.updateAddress(address.getFirstName(), address);

        return "Updated address for " + address.getFirstName() + " " + address;
    }
}
