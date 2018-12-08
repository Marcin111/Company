package company.app.Company.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String job;
    private String mail;

    public Employee(String name, String surname, String job, String mail) {
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.mail = mail;
    }
}
