package com.blog.repository;

import com.blog.model.Favourite;
import com.blog.model.Post;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    Favourite findFavouriteByPostAndUser(Post post, User user);
}
