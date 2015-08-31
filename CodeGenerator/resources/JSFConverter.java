package resources;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import BASE_PACKAGE.entidades.EntidadeBasica;

/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


@FacesConverter(value="br.com.faces.converter.JSFConverter", forClass=EntidadeBasica.class)
public class JSFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null){
			return component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && ! "".equals(value)) {
			EntidadeBasica entity = (EntidadeBasica) value;

			if (entity.getId() != null) {
				component.getAttributes().put(entity.getId().toString(), entity);

				if (entity.getId() != null) {
					return String.valueOf(entity.getId());
				}
				return (String) value;
			}
		}
		return "";
	}
}
