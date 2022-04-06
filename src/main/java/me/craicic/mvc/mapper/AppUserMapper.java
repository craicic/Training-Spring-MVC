package me.craicic.mvc.mapper;

import me.craicic.mvc.model.dto.AppUserDto;
import me.craicic.mvc.model.dto.EntryDto;
import me.craicic.mvc.model.entity.AppUser;
import me.craicic.mvc.model.entity.Entry;

import java.util.HashSet;
import java.util.Set;

public class AppUserMapper {

    AppUser dtoToModel(AppUserDto dto) {
        AppUser model = new AppUser();

        model.setId(dto.getId());
        model.setCreationDate(dto.getCreationDate());
        model.setMainPassword(dto.getMainPassword());
        model.setMainUsername(dto.getMainUsername());

        return model;
    }

    AppUserDto modelToDto(AppUser model) {
        AppUserDto dto = new AppUserDto();

        dto.setId(model.getId());
        dto.setCreationDate(model.getCreationDate());
        dto.setMainPassword(model.getMainPassword());
        dto.setMainUsername(model.getMainUsername());

        Set<EntryDto> entryDtoSet = new HashSet<>();
        EntryMapper entryMapper = new EntryMapper();


        for (Entry entry: model.getEntries() ) {
            entryDtoSet.add(entryMapper.modelToDto(entry));
        }
        dto.getEntryDtoSet().addAll(entryDtoSet);

        return dto;
    }
}
