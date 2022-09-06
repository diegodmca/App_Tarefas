
package Model;

import java.util.Date;

/**
 *
 * @author diegocarvalho
 */
public class Tarefas {
    
    private int id;
    private int idProjeto;
    private String nome;
    private String descricao;
    private boolean concluido;
    private String anotacoes;
    private Date prazo;
    private Date criadoEm;
    private Date atualizadoEm;

    public Tarefas(int id, int idProjeto, String nome, String descricao, boolean concluido, String anotacoes, Date prazo, Date criadoEm, Date atualizadoEm) {
        this.id = id;
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
        this.anotacoes = anotacoes;
        this.prazo = prazo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    
    public Tarefas() {
        this.concluido = false;
        this.criadoEm = new Date();
        this.atualizadoEm = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
    
}
