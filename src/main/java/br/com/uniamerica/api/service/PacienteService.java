package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Paciente;
import br.com.uniamerica.api.entity.TipoAtendimento;
import br.com.uniamerica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElse(new Paciente());
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<Paciente> listAll(Pageable pageable) {
        return this.pacienteRepository.findAll(pageable);
    }

    /**
     *
     * @param paciente
     */
    public void insert(Paciente paciente) {
        this.validarFormulario(paciente);
        this.saveTransactional(paciente);
    }

    /**
     *
     * @param paciente
     */
    @Transactional
    public void saveTransactional(Paciente paciente) {
        this.pacienteRepository.save(paciente);
    }

    /**
     *
     * @param id
     * @param paciente
     */
    public void update(Long id, Paciente paciente) {
        if (id == paciente.getId()) {
            this.validarFormulario(paciente);
            this.saveTransactional(paciente);
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }

    /**
     *
     * @param id
     * @param paciente
     */
    @Transactional
    public void desativar(Long id, Paciente paciente) {
        if (id == paciente.getId()) {
            this.pacienteRepository.desativar(paciente.getId());
        }
        else {
            throw new RuntimeException("Error: Não foi possivel editar a Secretaria, valores inconsistentes.");
        }
    }

    /**
     *
     * @param paciente
     */
    public void validarFormulario(Paciente paciente) {

        if (paciente.getTipoAtendimento().equals(TipoAtendimento.convenio)) {

            Assert.isTrue(paciente.getConvenio() == null || paciente.getConvenio().getId() == null,
                    "Error: Convênio não informado.");

            Assert.notNull(paciente.getNumeroCartaoConvenio(),
                    "Error: Cartão do convênio não informado.");

            Assert.notNull(paciente.getDataVencimento(),
                    "Error: Data de vencimento do cartão do convênio não informado.");

            Assert.isTrue(paciente.getDataVencimento().isBefore(LocalDateTime.now()),
                    " Error: Data de vencimento do cartão do convênio está expirado. ");
        }

        if (paciente.getTipoAtendimento().equals(TipoAtendimento.particular)) {
            paciente.setConvenio(null);
            paciente.setNumeroCartaoConvenio(null);
            paciente.setDataVencimento(null);
        }
    }
}
