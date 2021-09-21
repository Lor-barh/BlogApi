package com.blog.controller;

import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/post/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("createPost")
    public Post createPost(@RequestBody Post post, HttpSession session){
        return postService.createPost(post, session);
    }

    @GetMapping("getAllPost")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("getPost/{username}")
    public List <Post> getAllUserComments(@PathVariable("username") String userName){
        return postService.getAllUserPosts(userName);
    }
}
