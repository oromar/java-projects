package com.globalsoft.util;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.globalsoft.entities.BasicEntity;
import com.globalsoft.entities.Entity;
import com.globalsoft.entities.Supplier;
import com.globalsoft.gui.SubCategoryView;

public class Util {

	private static final DateFormat dFormat = new SimpleDateFormat(
			Constants.DEFAULT_DATE_FORMAT);

	private Util() {
		super();
	}

	public static final String getDateAsString(Date date) {
		return dFormat.format(date);
	}

	public static final Date getStringAsDate(String string)
			throws ParseException {
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

	public static final void toUpperCaseAllStrings(Object object)
			throws IllegalArgumentException, IllegalAccessException {
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
					&& (f != null
							&& f.get(object) != null
							&& !f.get(object).equals(
									Constants.PASSWORD_FIELD_NAME) && !f.get(
							object).equals(Constants.LOGIN_FIELD_NAME))) {
				try {
					f.set(object, String.valueOf(f.get(object)).trim()
							.toUpperCase());
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(Util.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			} else if (f.get(object) instanceof Entity) {
				toUpperCaseAllStrings(f.get(object));
			}
		}
	}

	public static String hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Map<String, Object> getBeanAsMap(Object bean) {
		Map<String, Object> mReturn = new HashMap<String, Object>();
		try {
			Method[] methods = bean.getClass().getMethods();
			Object result = null;
			String attributeName = null;
			for (Method m : methods) {
				if (m.getName().startsWith("get")
						&& m.getParameterTypes().length == 0) {
					result = m.invoke(bean, new Object[] {});
					if (result != null && !result.toString().isEmpty()) {
						if (result instanceof String || result instanceof Date
								|| result instanceof Number) {
							attributeName = m.getName().substring(3, 4)
									.toLowerCase()
									+ m.getName().substring(4);
							mReturn.put(attributeName, result);
						} else if (result instanceof BasicEntity) {
							Map<String, Object> map = getBeanAsMap(result);
							for (String s : map.keySet()) {
								mReturn.put(result.getClass().getSimpleName()
										.toLowerCase()
										+ "." + s, map.get(s));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mReturn;
	}

	public static Map<String, String> getMapToGeneralFilter(String value,
			Class<?> clazz) {
		Map<String, String> retorno = new HashMap<String, String>();
		try {
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get")
						&& m.getParameterTypes().length == 0) {
					if (String.class.equals(m.getReturnType())) {
						retorno.put(m.getName().substring(3).toLowerCase(),
								value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public static<T> void setScreenData(JFrame form, T object) {
		Field[] txtFields = form.getClass().getDeclaredFields();

		Class<?> clazz = object.getClass();
		List<Field> fields = new ArrayList<Field>();
		while (clazz != null) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		Field[] objFields = fields.toArray(new Field[fields.size()]);
		String objFieldName = "";
		String txtFieldName = "";
		try {
			for (Field f : txtFields) {
				f.setAccessible(true);
				txtFieldName = f.getName().substring(3, 4).toLowerCase()
						+ f.getName().substring(4);
				for (Field field : objFields) {
					field.setAccessible(true);
					objFieldName = field.getName();
					if (txtFieldName.equals(objFieldName)) {
						if (f.getType().equals(JTextField.class)) {
							JTextField txt = (JTextField) f.get(form);
							txt.setText(String.valueOf(field.get(object)));
						} else if (f.getType().equals(JTextPane.class)) {
							JTextPane txt = (JTextPane) f.get(form);
							txt.setText(String.valueOf(field.get(object)));
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static<T> T getScreenData(JFrame form, Class<T> clazz) {
		
		T result = null;
		try {
			result = clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		Field[] txtFields = form.getClass().getDeclaredFields();
		List<Field> fields = new ArrayList<Field>();
		while (clazz != null) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = (Class<T>) clazz.getSuperclass();
		}
		Field[] objFields = fields.toArray(new Field[fields.size()]);
		String objFieldName = "";
		String txtFieldName = "";
		try {
			for (Field f : txtFields) {
				f.setAccessible(true);
				txtFieldName = f.getName().substring(3, 4).toLowerCase() + f.getName().substring(4);
				for (Field field : objFields) {
					field.setAccessible(true);
					objFieldName = field.getName();
					if (txtFieldName.equals(objFieldName)) {
						if (f.getType().equals(JTextField.class)) {
							JTextField txt = (JTextField) f.get(form);
							if (txt.getText() != null && !txt.getText().isEmpty()) {
								if (field.getType().equals(Long.class)) {
									field.set(result, Long.valueOf(txt.getText()));
								} else if (field.getType().equals(Date.class)) {
									field.set(result, getStringAsDate(txt.getText()));
								} else {
									field.set(result, txt.getText());
								}
							}
						} else if (f.getType().equals(JTextPane.class)) {
							JTextPane txt = (JTextPane) f.get(form);
							field.set(result, txt.getText());
						} else if (f.getType().equals(JComboBox.class)){
							JComboBox<T> combo = (JComboBox<T>) f.get(form);
							field.set(result, combo.getSelectedItem());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void clearScreen(JFrame form) {
		Field[] txtFields = form.getClass().getDeclaredFields();
		try {
			for (Field f : txtFields) {
				f.setAccessible(true);
				if (f.getType().equals(JTextField.class)) {
					JTextField txt = (JTextField) f.get(form);
					txt.setText("");
				}
				if (f.getType().equals(JTextPane.class)) {
					JTextPane txt = (JTextPane) f.get(form);
					txt.setText("");
				}
				if (f.getType().equals(JComboBox.class)) {
					JComboBox cmb = (JComboBox) f.get(form);
					cmb.setSelectedIndex(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static <T> void createTableModel(JTable table, String[] columnNames, T[] values) {
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 3042308105275794952L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		try {
			String[] line = null;
			Field field = null;
			Class<?> superClass = null;
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					line = new String[columnNames.length];
					for (int j = 0; j < columnNames.length; j++) {
						superClass = values[i].getClass().getSuperclass();
						try{
							field = values[i].getClass().getDeclaredField(getFieldName(columnNames[j]));
						}catch(NoSuchFieldException sfe) { 
							while (field == null && superClass != null) {
								field = superClass.getDeclaredField(getFieldName(columnNames[j]));							
								superClass = superClass.getSuperclass();
							} 
						}						
						if (field != null) {
							field.setAccessible(true);
							line[j] = String.valueOf(field.get(values[i]));
							field = null;
						}
					}
					model.addRow(line);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		table.setModel(model);
		table.createDefaultColumnsFromModel();
	}

	private static String getFieldName(String string) {
		return string.substring(0, 1).toLowerCase() + string.substring(1);
	}
	
	public static void showSaveRecordSuccessMessage(Component component){
		JOptionPane.showMessageDialog(component, "Registro Salvo com Sucesso !");
	}
	
	public static void showDeleteRecordSuccessMessage(Component component){
		JOptionPane.showMessageDialog(component, "Registro Removido com Sucesso !");
	}
	
	public static Integer getStringAsInteger(String value){
		return Integer.valueOf(value != null && !value.isEmpty() ? value : "0");
	}
	
	public static Double getStringAsDouble(String value){
		return Double.valueOf(value != null && !value.isEmpty() ? value : "0");
	}
	
}
