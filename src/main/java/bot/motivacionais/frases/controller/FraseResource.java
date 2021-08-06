package bot.motivacionais.frases.controller;

import bot.motivacionais.frases.model.Frase;
import bot.motivacionais.frases.service.FraseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/frase")
@Api(value = "Lista de endpoints")
public class FraseResource {

    private final FraseService fraseService;

    @Autowired
    public FraseResource(FraseService fraseService){
        this.fraseService = fraseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Frase>> getAllFrases(){
        List<Frase> frases = fraseService.findAllFrases();
        return new ResponseEntity<>(frases, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Frase> getFraseById(@PathVariable("id")Long id) throws Throwable {
        Frase frases = fraseService.findFraseByID(id);
        return new ResponseEntity<>(frases, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Frase> addFrase(@RequestBody Frase frase){
        Frase newFrase = fraseService.addFrase(frase);
        return new ResponseEntity<>(newFrase, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Frase> updateFrase(@RequestBody Frase frase){
        Frase updateFrase = fraseService.updateFrase(frase);
        return new ResponseEntity<>(updateFrase, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Frase> deleteFrase(@PathVariable("id") Long id){
        fraseService.deleteFrase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<Frase> selectRandomFrase() throws Throwable {
        Frase frase = fraseService.selectRandomFrase();
        return new ResponseEntity<>(frase, HttpStatus.OK);
    }
}
