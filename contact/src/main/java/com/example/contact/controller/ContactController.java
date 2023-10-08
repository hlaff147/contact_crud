package com.example.contact.controller;

import com.example.contact.dto.ContactDTO;
import com.example.contact.entity.Contact;
import com.example.contact.repository.ContactRepository;
import com.example.contact.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    private final ContactService contactService;

    public ContactController(ContactRepository contactRepository, ContactService contactService) {
        this.contactRepository = contactRepository;
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(contactService::parseToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        return contact != null ? contactService.parseToDTO(contact) : null;
    }

    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {
        Contact contact =                contactService.parseToEntity(contactDTO);
        contact = contactRepository.save(contact);
        return contactService.parseToDTO(contact);
    }

    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contact = contactService.parseToEntity(contactDTO);
            contact = contactRepository.save(contact);
            return contactService.parseToDTO(contact);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<Void> updateIsFavorite(@PathVariable Long id, @RequestParam boolean isFavorite) {
        contactService.updateIsFavorite(id, isFavorite);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/active")
    public ResponseEntity<Void> updateIsActive(@PathVariable Long id, @RequestParam boolean isActive) {
        contactService.updateIsActive(id, isActive);
        return ResponseEntity.ok().build();
    }
}
