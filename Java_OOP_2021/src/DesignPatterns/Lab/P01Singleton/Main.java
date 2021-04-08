package DesignPatterns.Lab.P01Singleton;

public class Main {
    static {
        SingletonContainer.init();
    }
    public static void main(String[] args) {
//       Address address = Address.Builder
//               .get()
//               .withLastName("Pehso")
//               .withEmail("Peshev")
//               .withPhone("9182312321")
//               .withCity("Sofia")
//               .withCountry("Bulgaria")
//               .withLine1("ul. Tintiava 12")
//               .withPostalCode("1000")
//               .build();
//
//       Datastore datastore = SingletonContainer.getDatastore();
//       datastore.createAddress("1242", address);
//       updateUserAddress();

        registerCommands();
        Engine engine = SingletonContainer.getEngine();
        engine.run();
    }

    private static void registerCommands() {
        CommandRepository commands = SingletonContainer.getCommandRepository();
        commands.register("Create", new CreateAddress());
        commands.register("Update", new UpdateCommand());
        commands.register("Get", new GetAddress());
        commands.register("End", new EndCommand());
    }

    private static void updateUserAddress() {
        Datastore datastore = SingletonContainer.getDatastore();
        Address address = datastore.getUserAddress("1242").clone();
        System.out.println(address);

        address.setCountry("Germany");
    }
}
