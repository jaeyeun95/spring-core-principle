package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // id를 자동으로 증가시켜주는 것 oracle 에서 sequence
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
