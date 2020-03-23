package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementação
 */

@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pNome = request.getParameter("nome");
        String pFone = request.getParameter("fone");
        String pEmail = request.getParameter("email");

        Cliente cliente = new Cliente();
        cliente.setNome(pNome);
        cliente.setFone(pFone);
        cliente.setEmail(pEmail);

        ClienteService cs = new ClienteService();
        cs.criar(cliente);
        cliente = cs.carregar(cliente.getId());


        request.setAttribute("cliente", cliente);

        RequestDispatcher view = request.getRequestDispatcher("Cliente.jsp");
        view.forward(request, response);
    }
}