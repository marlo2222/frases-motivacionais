package bot.motivacionais.frases.service;

import bot.motivacionais.frases.model.Frase;
import bot.motivacionais.frases.repository.FraseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class FraseService {

    private final FraseRepository fraseRepository;

    @Autowired
    public FraseService(FraseRepository fraseRepository){
        this.fraseRepository = fraseRepository;
    }

    public Frase addFrase(Frase frase){
        return fraseRepository.save(frase);
    }

    public List<Frase> findAllFrases(){
        return fraseRepository.findAll();
    }

    public Frase updateFrase(Frase frase){
        return fraseRepository.save(frase);
    }

    public void deleteFrase(Long id){
        fraseRepository.deleteFraseById(id);
    }

    public Frase findFraseByID(Long id) throws Throwable {
        return fraseRepository.findFraseById(id)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Frase by id "+ id + "was not found"));
    }

    public long contFrases(){
        return fraseRepository.count();
    }

    public Frase selectRandomFrase() throws Throwable {
        long cont = contFrases();
        int indice = new Random().nextInt((int) cont);
        if(indice == 0){
            indice++;
        }
        log.info("INDICE SELECIONADO -> " + indice);
        return findFraseByID((long) indice);
    }
}
