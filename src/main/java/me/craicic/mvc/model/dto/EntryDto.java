package me.craicic.mvc.model.dto;

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

    @Override
    public String toString() {
        return "EntryDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
