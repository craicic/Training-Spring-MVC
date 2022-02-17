package me.craicic.mvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class EntryDto {

    private Integer id;

    private String title;

    private String username;

    private String password;

    private String note;

    private Date lastModified;

    public EntryDto() {
    }
}
