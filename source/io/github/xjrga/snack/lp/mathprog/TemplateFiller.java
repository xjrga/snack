package io.github.xjrga.snack.lp.mathprog;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateFiller {
  public String apply(MathProgDataObject data) {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setClassForTemplateLoading(this.getClass(), "/resources/templates");
    Map<String, MathProgDataObject> root = new HashMap<String, MathProgDataObject>();
    root.put("data", data);
    StringWriter stringWriter = new StringWriter();
    Template temp;
    try {
      temp = cfg.getTemplate("mathprog.ftl");
      temp.process(root, stringWriter);
    } catch (TemplateException | IOException ex) {
    }
    return stringWriter.toString();
  }
}
