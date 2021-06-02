package ControllersApi;

import Model.Contato;
import Model.Pessoa;
import Regras.BuscaPessoaForm;
import Repositories.ContatoRepository;
import Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class PessoaApi {
    @Autowired
    PessoaRepository pessoaRepo;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    private Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) throws Exception {
        Date dataAtual = new Date();
        if(pessoa.getDataNascimento().after(dataAtual) == true){throw new Exception("A data é futura!");}
        return pessoaRepo.save(pessoa);
    };

    @GetMapping("/buscar-id/{id}")//trocar por pessoa
    private Pessoa buscarPorId(@PathVariable Integer id){
        return pessoaRepo.findById(id).get();
    };

    @GetMapping("/lista-pagina-simples/{pagina}")
    private String listaPessoasPaginada(@PathVariable Integer pagina){
        Page<Pessoa> page =  pessoaRepo.findAll(PageRequest.of(pagina,10));
        return page.getContent().toString();
    };

    @GetMapping("/lista-pagina-parametros")
    private String paginacaoParametros(Pageable pageable){
        Page<Pessoa> page = pessoaRepo.findAll(pageable);
        return page.getContent().toString();
    };

    @GetMapping("/busca-por-filtro")
    private String paginacaoFiltrada(BuscaPessoaForm buscaPessoaForm){
        return pessoaRepo.findAll(buscaPessoaForm.toSpec()).toString();

    }

    @PutMapping("/atualizarPessoa/{pessoaId}")
    private Pessoa atualizarCadastro(
            @PathVariable Integer pessoaId,
            @RequestBody Pessoa detalhesPessoa
    ){
    Pessoa pessoa = pessoaRepo.findById(pessoaId).get();
    pessoa.setNome(detalhesPessoa.getNome());
    pessoa.setCpf(detalhesPessoa.getCpf());
    final Pessoa pessoaAtualizada = pessoaRepo.save(pessoa);
    return pessoaRepo.save(pessoaAtualizada);
    };

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletarPessoa(@PathVariable Integer id){
        pessoaRepo.deleteById(id);
    };
}
