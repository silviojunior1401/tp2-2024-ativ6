package edu.fatec.aulamvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.fatec.aulamvc.model.Imovel;
import edu.fatec.aulamvc.business.ImovelBusiness;
import java.util.Map;


@RestController
public class ImovelController {

    @Autowired
    private ImovelBusiness imovelBusiness;

    @PostMapping(path = "/imoveis")
    public ResponseEntity<?> cadastrar(@RequestBody Imovel imovel) {
        Imovel imovelCadastrado = this.imovelBusiness.salvarImovel(imovel);

        return ResponseEntity.status(HttpStatus.CREATED).body(imovelCadastrado);
    }

    @GetMapping(path = "/imoveis")
    public List<Imovel> consultarProduto() {
        return this.imovelBusiness.listarImoveis();
    }

    @GetMapping(path = "/imoveis/{matricula}")
    public Imovel consultarMatricula(@PathVariable("matricula") Integer matricula) {
        return this.imovelBusiness.consultarMatricula(matricula);
    }
    
    @DeleteMapping(path = "/imoveis/{matricula}")
    public Imovel removerMatricula(@PathVariable("matricula") Integer matricula) {
        return this.imovelBusiness.removerMatricula(matricula);
    }
    
    @GetMapping(path = "/imoveis/calculoiptu/{matricula}")
    public List<Double> calculoIPTU(@PathVariable("matricula") Integer matricula) {
        return this.imovelBusiness.calculoIPTUMatricula(matricula);
    }
    
    @GetMapping(path = "/imoveis/valorvenal/tipo")
    public Map<String, Double> calculoValorTotalPorTipo() {
        return this.imovelBusiness.calculoValorTotalPorTipo();
    }
}
