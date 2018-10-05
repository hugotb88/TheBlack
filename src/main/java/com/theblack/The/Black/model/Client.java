package com.theblack.The.Black.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Entity(name="client")
@Data
public class Client implements Serializable {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String phone;

    @Id
    private String mail;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime modificationDate;

}
