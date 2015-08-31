package br.com.qualiti.delivery.negocio;

import java.util.Collection;
import java.util.Map;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.entidades.Entregador;
import br.com.qualiti.delivery.entidades.FormaPagamento;
import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.entidades.Produto;
import br.com.qualiti.delivery.interfaces.CadastroHibernate;
import br.com.qualiti.delivery.repositorio.RepositorioClienteHibernate;
import br.com.qualiti.delivery.repositorio.RepositorioHibernateEntregador;
import br.com.qualiti.delivery.repositorio.RepositorioHibernateFormaPagamento;
import br.com.qualiti.delivery.repositorio.RepositorioHibernatePedido;
import br.com.qualiti.delivery.repositorio.RepositorioHibernateProduto;
import java.io.Serializable;

public class Fachada {

    public static Fachada instancia;
    private CadastroHibernate<Cliente> cadastroClientes;
    private CadastroHibernate<FormaPagamento> cadastroFormaPagamento;
    private CadastroHibernate<Produto> cadastroProduto;
    private CadastroHibernate<Entregador> cadastroEntregador;
    private CadastroHibernate<Pedido> cadastroPedido;
    private Fachada() {
        super();
        init();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private void init() {
        cadastroClientes = new CadastroCliente(new RepositorioClienteHibernate());
        cadastroFormaPagamento = new CadastroFormaPagamento(new RepositorioHibernateFormaPagamento());
        cadastroProduto = new CadastroProduto(new RepositorioHibernateProduto());
        cadastroEntregador = new CadastroEntregador(new RepositorioHibernateEntregador());
        cadastroPedido = new CadastroPedido(new RepositorioHibernatePedido());
    }

    /**
     * @param cliente
     * @throws Exception
     * @see
     * br.com.qualiti.delivery.negocio.CadastroClientes#inserir(br.com.qualiti.delivery.entidades.Cliente)
     */
    public void inserirCliente(Cliente cliente) throws Exception {
        cadastroClientes.inserir(cliente);
    }

    /**
     * @param cpf
     * @throws Exception
     * @see
     * br.com.qualiti.delivery.negocio.CadastroClientes#remover(java.lang.String)
     */
    public void removerCliente(String cpf) throws Exception {
        cadastroClientes.remover(cpf);
    }

    /**
     * @param cliente
     * @throws Exception
     * @see
     * br.com.qualiti.delivery.negocio.CadastroClientes#atualizar(br.com.qualiti.delivery.entidades.Cliente)
     */
    public void atualizarCliente(Cliente cliente) throws Exception {
        cadastroClientes.atualizar(cliente);
    }

    /**
     * @param cpf
     * @return
     * @throws Exception
     * @see
     * br.com.qualiti.delivery.negocio.CadastroClientes#procurar(java.lang.String)
     */
    public Cliente procurarCliente(String cpf) throws Exception {
        return cadastroClientes.procurar(cpf);
    }

    /**
     * @return @throws Exception
     * @see
     * br.com.qualiti.delivery.negocio.CadastroClientes#buscarTodosClientes()
     */
    public Cliente[] buscarTodosClientes() throws Exception {
        return cadastroClientes.buscarTodos();
    }

    public Collection<Cliente> filtrarClientes(Cliente cliente) {
        return cadastroClientes.filtrar(cliente);
    }

    public Collection<Cliente> findCollectionClienteByHQL(String hql, Map<String, Object> parameters) {
        return cadastroClientes.findCollectionByHQL(hql, parameters);
    }

    public Cliente findUniqueClienteByHQL(String hql, Map<String, Object> parameters) {
        return cadastroClientes.findUniqueByHQL(hql, parameters);
    }

    public Collection<FormaPagamento> filtrar(FormaPagamento t) {
        return cadastroFormaPagamento.filtrar(t);
    }

    public Collection<FormaPagamento> findFormaPagamentoCollectionByHQL(String hql, Map<String, Object> parameters) {
        return cadastroFormaPagamento.findCollectionByHQL(hql, parameters);
    }

    public FormaPagamento findFormaPagamentoUniqueByHQL(String hql, Map<String, Object> parameters) {
        return cadastroFormaPagamento.findUniqueByHQL(hql, parameters);
    }

    public boolean existe(Serializable chave) throws Exception {
        return cadastroFormaPagamento.existe(chave);
    }

    public void inserir(FormaPagamento entidade) throws Exception {
        cadastroFormaPagamento.inserir(entidade);
    }

    public void atualizar(FormaPagamento entidade) throws Exception {
        cadastroFormaPagamento.atualizar(entidade);
    }

    public void removerFormaPagamento(Serializable codigo) throws Exception {
        cadastroFormaPagamento.remover(codigo);
    }

    public FormaPagamento procurar(Serializable chave) throws Exception {
        return cadastroFormaPagamento.procurar(chave);
    }

    public FormaPagamento[] buscarTodasFormasPagamento() throws Exception {
        return cadastroFormaPagamento.buscarTodos();
    }

    public Collection<Produto> filtrar(Produto t) {
        return cadastroProduto.filtrar(t);
    }

    public Collection<Produto> findProdutoCollectionByHQL(String hql, Map<String, Object> parameters) {
        return cadastroProduto.findCollectionByHQL(hql, parameters);
    }

    public Produto findProdutoUniqueByHQL(String hql, Map<String, Object> parameters) {
        return cadastroProduto.findUniqueByHQL(hql, parameters);
    }

    public void inserir(Produto entidade) throws Exception {
        cadastroProduto.inserir(entidade);
    }

    public void atualizar(Produto entidade) throws Exception {
        cadastroProduto.atualizar(entidade);
    }

    public void remover(Serializable codigo) throws Exception {
        cadastroProduto.remover(codigo);
    }

    public Produto procurarProduto(Serializable codigo) throws Exception {
        return cadastroProduto.procurar(codigo);
    }

    public Produto[] buscarTodosProdutos() throws Exception {
        return cadastroProduto.buscarTodos();
    }

    public Collection<Entregador> filtrar(Entregador t) {
        return cadastroEntregador.filtrar(t);
    }

    public Collection<Entregador> findCollectionByHQL(String hql, Map<String, Object> parameters) {
        return cadastroEntregador.findCollectionByHQL(hql, parameters);
    }

    public Entregador findUniqueByHQL(String hql, Map<String, Object> parameters) {
        return cadastroEntregador.findUniqueByHQL(hql, parameters);
    }

    public void inserir(Entregador entidade) throws Exception {
        cadastroEntregador.inserir(entidade);
    }

    public void atualizar(Entregador entidade) throws Exception {
        cadastroEntregador.atualizar(entidade);
    }
    
    public void removerEntregador(Serializable chave) throws Exception {
        cadastroEntregador.remover(chave);
    }

    public Entregador procurarEntregador(Serializable chave) throws Exception {
        return cadastroEntregador.procurar(chave);
    }

    public Entregador[] buscarTodos() throws Exception {
        return cadastroEntregador.buscarTodos();
    }

    public Collection<Pedido> filtrar(Pedido t) {
        return cadastroPedido.filtrar(t);
    }

    public Collection<Pedido> findPedidoCollectionByHQL(String hql, Map<String, Object> parameters) {
        return cadastroPedido.findCollectionByHQL(hql, parameters);
    }

    public Pedido findPedidoUniqueByHQL(String hql, Map<String, Object> parameters) {
        return cadastroPedido.findUniqueByHQL(hql, parameters);
    }

    public void inserir(Pedido entidade) throws Exception {
        cadastroPedido.inserir(entidade);
    }

    public void atualizar(Pedido entidade) throws Exception {
        cadastroPedido.atualizar(entidade);
    }
    
    public void removerPedido(Serializable id) throws Exception{
        cadastroPedido.remover(id);
    }
        

    public Pedido procurarPedido(Serializable chave) throws Exception {
        return cadastroPedido.procurar(chave);
    }

    public Pedido[] buscarTodosPedidos() throws Exception {
        return cadastroPedido.buscarTodos();
    }
    
    
    
    
}
