package Biblioteca;

import java.io.*;
import java.util.*;

public class Biblioteca {
    private Map<String, Livro> livros;
    private static final String ARQUIVO_BIBLIOTECA = "biblioteca.dat";

    public Biblioteca() {
        this.livros = new HashMap<>();
        carregarDados();
    }

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getIsbn(), livro);
        salvarDados();
    }

    public void removerLivro(String isbn) {
        livros.remove(isbn);
        salvarDados();
    }

    public Livro buscarLivro(String isbn) {
        return livros.get(isbn);
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros.values());
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BIBLIOTECA))) {
            oos.writeObject(livros);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_BIBLIOTECA))) {
            livros = (Map<String, Livro>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum dado salvo encontrado. Iniciando com biblioteca vazia.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}

