# Folder Locker

Folder Locker is a simple command-line Java application that allows you to lock a folder by renaming it to a hidden name. This can help secure your sensitive folders by making them less visible and accessible.

## Usage

1. Make sure you have Java installed on your system.
2. Clone or download the Folder Locker repository.
3. Open a terminal or command prompt and navigate to the project directory.
4. Compile the Java source file: javac FolderLocker.java
5. Run the application: java FolderLocker
   
6. Follow the prompts to enter the path of the folder you want to lock and set a password.

- Note: Once the folder is locked, it will be renamed to a hidden name using the provided password. Make sure to remember the password for unlocking the folder.

7. The application will attempt to lock the folder by renaming it to a hidden name. If successful, it will display a success message.

- If the folder path is invalid or the folder cannot be locked, an appropriate error message will be displayed.

8. To unlock the folder, you need to run the application again and provide the correct folder path and password.

## Important Note

- The password is not securely stored in this example. In a real-world scenario, you should employ proper password storage and hashing techniques.
- Renaming the folder to a hidden name is a basic method of hiding the folder. It may not provide full security or hide the folder from advanced users or certain operating systems.

## Contribution

Contributions to improve Folder Locker are welcome! Feel free to submit issues and pull requests to address bugs, add new features, or improve the code.

