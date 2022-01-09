package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Record;
import com.example.demo.Entity.Result;
import com.example.demo.Mapper.RecordMapper;

@RestController
@RequestMapping("/record")
public class RecordController {

	// Define file reserve path
	private String path = "D:\\Files\\uploadImgs";

	// Define flags to check store process
	private boolean picStore = false;
	private boolean dbStore = false;

	@Resource
	RecordMapper recordMapper;

	/* GET ALL THE RECORD IN DATABASE*/
	@GetMapping("/getAll")
	public List<Record> getAllRecord() {
		return recordMapper.getAllRecord();
	}

	/* GET SPECIFIC RECORD BY POST ID*/
	@PostMapping("/getRecord")
	public Record getSpcRecord(@RequestParam(value = "id") String id) {
		int tmpid = Integer.parseInt(id);
		return recordMapper.getSpcRecord(tmpid);
	}

	/* UPLOAD IMAGE AND STORE */
	@PostMapping("/addRecord")
	@ResponseBody
	public Object test(@RequestParam("imgFile") MultipartFile file, HttpServletRequest request) {
		// Get the name of the file uploaded
		String originalFilename = file.getOriginalFilename();

		// Get suffix name of the file
		String suffixName = originalFilename.substring(originalFilename.lastIndexOf('.'));

		// Generate a new filename for database
		String dbFileName = UUID.randomUUID() + suffixName;

		File newFile = new File(path, dbFileName);

		Map<String, String> data = new HashMap<String, String>();
		data.put("filename", originalFilename);

		try {
			// Generate a new record and insert
			String fileAddr = path + "\\" + dbFileName;
			recordMapper.addRecord(generateNewRecord(fileAddr));

			try {
				// Preserve file to specified location
				file.transferTo(newFile);
			} catch (IOException e) {
				e.printStackTrace();

				return new Result(-1, data, "Preserve Fail");
			}

			return new Result(1, data, "Upload Success");
		} catch (Exception e) {
			e.printStackTrace();

			return new Result(-2, data, "Insert Fail");

		}

	}

	private Record generateNewRecord(String path) {
		Date d = new Date();

		return new Record(path, d);
	}

}
