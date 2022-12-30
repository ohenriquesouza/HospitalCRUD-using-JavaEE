package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.Espec;
import model.JavaBeans;
import model.Plano;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/edit", "/delete", "/relatorio", "/search",
		"/novaConsulta", "/error", "/2nderror" })
@SuppressWarnings("unused")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans consulta = new JavaBeans();
	Espec especialidade = new Espec();
	Plano planos = new Plano();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			consultas(request, response);
		} else if (action.equals("/insert")) {
			novoAgendamento(request, response);
		} else if (action.equals("/select")) {
			listarConsultas(request, response);
		} else if (action.equals("/edit")) {
			editarConsulta(request, response);
		} else if (action.equals("/delete")) {
			removeConsulta(request, response);
		} else if (action.equals("/relatorio")) {
			gerarpdf(request, response);
		} else if (action.equals("/search")) {
			pesquisaConsulta(request, response);
		} else if (action.equals("/novaConsulta")) {
			novaConsulta(request, response);
		} else if (action.equals("/error")) {
			pacienteNaoExiste(request, response);
		} else if (action.equals("/2nderror")) {
			duplicidade(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void consultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> consultas = dao.visualizarConsultas();
		request.setAttribute("consultasAgendadas", consultas);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	protected void novaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Espec> especs = dao.especsCadastradas();
		request.setAttribute("especsCadastradas", especs);
		ArrayList<Plano> planos = dao.planosCadastradas();
		request.setAttribute("planosCadastradas", planos);
		RequestDispatcher rd = request.getRequestDispatcher("novoAgendamento.jsp");
		rd.forward(request, response);
	}

	protected int novoAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int achou = 0;

//		 System.out.println(request.getParameter("nome"));
//		 System.out.println(request.getParameter("NmCarteira"));
//		 System.out.println(request.getParameter("plan"));
//		 System.out.println(request.getParameter("especs"));

		consulta.setnomePaciente(request.getParameter("nome"));
		consulta.setnmCarteira(request.getParameter("NmCarteira"));
		consulta.setPlanSaude(request.getParameter("plan"));
		consulta.setespeci(request.getParameter("especs"));
		ArrayList<JavaBeans> registrosCarteira = dao.retornarRegistrosNmCarteira(consulta);
		for (int i = 0; i < registrosCarteira.size(); i++) {
			if (Integer.parseInt(request.getParameter("plan")) == Integer
					.parseInt(registrosCarteira.get(i).getPlanSaude())
					&& Integer.parseInt(request.getParameter("especs")) == Integer
							.parseInt(registrosCarteira.get(i).getespeci())) {
				achou = 1;
			}
		}
		if (achou == 1) {
			response.sendRedirect("2nderror");
			return 0;

		} else {
			consulta.setnomePaciente(request.getParameter("nome"));
			consulta.setnmCarteira(request.getParameter("NmCarteira"));
			consulta.setPlanSaude(request.getParameter("plan"));
			consulta.setespeci(request.getParameter("especs"));
			dao.agendarConsulta(consulta);
			response.sendRedirect("main");
			return 1;
		}
	}

	protected void pacienteNaoExiste(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Espec> especs = dao.especsCadastradas();
		request.setAttribute("especsCadastradas", especs);
		ArrayList<Plano> planos = dao.planosCadastradas();
		request.setAttribute("planosCadastradas", planos);
		consulta.setnomePaciente(request.getParameter("nome"));
		consulta.setnmCarteira(request.getParameter("NmCarteira"));
		consulta.setPlanSaude(request.getParameter("plan"));
		consulta.setespeci(request.getParameter("especs"));
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
	
	protected void duplicidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Espec> especs = dao.especsCadastradas();
		request.setAttribute("especsCadastradas", especs);
		ArrayList<Plano> planos = dao.planosCadastradas();
		request.setAttribute("planosCadastradas", planos);
		consulta.setnomePaciente(request.getParameter("nome"));
		consulta.setnmCarteira(request.getParameter("NmCarteira"));
		consulta.setPlanSaude(request.getParameter("plan"));
		consulta.setespeci(request.getParameter("especs"));
		RequestDispatcher rd = request.getRequestDispatcher("2nderror.jsp");
		rd.forward(request, response);
	}

	protected void listarConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Espec> especs = dao.especsCadastradas();
		request.setAttribute("especsCadastradas", especs);
		ArrayList<Plano> planos = dao.planosCadastradas();
		request.setAttribute("planosCadastradas", planos);
		String idPacienteAux = request.getParameter("idPaciente");
		consulta.setidPaciente(idPacienteAux);
		dao.selecionaConsulta(consulta);
		request.setAttribute("idPaciente", consulta.getidPaciente());
		request.setAttribute("nome", consulta.getnomePaciente());
		request.setAttribute("NmCarteira", consulta.getnmCarteira());
		request.setAttribute("plan", consulta.getPlanSaude());
		request.setAttribute("especs", consulta.getespeci());
//		System.out.println(request.getAttribute("plan"));
//		System.out.println(request.getAttribute("especs"));
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
	}

	protected void editarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getParameter("iduser"));
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("NmCarteira"));
		// System.out.println(request.getParameter("plan"));
		// System.out.println(request.getParameter("especs"));

		consulta.setidPaciente(request.getParameter("iduser"));
		consulta.setnomePaciente(request.getParameter("nome"));
		consulta.setnmCarteira(request.getParameter("NmCarteira"));
		consulta.setPlanSaude(request.getParameter("plan"));
		consulta.setespeci(request.getParameter("especs"));
		dao.alteraConsulta(consulta);
		response.sendRedirect("main");
	}

	protected void removeConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idRemover = request.getParameter("idPaciente");
		consulta.setidPaciente(idRemover);
		dao.removeConsulta(consulta);
		response.sendRedirect("main");
	}

	protected void gerarpdf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document doc = new Document();
		int cont = 0;
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "Consultas.pdf");
			PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			doc.add(new Paragraph("Consultas agendadas:"));
			doc.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nº da carteira"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Plano de Saúde"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Especialidade"));
			table.addCell(col1);
			table.addCell(col2);
			table.addCell(col3);
			table.addCell(col4);
			ArrayList<JavaBeans> consultas = dao.visualizarConsultas();
			for (int i = 0; i < consultas.size(); i++) {
				table.addCell(consultas.get(i).getnomePaciente());
				table.addCell(consultas.get(i).getnmCarteira());
				table.addCell(consultas.get(i).getPlanSaude());
				table.addCell(consultas.get(i).getespeci());
				cont++;
			}
			doc.add(table);
			doc.add(new Paragraph("No total, foram agendadas " + cont + " consultas."));
			doc.close();
		} catch (Exception e) {
			System.out.println(e);
			doc.close();
		}
	}

	protected void pesquisaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("Entrou no Controller");

		String nomeSearch = request.getParameter("nome");
		String nmCaSearch = request.getParameter("NmCarteira");
		consulta.setnomePaciente(nomeSearch);
		consulta.setnmCarteira(nmCaSearch);
		int auxNome = dao.retornaSeExisteNome(consulta);
		if (auxNome == 0) {
			consulta.setnomePaciente(nomeSearch);
			consulta.setnmCarteira(nmCaSearch);
			dao.pesquisaConsulta(consulta);
			request.setAttribute("idPaciente", consulta.getidPaciente());
			request.setAttribute("nome", consulta.getnomePaciente());
			request.setAttribute("NmCarteira", consulta.getnmCarteira());
			request.setAttribute("plan", consulta.getPlanSaude());
			request.setAttribute("especs", consulta.getespeci());
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("error");
		}
	}

}
