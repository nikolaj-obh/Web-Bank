package dk.nikolaj.webbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long ID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private Character gender;
    //@Column(name = "is_admin")
    //private Boolean isAdmin;
    @Column(name = "level_of_access")
    private String accessLevel;
    @Column(name = "supervisor_id")
    private Long supervisorID;
    @Column(name = "date_of_birth")
    private Date birthday;
    @Column(name = "street_address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private Integer zipcode;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    // TODO implement login with email & password
    // TODO find correct datatype for passwords
    // TODO add assigned employee to customer?
    // TODO add employee role (for example Banker?)
    // TODO add Manager/Supervisor id for employees
}
