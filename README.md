# ElotechBackend
Teste de conhecimentos Java Web

Utiliza a porta 8080 e 5432/testes(DB)

# Api pessoa usuário
Url padrão: http://localhost:8080/usuario

# Método POST  "/adicionar"
A requisição deve possuir o seguinte corpo:
{
"nome":"",
"cpf":"",
"dataNascimento":"dd/mm/AAAA",
"contato":[{
    "nome":"",
    "telefone":"",
    "email":""
}]
}

# Métodos GET "/busca"
Todos os métodos irão retornar um objeto igual ao corpo da requisição, adicionado de seu id único.

/buscar-id/{id} informe o {id} à url e retornará o usuário desejado;

/pagina-simples/{pagina} busca paginada simples, informe apenas a {pagina} e será retornado uma lista de 5 objetos ;

/pagina-parametros? você pode passar seus proprios paramêtros de busca que incluem a página e o tamanho da lista (page=&size=) respectivamente

/busca-por-filtro busca com filtros, podendo ser qualquer um dos atributos do objeto. Irá retornar uma lista, ou um objeto identico ao solicitado

# Método PUT "/atualizarPessoa/{id}"
Com o corpo o mesmo corpo da requisição POST, é possível  atualizar o cadastro do usuário apenas informando seu id, o contato deve ser atualizado em sua própria API.

# Método DELETE "/delete/{id}"
Apenas informe o id e o cadastro do Banco de Dados será deletado.


////


## Api contato do usuário
Url padrão: http://localhost:8080/contatos

# Método POST  "/adicionar"
A requisição deve possuir o seguinte corpo:
{
"nome":"pessoal",
"telefone":"12345678910",
"email":"abc@gmail.com"
}

# Métodos GET "/busca"
Todos os métodos irão retornar um objeto igual ao corpo da requisição, adicionado de seu id único.

/buscar-id/{id} informe o {id} à url e retornará o contato desejado;

/pagina-simples/{pagina} busca paginada simples, informe apenas a {pagina} e será retornado uma lista de 5 objetos ;

/pagina-parametros? você pode passar seus proprios paramêtros de busca que incluem a página e o tamanho da lista (page=&size=) respectivamente

/busca-por-filtro busca com filtros, podendo ser qualquer um dos atributos do objeto. Irá retornar uma lista, ou um objeto identico ao solicitado

# Método PUT "/atualizarPessoa/{id}"
Com o corpo o mesmo corpo da requisição POST, é possível  atualizar o contatoo apenas informando seu id, o contato deve ser atualizado em sua própria API.

# Método DELETE "/delete/{id}"
Apenas informe o id e o cadastro do Banco de Dados será deletado.












