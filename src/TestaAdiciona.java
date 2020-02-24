
public class TestaAdiciona {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome("Beto Chulé");
		contato.setTelefone("85 98684 6858");
		contato.setEmail("beto@email.com");
		
		//grave nessa conexao!!!
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado com Sucesso!");

	}

}
