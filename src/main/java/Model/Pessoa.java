package Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class Pessoa {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 3, max=20)
    @NotBlank(message = "Campo não pode estar vazio!")
    private String nome;

    @Column(nullable = false)
    @Size(min=11, max=11)
    @NotBlank(message = "Campo não pode estar vazio!")
    private String cpf;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(nullable = false)
    private Date dataNascimento;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @NotEmpty(message = "A pessoa deve ter pelo menos uma forma de contato!")
    private Set<Contato> contato;
}
