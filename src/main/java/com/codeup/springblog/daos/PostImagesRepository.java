package com.codeup.springblog.daos;

import com.codeup.springblog.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImagesRepository extends JpaRepository<PostImage,Long> {
}
