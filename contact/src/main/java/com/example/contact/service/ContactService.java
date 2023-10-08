package com.example.contact.service;

import com.example.contact.dto.ContactDTO;
import com.example.contact.entity.Contact;
import com.example.contact.exception.ContactNotFoundException;
import com.example.contact.repository.ContactRepository;
import com.example.contact.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactDTO parseToDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setContactId(contact.getContactId());
        dto.setContactName(contact.getContactName());
        dto.setContactEmail(contact.getContactEmail());
        dto.setContactCell(contact.getContactCell());
        dto.setContactPhone(contact.getContactPhone());
        dto.setIsFavorite(contact.getIsFavoriteBoolean()); // Usando o método getter para obter o valor booleano
        dto.setIsActive(contact.getIsActiveBoolean()); // Usando o método getter para obter o valor booleano
        dto.setCreatedAt(DateUtils.dateToString(contact.getCreatedAt()));
        return dto;
    }

    public Contact parseToEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setContactName(dto.getContactName());
        contact.setContactEmail(dto.getContactEmail());
        contact.setContactCell(dto.getContactCell());
        contact.setContactPhone(dto.getContactPhone());
        contact.setIsFavoriteBoolean(dto.getIsFavorite());
        contact.setIsActiveBoolean(dto.getIsActive());
        if (dto.getContactId() == null) {
            contact.setCreatedAt(new Date());
        }
        return contact;
    }

    public void updateIsFavorite(Long id, boolean isFavorite) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setIsFavoriteBoolean(isFavorite);
            contactRepository.save(contact);
        } else {
            throw new ContactNotFoundException("Contact not found with ID: " + id);
        }
    }

    public void updateIsActive(Long id, boolean isActive) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setIsActiveBoolean(isActive);
            contactRepository.save(contact);
        } else {
            throw new ContactNotFoundException("Contact not found with ID: " + id);
        }
    }

}