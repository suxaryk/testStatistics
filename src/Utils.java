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
//    public void parseXML(Path path){
//        try {
//            return DOMparser(path);
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public void DOMparser(Path path) throws ParserConfigurationException, IOException, SAXException {
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(path.toString());
//        Element element = document.getDocumentElement();
////        //System.out.println(new Date(element.getAttribute("timestamp").replace("T", " ")));
////        System.out.println(element.getAttribute("name"));
////        System.out.println(element.getAttribute("failures"));
////        System.out.println(element.getAttribute("time"));
////        System.out.println(element.getAttribute("timestamp").replace("T", " "));
////        System.out.println(document.getElementsByTagName("error").item(0).getTextContent());
////        Integer.parseInt(element.getAttribute("failures"));
//        Test tmpTest = new Test(
//                                element.getAttribute("name"),
//                                element.getAttribute("timestamp").replace("T", " "),
//                                Integer.parseInt(element.getAttribute("failures")),
//                                Long.parseLong(element.getAttribute("time")),
//                                document.getElementsByTagName("error").item(0).getTextContent()
//                                );
//
//
//    }







    private String readFiles(Path inputPath){
        {
            String taskText = "";
            try {

                in = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath.toString())), "UTF8"));
                String str;
                do {
                    str = in.readLine();

                    if(str.equals("*/")) break;
                    if(str.equals("public class Solution")) break;
                    // System.out.println(str);
                    taskText += str + "\n";

                }while(str != null);
            } catch (UnsupportedEncodingException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return taskText + "*/";

            }}
    }
}
