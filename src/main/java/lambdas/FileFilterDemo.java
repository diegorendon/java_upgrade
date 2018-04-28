package lambdas;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        File root = new File("src/main/java");
        File[] files = root.listFiles(); // list everything
        for (File file : files) {
            System.out.println(file);
        }

        // Use anonymous inner class for FileFilter
        files = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        System.out.println("Only list directories: ");
        System.out.println(files.length);
        for (File file : files) {
            System.out.println(file);
        }

        // Use a lambda for the file filter
        files = root.listFiles(path -> path.isDirectory());
        System.out.println("Only list directories: ");
        System.out.println(files.length);
        for (File file : files) {
            System.out.println(file);
        }

        // Use a method reference for the file filter
        files = root.listFiles(File::isDirectory);
        System.out.println("Only list directories: ");
        System.out.println(files.length);
        for (File file : files) {
            System.out.println(file);
        }

    }
}