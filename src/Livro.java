public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;
    
    //contrutor
    public Livro(String titulo, String autor, int anoPublicacao){
        this.titulo=titulo;
        this.autor=autor;
        this.anoPublicacao=anoPublicacao;
        this.disponivel = true;
    }
    //getter
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    public boolean isDisponivel(){
        return disponivel;
    }
    //setter(apenas o disponivel vai mudar, logo não há nececidade de ter os outros 3 setters)
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public void exibirInfo(){
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Ano de publicação: "+ anoPublicacao);
        if (disponivel != true) {
            System.out.println("Está disponível: Não");
        }else{
            System.out.println("Está disponível: Sim");
        }

        }
    }

