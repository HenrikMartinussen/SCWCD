package info.martinussen.scwcd.hfsj.ch13.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

public class StylesheetCache {
  //Java & xslt p. 168

  //map xslt file names to MapEntry instances
  // (MapEntry is defined below)
  private static Map<String, MapEntry> cache = new HashMap<String, MapEntry>();

  //prevent instantiation of this class
  private StylesheetCache(  ) {
  }

  /**
   * Flush all cached stylesheets from memory, emptying the cache.
   */
  public static synchronized void flushAll(  ) {
    cache.clear(  );
  }

  /**
   * Flush a specific cached stylesheet from memory.
   *
   * @param xsltFileName the file name of the stylesheet to remove.
   */
  public static synchronized void flush(String xsltFileName) {
    cache.remove(xsltFileName);
  }


  public static synchronized Transformer newTransformer(String xsltFileName)
      throws TransformerConfigurationException {
    File xsltFile = new File(xsltFileName);
    // determine when the file was last modified on disk
    long xslLastModified = xsltFile.lastModified(  );
    MapEntry entry = cache.get(xsltFileName);
    if (entry != null) {
      // if the file has been modified more recently than the
      // cached stylesheet, remove the entry reference
      if (xslLastModified > entry.lastModified) {
        entry = null;
      }
    }

    // create a new entry in the cache if necessary
    if (entry == null) {
      Source xslSource = new StreamSource(xsltFile);
      TransformerFactory transFact = TransformerFactory.newInstance(  );
      Templates templates = transFact.newTemplates(xslSource);
      entry = new MapEntry(xslLastModified, templates);
      cache.put(xsltFileName, entry);
    }
    return entry.templates.newTransformer(  );
  }

  static class MapEntry {
    long lastModified; //When was the file last modified 
    Templates templates;

    public MapEntry(long lastModified, Templates templates) {
      this.lastModified = lastModified;
      this.templates = templates;
    }
  }
}
