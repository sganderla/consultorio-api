package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Especialidade;
import br.com.uniamerica.api.service.EspecialidadeService;
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
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    /**
     *
     * @param idEspecialidade
     * @return
     */
    @GetMapping("/{idEspecialidade}")
    public ResponseEntity<Especialidade> findById(
            @PathVariable("idEspecialidade") Long idEspecialidade
    ){
        return ResponseEntity.ok().body(this.especialidadeService.findById(idEspecialidade));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Especialidade>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.especialidadeService.listAll(pageable));
    }

    /**
     *
     * @param especialidade
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Especialidade especialidade
    ){
        try {
            this.especialidadeService.insert(especialidade);
            return ResponseEntity.ok().body("Especialidade Cadastrada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idEspecialidade
     * @param especialidade
     * @return
     */
    @PutMapping("/{idEspecialidade}")
    public ResponseEntity<?> update(
            @PathVariable Long idEspecialidade,
            @RequestBody Especialidade especialidade
    ){
        try {
            this.especialidadeService.update(idEspecialidade, especialidade);
            return ResponseEntity.ok().body("Especialidade Atualizada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idEspecialidade
     * @param especialidade
     * @return
     */
    @PutMapping("/desativar/{idEspecialidade}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idEspecialidade,
            @RequestBody Especialidade especialidade
    ){
        try {
            this.especialidadeService.desativar(idEspecialidade, especialidade);
            return ResponseEntity.ok().body("Especialidade Desativada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
