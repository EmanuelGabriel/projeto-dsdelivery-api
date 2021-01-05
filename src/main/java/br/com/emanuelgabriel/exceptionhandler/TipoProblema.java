package br.com.emanuelgabriel.exceptionhandler;


public enum TipoProblema {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"), 
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	UNSOPPORTED_NAO_SUPORTADO("/unsopported-media-type", "Tipo de conteúdo não suportado"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	TOKEN_INVALIDO("/token-invalid", "Token inválido ou expirado"),
	ERRO_UNAUTHORIZED("/erro-unauthorized", "Credencial inválida"),
	ERRO_INTEGRIDADE_DADOS("/erro-integridade-dados", "Erro de integridade de dados");

	private String titulo;
	private String uri;

	private TipoProblema(String path, String titulo) {
		this.uri = "https://dsdelivery.com.br" + path;
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}

}
