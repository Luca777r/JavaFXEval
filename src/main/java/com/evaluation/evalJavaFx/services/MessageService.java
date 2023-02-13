package com.evaluation.evalJavaFx.services;

import com.evaluation.evalJavaFx.dtos.MessageDTO;
import com.evaluation.evalJavaFx.models.Category;
import com.evaluation.evalJavaFx.models.LocalUser;
import com.evaluation.evalJavaFx.models.Message;
import com.evaluation.evalJavaFx.repositories.UserRepository;
import com.evaluation.evalJavaFx.repositories.messageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private static UserRepository userRepository;

    public MessageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static List<MessageDTO> getMessages() {
        List<Message> messages = messageRepository.getMessages();
        List<MessageDTO> messageDTOS = new ArrayList<>();


        messages.forEach((message) -> messageDTOS.add(new MessageDTO(message.getContent(), message.getCategory())));

        return messageDTOS;
    }

    public static List<MessageDTO> getMessagesByName(String username) {
        List<Message> messages = messageRepository.getMessages();
        List<MessageDTO> messagesForUser = new ArrayList<>();
        LocalUser user = userRepository.getUserByUsername(username);

        for (Message message : messages) {
            for (Integer id : user.getCategoryList()) {
                if (message.getCategory().getId() == id) {
                    messagesForUser.add(new MessageDTO(message.getContent(), message.getCategory()));
                }
            }
        }
        return messagesForUser;
    }
}
