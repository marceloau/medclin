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
import br.com.medclin.model.Paciente;

@Transactional
@Repository
public class PacienteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Page<Paciente> buscarPaciente(final PageRequest page, final String nomePaciente, final String nomeMae,
			final String numeroRg, final String numeroCpf, final String numeroCartaoSUS, final Short codigoTipoPlano,
			final String textoContato) {
		StringBuilder hql = new StringBuilder(100);
		StringBuilder select = new StringBuilder(100);

		// CONSULTA PRINCIPAL
		select.append(" SELECT p1 FROM Paciente p1");
		hql.append("	WHERE p1.codigoPessoa IN(");
		hql.append(" SELECT DISTINCT p.codigoPessoa FROM Paciente p ");
		hql.append(" LEFT JOIN p.listaPlanoSaudePaciente lPS");
		hql.append("	LEFT JOIN lPS.tipoPlanoSaude tP");
		hql.append("	LEFT JOIN p.contatos c WHERE 1=1");
		// CARREGA PARAMETROS
		Map<String, Object> parametros = new HashMap<String, Object>();

		if (AssertUtil.isNotNull(nomePaciente)) {
			parametros.put("nomePaciente", nomePaciente);
			hql.append(" AND UPPER(p.nomePessoa) LIKE UPPER(CONCAT('%',:nomePaciente,'%'))");
		}
		if (AssertUtil.isNotNull(nomeMae)) {
			parametros.put("nomeMae", nomeMae);
			hql.append(" AND UPPER(p.nomeMae) LIKE UPPER(CONCAT('%',:nomeMae,'%'))");
		}
		if (AssertUtil.isNotNull(numeroRg)) {
			parametros.put("numeroRg", numeroRg);
			hql.append(" AND UPPER(p.numeroRg) LIKE UPPER(CONCAT('%',:numeroRg,'%'))");
		}
		if (AssertUtil.isNotNull(numeroCpf)) {
			parametros.put("numeroCpf", numeroCpf);
			hql.append(" AND UPPER(p.numeroCpf) LIKE UPPER(CONCAT('%',:numeroCpf,'%'))");
		}
		if (AssertUtil.isNotNull(numeroCartaoSUS)) {
			parametros.put("numeroCartaoSUS", numeroCartaoSUS);
			hql.append(" AND UPPER(p.numeroCartaoSUS) LIKE UPPER(CONCAT('%',:numeroCartaoSUS,'%'))");
		}
		if (AssertUtil.isNotNull(codigoTipoPlano)) {
			parametros.put("codigoTipoPlano", codigoTipoPlano);
			hql.append(" AND tP.codigoTipoPlano = :codigoTipoPlano");
		}
		if (AssertUtil.isNotNull(textoContato)) {
			parametros.put("textoContato", textoContato);
			hql.append(" AND UPPER(c.textoContato) LIKE UPPER(CONCAT('%',:textoContato,'%'))");
		}

		hql.append(" )ORDER BY p1.codigoPessoa ASC");

		select.append(hql);
		TypedQuery<Paciente> query = entityManager.createQuery(select.toString(), Paciente.class)
				.setFirstResult(page.getPageNumber()).setMaxResults(page.getPageSize());

		for (Map.Entry<String, Object> pair : parametros.entrySet()) {
			query.setParameter(pair.getKey(), pair.getValue());
		}

		// COUNT
		StringBuilder count = new StringBuilder(100);
		count.append(" SELECT COUNT(p1.codigoPessoa) FROM Paciente p1");
		count.append(hql);
		TypedQuery<Long> querySize = entityManager.createQuery(count.toString(), Long.class);

		for (Map.Entry<String, Object> pair : parametros.entrySet()) {
			querySize.setParameter(pair.getKey(), pair.getValue());
		}

		PageImpl<Paciente> listaRetorno = new PageImpl<>(query.getResultList(), page, querySize.getSingleResult());
		return listaRetorno;
	}
}
