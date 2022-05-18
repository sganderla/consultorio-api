package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    /**
     *
     * @param dataExcluido
     * @param idMedico
     */
    @Modifying
    @Query("UPDATE Medico medico " +
            "SET medico.excluido = :dataExcluido " +
            "WHERE medico.id = :idMedico")
    public void updateDataExcluido(
            @Param("dataExcluido") LocalDateTime dataExcluido,
            @Param("idMedico") Long idMedico);

}
