package me.craicic.mvc.repository;

import me.craicic.mvc.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findAppUserByMainUsername(String pseudo);
}
