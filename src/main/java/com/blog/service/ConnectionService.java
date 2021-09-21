package com.blog.service;

import com.blog.model.Connection;

import javax.servlet.http.HttpSession;

public interface ConnectionService {

    Connection saveConnection(Connection connection, String username, HttpSession session);
}
