package kr.co.greenart.model.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	@Override
	public Resource getByName(String fileName) {
		// Resource: 자원을 원활하게 사용하기 위한 클래스
		throw new  UnsupportedOperationException("미구현");
	}

	@Override
	public List<String> getAllnames() {
		throw new UnsupportedOperationException("미구현");
	}

	@Override
	public int save(MultipartFile file) {
		/* 1 */
		File saveFolder = new File("d:\\temp\\");
		if(saveFolder.exists()) {
			saveFolder.mkdir();
		}
		try {
			file.transferTo(new File(saveFolder.getAbsolutePath()
					+ File.separatorChar
					+ file.getOriginalFilename()));
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		
		/* 2 */
//		Path saveFolder = Paths.get("d:\\");
//		try {
//			if (!Files.exists(saveFolder)) {
//				Files.createDirectories(saveFolder);
//			}
//			Files.createDirectories(saveFolder);
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename()).normalize()));
//			return 1;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
		
		
	}
}
