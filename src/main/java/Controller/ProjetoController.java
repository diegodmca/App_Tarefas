
package Controller;

import Model.Projetos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.credenciaisBd;

/**
 *
 * @author diegocarvalho
 */
public class ProjetoController {
    
    public void salvar (Projetos projetos){
        
        String sql = "INSERT INTO projects (name, description, "
                + "createdAt, "
                + "updatedAt) VALUES(?, ?, ?, ?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = credenciaisBd.getConnection();
            statement = connect.prepareStatement(sql);
            statement.setString(1, projetos.getNome());
            statement.setString(2, projetos.getDescricao());
            statement.setDate(3, new Date(projetos.getCriadoEm().getTime()));
            statement.setDate(4, new Date(projetos.getAtualizadoEm().getTime()));
            statement.execute();
            
        }catch (Exception ex) {
            
            throw new RuntimeException("Erro ao salvar o projeto", ex);
            
        }finally {
            credenciaisBd.closeConnection(connect, statement);
        }
    }
    public void atualizar(Projetos projetos){
        
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = credenciaisBd.getConnection();
            statement = connect.prepareStatement(sql);
            statement.setString(1, projetos.getNome());
            statement.setString(2, projetos.getDescricao());
            statement.setDate(3, new Date(projetos.getCriadoEm().getTime()));
            statement.setDate(4, new Date(projetos.getAtualizadoEm().getTime()));
            statement.setInt(5, projetos.getId());
            
        }catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar as informacoes", ex);
            
        }finally {
            credenciaisBd.closeConnection(connect, statement);
        }
    }
    public void apagarPorId(int projetoId){
        
          String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = credenciaisBd.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projetoId);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa", ex);
            
        }finally {
            credenciaisBd.closeConnection(connection, statement);
        }
    }
    public List<Projetos> todosProjetos(){
       String sql = "SELECT * FROM projects";
        
       
        //Lista de projetos que sera devolvida
        List<Projetos> listaProjetos = new ArrayList<Projetos>();
        
         Connection connection = null;
         PreparedStatement statement = null;
         ResultSet resultSet = null;
        
        
        try {
            connection = credenciaisBd.getConnection();
            statement = connection.prepareStatement(sql);
            
            //valor retornado pela execucao da query
            resultSet = statement.executeQuery();
            //enquanto houver valores, percorrer
            while(resultSet.next()){
                Projetos projeto = new Projetos();
                
                projeto.setNome(resultSet.getString("name"));
                projeto.setDescricao(resultSet.getString("description"));
                projeto.setCriadoEm(resultSet.getDate("createdAt"));
                projeto.setAtualizadoEm(resultSet.getDate("updatedAt"));
                
                listaProjetos.add(projeto);
            }
        }catch(Exception ex) {
            throw new RuntimeException("Erro ao atualizar a lista de projetos", ex);
        }finally {
            credenciaisBd.closeConnection(connection, statement);
            
        }
        return listaProjetos;
            }
}