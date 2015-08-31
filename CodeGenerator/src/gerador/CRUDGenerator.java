package gerador;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CRUDGenerator {

	private static String nomeMB = "";
	private static String nomeEntidade = "";
	private static String nomeEntidadeLowerCase = "";
	private static String nomeEntidadePluralLowerCase = "";
	private static String labelNomeEntidade = "";
	private static String basePackage = "";
	private static String corPadrao = "default";
	private static String declaracaoAtributos = "";
	private static String getters = "";
	private static String setters = "";
	private static String inputsXHTML = "";
	private static String inputsFiltrosXHTML = "";
	private static String linksMenu = "";
	private static String columnsDataTable = "";
	private static List<String> listaEntidades = new ArrayList<String>();
	private static Map<String, String> fieldsEntidade;

	public static void main(String[] args) {

		String novaEntidade = "";

		Scanner scan = new Scanner(System.in);

		defineBasePackage(scan);

		defineGeneralColor(scan);

		try{

			do {

				reset();

				populateVariables(scan);

				createMenu();

				File dirTemplatesResources = new File(System.getProperty("user.dir") + File.separator + "resources");

				File[] resourceFiles = dirTemplatesResources.listFiles();

				StringBuilder bufferReadFile = null;

				String fileContent = null;

				BufferedReader reader = null;

				File out = null;

				String nomeArquivoOut = null;

				String filePath = basePackage.replace('.', File.separatorChar);

				for (File arquivoAtual : resourceFiles) {

					nomeArquivoOut = arquivoAtual.getName().replaceAll("Template", nomeEntidade);

					bufferReadFile = new StringBuilder();

					reader = new BufferedReader(new FileReader(arquivoAtual));

					while(reader.ready()){

						bufferReadFile.append(reader.readLine()).append("\n");

					}

					reader.close();

					fileContent = replaceFileContent(bufferReadFile);

					out = organizeFiles(fileContent, nomeArquivoOut, filePath);

					writeFile(fileContent, out);
				}

				System.out.print("Deseja criar uma nova entidade(S/N)? ");

				novaEntidade  = scan.next();

			} while(!novaEntidade.equalsIgnoreCase("N"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println("Arquivos gerados com sucesso !");
	}

	private static void reset() {
		nomeMB = "";
		nomeEntidade = "";
		nomeEntidadeLowerCase = "";
		nomeEntidadePluralLowerCase = "";
		labelNomeEntidade = "";
		declaracaoAtributos = "";
		getters = "";
		setters = "";
		inputsXHTML = "";
		inputsFiltrosXHTML = "";
		columnsDataTable = "";
		fieldsEntidade = null;
	}

	private static void createinputsXHTML() {

		StringBuilder builder = new StringBuilder();

		for (String s : fieldsEntidade.keySet()) {

			builder.append("\t\t\t\t\t<h:outputLabel value=\"").append(s.substring(0,1).toUpperCase()).append(s.substring(1)).append("\" /> \n");

			builder.append("\t\t\t\t\t<h:inputText id=\"")
			.append("input_").append(s).append("_").append(nomeEntidadeLowerCase)
			.append("\" value=\"#{")
			.append(nomeEntidadeLowerCase).append("MB").append(".beanSelecionado.").append(s)
			.append("}\" styleClass=\"form-control\"");

			if (fieldsEntidade.get(s).equalsIgnoreCase("Date")) {

				builder.append(">\n");

				builder.append("\t\t\t\t\t\t <f:convertDateTime pattern=\"dd/MM/yyyy\"/>\n");

				builder.append("\t\t\t\t\t</h:inputText>");

			} else {

				builder.append("/>");
			}

			builder.append("\n\n");
		}

		inputsXHTML = builder.toString();

		inputsFiltrosXHTML = inputsXHTML.replaceAll("beanSelecionado", "beanFiltro");
		inputsFiltrosXHTML = inputsFiltrosXHTML.replaceAll("input_", "input_filtro_"); 
	}

	private static void createFieldsDeclarations() {

		StringBuilder builder = new StringBuilder();

		if (fieldsEntidade != null) {

			for (String s : fieldsEntidade.keySet()) {

				builder.append("\t @Column(name=\"" + createColumnNameInTableDB(s) + "\")").append("\n");

				if (fieldsEntidade.get(s).equalsIgnoreCase("date")) {

					builder.append("\t @Temporal(TemporalType.TIMESTAMP)").append("\n");
				}

				builder.append("\t private").append(" ").append(fieldsEntidade.get(s)).append(" ").append(s).append(";").append("\n\n");
			}
			declaracaoAtributos = builder.toString();

			createGetters();

			createSetters();

			createinputsXHTML();

			createColumnsDataTable();
		}
	}

	private static String createColumnNameInTableDB(String s) {

		StringBuilder builder = new StringBuilder();
		
		for (Character c : s.toCharArray()) {
			
			if (Character.isUpperCase(c)) {
				
				builder.append("_");
			}
			
			builder.append(Character.toUpperCase(c));
			
		}
		
		return builder.toString();
	}

	private static void createColumnsDataTable() {

		StringBuilder builder = new StringBuilder();

		if (fieldsEntidade != null) {

			for (String s : fieldsEntidade.keySet()) {

				builder.append("\t\t\t\t\t");

				builder.append("<h:column id=\"column_").append(s).append("_").append(nomeEntidadeLowerCase).append("\">\n");

				builder.append("\t\t\t\t\t\t");

				builder.append("<f:facet name=\"header\">\n");

				builder.append("\t\t\t\t\t\t\t");

				builder.append("<h:outputLabel value=\"").append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append("\"/>\n");

				builder.append("\t\t\t\t\t\t");

				builder.append("</f:facet>\n");

				builder.append("\t\t\t\t\t\t");

				builder.append("<h:outputLabel value=\"#{").append(nomeEntidadeLowerCase).append(".").append(s).append("}\"");

				if (fieldsEntidade.get(s).equalsIgnoreCase("Date")) {

					builder.append(">\n");

					builder.append("\t\t\t\t\t\t\t <f:convertDateTime pattern=\"dd/MM/yyyy\"/>\n");

					builder.append("\t\t\t\t\t\t</h:outputLabel>\n");

				} else {

					builder.append("/>\n");
				}

				builder.append("\t\t\t\t\t");

				builder.append("</h:column>");

				builder.append("\n\n");
			}
		}

		columnsDataTable = builder.toString();
	}

	private static void createGetters(){

		StringBuilder builder = new StringBuilder();

		builder.append("\t // métodos getters\n\n");

		if (fieldsEntidade != null) {

			for (String s : fieldsEntidade.keySet()) {

				builder.append("\t public ").append(fieldsEntidade.get(s)).append(" get").append(s.substring(0,1).toUpperCase()).append(s.substring(1)).append("() { \n");

				builder.append("\t\t return this.").append(s).append(";\n");

				builder.append("\t }").append("\n\n");
			}
			getters = builder.toString();
		}
	}

	private static void createSetters(){

		StringBuilder builder = new StringBuilder();

		builder.append("\t // métodos setters\n\n");

		if (fieldsEntidade != null) {

			for (String s : fieldsEntidade.keySet()) {

				builder.append("\t public void").append(" set").append(s.substring(0,1).toUpperCase())
				.append(s.substring(1)).append("(").append(fieldsEntidade.get(s)).append(" ").append(s).append(") { \n");

				builder.append("\t\t this.").append(s).append(" = ").append(s).append("; \n");

				builder.append("\t }").append("\n\n");
			}
			setters = builder.toString();
		}
	}

	/**
	 * @param fileContent
	 * @param out
	 * @throws FileNotFoundException
	 */
	private static void writeFile(String fileContent, File out) throws FileNotFoundException {

		PrintWriter writer;

		writer = new PrintWriter(out);

		writer.write(fileContent);

		writer.flush();

		writer.close();
	}

	/**
	 * @param bufferReadFile
	 * @return
	 */
	private static String replaceFileContent(StringBuilder bufferReadFile) {

		String fileContent;

		fileContent = bufferReadFile.toString();

		fileContent = fileContent.replaceAll("LABEL_NOME_ENTIDADE", labelNomeEntidade);

		fileContent = fileContent.replaceAll("NOME_MB", nomeMB);

		fileContent = fileContent.replaceAll("NOME_ENTIDADE_LOWER_CASE", nomeEntidadeLowerCase);

		fileContent = fileContent.replaceAll("NOME_ENTIDADE_PLURAL_LOWER_CASE", nomeEntidadePluralLowerCase);

		fileContent = fileContent.replaceAll("NOME_ENTIDADE", nomeEntidade);

		fileContent = fileContent.replaceAll("BASE_PACKAGE", basePackage);

		fileContent = fileContent.replaceAll("DATA_CRIACAO_ARQUIVO", new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));

		fileContent = fileContent.replaceAll("COR_PADRAO", corPadrao);

		fileContent = fileContent.replaceAll("FIELDS_ENTIDADE", declaracaoAtributos);

		fileContent = fileContent.replaceAll("GETTERS", getters);

		fileContent = fileContent.replaceAll("SETTERS", setters);

		fileContent = fileContent.replaceAll("INPUTS_XHTML", inputsXHTML);

		fileContent = fileContent.replaceAll("INPUTS_FILTROS_XHTML", inputsFiltrosXHTML);

		fileContent = fileContent.replaceAll("LINKS_MENU", linksMenu);

		fileContent = fileContent.replaceAll("COLUMNS_DATA_TABLE", columnsDataTable);

		return fileContent;
	}

	/**
	 * @param fileContent
	 * @param nomeArquivoOut
	 * @param filePath
	 * @return
	 */
	private static File organizeFiles(String fileContent, String nomeArquivoOut, String filePath) {

		File out;

		File path;

		if (fileContent.contains("Converter")) { 

			createPackages(filePath, "util");

			out =  new File("generated" + File.separator + filePath +  File.separator + "util" + File.separator + nomeArquivoOut);

		} else if (fileContent.contains("AbstractManagedBean")) {

			createPackages(filePath, "managedbeans");

			out = new File("generated" + File.separator + filePath +  File.separator + "managedbeans"+ File.separator + nomeArquivoOut);

		} else if (fileContent.contains("AbstractService")) {

			createPackages(filePath, "services");

			out = new File("generated" + File.separator + filePath +  File.separator + "services"+ File.separator + nomeArquivoOut);

		} else if (fileContent.contains("AbstractDAO")) {

			createPackages(filePath, "data");

			out = new File("generated" + File.separator + filePath +  File.separator + "data"+ File.separator + nomeArquivoOut);

		} else if (fileContent.contains("EntidadeBasica")) {

			createPackages(filePath, "entidades");

			out = new File("generated" + File.separator + filePath +  File.separator + "entidades"+ File.separator + nomeArquivoOut);

		} else {

			path = new File("generated" + File.separator + "WebContent");

			if (!path.exists()) {

				path.mkdirs();
			}

			out = new File("generated" + File.separator + "WebContent" +  File.separator + nomeArquivoOut);
		}
		return out;
	}

	/**
	 * 
	 */
	private static void populateVariables(Scanner scan) {

		System.out.print("Favor informe o nome da entidade: ");

		nomeEntidade = scan.next();

		nomeEntidade = nomeEntidade.substring(0, 1).toUpperCase() + nomeEntidade.substring(1);

		nomeEntidadeLowerCase = nomeEntidade.toLowerCase();

		nomeMB = nomeEntidadeLowerCase + "MB";

		labelNomeEntidade = nomeEntidade;

		listaEntidades.add(nomeEntidade);

		System.out.print("Entidade possui Atributos (S/N) ?");

		String hasAttributes = scan.next();

		if (hasAttributes.equalsIgnoreCase("s")) {

			getFieldsEntidade(scan);
		}

	}

	/**
	 * @param scan
	 */
	private static void defineBasePackage(Scanner scan) {
		System.out.print("Favor informe o pacote base: ");

		basePackage = scan.next();
	}

	private static void getFieldsEntidade(Scanner scan) {

		Map<String, String> retorno = new LinkedHashMap<String, String>();

		String novoAtributo = null;

		do {

			System.out.print("Informe o nome do Atributo (Conven��o Java beans): ");

			String nomeAtributo = scan.next();

			System.out.print("Informe o tipo do Atributo: ");

			String tipoAtributo = scan.next();

			retorno.put(nomeAtributo, tipoAtributo);

			System.out.print("Adicionar novo atributo (S/N) ?");

			novoAtributo = scan.next();

		} while (novoAtributo.equalsIgnoreCase("S"));

		fieldsEntidade = retorno;

		createFieldsDeclarations();

	}

	private static void defineGeneralColor(Scanner scan) {

		System.out.println("Escolha uma cor padrão (Botões da aplicação): ");

		System.out.println(" 1 - Branca ");

		System.out.println(" 2 - Azul ");

		System.out.println(" 3 - Azul Claro");

		System.out.println(" 4 - Verde ");

		System.out.println(" 5 - Laranja ");

		System.out.println(" 6 - Vermelho");

		int escolha = scan.nextInt();

		switch(escolha) {

		case 1 :
			corPadrao = "default";
			break;
		case 2 :
			corPadrao = "primary";
			break;
		case 3 :
			corPadrao = "info";
			break;
		case 4 :
			corPadrao = "success";
			break;
		case 5 :
			corPadrao = "warning";
			break;
		case 6 :
			corPadrao = "danger";
			break;
		}
	}

	/**
	 * @param filePath
	 */
	private static void createPackages(String filePath, String packageName) {

		File path;

		path = new File("generated" + File.separator + filePath + File.separator + packageName);

		if (!path.exists()) {

			path.mkdirs();
		}
	}

	private static void createMenu() {

		StringBuilder sb = new StringBuilder();

		if (!listaEntidades.isEmpty()) {

			for (String s : listaEntidades) {

				sb.append("\t\t\t\t\t<h:commandLink action=\"").append(s).append(".xhtml\" value=\"").append(s).append("\"/>\n");
				
				sb.append("\t\t\t\t\t<br /> <br />\n\n");
			}

		}

		linksMenu = sb.toString();
	}
}

