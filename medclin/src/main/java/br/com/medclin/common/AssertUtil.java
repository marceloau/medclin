/*
 * 
 */
package br.com.medclin.common;

import java.io.StringWriter;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public final class AssertUtil {

	final private static String ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";

	final private static String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";

	final private static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

	public static boolean areAllArgsNotNull(final Object... objects) {
		boolean retorno = true;
		for (final Object object : objects) {
			if (object == null) {
				retorno = false;
			}
		}
		return retorno;
	}

	public static <T> T coalescenciaNula(final T object, final T defaultValue) {
		T retorno = defaultValue;
		if (AssertUtil.isNotNull(object)) {
			retorno = object;
		}
		return retorno;
	}

	public static boolean isEmptyList(final Collection<? extends Object> collection) {
		return (collection == null) || collection.isEmpty();
	}

	public static boolean isNegativo(final Number value) {
		return isNotNull(value) && (value.longValue() <= 0);
	}

	public static boolean isNegativo(final String value) {
		Boolean retorno = Boolean.TRUE;
		try {
			final Long parsed = Long.valueOf(value);
			retorno = parsed < 0;
		} catch (final NumberFormatException exc) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	public static boolean isNotEmptyList(final Collection<? extends Object> collection) {
		return !isEmptyList(collection);
	}

	public static boolean isNotNull(final Object value) {
		return !isNull(value);
	}

	public static boolean isNotNullAndEmpty(final Number value) {
		return (value != null) && (value.longValue() > 0);
	}

	public static boolean isNotNullAndEmpty(final Object objeto) {
		boolean retorno = false;
		if (objeto != null) {
			if (!objeto.toString().trim().equals("")) {
				retorno = true;
			}
		}
		return retorno;
	}

	public static boolean isNotNullAndEmpty(final String value) {
		return (value != null) && !value.trim().equals("");
	}

	public static boolean isNotNumber(final String value) {
		Boolean retorno = Boolean.TRUE;
		try {
			Long.valueOf(value);
			retorno = Boolean.FALSE;
		} catch (final NumberFormatException exc) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	public static boolean isNull(final Object value) {
		return value == null;
	}

	public static boolean isNullAndEmpty(final Number value) {
		return !isNotNullAndEmpty(value);
	}

	public static boolean isNullAndEmpty(final String value) {
		return (value == null) || value.trim().equals("");
	}

	public static boolean isValidEmail(final String email) {
		Boolean retorno = Boolean.FALSE;
		final Pattern pattern = java.util.regex.Pattern.compile(
				"^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$", Pattern.CASE_INSENSITIVE);
		if ((email == null) || (email.length() == 0)) {
			retorno = Boolean.FALSE;
		}
		final Matcher matcher = pattern.matcher(email);
		retorno = matcher.matches();
		return retorno;
	}

	private AssertUtil() {
		super();
	}
	
}
