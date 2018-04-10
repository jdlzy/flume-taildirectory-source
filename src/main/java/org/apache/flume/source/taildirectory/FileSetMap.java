package org.apache.flume.source.taildirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSetMap extends HashMap<String, FileSet> {
	
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileSetMap.class);
	
	private Map<String, String> filePathsAndKeys;
	
	FileSetMap(Map<String, String> filePathsAndKeys){
		super();
		this.filePathsAndKeys = filePathsAndKeys;
	}
	
	public FileSet getFileSet(Path path) throws IOException {

		String fileKey = FileKeys.getFileKey(path);

		if (this.containsKey(fileKey)) {
			return this.get(fileKey);
		} else {
			return addFileSetToMap(path, "lastLine");
		}
	}
	
	public FileSet addFileSetToMap(Path path, String startFrom)
			throws IOException {

		FileSet fileSet;
        
		if (Files.isSymbolicLink(path)){
			LOGGER.warn("Symbolic links not accepted, ignoring {}",path);
			return null;
		}
		
		String fileKey = FileKeys.getFileKey(path);

		if (!this.containsKey(fileKey)) {
			LOGGER.info("扫描到文件: " + path.toString() + " with key: "
					+ fileKey);
				fileSet = new FileSet(path, startFrom);
				filePathsAndKeys.put(path.toString(), fileKey);
				this.put(fileKey, fileSet);
		} else{
			fileSet = this.get(fileKey);
			
			if (!fileSet.getFilePath().toString().equals(path.toString())){
				fileSet.setFilePath(path);
			}
		}
		return fileSet;
	}
}
