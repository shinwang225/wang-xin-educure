import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main4 {
    public static void main(String[] args) {
        Path source = Path.of("source.txt");
        Path backupDirectory = Path.of("backup/");
        Path archiveDirectory = Path.of("archive/");

        try {
            Files.createDirectories(backupDirectory);
            Files.createDirectories(archiveDirectory);

            if (!Files.exists(source)) {
                Files.writeString(source, "sourceファイルです");
            }

            Path backupFile = backupDirectory.resolve(source.getFileName());
            Files.copy(source, backupFile, StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(backupFile)) {
                System.out.println("ファイルが 'backup/' にコピーされました。");
                System.out.println("コピーの確認: 成功");
            } else {
                System.out.println("コピーの確認: 失敗");
            }

            Path archiveFile = archiveDirectory.resolve(backupFile.getFileName());
            Files.move(backupFile, archiveFile, StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(archiveFile)) {
                System.out.println("ファイルが 'archive/' に移動されました。");
                System.out.println("移動の確認: 成功");
            } else {
                System.out.println("移動の確認: 失敗");
            }

        } catch (IOException e) {
            System.out.println("処理中にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}

