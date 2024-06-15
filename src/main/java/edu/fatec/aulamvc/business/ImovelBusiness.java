/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fatec.aulamvc.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fatec.aulamvc.model.Imovel;
import edu.fatec.aulamvc.repository.ImovelRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Silvio Junior
 */
@Service
public class ImovelBusiness {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel salvarImovel(Imovel imovel){
        return this.imovelRepository.cadastro(imovel);
    }
    
    public List<Imovel> listarImoveis() {
        return this.imovelRepository.getImoveis();
    }
    
    public Imovel consultarMatricula(Integer matricula) {
       return this.imovelRepository.consultarMatricula(matricula);
    }
    
    public Imovel removerMatricula(Integer matricula) {
       return this.imovelRepository.removerMatricula(matricula);
    }
    
    public Double calculoIPTU(Imovel imovel) {
      
        switch (imovel.getTipoImovel()) {
            case CASA -> {
                if(imovel.getArea() <= 200) {
                    return (imovel.getArea() * 5) + 200 + (imovel.getValorVenal() * 0.05);
                }
                
                return (imovel.getArea() * 6) + 350 + (imovel.getValorVenal() * 0.08);
            }
            case TERRENO -> {
               if(imovel.getArea() <= 400) {
                    return (imovel.getArea() * 3) + 500;
                }
                
                return (imovel.getArea() * 10) + 500; 
            }
            case APARTAMENTO -> {
                if(imovel.getArea() <= 150) {
                    return (imovel.getArea() * 2) + 200 + (imovel.getValorVenal() * 0.03);
                }
                
                return (imovel.getArea() * 4) + 350 + (imovel.getValorVenal() * 0.10);
            }
            default -> {
                return 0D;
            }
        }
    }
    
    public List<Double> calculoIPTUMatricula(Integer matricula) {
        Imovel imovel = this.imovelRepository.consultarMatricula(matricula);
        
        List<Double> imposto = new ArrayList<>();
        
        Double iptu = this.calculoIPTU(imovel);
        
        for (int i = 0; i <= 5; i++) {
            imposto.add(iptu);
            
            iptu += iptu * 0.07;
        }
        
        return imposto;
    }
    
    public Map<String, Double> calculoValorTotalPorTipo() {
        List<Imovel> imoveis = this.imovelRepository.getImoveis();
        
        Double totalCasa = 0D;
        Double totalTerreno = 0D;
        Double totalApartamento = 0D;
        
        Map<String, Double> total = new HashMap<>();
        
        for (Imovel imovel : imoveis) {
            switch (imovel.getTipoImovel()) {
                case CASA -> totalCasa += imovel.getValorVenal();
                case TERRENO -> totalTerreno += imovel.getValorVenal();
                case APARTAMENTO -> totalApartamento += imovel.getValorVenal();
            }
        }
        
        total.put("Total Casa", totalCasa);
        total.put("Total Terreno", totalTerreno);
        total.put("Total Apartamento", totalApartamento);
      
        return total;
    }
}
