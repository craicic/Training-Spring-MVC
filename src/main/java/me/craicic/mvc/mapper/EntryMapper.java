package me.craicic.mvc.mapper;

import me.craicic.mvc.dto.EntryDto;
import me.craicic.mvc.model.Entry;

public class EntryMapper {

    Entry dtoToModel(EntryDto dto) {
        Entry model = new Entry();

        model.setId(dto.getId());
        model.setTitle(dto.getTitle());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setLastModified(dto.getLastModified());
        model.setNote(dto.getNote());

        return model;
    }

    EntryDto modelToDto(Entry model) {
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
