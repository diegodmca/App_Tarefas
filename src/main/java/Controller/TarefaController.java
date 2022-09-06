
package Controller;


import java.sql.Connection;
import Model.Tarefas;
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

public class TarefaController {
    
    public void salvar(Tarefas tarefa){
        
       String sql = "INSERT INTO tasks (idProject, name, description, "
               + "completed, "
               + "notes, "
               + "deadline, "
               + "createdAt, "
               + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           connection = credenciaisBd.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setInt(1, tarefa.getIdProjeto());
           statement.setString(2, tarefa.getNome());
           statement.setString(3, tarefa.getDescricao());
           statement.setBoolean(4, tarefa.isConcluido());
           statement.setString(5, tarefa.getAnotacoes());
           statement.setDate(6, new Date(tarefa.getPrazo().getTime()));
           statement.setDate(7, new Date(tarefa.getCriadoEm().getTime()));
           statement.setDate(8, new Date(tarefa.getAtualizadoEm().getTime()));
           statement.execute();
        
    }catch (Exception ex) {
        
        throw new RuntimeException("Erro ao salvar a tarefa", ex);
        
    }finally {
           credenciaisBd.closeConnection(connection, statement);
       }
    }
    
    public void atualiza(Tarefas tarefa){
        
       String sql = "UPDATE tasks SET idProject = ?, name = ?, "
               + "description = ?, "
               + "notes = ?, "
               + "completed = ?, "
               + "deadline = ?,"
               + "createdAt = ?, "
               + "updatedAt = ? "
               + "WHERE id = ?";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           connection = credenciaisBd.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setInt(1, tarefa.getIdProjeto());
           statement.setString(2, tarefa.getNome());
           statement.setString(3, tarefa.getDescricao());
           statement.setString(4, tarefa.getAnotacoes());
           statement.setBoolean(5, tarefa.isConcluido());
           statement.setDate(6, new Date(tarefa.getPrazo().getTime()));
           statement.setDate(7, new Date(tarefa.getCriadoEm().getTime()));
           statement.setDate(8, new Date(tarefa.getAtualizadoEm().getTime()));
           statement.setInt(9, tarefa.getId());
           statement.execute();
           
       }catch (Exception ex) {
           throw new RuntimeException("Erro ao atualizar", ex);
           
       }finally {
           credenciaisBd.closeConnection(connection, statement);
       }
    }
    
    public void apagarPorId(int tarefaId){
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = credenciaisBd.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, tarefaId);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa", ex);
            
        }finally {
            credenciaisBd.closeConnection(connection, statement);
        }
    }
    
    public List<Tarefas> todasTarefas(int projetoId){
        
        String sql = "SELECT * FROM tasks WHERE idproject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Lista de tarefas que sera devolvida
        List<Tarefas> listaTarefas = new ArrayList<Tarefas>();
        
        try {
            connection = credenciaisBd.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projetoId);
            //valor retornado pela execucao da query
            resultSet = statement.executeQuery();
            //enquanto houver valores, percorrer
            while(resultSet.next()){
                Tarefas tarefa = new Tarefas();
                
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setIdProjeto(resultSet.getInt("idproject"));
                tarefa.setNome(resultSet.getString("name"));
                tarefa.setDescricao(resultSet.getString("description"));
                tarefa.setAnotacoes(resultSet.getString("notes"));
                tarefa.setConcluido(resultSet.getBoolean("completed"));
                tarefa.setPrazo(resultSet.getDate("deadline"));
                tarefa.setCriadoEm(resultSet.getDate("createdAt"));
                tarefa.setAtualizadoEm(resultSet.getDate("updatedAt"));
                
                listaTarefas.add(tarefa);
            }
        }catch(Exception ex) {
            
            throw new RuntimeException("Erro ao capturar as informacoes", ex);
            
        }finally {
            credenciaisBd.closeConnection(connection, statement);
            
        }
        return listaTarefas;
    }
}
