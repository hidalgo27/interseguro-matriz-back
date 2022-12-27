package com.interseguro.matrix;

import com.interseguro.matrix.component.MatrizDependency;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MatrixApplicationTests {

    @Autowired
    public MatrizDependency matrizDependency;

    @Test
    void matriz2Dimensiones() {
        int[][] matriz = {{1,2},{3,4}};
        String ma = matrizDependency.mat(matriz);
        Assert.assertEquals("[2, 4][1, 3]", ma);
    }
    @Test
    void matriz3Dimensiones() {
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
        String ma = matrizDependency.mat(matriz);
        Assert.assertEquals("[3, 6, 9][2, 5, 8][1, 4, 7]", ma);
    }
    @Test
    void matriz4Dimensiones() {
        int[][] matriz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        String ma = matrizDependency.mat(matriz);
        Assert.assertEquals("[4, 8, 12, 16][3, 7, 11, 15][2, 6, 10, 14][1, 5, 9, 13]", ma);
    }

    @Test
    void matrizCuadrada(){
        int[][] matriz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Assert.assertEquals( true,matrizDependency.matCuadrada(matriz));
    }

    @Test
    void matrizVacia(){
        int[][] matriz = {};
        String ma = matrizDependency.mat(matriz);
        Assert.assertEquals( "La Matriz esta vacia",ma);
    }

//    @Test
//    void notNullExceptionMatriz() {
//        int[][] matriz = {};
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            throw new IllegalArgumentException(matrizDependency.mat(matriz));
//        });
//        Assert.assertEquals(exception.getMessage(), "1");
//    }
}
