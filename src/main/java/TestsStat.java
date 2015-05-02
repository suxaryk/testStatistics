import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class TestsStat {
    private List<Path> listPaths;

    public TestsStat(Path path) {
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
    private List<Path> getPaths(Path path) throws NullPointerException {
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                for (File file : path.toFile().listFiles()) {
                    getPaths(file.toPath());
                }
            } else {
                    if (path.getFileName().toString().endsWith("Test.java")){
                        listPaths.add(path);
                    }
            }
        } else throw new IllegalArgumentException("Invalid folder path");
        return listPaths;
    }


}
