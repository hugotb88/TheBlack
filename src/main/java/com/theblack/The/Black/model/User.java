package com.theblack.The.Black.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author Victor Hugo Olvera Cruz
 * POJO and Persistence
 */
@Entity(name = "users")
@IdClass(UserID.class)
@Data
public class User implements Serializable {

    //Members
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column
    private String type;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Id
    @Column(unique = true)
    private String mail;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Column
    private LocalDateTime dateOfRegistration;

    @Column
    private LocalDateTime dateOfUpdate;

    //Constructors
    public User(String type, String firstName, String lastName, Integer age, String mail, LocalDate dateOfBirth) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = LocalDateTime.now();
        this.dateOfUpdate = LocalDateTime.now();
    }

    public User(){}

    //Methods
    public void setAge(){
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
