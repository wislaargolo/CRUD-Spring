package com.example.demo.util;

import java.util.List;

public class PaginacaoUtil<T> {
	
	private int tamanho;
	private int pagina;
	private long totalDePaginas;
	private String direcao;
	private List<T> registros;
	
	public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, String direcao, List<T> registros) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalDePaginas = totalDePaginas;
		this.direcao = direcao;
		this.registros = registros;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getPagina() {
		return pagina;
	}

	public long getTotalDePaginas() {
		return totalDePaginas;
	}

	public String getDirecao() {
		return direcao;
	}

	public List<T> getRegistros() {
		return registros;
	}

}
