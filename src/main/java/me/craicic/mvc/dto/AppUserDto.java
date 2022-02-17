package me.craicic.mvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
public class AppUserDto {

    private Integer id;

    private String pseudo;

    private String password;

    private Date creationDate;

    private Set<EntryDto> entryDtos;

    public AppUserDto() {
    }
}
