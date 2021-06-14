package com.codeup.springblog.daos;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ad, Long> {

Ad findByTitle(String title);

Ad findFirstByTitle(String title);

Ad findByTitleLike(String searchPattern);

}
