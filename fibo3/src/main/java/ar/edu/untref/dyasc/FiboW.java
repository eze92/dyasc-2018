package ar.edu.untref.dyasc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FiboW {

	 public void escribir(String fileName, String text) {
	        File aFile = creaArchivo(fileName);
	        FileWriter fw = null;
	        try {
	            fw = new FileWriter(aFile.getAbsoluteFile());
	            fw.write(text);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                fw.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private File creaArchivo(String fileName) {
	        File aFile = new File(fileName);
	        if (!aFile.exists()) {
	            try {
	                aFile.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return aFile;
	    }
	}
