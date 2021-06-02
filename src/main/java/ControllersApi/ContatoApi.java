package ControllersApi;

import Model.Contato;
import Regras.BuscaContatoForm;
import Repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoApi {
    @Autowired
    ContatoRepository contatoRepo;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    private Contato adicionarContato(@Valid @RequestBody Contato contato){
       return contatoRepo.save(contato);
    };

    @GetMapping("/busca/pagina-simples/{pagina}")
    @ResponseStatus(HttpStatus.OK)
    private String listarTodos(@PathVariable int pagina){
        Page<Contato> page = contatoRepo.findAll(PageRequest.of(pagina, 5));
        return page.getContent().toString();
    }
    @GetMapping("/busca/buscar-id/{id}")
    private Contato listarPorId(@PathVariable Integer id){
        return contatoRepo.findById(id).get();
    }

    @GetMapping("/busca/pagina-parametros")
    private String paginacaoParametros(Pageable pageable){
        Page<Contato> page = contatoRepo.findAll(pageable);
        return page.getContent().toString();
    };
    @GetMapping("/busca/busca-por-filtro")
    private String paginacaoFiltrada(BuscaContatoForm buscaContatoForm){
        return contatoRepo.findAll(buscaContatoForm.toSpec()).toString();

    }

    @PutMapping("/atualizar-contato/{contatoId}")
    private Contato atualizarContato(@PathVariable Integer contatoId, @RequestBody Contato detalhesContato){
        Contato contato = contatoRepo.findById(contatoId).get();
        contato.setNome(detalhesContato.nome);
        contato.setEmail(detalhesContato.getEmail());
        contato.setTelefone(detalhesContato.getTelefone());
        final Contato contatoAtualizado = contatoRepo.save(contato);
        return contatoRepo.save(contatoAtualizado);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletarContato(@PathVariable Integer id){
        contatoRepo.deleteById(id);
    }
}
