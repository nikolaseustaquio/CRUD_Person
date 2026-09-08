package com.projectnik;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Pessoas pessoas = new Pessoas();
    static Scanner sc = new Scanner(System.in);

    static void main() {

        while(true) {
            System.out.print("""
                    --------------------------------------
                    Escolha sua ação:
                    
                    [1] Criar dados de uma nova pessoa
                    [2] Listar pessoas
                    [3] Buscar pessoa
                    [4] Atualizar dados de uma pessoa
                    [5] Deletar dados de uma pessoa
                    [0] Encerrar
                    
                    ->\s""");
            int e = sc.nextInt();
            sc.nextLine();

            switch (e) {

                case 1 -> criarPessoa();
                case 2 -> listarPessoas();
                case 3 -> buscarPessoa();
                case 4 -> atualizarPessoa();
                case 5 -> deletarPessoa();
                case 0 -> encerrar();
                default -> System.out.println("Erro! Opção inválida.");
            }
        }
    }

    private static void criarPessoa(){
        System.out.println("--------------------------------------");
        System.out.print("NOME: ");
        String nome = sc.nextLine();

        System.out.print("IDADE: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("OCUPAÇÃO: ");
        String ocupacao = sc.nextLine();

        try{
            System.out.println("Criando dados de uma pessoa...");
            pessoas.criarPessoa(nome, idade, ocupacao);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarPessoas(){
        try{
            System.out.println("Listando...");
            pessoas.listarPessoas();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarPessoa(){
        System.out.print("Digite o ID -> ");
        int buscaID = sc.nextInt();
        try {
            System.out.println("Buscando...");
            System.out.println(pessoas.buscarPessoa(buscaID));
        } catch (SQLException | PessoaNaoEncontradaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void atualizarPessoa(){
        System.out.print("Digite o ID: ");
        int buscaID = sc.nextInt();
        sc.nextLine();

        try {
            System.out.println("Buscando...");
            pessoas.buscarPessoa(buscaID);


            System.out.println("--------------------------------------");
            System.out.print("DIGITE O NOVO NOME: ");
            String novoNome = sc.nextLine();

            System.out.print("DIGITE A NOVA IDADE: ");
            int novaIdade = sc.nextInt();
            sc.nextLine();

            System.out.print("DIGITE A NOVA OCUPAÇÃO: ");
            String novaOcupacao = sc.nextLine();

            System.out.println("Atualizando novos dados...");
            pessoas.atualizarPessoa(buscaID, novoNome, novaIdade, novaOcupacao);

        }catch (SQLException | PessoaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deletarPessoa(){
        System.out.print("Digite o ID: ");
        int buscaID = sc.nextInt();
        sc.nextLine();

        try{
            pessoas.deletarPessoa(buscaID);
            System.out.println("Deletando pessoa...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void encerrar(){
        System.out.println("Encerrando...");
        System.exit(0);
    }
}
