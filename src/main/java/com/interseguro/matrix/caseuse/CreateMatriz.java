package com.interseguro.matrix.caseuse;

import com.interseguro.matrix.entities.Matriz;
import com.interseguro.matrix.service.MatrizService;
import org.springframework.stereotype.Component;

@Component
public class CreateMatriz {
    private MatrizService matrizService;

    public CreateMatriz(MatrizService matrizService) {
        this.matrizService = matrizService;
    }
    public Matriz save(Matriz newMatriz){
        return matrizService.save(newMatriz);
    }
}
