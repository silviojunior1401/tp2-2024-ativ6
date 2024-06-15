package edu.fatec.aulamvc.model;

public class Imovel {

    private Integer matricula;

    private String[] proprietarios;

    private TipoImovel tipoImovel;

    private Double valorVenal;

    private Double area;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String[] getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(String[] proprietarios) {
        this.proprietarios = proprietarios;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Double getValorVenal() {
        return valorVenal;
    }

    public void setValorVenal(Double valorVenal) {
        this.valorVenal = valorVenal;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
