package Regras;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BuscaContatoForm {
    private String nome;


    public BuscaContatoForm( String nome){
        this.nome = nome;
    }

    public Specification toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if(StringUtils.hasText(nome)){
                Path<String> campoNome = root.<String>get("nome");
                Predicate predicadoNome = builder.like(campoNome, "%" +nome+"%");
                predicados.add(predicadoNome);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }

}
