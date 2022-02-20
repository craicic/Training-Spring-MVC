package me.craicic.mvc.repository;

import me.craicic.mvc.model.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface EntryRepository extends CrudRepository<Entry, Integer> {


    @Query("SELECT e FROM Entry AS e JOIN e.user u WHERE u.pseudo = :pseudo ")
    Set<Entry> findEntryByUserPseudo(String pseudo);
}
