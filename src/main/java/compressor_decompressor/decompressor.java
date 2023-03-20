package compressor_decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        String parent = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(parent + "/decompressedFile");

        byte[] buffer = new byte[1024];
        int len;

        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        gzip.close();
        fos.close();
        fis.close();

    }

    public static void main(String[] args) throws IOException {
        File path = new File("E:/String/Compressedfile.gz");
        method(path);
    }
}
