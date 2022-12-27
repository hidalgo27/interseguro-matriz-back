package com.interseguro.matrix.component;

import com.interseguro.matrix.entities.Matriz;
import com.interseguro.matrix.repository.MatrizRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MatrizImplement implements MatrizDependency{

    private MatrizRepository matrizRepository;

    public MatrizImplement(MatrizRepository matrizRepository) {
        this.matrizRepository = matrizRepository;
    }

    @Override
    public String mat(int[][] matrix) {
        int[][] matriz = matrix;

        // Verificamos si la matriz es nula o vacia
        if (matriz == null || matriz.length == 0) {
//            throw new IllegalArgumentException("La Matriz esta vacia");
            return "La Matriz esta vacia";
        }

        // Verificamos si la matriz es cuadrada
        if (matCuadrada(matrix) && (matriz[0].length > 1) && (matriz.length > 1)) {

            // Calculamos la longitud de la matriz
            int lng_matrix = matriz.length;
            // Algorito para sacar la matriz Transpuesta
            for (int i = 0; i < lng_matrix; i++) {
                for (int j = 0; j < i; j++) {
                    // Usamos el algorito de intercambio
                    int temp = matriz[i][j];
                    matriz[i][j] = matriz[j][i];
                    matriz[j][i] = temp;
                }
            }
            // Usamos el algorito de intercambio para intercambiar filas
            for (int i = 0; i < lng_matrix / 2; i++) {
                for (int j = 0; j < lng_matrix; j++) {
                    int temp = matriz[i][j];
                    matriz[i][j] = matriz[lng_matrix - i - 1][j];
                    matriz[lng_matrix - i - 1][j] = temp;
                }
            }

            // Recorremos el arreglo con el resultado y convertimos a String
            StringBuilder stringMatriz = new StringBuilder();
            for (var mat : matriz) {
                stringMatriz.append(Arrays.toString(mat));
            }

            // Guardamos el resultado en base de datos
            Matriz matr = new Matriz(stringMatriz.toString());
            matrizRepository.save(matr);

            // retornamos la matriz rotada
            return stringMatriz.toString();

        }else {
            return "Matriz invalida";
        }
    }
    // Metodo que verifica si una matriz es cuadrada o no
    public Boolean matCuadrada(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i].length != matriz.length){
                return false;
            }
        }
        return true;
    }
}
