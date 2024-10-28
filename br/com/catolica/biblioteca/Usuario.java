package br.com.catolica.biblioteca;

public class Usuario {
    private String nome;
    private String id;
    private String email;
    private Livro[] livrosEmPosse;
    private int livrosEmprestados;

    public Usuario(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmPosse = new Livro[5];
        this.livrosEmprestados = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void emprestarLivro(Livro livro) {
        if (livrosEmprestados < 5) {
            livrosEmPosse[livrosEmprestados] = livro;
            livrosEmprestados++;
        } else {
            System.out.println("Limite de 5 livros já foi atingido.");
        }
    }

    public void devolverLivro(Livro livro) {
        for (int i = 0; i < livrosEmprestados; i++) {
            if (livrosEmPosse[i].equals(livro)) {
                livrosEmPosse[i] = null;
                livrosEmprestados--;
                break;
            }
        }
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Livros em posse:");
        for (int i = 0; i < livrosEmprestados; i++) {
            if (livrosEmPosse[i] != null) {
                System.out.println("- " + livrosEmPosse[i].getTitulo());
            }
        }
    }
}
