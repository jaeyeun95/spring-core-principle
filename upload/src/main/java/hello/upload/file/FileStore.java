package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String filedir;

    public String getFullPath(String filename) {
        return filedir + filename;
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty())  {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilenmae = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilenmae);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFile(originalFilenmae, storeFileName);
    }

    private String createStoreFileName(String originalFilenmae) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractedExt(originalFilenmae);
        return uuid + "." + ext;
    }

    private String extractedExt(String originalFilenmae) {
        int pos = originalFilenmae.lastIndexOf(".");
        return originalFilenmae.substring(pos + 1);
    }

}
