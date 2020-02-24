import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ContatoDao {
	private Connection connection;
	
	public ContatoDao(){
		this.connection= new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contato" + "(nome, tel, email)" + "values (?,?,?)";
		try{
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEmail());
			
			// executa
			stmt.execute();
			stmt.close();
		
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contato");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				// Criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("codigo"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("tel"));
				contato.setEmail(rs.getString("email"));
				
				// Adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
