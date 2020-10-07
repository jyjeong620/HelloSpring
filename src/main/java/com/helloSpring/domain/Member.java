package com.helloSpring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id //pk setting
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 알아서 생성해주는건 identity 설정
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
