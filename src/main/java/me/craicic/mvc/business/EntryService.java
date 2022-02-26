package me.craicic.mvc.business;

import me.craicic.mvc.business.mapper.EntryMapper;
import me.craicic.mvc.model.dto.EntryDto;
import me.craicic.mvc.model.entity.Entry;
import me.craicic.mvc.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class EntryService {

    final private EntryRepository entryRepo;

    final private EntryMapper entryMapper;


    @Autowired
    public EntryService(EntryRepository entryRepo, EntryMapper entryMapper) {
        this.entryRepo = entryRepo;
        this.entryMapper = entryMapper;
    }


    public Set<EntryDto> getUserEntries(String username) {

        Set<Entry> entries = entryRepo.findEntryByUserMainUsername(username);
        Set<EntryDto> userEntries = new HashSet<>();
        entries.forEach(model -> userEntries.add(entryMapper.modelToDto(model)));

        return userEntries;

    }
}
