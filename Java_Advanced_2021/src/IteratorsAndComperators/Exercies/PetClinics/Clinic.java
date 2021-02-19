package IteratorsAndComperators.Exercies.PetClinics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Clinic implements Iterable<Pet> {
    private Pet[] pets;

    public Clinic(int roomCount) {
        validate(roomCount);
    }

    private void validate(int roomCount) {
        if (roomCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.pets = new Pet[roomCount];
    }

    public Pet[] getPets() {
        return pets;
    }

    public boolean hasEmptyRooms() {
        return Arrays.stream(this.pets).anyMatch(Objects::isNull);
    }

    public void print(int room) {
        System.out.println(this.pets[room - 1] == null
                ? "Room empty"
                : pets[room - 1].toString());
    }


    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public boolean addPet(Pet pet) {
        int room = this.pets.length / 2;
        for (int i = 0; i < this.pets.length; i++) {
            if (i % 2 == 0) {
                room += i;
            } else {
                room -= i;
            }
            if (this.pets[room] == null) {
                this.pets[room] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int start = this.pets.length / 2;
        {
            int i = start;
            while (i < this.pets.length) {
                if (this.pets[i] != null) {
                    this.pets[i] = null;
                    return true;
                }
                i++;
            }
        }
        int i = 0;
        while (i < start) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
            i++;
        }
        return false;
    }
}
