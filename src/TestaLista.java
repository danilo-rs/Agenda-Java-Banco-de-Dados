import java.util.List;

public class TestaLista {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		for(Contato contato : contatos){
			System.out.println("Nome: "+ contato.getNome());
			System.out.println("Telefone: "+contato.getTelefone());
			System.out.println("Email: "+contato.getEmail());
			System.out.println("------------------------------------------");
		}
	}

}
