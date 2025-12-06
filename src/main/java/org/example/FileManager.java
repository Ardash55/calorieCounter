package org.example;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import static org.example.CalorieApp.user;

public class FileManager {

    public void saveUser() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))){
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User loadUser() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            User u = (User) ois.readObject();
            u.initTransient();
            return u;
        } catch (Exception e) {
            return null;
        }
    }
}
