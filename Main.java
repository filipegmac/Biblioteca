import br.com.catolica.biblioteca.Biblioteca;
import br.com.catolica.biblioteca.Livro;
import br.com.catolica.biblioteca.Usuario;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca", "Rua sem nome, 123");
        Livro livro1 = new Livro("Livro A", "Autor A", "00000", 2014, 5);
        Livro livro2 = new Livro("Livro B", "Autor B", "00000", 2008, 3);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        Usuario usuario = new Usuario("Filipe", "12345", "filipe@email.com");

        biblioteca.emprestar(livro1);
        usuario.emprestarLivro(livro1);

        usuario.exibirInfo();
        biblioteca.exibirInfo();
    }
}
