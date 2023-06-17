import java.io.File;
import java.util.Scanner;

public class FolderLocker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the folder you want to lock/unlock: ");
        String folderPath = scanner.nextLine();

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        File folder = new File(folderPath);

        if (isFolderLocked(folder, password)) {
            unlockFolder(folder);
            System.out.println("Folder unlocked successfully!");
        } else {
            lockFolder(folder, password);
            System.out.println("Folder locked successfully!");
        }

        scanner.close();
    }

    public static void lockFolder(File folder, String password) {
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path");
            return;
        }

        String hiddenName = generateHiddenName(folder.getName(), password);
        File hiddenFolder = new File(folder.getParent(), hiddenName);
        if (!folder.renameTo(hiddenFolder)) {
            System.out.println("Failed to lock the folder");
        }
    }

    public static void unlockFolder(File folder) {
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path");
            return;
        }

        String folderName = folder.getName();
        String[] parts = folderName.split("\\.");

        if (parts.length != 3 || !parts[0].isEmpty()) {
            System.out.println("Folder is not locked");
            return;
        }

        File parentFolder = folder.getParentFile();
        String originalName = parts[1];
        File originalFolder = new File(parentFolder, originalName);
        if (!folder.renameTo(originalFolder)) {
            System.out.println("Failed to unlock the folder");
        }
    }

    public static boolean isFolderLocked(File folder, String password) {
        if (!folder.exists() || !folder.isDirectory()) {
            return false;
        }

        String folderName = folder.getName();
        String[] parts = folderName.split("\\.");

        if (parts.length != 3 || !parts[0].isEmpty()) {
            return false;
        }

        String originalName = parts[1];
        String expectedHiddenName = generateHiddenName(originalName, password);

        return folderName.equals(expectedHiddenName);
    }

    public static String generateHiddenName(String folderName, String password) {
        return "." + folderName + "." + password.hashCode();
    }

}
