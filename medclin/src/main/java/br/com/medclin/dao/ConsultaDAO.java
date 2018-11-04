package br.com.medclin.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.medclin.common.AssertUtil;
import br.com.medclin.model.Consulta;

@Transactional
@Repository
public class ConsultaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Page<Consulta> buscarConsultaPorNomePaciente(final PageRequest page, final String nomePaciente) {
		StringBuilder hql = new StringBuilder(100);
		StringBuilder select = new StringBuilder(100);

		// CONSULTA PRINCIPAL
		select.append(" SELECT consulta FROM Consulta consulta");
		hql.append("	WHERE 1=1 ");
		
		// CARREGA PARAMETROS
		Map<String, Object> parametros = new HashMap<String, Object>();

		if (AssertUtil.isNotNull(nomePaciente)) {
			parametros.put("nomePaciente", nomePaciente);
			hql.append(" AND UPPER(consulta.paciente.nomePessoa) LIKE UPPER(CONCAT('%',:nomePaciente,'%'))");
		}
		
		hql.append(" ORDER BY consulta.codigoConsulta ASC");

		select.append(hql);
		TypedQuery<Consulta> query = entityManager.createQuery(select.toString(), Consulta.class)
				.setFirstResult(page.getPageNumber()).setMaxResults(page.getPageSize());

		for (Map.Entry<String, Object> pair : parametros.entrySet()) {
			query.setParameter(pair.getKey(), pair.getValue());
		}

		// COUNT
		StringBuilder count = new StringBuilder(100);
		count.append(" SELECT COUNT(consulta.codigoConsulta) FROM Consulta consulta");
		count.append(hql);
		TypedQuery<Long> querySize = entityManager.createQuery(count.toString(), Long.class);

		for (Map.Entry<String, Object> pair : parametros.entrySet()) {
			querySize.setParameter(pair.getKey(), pair.getValue());
		}

		PageImpl<Consulta> listaRetorno = new PageImpl<>(query.getResultList(), page, querySize.getSingleResult());
		return listaRetorno;
	}
}
