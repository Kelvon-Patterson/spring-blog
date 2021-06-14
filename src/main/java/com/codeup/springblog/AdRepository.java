package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

Ad findByTitle(String title);

Ad findFirstByTitle(String title);

Ad findByTitleLike(String searchPattern);

}
