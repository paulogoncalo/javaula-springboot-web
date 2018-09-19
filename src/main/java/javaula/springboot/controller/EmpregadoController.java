package javaula.springboot.controller;

import java.util.List;
import java.util.Optional;

import javaula.springboot.model.Empregado;
import javaula.springboot.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prjunior
 * @version $Revision: $<br/>
 * $Id: $
 * @since 29/08/18 10:12
 */
@RestController
@RequestMapping("empregado")
public class EmpregadoController {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @PostMapping
    public ResponseEntity postEmpregado(@RequestBody Empregado empregadoRequest) {

        Empregado empregado = empregadoRepository.save(empregadoRequest);

        return new ResponseEntity<>(empregado.getId(), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity getEmpregadoById(@PathVariable Long id) {

        Optional<Empregado> empregado = empregadoRepository.findById(id);

        if(empregado.isPresent()) {
            return new ResponseEntity<>(empregado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
    @GetMapping
    public ResponseEntity getListEmpregadoByNomeOrderByDataNascimento(@RequestParam(name = "nome", required = true) String nome) {

        List<Empregado> empregado = empregadoRepository.findByNomeOrderByDataNascimentoAsc(nome);

        if(!empregado.isEmpty()) {
            return new ResponseEntity<>(empregado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{nome}/{departamento}")
    public ResponseEntity getEmpregadoByNomeDepartamento(@PathVariable String nome,
            @PathVariable String departamento) {

        Optional<Empregado> empregado = empregadoRepository.findByNomeAndDepartamento(nome, departamento);

        if(empregado.isPresent()) {
            return new ResponseEntity<>(empregado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
