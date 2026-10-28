package br.com.etechas.clubedolivro.service;



import com.example.clubedolivro.model.Livro;
import com.example.clubedolivro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setLido(livroAtualizado.getLido());
            return livroRepository.save(livro);
        }).orElse(null);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
