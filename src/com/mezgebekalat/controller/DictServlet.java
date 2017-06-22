package com.mezgebekalat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mezgebekalat.model.Word;
import com.mezgebekalat.service.DictService;

/**
 * Servlet implementation class DictServlet
 */
@WebServlet("/DictServlet")
public class DictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DictServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("dict.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String word = request.getParameter("word");
		System.out.println(word);
		if (word == null || word.length() == 0) {
			response.getWriter().write("");
		} else {
			DictService find = new DictService();
			List<Word> results = find.findByName(word);
		    String json = new Gson().toJson(results);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}