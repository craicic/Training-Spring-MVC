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

    public EntryDto(Integer id, String title, String username, String password, String note, Date lastModified) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.note = note;
        this.lastModified = lastModified;
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
