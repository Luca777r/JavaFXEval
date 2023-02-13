package com.evaluation.evalJavaFx.services;

import com.evaluation.evalJavaFx.dtos.MessageDTO;
import com.evaluation.evalJavaFx.models.Category;
import com.evaluation.evalJavaFx.models.LocalUser;
import com.evaluation.evalJavaFx.models.Message;
import com.evaluation.evalJavaFx.repositories.CategoryRepository;
import com.evaluation.evalJavaFx.repositories.UserRepository;
import com.evaluation.evalJavaFx.repositories.messageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private static UserRepository userRepository;
    private static CategoryRepository categoryRepository;

    public MessageService(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public static List<MessageDTO> getMessagesByName(String username) {
        List<Message> messages = messageRepository.getMessages();
        List<MessageDTO> messagesForUser = new ArrayList<>();
        LocalUser user = userRepository.getUserByUsername(username);
        List<Category> categoryList = CategoryRepository.getCategories();

        for (Message message : messages) {
            for (Integer id : user.getCategoryList()) {
                if (message.getCategoryId() == id) {
                    messagesForUser.add(new MessageDTO(message.getContent(), message.getCategoryId()));
                }
            }
        }
        return messagesForUser;
    }
}
