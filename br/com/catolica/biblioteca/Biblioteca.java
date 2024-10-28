package br.com.catolica.biblioteca;

public class Biblioteca {
    private String nome;
    private String endereco;
    private Livro[] livrosDisponiveis;
    private int totalLivros;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livrosDisponiveis = new Livro[100];
        this.totalLivros = 0;
    }

    public void cadastrarLivro(Livro livro) {
        if (totalLivros < 100) {
            livrosDisponiveis[totalLivros] = livro;
            totalLivros++;
        } else {
            System.out.println("Limite de livros na biblioteca foi atingido.");
        }
    }

    public Livro localizarLivroPorTitulo(String titulo) {
        for (int i = 0; i < totalLivros; i++) {
            if (livrosDisponiveis[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livrosDisponiveis[i];
            }
        }
        return null;
    }

    public Livro localizarLivroPorAutor(String autor) {
        for (int i = 0; i < totalLivros; i++) {
            if (livrosDisponiveis[i].getAutor().equalsIgnoreCase(autor)) {
                return livrosDisponiveis[i];
            }
        }
        return null;
    }

    public boolean verificarDisponibilidade(Livro livro) {
        return livro.getQuantidadeEstoque() > 0;
    }

    public void emprestar(Livro livro) {
        if (verificarDisponibilidade(livro)) {
            livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
        } else {
            System.out.println("Livro indisponível.");
        }
    }

    public void devolver(Livro livro) {
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + 1);
    }

    public void exibirInfo() {
        System.out.println("Biblioteca: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < totalLivros; i++) {
            System.out.println("- " + livrosDisponiveis[i].getTitulo());
        }
    }
}

