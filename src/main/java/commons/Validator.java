package commons;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface Validator {
	default void requiredCheck(HttpServletRequest request, Map<String, String> fields) {
		 for(Map.Entry<String, String> entry : fields.entrySet()) {
			 String value = request.getParameter(entry.getKey());
			 String msg = entry.getValue();
			 if(value == null || value.isBlank()) {
				 throw new BadRequestException(msg);
			 }
		 }
	 }
}
