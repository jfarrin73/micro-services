package com.example.organizationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organizations")
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String organizationName;
    private String organizationDescription;
    @Column(nullable = false, unique = true)
    private String organizationCode;
    @CreationTimestamp
    private Instant createdDate;
}
