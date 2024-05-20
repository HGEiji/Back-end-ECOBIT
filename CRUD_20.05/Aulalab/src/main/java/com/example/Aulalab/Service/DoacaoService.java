package com.example.Aulalab.Service;

import com.example.Aulalab.Model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.Aulalab.Model.Doacao;
import com.example.Aulalab.Model.doacaoDTO;
import com.example.Aulalab.Model.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService implements IDoacaoService {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    DoacaoRepository doacaoRepository;
    @Override
    public Optional<Doacao> cadastrarDoa(doacaoDTO d) {
        logger.info("Service de cadastro iniciado: ");
        Doacao doacao = dtoParaDoacao(d);
        return Optional.ofNullable(doacaoRepository.save(doacao));

    }

    @Override
    public Optional<doacaoDTO> consultarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Doacao> consultarDoacao() {
        return doacaoRepository.findAll();
    }


    @Override
    public doacaoDTO atualizaDoa(Long id, doacaoDTO doacao) {
        Optional<Doacao> doacaoOptional = doacaoRepository.findById(id);
        if (doacaoOptional.isPresent()) {
            Doacao doacaoExistente = doacaoOptional.get();
            doacaoExistente.setDescricao(doacao.descricao());
            doacaoExistente.setNome(doacao.nome());
            doacaoExistente.setEstatus(doacao.estatus());
            doacaoExistente.setQuatidade(doacao.quantidade());
            doacaoExistente.setCategoria(doacao.categoria());

            Doacao doacaoAtualizada = doacaoRepository.save(doacaoExistente);

            return new doacaoDTO(
                    doacaoAtualizada.getId(),
                    doacaoAtualizada.getDescricao(),
                    doacaoAtualizada.getNome(),
                    doacaoAtualizada.isEstatus(),
                    doacaoAtualizada.getQuatidade(),
                    doacaoAtualizada.getCategoria()
            );
        } else {

            throw new IllegalArgumentException("Doação não encontrada para o ID fornecido: " + id);
        }
    }


    @Override
    public void excluir(long id) {
         doacaoRepository.deleteById(id);
    }

    public Doacao dtoParaDoacao(doacaoDTO d){
        return new Doacao(d.descricao(), d.nome(),d.estatus(), d.quantidade(), d.categoria());

        //String descricao, String nome, boolean estatus, int quantidade, String categoria

    }
}
