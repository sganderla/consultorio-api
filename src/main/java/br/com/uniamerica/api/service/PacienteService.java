package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Paciente;
import br.com.uniamerica.api.entity.TipoAtendimento;
import br.com.uniamerica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 04/05/2022
 * @version 1.0.0
 */
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     *
     * @param id
     * @return
     */
    public Optional<Paciente> findById(Long id){
        return this.pacienteRepository.findById(id);
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<Paciente> listAll(Pageable pageable){
        return this.pacienteRepository.findAll(pageable);
    }

    /**
     *
     * @param paciente
     */
    public void insert(Paciente paciente){
        this.validarFormulario(paciente);
        this.saveTransactional(paciente);
    }

    /**
     *
     * @param id
     * @param paciente
     */
    public void update(Long id, Paciente paciente){
        if (id == paciente.getId()) {
            this.validarFormulario(paciente);
            this.saveTransactional(paciente);
        }
        else {
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param paciente
     */
    @Transactional
    public void saveTransactional(Paciente paciente){
        this.pacienteRepository.save(paciente);
    }

    /**
     *
     * @param id
     * @param paciente
     */
    @Transactional
    public void updateStatus(Long id, Paciente paciente){
        if (id == paciente.getId()) {
            this.pacienteRepository.updateDataExcluido(
                    LocalDateTime.now(),
                    paciente.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param paciente
     */
    public void validarFormulario(Paciente paciente){

        if( paciente.getTipoAtendimento().equals(TipoAtendimento.convenio) ){
            if( paciente.getConvenio() == null || paciente.getConvenio().getId() == null ){
                throw new RuntimeException(" Warning: Convênio não informado. ");
            }
            if( paciente.getNumeroCartaoConvenio() == null ){
                throw new RuntimeException(" Warning: Cartão do convênio não informado. ");
            }
            if( paciente.getDataVencimento() == null ){
                throw new RuntimeException(" Warning: Data de vencimento do cartão do convênio não informado. ");
            }
            if( paciente.getDataVencimento().compareTo(LocalDateTime.now()) <= 0 ){
                throw new RuntimeException(" Warning: Data de vencimento do cartão do convênio está expirado. ");
            }
        }

        if( paciente.getTipoAtendimento().equals(TipoAtendimento.particular) ){
            paciente.setConvenio(null);
            paciente.setNumeroCartaoConvenio(null);
            paciente.setDataVencimento(null);
        }
    }
}
