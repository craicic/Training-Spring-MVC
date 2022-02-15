package me.craicic.mvc;

import java.sql.Date;

public class AppUser {

    private Integer id;
    private String pseudo;
    private String password;
    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (!id.equals(appUser.id)) return false;
        if (!pseudo.equals(appUser.pseudo)) return false;
        if (!password.equals(appUser.password)) return false;
        return creationDate.equals(appUser.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + pseudo.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }
}
