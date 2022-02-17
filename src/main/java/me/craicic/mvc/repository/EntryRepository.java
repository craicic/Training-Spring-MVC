package me.craicic.mvc.repository;

import me.craicic.mvc.model.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Integer> {

}
