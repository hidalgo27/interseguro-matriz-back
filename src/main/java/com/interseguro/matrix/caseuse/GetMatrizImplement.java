package com.interseguro.matrix.caseuse;

import com.interseguro.matrix.entities.Matriz;
import com.interseguro.matrix.service.MatrizService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatrizImplement implements GetMatriz{
    private MatrizService matrizService;

    public GetMatrizImplement(MatrizService matrizService) {
        this.matrizService = matrizService;
    }

    @Override
    public List<Matriz> getAll() {
        return matrizService.getAllMatriz();
    }
}
