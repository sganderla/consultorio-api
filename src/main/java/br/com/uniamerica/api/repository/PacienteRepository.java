package br.com.uniamerica.api.repository;

import br.com.uniamerica.api.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 05/04/2022
 * @version 1.0.0
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    /**
     *
     * @param dataExcluido
     * @param idPaciente
     */
    @Modifying
    @Query("UPDATE Paciente paciente " +
            "SET paciente.excluido = :dataExcluido " +
            "WHERE paciente.id = :idPaciente")
    public void updateDataExcluido(
            @Param("dataExcluido") LocalDateTime dataExcluido,
            @Param("idPaciente") Long idPaciente);

}
