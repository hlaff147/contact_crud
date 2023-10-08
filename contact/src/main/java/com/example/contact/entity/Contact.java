package com.example.contact.entity;

import com.example.contact.utils.BooleanCharConverter;
import lombok.Getter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.util.Date;


@Getter
@Table(name = "contact")
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "contact_name", length = 100)
    private String contactName;

    @Column(name = "contact_email", length = 255)
    private String contactEmail;

    @Column(name = "contact_cell", length = 11)
    private String contactCell;

    @Column(name = "contact_phone", length = 10)
    private String contactPhone;

    @Column(name = "is_favorite", length = 1)
    private char isFavorite;

    @Column(name = "is_active", length = 1)
    private char isActive;

    @Column(name = "created_at")
    private Date createdAt;

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactCell(String contactCell) {
        this.contactCell = contactCell;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setIsFavorite(char isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getIsFavoriteBoolean() {
        return BooleanCharConverter.toBoolean(this.isFavorite);
    }

    public void setIsFavoriteBoolean(boolean isFavorite) {
        this.isFavorite = BooleanCharConverter.toChar(isFavorite);
    }

    public boolean getIsActiveBoolean() {
        return BooleanCharConverter.toBoolean(this.isActive);
    }

    public void setIsActiveBoolean(boolean isActive) {
        this.isActive = BooleanCharConverter.toChar(isActive);
    }

    // Getters, setters, and other methods...
}



