package DesignPatterns.Lab.P01Singleton;

public class GetAddress implements Command{
    private Datastore datastore;

    public GetAddress(){
        datastore = SingletonContainer.getDatastore();
    }

    @Override
    public String execute(String info) {
        return datastore.getUserAddress(info).toString();
    }
}
