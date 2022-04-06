package me.craicic.mvc.repository;

import me.craicic.mvc.model.entity.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Integer> {


    @Query("SELECT e FROM Entry e JOIN e.user u WHERE upper(u.mainUsername) = upper(:mainUsername) " +
            "ORDER BY e.title ASC ")
    List<Entry> findEntryByUserMainUsername(String mainUsername);
}
