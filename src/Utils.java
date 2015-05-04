import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    private BufferedReader in;
    private List<Path> listPaths;

    public void createList(Path path) {
        listPaths = new ArrayList<>();
        try {
            getPaths(path);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
    public List<Path> getListPaths() {
        return listPaths;
    }
    public void showList(){
        for (Path i :listPaths) {
            System.out.println(i);
        }
    }
    private List<Path> getPathsRecurs(Path path) throws NullPointerException {
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                for (File file : path.toFile().listFiles()) {
                    getPaths(file.toPath());
                }
            } else {
                if (path.getFileName().toString().endsWith("Test.xml")){
                    listPaths.add(path);
                }
            }
        } else throw new IllegalArgumentException("Invalid folder path");
        return listPaths;
    }

    private List<Path> getPaths(Path path)  {
        if (Files.exists(path)) {
            for (File file : path.toFile().listFiles()) {
                if (file.toString().endsWith("Test.xml")){
                    listPaths.add(file.toPath());
                }
            }
        } else throw new IllegalArgumentException("Invalid folder path");
        return listPaths;
    }
//    public Test parseXML(Path path){
//            return DOMparser(path);
//    }

//    public Test DOMparser(Path path){
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = null;
//        Document document = null;
//        Element element = null;
//        try {
//            builder = factory.newDocumentBuilder();
//            document = builder.parse(path.toString());
//            document.getDocumentElement();
//
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//                return new Test(
//                        element.getAttribute("name"),
//                        element.getAttribute("timestamp").replace("T", " "),
//                        Integer.parseInt(element.getAttribute("failures")),
//                        Long.parseLong(element.getAttribute("time")),
//                        document.getElementsByTagName("error").item(0).getTextContent()
//                );
//
//        }
//
//    }








}
