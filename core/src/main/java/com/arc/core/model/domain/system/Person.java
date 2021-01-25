package com.arc.core.model.domain.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "mongo_person")
public class Person implements Serializable {

    //        @Id
//    @GeneratedValue
    private Long id;

    private Integer age;
    private String nickname;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String realname;
    private String id_number;

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;

    }

    //    @Column(name = "username", nullable = true, length = 20)
//    @Column(name = "age", nullable = true, length = 4)
}
