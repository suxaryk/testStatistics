import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class TestStat {
    private static  List<Path> listPaths;
    public void showList(){
        for (Path i :listPaths) {
            System.out.println(i);
        }
    }
    public void createListOfFiles(Path path){
        getPaths(path);
    }

    private List<Path> getPaths(Path path){
        listPaths = new ArrayList<Path>();
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                for (File file : path.toFile().listFiles()) {
                    getPaths(file.toPath());
                }
            } else {
                    if (path.getFileName().toString().endsWith("Test.java")){
                        listPaths.add(path);
                        System.out.println(listPaths.get(listPaths.size() - 1));
                    }
            }
        }
        return listPaths;
    }


}
