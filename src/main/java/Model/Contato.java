package Model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@Data
public class Contato{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 3, max=20)
    @NotBlank(message = "Campo não pode estar vazio!")
    public String nome;

    @Column(nullable = false)
    @Size(min=11, max=13)
    @NotBlank(message = "Campo não pode estar vazio!")
    private String telefone;

    @Column(nullable = false)
    @org.hibernate.validator.constraints.Email
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    @NotBlank(message = "Campo não pode estar vazio!")
    private String email;




}