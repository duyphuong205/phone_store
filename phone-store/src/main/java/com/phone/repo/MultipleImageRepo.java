package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.MultipleImage;

@Repository
public interface MultipleImageRepo extends JpaRepository<MultipleImage, Long> {

}
