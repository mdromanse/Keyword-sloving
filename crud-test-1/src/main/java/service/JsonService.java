package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.KeywordData;

public class JsonService {
	
	 private static final String FILE_PATH = "src/main/resources/keywords.json";

	    public List<KeywordData> readData() throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        return List.of(mapper.readValue(new File(FILE_PATH), KeywordData[].class));
	    }

	    public void writeData(List<KeywordData> data) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.writeValue(new File(FILE_PATH), data);
	    }

}
