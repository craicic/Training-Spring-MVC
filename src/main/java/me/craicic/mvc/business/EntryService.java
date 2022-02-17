package me.craicic.mvc.business;

import me.craicic.mvc.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntryService {

    final private EntryRepository entryRepo;

    @Autowired
    public EntryService(EntryRepository entryRepo) {
        this.entryRepo = entryRepo;
    }

}
