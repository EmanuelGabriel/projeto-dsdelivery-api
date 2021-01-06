package br.com.emanuelgabriel.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProblemaResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;
	private LocalDateTime timestamp;
	private String tipo;
	private String mensagem;
	private String path;
	private List<Campos> campos = new ArrayList<>();

	public ProblemaResponse(Integer status, LocalDateTime timestamp, String tipo, String mensagem, String path) {
		this.status = status;
		this.timestamp = timestamp;
		this.tipo = tipo;
		this.mensagem = mensagem;
		this.path = path;
	}

	public static class ProblemaResponseBuilder {
		private Integer status;
		private LocalDateTime timestamp;
		private String path;
		private String tipo;
		private String mensagem;

		public ProblemaResponseBuilder() {
		}

		public ProblemaResponseBuilder status(Integer status) {
			this.status = status;
			return this;
		}

		public ProblemaResponseBuilder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ProblemaResponseBuilder path(String path) {
			this.path = path;
			return this;
		}

		public ProblemaResponseBuilder tipo(String tipo) {
			this.tipo = tipo;
			return this;
		}

		public ProblemaResponseBuilder mensagem(String mensagem) {
			this.mensagem = mensagem;
			return this;
		}

		/*
		 * Criar um ProblemaResponse
		 */
		public ProblemaResponse build() {
			return new ProblemaResponse(status, timestamp, tipo, mensagem, path);
		}

	}

	public static class Campos {
		private String nome;
		private String mensagem;

		public Campos() {
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Campos> getCampos() {
		return campos;
	}

	public void setCampos(List<Campos> campos) {
		this.campos = campos;
	}

}
