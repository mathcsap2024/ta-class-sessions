package Tuesday.session3.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String relativePath = "src/Tuesday/session3/resources/users/";

    public void createUserFolderOnUserSignup(String username, String password) {
        File userFolder = new File(relativePath + username);
        if (!userFolder.mkdir()) return;
        File file = new File(relativePath + username + "/" + username + ".txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(username + ":" + password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
