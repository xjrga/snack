package io.github.xjrga.snack.lp.mathprog;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateFillerE {
  public String apply(MathProgDataObjectE data) {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setClassForTemplateLoading(this.getClass(), "/resources/templates");
    Map<String, MathProgDataObjectE> root = new HashMap<String, MathProgDataObjectE>();
    root.put("data", data);
    StringWriter stringWriter = new StringWriter();
    Template temp;
    try {
      temp = cfg.getTemplate("mathprogE.ftl");
      temp.process(root, stringWriter);
    } catch (TemplateException | IOException ex) {
    }
    return stringWriter.toString();
  }
}
