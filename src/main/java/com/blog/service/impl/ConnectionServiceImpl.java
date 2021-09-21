package com.blog.service.impl;

import com.blog.model.Connection;
import com.blog.model.User;
import com.blog.repository.ConnectionRepository;
import com.blog.repository.UserRepository;
import com.blog.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Connection saveConnection(Connection connection, String username, HttpSession session) {
        Optional <User> user = userRepository.findById(connection.getUser().getUserId());
        User user1 = new User();
        User userSession;
        if (user.isPresent()){
            user1 = user.get();
            System.out.println("--------->user = " + user1.getUsername());
        }
        userSession = (User) session.getAttribute(user1.getUsername());
        if (userSession != null){
            connection.setUser(user1);
            User connectedUser = new User();
            Optional <User> findingconnectedUser = userRepository.findByUsername(username);
            if (findingconnectedUser.isPresent() &&
                    !findingconnectedUser.get().getUsername().equals(user1.getUsername())){
                connectedUser = findingconnectedUser.get();
                System.out.println(connectedUser.getUsername());
                connectionRepository.save(connection);
                Optional<Connection> newConnection = connectionRepository.findById(connection.getConnectionId());
                System.out.println("--------connectedUser = " + newConnection.get().getUser().getUsername());
                newConnection.get().getConnections().add(connectedUser);
                System.out.println(connection.getUser().getUsername());
                return newConnection.get();
            }
            else throw new IllegalStateException("User not found");
        }
        else throw new IllegalStateException("You are not logged in");
    }
}
