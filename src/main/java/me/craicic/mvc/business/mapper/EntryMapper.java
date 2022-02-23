package me.craicic.mvc.business.mapper;

import me.craicic.mvc.model.dto.EntryDto;
import me.craicic.mvc.model.entity.Entry;
import org.springframework.stereotype.Service;

@Service
public class EntryMapper {

    public Entry dtoToModel(EntryDto dto) {
        Entry model = new Entry();

        model.setId(dto.getId());
        model.setTitle(dto.getTitle());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setLastModified(dto.getLastModified());
        model.setNote(dto.getNote());

        return model;
    }

    public EntryDto modelToDto(Entry model) {
        EntryDto dto = new EntryDto();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setLastModified(model.getLastModified());
        dto.setNote(model.getNote());

        return dto;
    }
}
