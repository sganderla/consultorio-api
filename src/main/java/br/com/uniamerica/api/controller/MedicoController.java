package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Medico;
import br.com.uniamerica.api.service.MedicoService;
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
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    /**
     *
     * @param idMedico
     * @return
     */
    @GetMapping("/{idMedico}")
    public ResponseEntity<Medico> findById(
            @PathVariable("idMedico") Long idMedico
    ){
        return ResponseEntity.ok().body(this.medicoService.findById(idMedico));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Medico>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.medicoService.listAll(pageable));
    }

    /**
     *
     * @param medico
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Medico medico
    ){
        try {
            this.medicoService.insert(medico);
            return ResponseEntity.ok().body("Médico Cadastrada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idMedico
     * @param medico
     * @return
     */
    @PutMapping("/{idMedico}")
    public ResponseEntity<?> update(
            @PathVariable Long idMedico,
            @RequestBody Medico medico
    ){
        try {
            this.medicoService.update(idMedico, medico);
            return ResponseEntity.ok().body("Médico Atualizada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idMedico
     * @param medico
     * @return
     */
    @PutMapping("/desativar/{idMedico}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idMedico,
            @RequestBody Medico medico
    ){
        try {
            this.medicoService.desativar(idMedico, medico);
            return ResponseEntity.ok().body("Médico Desativada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
