package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Entity.Record;

public interface RecordMapper {

	@Select("SELECT * FROM result;")
	List<Record> getAllRecord();

	@Select("SELECT * FROM result WHERE Id=#{id};")
	Record getSpcRecord(int id);

	@Update("INSERT INTO result (ImgUrl,SbmDate) VALUES (#{ImgUrl}, #{SbmDate});")
	void addRecord(Record record);
}
