package com.interseguro.matrix.service;

import com.interseguro.matrix.entities.Matriz;
import com.interseguro.matrix.repository.MatrizRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MatrizService {
    private final Log LOG = LogFactory.getLog(MatrizService.class);
    private MatrizRepository matrizRepository;

    public MatrizService(MatrizRepository matrizRepository) {
        this.matrizRepository = matrizRepository;
    }

    @Transactional
    public void saveTransactional(List<Matriz> matrizs){
        matrizs.stream()
                .peek(matriz -> LOG.info("Matriz insertada: "+matrizs))
                .forEach(matrizRepository::save);
    }
    public List<Matriz> getAllMatriz(){
        return matrizRepository.findAll();
    }
    public Matriz save(Matriz newMatriz){
        return matrizRepository.save(newMatriz);
    }
    public void delete(Long id) {
        matrizRepository.delete(new Matriz(id));
    }
    public Matriz update(Matriz newMatriz, Long id) {
        return matrizRepository.findById(id)
                .map(
                        matrizs -> {
                            matrizs.setMatriz(newMatriz.getMatriz());
                            return matrizRepository.save(matrizs);
                        }
                ).get();
    }
}
