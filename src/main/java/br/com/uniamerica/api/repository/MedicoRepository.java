package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    /**
     * @see Medico#Medico(Long, String, String)
     */
    @Query("SELECT new Medico(medico.id, medico.nome, medico.crm) FROM Medico medico")
    public List<Medico> listTable();

}
