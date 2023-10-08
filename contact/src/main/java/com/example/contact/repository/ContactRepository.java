package com.example.contact.repository;

import com.example.contact.entity.Contact;
import com.example.contact.helpers.ContactHelper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>, ContactHelper {

}
