package es.iesclaradelrey.da2d1a.tiendarmgaos.common.utils;

import java.text.Normalizer;


public class SlugUtils {
    public static String toSlug(String texto) {
        if (texto == null) return "";
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]" ,"")
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .trim();
    }
}
