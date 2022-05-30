package br.com.uniamerica.api.controller;

import br.com.uniamerica.api.entity.Convenio;
import br.com.uniamerica.api.service.ConvenioService;
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
@RequestMapping("/api/convenios")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    /**
     *
     * @param idConvenio
     * @return
     */
    @GetMapping("/{idConvenio}")
    public ResponseEntity<Convenio> findById(
            @PathVariable("idConvenio") Long idConvenio
    ){
        return ResponseEntity.ok().body(this.convenioService.findById(idConvenio));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public ResponseEntity<Page<Convenio>> listByAllPage(
            Pageable pageable
    ){
        return ResponseEntity.ok().body(this.convenioService.listAll(pageable));
    }

    /**
     *
     * @param convenio
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Convenio convenio
    ){
        try {
            this.convenioService.insert(convenio);
            return ResponseEntity.ok().body("Convênio Cadastrada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idConvenio
     * @param convenio
     * @return
     */
    @PutMapping("/{idConvenio}")
    public ResponseEntity<?> update(
            @PathVariable Long idConvenio,
            @RequestBody Convenio convenio
    ){
        try {
            this.convenioService.update(idConvenio, convenio);
            return ResponseEntity.ok().body("Convênio Atualizada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param idConvenio
     * @param convenio
     * @return
     */
    @PutMapping("/desativar/{idConvenio}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idConvenio,
            @RequestBody Convenio convenio
    ){
        try {
            this.convenioService.desativar(idConvenio, convenio);
            return ResponseEntity.ok().body("Convênio Desativada com Sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
