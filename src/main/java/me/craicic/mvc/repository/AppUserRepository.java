package me.craicic.mvc.repository;

import me.craicic.mvc.model.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    @Query("SELECT u FROM AppUser u WHERE upper(u.mainUsername) = upper(:pseudo)")
    AppUser findAppUserByMainUsername(String pseudo);
}
