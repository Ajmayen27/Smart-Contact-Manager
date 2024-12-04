package com.ajmayen.smart_contact_manager.forms;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForms {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String about;

}
