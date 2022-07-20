import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		
		
			//fazer uma conexão http
		
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build(); 
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//extrair os dados necessarios
		
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		//exibir e manipular os dados
		
		for(Map<String, String> filme: listaDeFilmes) {
			System.out.print("Rank: ");
			System.out.println(filme.get("rank"));
			
			System.out.print(filme.get("fullTitle"));
			System.out.print(", Score: ");
			System.out.println(filme.get("imDbRating"));
			System.out.println("");
			
			System.out.println(filme.get("image"));
			System.out.println("");
			
			System.out.print("Elenco: ");
			System.out.println(filme.get("crew"));
			System.out.println("");
			
		}//image
		
		
		
	}

}
