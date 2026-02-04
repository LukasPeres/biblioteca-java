import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();

    public Usuario(String nome, String email){
        this.nome=nome;
        this.email=email;
        this.livrosEmprestados = new ArrayList<Livro>();
    }

    //getter
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public ArrayList<Livro> getLivrosEmprestados(){
        return livrosEmprestados;
    }

    //pegar livro
    public void emprestarLivro(Livro livro){
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livrosEmprestados.add(livro);
        }
    } 

    //devolver para a biblioteca
    public void devolverLivro (Livro livro){
        if (livrosEmprestados.contains(livro)){
            livrosEmprestados.remove(livro);
            livro.setDisponivel(true);
        }
    }

    public void exibirInfo() {
        System.out.println("=== USUÁRIO: " + nome + " ===");
        System.out.println("Email: " + email);
        System.out.println("Livros emprestados: " + livrosEmprestados.size());
        for (Livro livro : livrosEmprestados) {
            System.out.println("  - " + livro.getTitulo());
        }
    }
}
