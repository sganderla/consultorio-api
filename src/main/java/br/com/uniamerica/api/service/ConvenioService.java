package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Convenio;
import br.com.uniamerica.api.repository.ConvenioRepository;
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
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    /**
     *
     * @param id
     * @return
     */
    public Convenio findById(Long id){
        return this.convenioRepository.findById(id).orElse(new Convenio());
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<Convenio> listAll(Pageable pageable){
        return this.convenioRepository.findAll(pageable);
    }

    /**
     *
     * @param convenio
     */
    @Transactional
    public void insert(Convenio convenio){
        this.convenioRepository.save(convenio);
    }

    /**
     *
     * @param id
     * @param convenio
     */
    @Transactional
    public void update(Long id, Convenio convenio){
        if (id == convenio.getId()) {
            this.convenioRepository.save(convenio);
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }

    /**
     *
     * @param id
     * @param convenio
     */
    @Transactional
    public void desativar(Long id, Convenio convenio){
        if (id == convenio.getId()) {
            this.convenioRepository.desativar(convenio.getId());
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }
}
