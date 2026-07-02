class Biblioteca (val nomeBiblioteca : String) {
    val listaDeLivros = mutableListOf<Livro>()

    init {
        listaDeLivros.add(Livro("Arquitetura Limpa", "Robert C. Martin (Uncle Bob)", 2017, "O guia do artesão para estrutura e design de software.", true))
        listaDeLivros.add(Livro("O Programador Pragmático", "Andrew Hunt e David Thomas", 1999, "Seu guia para a maestria em desenvolvimento de software e eficiência.", true))
        listaDeLivros.add(Livro("Entendendo Algoritmos", "Aditya Bhargava", 2016, "Um guia ilustrado para programadores e outros curiosos.", true))

    }
    fun menuPrincipal(){
        println("Bem vindo a biblioteca $nomeBiblioteca!")
        println("1 - Listar livros")
        println("2 - Alugar Livro")
        println("3 - Devolver Livro")
        println("4 - Funções de Administrador")
        print("Selecione a opção desejada: ")
        var escolhaMenuPrincipal : Int = readLine().toString().toInt()

        when(escolhaMenuPrincipal){
            1 -> listarLivros()
            2 -> alugarLivro()
            3 -> devolverLivro()
            4 -> funcoesAdministrador()
            else-> println("Digite uma opção válida!")
        }
    }

    fun listarLivros(){
        barra()
        if (listaDeLivros.isEmpty()){
            println("Nenhum livro na biblioteca!")
        }else{
            println("Livros:")
            for (livro in listaDeLivros){
                println("Título: ${livro.titulo}")
                println("Autor: ${livro.autor}")
                println("Ano de publicação: ${livro.anoPublicacao}")
                println("Descrição: ${livro.descricao}")
                if (livro.statusDisponivel){
                    println("Status: Disponível!")
                }else{
                    println("Status: Indisponível!")
                }
                barra()
            }
            menuPrincipal()
        }
    }

    fun alugarLivro(){
        barra()
        while (true) {
            if (listaDeLivros.isEmpty()){
                println("Não há livros para alugar")
                barra()
                menuPrincipal()
            }
            println("Livros disponíveis: ")
            for ((index, livro) in listaDeLivros.withIndex()){
                println("${index + 1} - ${livro.titulo}")
            }
            print("Escolha um livro pelo número: ")
            val escolhaAlugarLivro = readLine().toString().toInt()


            val livroEscolhido = listaDeLivros[escolhaAlugarLivro - 1]
            if (!livroEscolhido.statusDisponivel){
                println("O livro selecionado não está mais disponível!")
                barra()
                menuPrincipal()
            } else if (escolhaAlugarLivro in 1..listaDeLivros.size){
                var livroAlugado = listaDeLivros[escolhaAlugarLivro - 1]
                livroAlugado.statusDisponivel = false
                println("Livro alugado com sucesso!")
                barra()
                println("1 - Alugar outro livro")
                println("2 - Sair para o painel principal")
                print("Opção: ")
                val escolhaAlugarOutroLivro = readLine().toString().toInt()
                if (escolhaAlugarOutroLivro == 2){
                    barra()
                    menuPrincipal()
                }
            }
            barra()
        }

    }

    fun devolverLivro(){
        barra()
        val livrosAlugados = listaDeLivros.filter { !it.statusDisponivel }
        while (true) {
            if (livrosAlugados.isEmpty()){
                println("Não há livros para devolver")
                barra()
                menuPrincipal()
            }
            println("Livros Alugados:")
            for ((index, livro) in livrosAlugados.withIndex()){
                println("${index + 1} - ${livro.titulo}")
            }
            print("Escolha um livro pelo número: ")
            val escolhaDevolverLivro = readLine().toString().toInt()

            var livroEscolhido = livrosAlugados[escolhaDevolverLivro - 1]
            if (!livroEscolhido.statusDisponivel){
                var livroDevolvido = livrosAlugados[escolhaDevolverLivro - 1]
                livroDevolvido.statusDisponivel = true
                println("Livro devolvido com sucesso!")
                barra()
                println("1 - Devolver outro livro")
                println("2 - Sair para o painel principal")
                print("Opção: ")
                val escolhaDevolverOutroLivro = readLine().toString().toInt()
                if (escolhaDevolverOutroLivro == 2){
                    barra()
                    menuPrincipal()
                }
            }
            barra()
        }
    }

    fun funcoesAdministrador(){
        barra()
        println("Para acessar o painel do administrador insira o usuário e a senha")
        print("Usuário: ")
        val usuario = readLine().toString()
        print("Senha: ")
        val senha = readLine().toString()

        if (usuario == "admin" && senha == "1234"){
            painelAdministrador()
        }else{
            println("Usuário ou senha inválidos!")
            barra()
            menuPrincipal()
        }

    }

    fun painelAdministrador(){
        barra()
        println("Login realizado com sucesso!")
        println("1 - Cadastrar livro")
        println("2 - Remover livro")
        val escolhaAdmin = readLine().toString().toInt()

        if (escolhaAdmin == 1){
            cadastrarLivro()
        }else if (escolhaAdmin == 2){
            removerLivro()
        }else{
            println("Escolha uma opção válida!")
            barra()
            painelAdministrador()
        }
    }

    fun cadastrarLivro(){
        barra()
        while (true){
            print("Insira o nome do livro: ")
            var tituloLivro = readLine().toString()

            print("Insira o autor do livro: ")
            var autorLivro = readLine().toString()

            print("Insira o ano de publicação do livro: ")
            var anoDePublicacaoLivro = readLine().toString().toInt()

            print("Insira a descrição do livro: ")
            var descricaoLivro = readLine().toString()

            var livro = Livro(tituloLivro, autorLivro, anoDePublicacaoLivro, descricaoLivro, true)

            listaDeLivros.add(livro)

            println("Livro adicionado com sucesso!")
            println("1 - Adicionar outro livro")
            println("2 - Sair para o painel principal")
            print("Opção: ")
            val escolhaAdicionarMaisLivros = readLine().toString().toInt()

            if (escolhaAdicionarMaisLivros == 2){
                barra()
                menuPrincipal()
            }
        }

    }
    fun removerLivro(){
        barra()
        while (true){
            if (listaDeLivros.isEmpty()){
                println("Não há livros para remover!")
            }
            for ((index, livro) in listaDeLivros.withIndex()){
                println("Livros: ")
                println("${index + 1} - ${livro.titulo}")
            }
            print("Escolha um livro pelo número: ")
            val escolhaRemoverLivro = readLine().toString().toInt()

            if (escolhaRemoverLivro in 1..listaDeLivros.size){
                val livroRemovido = listaDeLivros.removeAt(escolhaRemoverLivro - 1)
                println("Livro removido com sucesso!")
                println("1 - Remover outro livro")
                println("2 - Sair para o painel principal")
                print("Opção: ")
                val escolhaRemoverLivro = readLine().toString().toInt()
                if (escolhaRemoverLivro == 2){
                    barra()
                    menuPrincipal()
                }
            }
        }
    }

    fun barra(){
        println("--------------------------------------------------------------------------")
    }
}