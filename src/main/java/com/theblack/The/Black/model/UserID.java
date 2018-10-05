package com.theblack.The.Black.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Data
public class UserID implements Serializable {

    private Long idUser;
    private String mail;

    //Constructor
    public UserID(Long idUser, String mail){
        this.idUser = idUser;
        this.mail = mail;
    }
}
