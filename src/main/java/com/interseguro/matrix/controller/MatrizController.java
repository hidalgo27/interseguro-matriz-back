package com.interseguro.matrix.controller;

import com.interseguro.matrix.caseuse.CreateMatriz;
import com.interseguro.matrix.caseuse.GetMatriz;
import com.interseguro.matrix.component.MatrizDependency;
import com.interseguro.matrix.dto.MatrizRequest;
import com.interseguro.matrix.dto.MatrizResponse;
import com.interseguro.matrix.entities.Matriz;
import com.interseguro.matrix.repository.MatrizRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/matrix/")
public class MatrizController {
    private MatrizRepository matrizRepository;

    private GetMatriz getMatriz;

    private MatrizDependency matrizDependency;

    public MatrizController(MatrizRepository matrizRepository, GetMatriz getMatriz, MatrizDependency matrizDependency) {
        this.matrizRepository = matrizRepository;
        this.getMatriz = getMatriz;
        this.matrizDependency = matrizDependency;
    }

    @PostMapping()
    public MatrizResponse calcular(@RequestBody MatrizRequest rq) {

        MatrizResponse rs = new MatrizResponse();

        String ma = matrizDependency.mat(rq.getMatriz());

        rs.setResultado(ma);

        return rs;
    }
    @GetMapping("/")
    List<Matriz> get(){
        return getMatriz.getAll();
    }
}
