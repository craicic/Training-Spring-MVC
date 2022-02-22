package me.craicic.mvc.business;

import me.craicic.mvc.dto.EntryDto;
import me.craicic.mvc.mapper.EntryMapper;
import me.craicic.mvc.repository.EntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class EntryService {

    private static final Logger logger = LoggerFactory.getLogger(EntryService.class);

    final private EntryRepository entryRepo;

    final private EntryMapper entryMapper;


    @Autowired
    public EntryService(EntryRepository entryRepo, EntryMapper entryMapper) {
        this.entryRepo = entryRepo;
        this.entryMapper = entryMapper;
    }


    public Set<EntryDto> getUserEntries(String username) {
        Set<EntryDto> userEntries = new HashSet<>();
        entryRepo.findEntryByUserMainUsername(username).forEach(model -> userEntries.add(entryMapper.modelToDto(model)));
        return userEntries;

    }
}
