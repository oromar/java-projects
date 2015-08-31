package br.com.qualiti.delivery.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

import br.com.qualiti.delivery.interfaces.EntidadeBasica;
import javax.swing.JOptionPane;

public class Util {

    public static final int LOG_TYPE_INFO = 1;

    private static final DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static final int LOG_TYPE_WARN = 2;

    public static final int LOG_TYPE_DEBUG = 3;

    public static final int LOG_TYPE_ERROR = 4;

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
        return value.matches("[0-9]+");
    }

    public static final void toUpperCaseAllStrings(Object object) throws IllegalArgumentException, IllegalAccessException {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("Não pode ser passado um objeto nulo !");
        }
        Class clazz = object.getClass();
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.getType().equals(String.class)) {
                try {
                    f.set(object, String.valueOf(f.get(object)).trim().toUpperCase());
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (f.get(object) instanceof EntidadeBasica) {
                toUpperCaseAllStrings(f.get(object));
            }
        }
    }

    public static final Connection getConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345678");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final void fechaConexao(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final void log(String message, int type) {
        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("log.log"), true));
            if (type == LOG_TYPE_INFO) {
                writer.write(df.format(new Date()) + "[INFO]: " + message + "\n");
            } else if (type == LOG_TYPE_WARN) {
                writer.write(df.format(new Date()) + "[WARN]: " + message + "\n");
            } else if (type == LOG_TYPE_DEBUG) {
                writer.write(df.format(new Date()) + "[DEBUG]: " + message + "\n");
            } else if (type == LOG_TYPE_ERROR) {
                writer.write(df.format(new Date()) + "[ERROR]: " + message + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCodigoComoString(String titulo, String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
    }

    public static Integer getCodigoComoInteger(String titulo, String mensagem) {
        Integer retorno = null;
        String codigo = getCodigoComoString(titulo, mensagem);
        if (codigo != null && !codigo.isEmpty()) {
            try {
                retorno = Integer.parseInt(codigo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Código inválido", titulo, JOptionPane.ERROR_MESSAGE);
            }
        }
        return retorno;
    }
}
