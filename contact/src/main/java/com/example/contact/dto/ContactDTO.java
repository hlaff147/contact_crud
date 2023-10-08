package com.example.contact.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO {
    private Long contactId;
    private String contactName;
    private String contactEmail;
    private String contactCell;
    private String contactPhone;
    private Boolean isFavorite;
    private Boolean isActive;
    private String createdAt;

}
