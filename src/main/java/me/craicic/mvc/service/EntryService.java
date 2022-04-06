package me.craicic.mvc.service;

import me.craicic.mvc.mapper.EntryMapper;
import me.craicic.mvc.model.dto.EntryDto;
import me.craicic.mvc.model.entity.Entry;
import me.craicic.mvc.repository.EntryRepository;
import me.craicic.mvc.utils.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EntryService {


    final private PasswordManager passwordManager;

    final private EntryRepository entryRepo;

    final private EntryMapper entryMapper;

    @Autowired
    public EntryService(PasswordManager passwordManager, EntryRepository entryRepo, EntryMapper entryMapper) {
        this.passwordManager = passwordManager;
        this.entryRepo = entryRepo;
        this.entryMapper = entryMapper;
    }


    public List<EntryDto> getUserEntries(String username) {

        List<Entry> entries = entryRepo.findEntryByUserMainUsername(username);
        entries.forEach(entry -> entry.setPassword(passwordManager.decodePassword(entry.getPassword())));
        List<EntryDto> userEntries = new ArrayList<>();
        entries.forEach(model -> userEntries.add(entryMapper.modelToDto(model)));

        return userEntries;

    }
}
