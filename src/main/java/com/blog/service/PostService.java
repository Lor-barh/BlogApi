package com.blog.service;

import com.blog.model.Comment;
import com.blog.model.Post;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface PostService {

   Post createPost(Post post, HttpSession session);

   List<Post> getAllPost();

   List<Post> getAllUserPosts(String userName);
}
