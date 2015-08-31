package br.com.qualiti.delivery.util;

public enum StatusPedido {
	
	SOLICITADO("Solicitado", 0),
	AGUARDANDO_PAGAMENTO("Aguardando Pagamento", 1),
	EM_ELABORACAO("Em Elaboração", 2),
	AGUARDANDO_ENTREGA("Aguardando Entrega", 3),
	ENCAMINHADO("Encaminhado", 4),
	ENTREGUE("Entregue", 5),
	DEVOLVIDO("Devolvido", 6),
	CANCELADO("Cancelado", 7);

	private final String nome;
        private final Integer codigo;

	private StatusPedido(String nome, Integer codigo){
		this.nome = nome;
                this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
        
        public Integer getCodigo(){
            return codigo;
        }
        
        public String getNomeFromCodigo(Integer codigo){
            String retorno = null;
            for (StatusPedido status : values()) {
                if (status.getCodigo().equals(codigo)) {
                    retorno = status.getNome();
                    break;
                }
            }
            return retorno;
        }
        
}
