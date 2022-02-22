package me.craicic.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@Getter
@Setter
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_seq")
    @SequenceGenerator(name = "entry_seq", sequenceName = "entry_sequence", initialValue = 200, allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser user;

    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 1023)
    private String note;

    @Column(name = "last_modified")
    private Date lastModified;

    public Entry() {
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
