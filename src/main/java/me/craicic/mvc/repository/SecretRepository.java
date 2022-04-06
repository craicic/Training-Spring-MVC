package me.craicic.mvc.repository;

import me.craicic.mvc.model.entity.Secret;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface SecretRepository extends Repository<Secret, Integer> {

    @Query("SELECT s.salt FROM Secret s JOIN s.user u where u.mainUsername = :userName ")
    String retrieveHashByUserName(String userName);
}
