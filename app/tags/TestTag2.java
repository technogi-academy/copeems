package tags;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.Map;

import play.templates.FastTags;
import play.templates.FastTags.Namespace;
import play.templates.GroovyTemplate.ExecutableTemplate;
import play.templates.JavaExtensions;

@Namespace("copeems")
public class TestTag2 extends FastTags {
	
	public static void _helloTestTag1 (Map<String, Object> args, Closure body, PrintWriter out, 
      ExecutableTemplate template, int fromLine) {
      
		Object arg1 = args.get("title");
		
		String title = "";
		if(arg1==null)
			title = "Sin Titulo";
		else
			title = arg1.toString();
		
		out.println("<h1>HELLO "+title+"</h1>"+
				JavaExtensions.toString(body));
   }

}
