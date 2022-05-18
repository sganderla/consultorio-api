package br.com.uniamerica.api.service;

import br.com.uniamerica.api.entity.Agenda;
import br.com.uniamerica.api.repository.AgendaRepository;
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
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    /**
     *
     * @param id
     * @return
     */
    public Optional<Agenda> findById(Long id){
        return this.agendaRepository.findById(id);
    }

    /**
     *
     * @param pageable
     * @return
     */
    public Page<Agenda> listAll(Pageable pageable){
        return this.agendaRepository.findAll(pageable);
    }

    /**
     *
     * @param id
     * @param agenda
     */
    @Transactional
    public void update(Long id, Agenda agenda){
        if (id == agenda.getId()) {
            this.agendaRepository.save(agenda);
        }
        else {
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param agenda
     */
    @Transactional
    public void insert(Agenda agenda){
        this.agendaRepository.save(agenda);
    }

    /**
     *
     * @param id
     * @param agenda
     */
    @Transactional
    public void updateStatus(Long id, Agenda agenda){
        if (id == agenda.getId()) {
            this.agendaRepository.updateDataExcluido(
                    LocalDateTime.now(),
                    agenda.getId());
        }
        else {
            throw new RuntimeException();
        }
    }
}
