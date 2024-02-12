package io.github.xjrga.snack.lp.mathprog;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateFillerE {
  public String apply(MathProgDataObjectE data) {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
    cfg.setDefaultEncoding("UTF-8");
    try {
      cfg.setDirectoryForTemplateLoading(new File("resources/templates"));
    } catch (IOException ex) {
    }
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
