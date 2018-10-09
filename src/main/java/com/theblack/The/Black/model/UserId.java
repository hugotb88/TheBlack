package com.theblack.The.Black.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Data
public class UserId implements Serializable {

    private Long idUser;
    private String mail;

}
