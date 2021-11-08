package exercicio7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GravadorDeDados {
	
	private String arquivoJogadores;
	private String arquivoPatroc;
	private String arquivoProd;
	
	public GravadorDeDados() {
		this.arquivoJogadores = "Jogadores.txt";
		this.arquivoPatroc = "Patrocinadores.txt";
		this.arquivoProd = "ProdutosVasco.txt";
	}
	
	public GravadorDeDados(String arquivoJogadores, String arquivoPatroc, String arquivoProd){
		this.arquivoJogadores = arquivoJogadores;
		this.arquivoPatroc = arquivoPatroc;
		this.arquivoProd = arquivoProd;
	}
	
	public void gravarJogadores(Collection<Jogador> jogadores) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoJogadores));
			List<Jogador> jogadorGravar = new ArrayList<Jogador>();
			jogadorGravar.addAll(jogadores);
			out.writeObject(jogadorGravar);
		} catch (FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo" + arquivoJogadores);
		} catch (IOException e) {
			throw e;
		} finally {
			if(out!=null) {
				out.close();
			}
		}
	}

	public Collection<Jogador> recuperJogador() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(arquivoJogadores));
			Collection<Jogador> jogadoresAchados = (Collection<Jogador>) in.readObject();
			return jogadoresAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo"+ arquivoJogadores);
		} catch (IOException e ) {
			throw e;
		} catch(ClassNotFoundException e) {
			throw new IOException("Classe de objetos gravados no arquivo "+ arquivoJogadores +" não existe");
		} finally {
			if(in!=null) {
				in.close();
			}
		}
		
	}
	
	public void gravarPatrocinadores(Collection<Patrocinio> patrocinios) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoPatroc));
			List<Patrocinio> patrocGravar = new ArrayList<Patrocinio>();
			patrocGravar.addAll(patrocinios);
			out.writeObject(patrocGravar);
		} catch (FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo" + arquivoPatroc);
		} catch (IOException e) {
			throw e;
		} finally {
			if(out!=null) {
				out.close();
			}
		}
	}
	
	public Collection<Patrocinio> recuperPatroc() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(arquivoPatroc));
			Collection<Patrocinio> patrocAchados = (Collection<Patrocinio>) in.readObject();
			return patrocAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo"+ arquivoPatroc);
		} catch (IOException e ) {
			throw e;
		} catch(ClassNotFoundException e) {
			throw new IOException("Classe de objetos gravados no arquivo "+ arquivoPatroc +" não existe");
		} finally {
			if(in!=null) {
				in.close();
			}
		}
		
	}
	
	public void gravarProdutoVasco(Collection<ProdutoVasco> produtos) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(arquivoProd));
			List<ProdutoVasco> produtoGravar = new ArrayList<ProdutoVasco>();
			produtoGravar.addAll(produtos);
			out.writeObject(produtoGravar);
		} catch (FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo" + arquivoProd);
		} catch (IOException e) {
			throw e;
		} finally {
			if(out!=null) {
				out.close();
			}
		}
	}
	
	public Collection<ProdutoVasco> recuperProd() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(arquivoProd));
			Collection<ProdutoVasco> produtoAchados = (Collection<ProdutoVasco>) in.readObject();
			return produtoAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo"+ arquivoProd);
		} catch (IOException e ) {
			throw e;
		} catch(ClassNotFoundException e) {
			throw new IOException("Classe de objetos gravados no arquivo "+ arquivoProd +" não existe");
		} finally {
			if(in!=null) {
				in.close();
			}
		}
		
	}
	
}
