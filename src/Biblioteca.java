import java.util.ArrayList;
public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(){
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    //Cadastro dos livros
    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }

    //Buscador de livros pelo titulo
    public Livro buscarLivroPorTitulo(String titulo){
        for (Livro livro : livros){
            if (livro.getTitulo().equals(titulo)){
                return livro;
            }
        }
        return null;
    }

    //Buscador de livros pelo autor
    public ArrayList<Livro> buscarLivroPorAutor(String autor){
        ArrayList <Livro> livrosPorAutor = new ArrayList<>();
        for(Livro livro: livros){
            if(livro.getAutor().equalsIgnoreCase(autor)){

                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    //Cadastro de usuarios
    public void cadastrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    //Buscador de usuarios pelo email
    public Usuario buscarUsuarioPorEmail(String email){
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    //Metodo de validação do emprestarLivro do Usuario.java
    public boolean emprestarLivro(String titulo, String email){
        Livro livro = buscarLivroPorTitulo(titulo);
        Usuario usuario = buscarUsuarioPorEmail(email);

        if (livro != null && usuario != null && livro.isDisponivel()) {
            usuario.emprestarLivro(livro);
            return true;
        }
        return false;
    }

    //Metodo de validação do devolverLivro do Usuario.java
    public boolean devolverLivro(String titulo, String email){
        Livro livro = buscarLivroPorTitulo(titulo);
        Usuario usuario = buscarUsuarioPorEmail(email);

        if (usuario == null || livro == null) {
            return false;
        }
        usuario.devolverLivro(livro);
        return true;
    }

    public void listarLivrosDisponiveis(){
        for(Livro livro : livros){
            if(livro.isDisponivel()){
                System.out.println("Título: "+ livro.getTitulo());
                System.out.println("Autor: "+ livro.getAutor());
                
            }
        }
    }
    
    
    public void listarLivrosEmprestados(){
        for(Livro livro : livros){
            if(!livro.isDisponivel()){
                System.out.println("Título: "+ livro.getTitulo());
                System.out.println("Autor: "+ livro.getAutor());
            }
        }
    }

    public void listarTodosUsuarios(){
        for(Usuario usuario : usuarios){
            System.out.println("Nome: "+ usuario.getNome());
            System.out.println("Email: "+ usuario.getEmail());
            System.out.print("Livros emprestados: ");
            if (usuario.getLivrosEmprestados().isEmpty()) {
                System.out.println("Nenhum");
            }else{
                ArrayList<String> titulos = new ArrayList<>();
                for(Livro livro : usuario.getLivrosEmprestados()){
                    titulos.add(livro.getTitulo());
                }
                System.out.println(String.join(",", titulos));
            }

        }
    }
}
