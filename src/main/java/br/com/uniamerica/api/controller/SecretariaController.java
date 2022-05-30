package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Secretaria;
import br.com.uniamerica.api.service.SecretariaService;
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
@RequestMapping("/api/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    /**
     *
     * @param idSecretaria
     * @return
     */
    @GetMapping("/{idSecretaria}")
    public ResponseEntity<Secretaria> findById(
            @PathVariable("idSecretaria") Long idSecretaria
    ){
        return ResponseEntity.ok().body(this.secretariaService.findById(idSecretaria));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Secretaria>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.secretariaService.listAll(pageable));
    }

    /**
     *
     * @param secretaria
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Secretaria secretaria
    ){
        try {
            this.secretariaService.insert(secretaria);
            return ResponseEntity.ok().body("Secretaria Cadastrada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idSecretaria
     * @param secretaria
     * @return
     */
    @PutMapping("/{idSecretaria}")
    public ResponseEntity<?> update(
            @PathVariable Long idSecretaria,
            @RequestBody Secretaria secretaria
    ){
        try {
            this.secretariaService.update(idSecretaria, secretaria);
            return ResponseEntity.ok().body("Secretaria Atualizada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idSecretaria
     * @param secretaria
     * @return
     */
    @PutMapping("/desativar/{idEspecialidade}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idSecretaria,
            @RequestBody Secretaria secretaria
    ){
        try {
            this.secretariaService.desativar(idSecretaria, secretaria);
            return ResponseEntity.ok().body("Secretaria Desativada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
