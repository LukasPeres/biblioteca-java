import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        // Criar alguns dados de exemplo
        inicializarDadosExemplo(biblioteca);
        
        int opcao;
        
        do {
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Listar livros disponíveis");
            System.out.println("6. Listar livros emprestados");
            System.out.println("7. Listar todos os usuários");
            System.out.println("8. Buscar livro por título");
            System.out.println("9. Buscar livro por autor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, biblioteca);
                    break;
                case 2:
                    cadastrarUsuario(scanner, biblioteca);
                    break;
                case 3:
                    emprestarLivro(scanner, biblioteca);
                    break;
                case 4:
                    devolverLivro(scanner, biblioteca);
                    break;
                case 5:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 6:
                    biblioteca.listarLivrosEmprestados();
                    break;
                case 7:
                    biblioteca.listarTodosUsuarios();
                    break;
                case 8:
                    buscarLivroPorTitulo(scanner, biblioteca);
                    break;
                case 9:
                    buscarLivroPorAutor(scanner, biblioteca);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void inicializarDadosExemplo(Biblioteca biblioteca) {
        // Adicionar alguns livros de exemplo
        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.cadastrarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881));
        biblioteca.cadastrarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        biblioteca.cadastrarLivro(new Livro("1984", "George Orwell", 1949));
        
        // Adicionar alguns usuários de exemplo
        biblioteca.cadastrarUsuario(new Usuario("João Silva", "joao@email.com"));
        biblioteca.cadastrarUsuario(new Usuario("Maria Santos", "maria@email.com"));
    }
    
    private static void cadastrarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== CADASTRAR LIVRO ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("Ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        Livro novoLivro = new Livro(titulo, autor, ano);
        biblioteca.cadastrarLivro(novoLivro);
        
        System.out.println("Livro cadastrado com sucesso!");
    }
    
    private static void cadastrarUsuario(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== CADASTRAR USUÁRIO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Usuario novoUsuario = new Usuario(nome, email);
        biblioteca.cadastrarUsuario(novoUsuario);
        
        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    private static void emprestarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== EMPRESTAR LIVRO ===");
        System.out.print("Email do usuário: ");
        String email = scanner.nextLine();
        
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        
        boolean sucesso = biblioteca.emprestarLivro(email, titulo);
        
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Falha no empréstimo. Verifique se:");
            System.out.println("- Usuário está cadastrado");
            System.out.println("- Livro existe");
            System.out.println("- Livro está disponível");
        }
    }
    
    private static void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== DEVOLVER LIVRO ===");
        System.out.print("Email do usuário: ");
        String email = scanner.nextLine();
        
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        
        boolean sucesso = biblioteca.devolverLivro(email, titulo);
        
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Falha na devolução. Verifique se:");
            System.out.println("- Usuário está cadastrado");
            System.out.println("- Livro existe");
            System.out.println("- Usuário realmente tem este livro emprestado");
        }
    }
    
    private static void buscarLivroPorTitulo(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== BUSCAR LIVRO POR TÍTULO ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        Livro livro = biblioteca.buscarLivroPorTitulo(titulo);
        
        if (livro != null) {
            livro.exibirInfo();
        } else {
            System.out.println("Livro não encontrado!");
        }
    }
    
    private static void buscarLivroPorAutor(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== BUSCAR LIVRO POR AUTOR ===");
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        java.util.ArrayList<Livro> livros = biblioteca.buscarLivroPorAutor(autor);
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado deste autor!");
        } else {
            System.out.println("Livros encontrados: " + livros.size());
            for (Livro livro : livros) {
                System.out.println("- " + livro.getTitulo() + " (" + livro.getAnoPublicacao() + ")");
            }
        }
    }
}