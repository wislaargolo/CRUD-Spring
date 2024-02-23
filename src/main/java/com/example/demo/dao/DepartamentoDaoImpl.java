package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Departamento;
import com.example.demo.util.PaginacaoUtil;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {
	
	public PaginacaoUtil<Departamento> buscaPaginada(int pagina, String direcao) {
		int tamanho = 5;
		List<Departamento> departamentos = getEntityManager()
				.createQuery("select d from Departamento d order by d.nome " + direcao, Departamento.class)
				.setFirstResult((pagina - 1) * tamanho)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalDePaginas = (count() + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, departamentos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Departamento", Long.class)
				.getSingleResult();
	}

}
