package DesignPatterns.Lab.P01Singleton;

import java.util.HashMap;
import java.util.Map;

public class Datastore {
    private static class EntityExistsException extends RuntimeException{

    }
    private Map<String, Address> addresses;

    public Datastore() {
        this.addresses = new HashMap<>();
    }

    private static Datastore instance;

    public static Datastore getInstance(){
        if (instance == null){
            instance = new Datastore();
        }

        return instance;
    }

    public void createAddress(String userId, Address address){
        if (addresses.containsKey(userId)){
            throw new EntityExistsException();
        }
        addresses.put(userId, address);
    }

    public void updateAddress(String userId, Address address){
        if (!addresses.containsKey(userId)){
            addresses.put(userId, address);
        }
    }

    public Address getUserAddress(String id){
        return this.addresses.get(id);
    }
}
