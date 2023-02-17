package com.sb.repo;

import com.sb.models.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepo extends JpaRepository<UrlEntity, Long> {
    @Query("SELECT u FROM url u WHERE u.fullUrl=?1")
    List<UrlEntity> findUrlByFullUrl(String fullUrl);

}
