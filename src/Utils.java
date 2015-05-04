
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import java.util.ArrayList;
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







}
