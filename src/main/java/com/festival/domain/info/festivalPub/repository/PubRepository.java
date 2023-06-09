package com.festival.domain.info.festivalPub.repository;

import com.festival.domain.info.festivalPub.data.entity.pub.Pub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PubRepository extends JpaRepository<Pub, Long>, PubRepositoryCustom {
}
