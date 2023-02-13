package com.evaluation.evalJavaFx.repositories;

import com.evaluation.evalJavaFx.models.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class messageRepository {
    public static List<Message> getMessages() {

        List<Message> messages = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            File ressourceJson  = new ClassPathResource("messages.json").getFile();
            messages = mapper.readValue(
                    ressourceJson,
                    new TypeReference<List<Message>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
