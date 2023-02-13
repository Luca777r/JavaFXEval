package com.evaluation.evalJavaFx.repositories;

import com.evaluation.evalJavaFx.models.LocalUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<LocalUser> getUsers() {

        List<LocalUser> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            File ressourceJson  = new ClassPathResource("users.json").getFile();
            users = mapper.readValue(
                    ressourceJson,
                    new TypeReference<List<LocalUser>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(LocalUser user) {

        ObjectMapper mapper = new ObjectMapper();
        List<LocalUser> existingUsers = this.getUsers();

        existingUsers.add(user);

        try {
            File newFile = new File("src/main/resources/users.json");
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(existingUsers);
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
