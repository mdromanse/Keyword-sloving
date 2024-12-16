package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.KeywordData;

@RestController
public class KeywordController {

	@Autowired 
	    private service.JsonService jsonService;

	    @GetMapping("/process-keywords")
	    public String processKeywords() {
	        try {
	            List<KeywordData> keywords = jsonService.readData();

	            for (KeywordData data : keywords) {
	               
	                System.out.println("Keyword: " + data.getKeyword());
	                System.out.println("Longest Option: " + data.getLongestOption());
	                System.out.println("Shortest Option: " + data.getShortestOption());
	            }

	           
	            jsonService.writeData(keywords);

	            return "Keywords processed successfully!";
	        } catch (IOException e) {
	            return "Error processing keywords: " + e.getMessage();
	        }
	    }
}
