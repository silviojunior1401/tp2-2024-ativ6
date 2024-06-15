/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fatec.aulamvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.fatec.aulamvc.model.Imovel;

/**
 *
 * @author Silvio Junior
 */
@Repository
public class ImovelRepository {

    private static final List<Imovel> listaImoveis = new ArrayList<>();

    public Imovel cadastro(Imovel imovel) {
        listaImoveis.add(imovel);

        return imovel;
    }
    
    public List<Imovel> getImoveis() {
        return listaImoveis;
    }
    
    public Imovel consultarMatricula(Integer matricula) {
       
        for(Imovel p: listaImoveis) {
            if(p.getMatricula().equals(matricula)){
                return p;
            }
        }
        
        return null;
    }
    
    public Imovel removerMatricula(Integer matricula) {
       
        for(Imovel p: listaImoveis) {
            if(p.getMatricula().equals(matricula)){
                listaImoveis.remove(p);
                return p;
            }
        }
        
        return null;
    }
}
