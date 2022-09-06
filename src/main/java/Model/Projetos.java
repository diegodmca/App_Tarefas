
package Model;

import java.util.Date;

/**
 *
 * @author diegocarvalho
 */
public class Projetos {
    
   private int id;
   private String nome;
   private String descricao;
   private Date criadoEm;
   private Date atualizadoEm;

    public Projetos(int id, String nome, String descricao, Date criadoEm, Date atualizadoEm) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    
    public Projetos(){
        this.criadoEm = new Date();
        this.atualizadoEm = new Date();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    @Override
    public String toString() {
        return nome;
    }
    
    
    
   
    
}
