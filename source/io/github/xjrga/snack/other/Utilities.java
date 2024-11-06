package io.github.xjrga.snack.other;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Precision;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class Utilities {
  public Utilities() {}

  public static String sha256_hash_to_hex(String s) {
    StringBuilder sb = null;
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
      sb = new StringBuilder(2 * encodedhash.length);
      for (byte b : encodedhash) {
        sb.append(String.format("%02x", b));
      }
    } catch (NoSuchAlgorithmException ex) {
    }
    return sb.toString();
  }

  public static String random() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      sb.append(Math.random());
    }
    String replace = sb.toString().replace(".", "");
    return replace.substring(0, 128);
  }

  private String convert_to_hex_02(byte[] hash) {
    StringBuilder sb = new StringBuilder(2 * hash.length);
    for (byte b : hash) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  private String convert_to_hex_03(byte[] hash) {
    StringBuilder sb = new StringBuilder(2 * hash.length);
    for (byte b : hash) {
      sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }

  public static String format_xml_doc(String xml) {
    String str = "";
    try {
      final InputSource src = new InputSource(new StringReader(xml));
      final Node document =
          DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
      final Boolean keepDeclaration = xml.startsWith("<?xml");
      final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
      final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
      final LSSerializer writer = impl.createLSSerializer();
      writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
      writer.getDomConfig().setParameter("xml-declaration", keepDeclaration);
      str = writer.writeToString(document);
      return str;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return str;
  }

  public static double[] convert_to_double_array(int[] array) {
    double[] darray = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      darray[i] = array[i];
    }
    return darray;
  }

  public static double[] convert_to_double_array(List<Double> list) {
    double[] arr = new double[list.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  public static String print_double_array(double[] array) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < array.length; i++) {
      sb.append(array[i]);
      sb.append(", ");
    }
    sb.setLength(sb.length() - 1);
    sb.append("]");
    return sb.toString();
  }

  public static void append_to_file(String filePath, String txt) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true))) {
      out.write(txt);
    } catch (IOException ex) {
    }
  }

  public static void write_to_new_file(String filePath, String txt) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath, false))) {
      out.write(txt);
    } catch (IOException ex) {
    }
  }

  public static String convert_file_to_string(String path) {
    String str = "";
    try {
      str = new String(Files.readAllBytes(Path.of(path)));
    } catch (IOException ex) {
    }
    return str;
  }

  public static void openUrl(String url) {
    try {
      Desktop.getDesktop().browse(new URL(url).toURI());
    } catch (IOException | URISyntaxException e) {
    }
  }

  public static String formatDecimal(Double x) {
    DecimalFormat formatter = new DecimalFormat("####.###");
    return formatter.format(x);
  }

  public static String formatDate(Date date) {
    String pattern = "EEEE, MMMMM dd, yyyy' at 'HH:mm:ss";
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    return dateFormat.format(date);
  }

  public static double calculateDotProduct(RealVector v, double[] point) {
    ArrayRealVector rvpoint = new ArrayRealVector(point);
    return v.dotProduct(rvpoint);
  }

  public static boolean isDoubleEqual(double value, double dot_product) {
    boolean flag = false;
    double epsilon = 0.000001d;
    if (Precision.equals(value, dot_product, epsilon)) {
      flag = true;
    }
    return flag;
  }

  public static long getCurrentTimeMillis() {
    return System.currentTimeMillis();
  }

  public static String getCurrentTimeMillisTxt() {
    StringBuilder sb = new StringBuilder();
    sb.append(System.currentTimeMillis());
    sb.setLength(sb.length() - 3);
    return sb.toString();
  }

  public static Dimension getDimension(Integer width, Integer height) {
    return new Dimension(width, height);
  }

  public static File getFileAsResource(String path) {
    return new File(Utilities.class.getClassLoader().getResource(path).getFile());
  }

  public static Path getPathAsResource(String path) {
    Path get = null;
    try {
      get =
          Paths.get(
              Objects.requireNonNull(Utilities.class.getClassLoader().getResource(path)).toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }
    return get;
  }

  public static BufferedReader getBufferedReader(String path) {
    BufferedReader br =
        new BufferedReader(
            new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(path)));
    return br;
  }

  public static String getResourceAsString(String path) {
    InputStream is = Utilities.class.getResourceAsStream(path);
    StringBuilder sb = new StringBuilder();
    InputStreamReader isr = new InputStreamReader(is);
    try {
      int i;
      while ((i = isr.read()) != -1) {
        sb.append((char) i);
      }
      isr.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return sb.toString();
  }

  public static URL getResourceAsUrl(String resource_path) {
    URL schemaUrl = Utilities.class.getResource(resource_path);
    return schemaUrl;
  }
}
