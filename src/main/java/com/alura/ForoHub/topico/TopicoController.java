package com.alura.ForoHub.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoModel> registrarTopico(@RequestBody TopicoModel request){
        TopicoModel topicoModel = this.topicoService.registrarTopico(request);
        return ResponseEntity.ok(topicoModel);
    }

    @GetMapping
    public ResponseEntity<ArrayList<TopicoModel>> listarTopicos(){
        ArrayList<TopicoModel> arrayList = (ArrayList<TopicoModel>) this.topicoService.listarTopicos();
        return ResponseEntity.ok(arrayList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity obtenerTopico(@PathVariable("id") Long id){
        Optional<TopicoModel> topicoModel = this.topicoService.obtenerTopico(id);
        if (topicoModel == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(topicoModel);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TopicoModel> actualizarTopico(@PathVariable("id") Long id, @RequestBody TopicoModel request){
        TopicoModel topicoModel = this.topicoService.actualizarTopico(id, request);
        if (topicoModel == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(topicoModel);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity eliminarTopico(@PathVariable("id") Long id){
        boolean eliminado = this.topicoService.eliminarTopico(id);
        if (eliminado){
            return ResponseEntity.ok(id);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
