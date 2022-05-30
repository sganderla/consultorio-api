package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Secretaria;
import br.com.uniamerica.api.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 27/04/2022
 * @version 1.0.0
 */
@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    /**
     *
     * @param id
     * @return
     */
    public Secretaria findById(Long id){
        return this.secretariaRepository.findById(id).orElse(new Secretaria());
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<Secretaria> listAll(Pageable pageable){
        return this.secretariaRepository.findAll(pageable);
    }

    /**
     *
     * @param secretaria
     */
    @Transactional
    public void insert(Secretaria secretaria){
        this.secretariaRepository.save(secretaria);
    }

    /**
     *
     * @param id
     * @param secretaria
     */
    @Transactional
    public void update(Long id, Secretaria secretaria){
        if (id == secretaria.getId()) {
            this.secretariaRepository.save(secretaria);
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }

    /**
     *
     * @param id
     * @param secretaria
     */
    @Transactional
    public void desativar(Long id, Secretaria secretaria){
        if (id == secretaria.getId()) {
            this.secretariaRepository.desativar(secretaria.getId());
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }
}
