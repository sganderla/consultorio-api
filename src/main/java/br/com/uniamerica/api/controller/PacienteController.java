package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Paciente;
import br.com.uniamerica.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 07/04/2022
 * @version 1.0.0
 */
@Controller
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /**
     *
     * @param idPaciente
     * @return
     */
    @GetMapping("/{idPaciente}")
    public ResponseEntity<Paciente> findById(
            @PathVariable("idPaciente") Long idPaciente
    ){
        return ResponseEntity.ok().body(this.pacienteService.findById(idPaciente));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Paciente>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.pacienteService.listAll(pageable));
    }

    /**
     *
     * @param paciente
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Paciente paciente
    ){
        try {
            this.pacienteService.insert(paciente);
            return ResponseEntity.ok().body("Paciente Cadastrada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idPaciente
     * @param paciente
     * @return
     */
    @PutMapping("/{idPaciente}")
    public ResponseEntity<?> update(
            @PathVariable Long idPaciente,
            @RequestBody Paciente paciente
    ){
        try {
            this.pacienteService.update(idPaciente, paciente);
            return ResponseEntity.ok().body("Paciente Atualizada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idPaciente
     * @param paciente
     * @return
     */
    @PutMapping("/desativar/{idPaciente}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idPaciente,
            @RequestBody Paciente paciente
    ){
        try {
            this.pacienteService.desativar(idPaciente, paciente);
            return ResponseEntity.ok().body("Paciente Desativada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
