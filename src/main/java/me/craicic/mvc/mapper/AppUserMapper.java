package me.craicic.mvc.mapper;

import me.craicic.mvc.dto.AppUserDto;
import me.craicic.mvc.dto.EntryDto;
import me.craicic.mvc.model.AppUser;
import me.craicic.mvc.model.Entry;

import java.util.HashSet;
import java.util.Set;

public class AppUserMapper {

    AppUser dtoToModel(AppUserDto dto) {
        AppUser model = new AppUser();

        model.setId(dto.getId());
        model.setCreationDate(dto.getCreationDate());
        model.setPassword(dto.getPassword());
        model.setPseudo(dto.getPseudo());

        return model;
    }

    AppUserDto modelToDto(AppUser model) {
        AppUserDto dto = new AppUserDto();

        dto.setId(model.getId());
        dto.setCreationDate(model.getCreationDate());
        dto.setPassword(model.getPassword());
        dto.setPseudo(model.getPseudo());

        Set<EntryDto> entryDtos = new HashSet<>();
        EntryMapper entryMapper = new EntryMapper();


        for (Entry entry: model.getEntries() ) {
            entryDtos.add(entryMapper.modelToDto(entry));
        }
        dto.setEntryDtos(entryDtos);

        return dto;
    }
}
