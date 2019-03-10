package br.com.medclin.dao;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
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

	public Page<Consulta> buscarConsulta(final PageRequest page, final String nomePaciente, final Date dataConsulta, 
			final Date mesConsulta, final BigInteger codigoPaciente, final Integer codigoStatusConsulta) {
		StringBuilder hql = new StringBuilder(100);
		StringBuilder select = new StringBuilder(100);

		// CONSULTA PRINCIPAL
		select.append(" SELECT consulta FROM Consulta consulta");
		hql.append("	WHERE 1=1 ");
		
		// CARREGA PARAMETROS
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if(mesConsulta != null) {
			Calendar dataCalendar = Calendar.getInstance();
			dataCalendar.setTime(mesConsulta);    
			int primeiroDia = dataCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
			int ultimodia = dataCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			dataCalendar.set(Calendar.DAY_OF_MONTH, primeiroDia);
			final Date dataInicioMesConsulta = dataCalendar.getTime();
			
			dataCalendar.set(Calendar.DAY_OF_MONTH, ultimodia);
			final Date dataFimMesConsulta = dataCalendar.getTime();
				
			parametros.put("dataInicioMesConsulta", dataInicioMesConsulta);
			parametros.put("dataFimMesConsulta", dataFimMesConsulta);
			hql.append(" AND CAST(consulta.dataConsulta AS date) "
					+ "  BETWEEN  DATE(:dataInicioMesConsulta) AND DATE(:dataFimMesConsulta) ");
		}
		if (AssertUtil.isNotNull(nomePaciente)) {
			parametros.put("nomePaciente", nomePaciente);
			hql.append(" AND UPPER(consulta.paciente.nomePessoa) LIKE UPPER(CONCAT('%',:nomePaciente,'%'))");
		}
		
		if (AssertUtil.isNotNull(codigoStatusConsulta)) {
			parametros.put("codigoStatusConsulta", codigoStatusConsulta);
			hql.append(" AND consulta.codigoStatusConsulta = :codigoStatusConsulta");
		}
		
		if (AssertUtil.isNotNull(codigoPaciente)) {
			parametros.put("codigoPaciente", codigoPaciente);
			hql.append(" AND consulta.paciente.codigoPessoa = :codigoPaciente");
		}
		
		if (AssertUtil.isNotNull(dataConsulta)) {
			parametros.put("dataConsulta", dataConsulta);
			hql.append(" AND CAST(consulta.dataConsulta AS date) = DATE(:dataConsulta)");
		}
		
		hql.append(" ORDER BY consulta.dataConsulta DESC");

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
	
	public Page<Consulta> listarConsultasAtendimento(final PageRequest page, final Date dataConsulta, final String flagConfirmada) {
		StringBuilder hql = new StringBuilder(100);
		StringBuilder select = new StringBuilder(100);

		// CONSULTA PRINCIPAL
		select.append(" SELECT consulta FROM Consulta consulta");
		hql.append("	WHERE consulta.codigoStatusConsulta in (2,3,4,5) ");
		
		// CARREGA PARAMETROS
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if (AssertUtil.isNotNull(dataConsulta)) {
			parametros.put("dataConsulta", dataConsulta);
			hql.append(" AND CAST(consulta.dataConsulta AS date) = DATE(:dataConsulta)");
		}
		
		if (AssertUtil.isNotNullAndEmpty(flagConfirmada)) {
			parametros.put("flagConfirmada", flagConfirmada);
			hql.append(" AND consulta.flagConfirmada = :flagConfirmada");
		}
		
		hql.append(" ORDER BY consulta.ordemChegada ASC");

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
	
	public Boolean existeConsultaDataConsultaEOrdemChegada(final Date dataConsulta, final Integer numeroOrdemChegada,
			final BigInteger codigoConsulta) {
		
		StringBuilder hql = new StringBuilder(100);
		StringBuilder select = new StringBuilder(100);
		Boolean retorno = Boolean.FALSE;

		select.append(" SELECT COUNT(consulta) FROM Consulta consulta");
		hql.append("	WHERE 1=1 ");
		
		// CARREGA PARAMETROS
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("dataConsulta", dataConsulta);
		hql.append(" AND CAST(consulta.dataConsulta AS date) = DATE(:dataConsulta)");
		
		parametros.put("numeroOrdemChegada", numeroOrdemChegada);
		hql.append(" AND consulta.ordemChegada = :numeroOrdemChegada");
		
		parametros.put("codigoConsulta", codigoConsulta);
		hql.append(" AND consulta.codigoConsulta <> :codigoConsulta");

		select.append(hql);
		TypedQuery<Long> queryCount = entityManager.createQuery(select.toString(), Long.class);

		for (Map.Entry<String, Object> pair : parametros.entrySet()) {
			queryCount.setParameter(pair.getKey(), pair.getValue());
		}

		final Long resultadoQuery = queryCount.getSingleResult();
		
		if(resultadoQuery > 0) {
			retorno = Boolean.TRUE;
		}

		return retorno;
	}
}
