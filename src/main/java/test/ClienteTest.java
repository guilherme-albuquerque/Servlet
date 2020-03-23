package test;


import static org.junit.Assert.assertEquals;
import model.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.ClienteService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
    Cliente cliente, copia;
    ClienteService clienteService;
    static int id = 0;


    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
        cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome("Guilherme Rodrigues");
        cliente.setFone("(11) 92341-4221");
        cliente.setEmail("(gui_rodrigues@yahoo.com.br");
        copia = new Cliente();
        copia.setId(id);
        copia.setNome("Sandra Facundes");
        copia.setFone("(11) 98132-9876");
        copia.setEmail("san_fac@outlook.com");
        clienteService = new ClienteService();
        System.out.println(cliente);
        System.out.println(copia);
        System.out.println(id);
    }

    @Test
    public void test00Carregar() {
        System.out.println("carregar");
        Cliente fixture = new Cliente();
        fixture.setId(1);
        fixture.setNome("Carlos Drummond de Andrade");
        fixture.setFone("(11) 91234-4321");
        fixture.setEmail("cda@usjt.br");
        ClienteService novoService = new ClienteService();
        Cliente novo = novoService.carregar(1);
        assertEquals("testa inclusao", novo, fixture);
    }

    @Test
    public void test01Criar() {
        System.out.println("criar");
        id = clienteService.criar(cliente);
        System.out.println(id);
        copia.setId(id);
        assertEquals("testa criacao", cliente, copia);
    }

    @Test
    public void test02Atualizar() {
        System.out.println("atualizar");
        this.cliente.setFone("11999329123");
        copia.setFone("11999329123");
        clienteService.atualizar(cliente);
        cliente = clienteService.carregar(cliente.getId());
        assertEquals("teste att", cliente, copia);
    }

    @Test
    public void test03Excluir() {
        System.out.println("excluir");
        copia.setId(-1);
        copia.setNome(null);
        copia.setFone(null);
        copia.setEmail(null);
        clienteService.excluir(id);
        cliente = clienteService.carregar(id);
        assertEquals("teste exclusao", cliente, copia);
    }
}