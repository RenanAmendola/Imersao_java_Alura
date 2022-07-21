import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class FabricaDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
	
	//ler a imagem
		
		//Utilizando o arquivo localmente
	//InputStream inputStream = new FileInputStream("entradas/TopMovies_1.jpg");
	
		//utilizando o arquivo por um link
	//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
	
	BufferedImage imagemOriginal = ImageIO.read(inputStream);
	
	
	//criar a nova imagem com transparencia e tamanho novos
	int largura = imagemOriginal.getWidth();
	int altura = imagemOriginal.getHeight();
	int novaAltura = altura + 200;
	BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
	
	
	// copiar a imagem original pra nova imagem
	Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
	graphics.drawImage(imagemOriginal, 0, 0, null);
	
	
	//configurar a fonte
	var fonte = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 52);
	graphics.setColor(Color.GREEN);
	graphics.setFont(fonte);
	
	
	//escrever uma  frase
	
	graphics.drawString("Muito bom, recomendo", 35 , novaAltura - 100);
	
	
	
	// escrever a nova imagem em um arquivo
	
	ImageIO.write(novaImagem, "png", new File("saida/",nomeArquivo));
	
	}
	

	
	
}