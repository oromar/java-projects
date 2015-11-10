package com.globalsoft.util;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.globalsoft.entities.Entity;

public class Util {

	private static final DateFormat dFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);

	private Util() {
		super();
	}

	public static final String getDateAsString(Date date) {
		return dFormat.format(date);
	}

	public static final Date getStringAsDate(String string) throws ParseException {
		return dFormat.parse(string);
	}

	public static final boolean isNullOrEmpty(String string) {
		return Objects.isNull(string) || string.isEmpty();
	}

	public static final boolean hasLenght(String string, int lenght) {
		return !Objects.isNull(string) && string.length() == lenght;
	}

	public static final boolean onlyNumbers(String value) {
		return value.matches(Constants.ONLY_NUMBERS_REGEX);
	}

	public static final void toUpperCaseAllStrings(Object object) throws IllegalArgumentException, IllegalAccessException {
		if (Objects.isNull(object)) {
			throw new IllegalArgumentException(Messages.CANNOT_PASS_NULL_OBJECT);
		}
		Class clazz = object.getClass();
		List<Field> fields = new ArrayList<Field>();
		while (clazz != null) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.getType().equals(String.class) 
					&& (!f.get(object).equals(Constants.PASSWORD_FIELD_NAME) && !f.get(object).equals(Constants.LOGIN_FIELD_NAME))) {
				try {
					f.set(object, String.valueOf(f.get(object)).trim().toUpperCase());
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else if (f.get(object) instanceof Entity) {
				toUpperCaseAllStrings(f.get(object));
			}
		}
	}

	public static String hashPassword(String password) {
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
