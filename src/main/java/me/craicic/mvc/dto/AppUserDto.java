package me.craicic.mvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
public class AppUserDto {

    private Integer id;

    private String mainUsername;

    private String mainPassword;

    private Date creationDate;


    private Set<EntryDto> entryDtoSet;

    public AppUserDto() {
    }
}
