package com.blog.service;

import com.blog.model.Favourite;

import javax.servlet.http.HttpSession;

public interface FavouriteService {

    Favourite saveFavourite(Long userId, Long postId, HttpSession httpSession);
}
