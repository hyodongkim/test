package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IHDHDDao {
	
	public List<HDHDDto> select();
	public List<HDHDDto> select_one(String id);
	public int insert(HDHDDto dto);
	public int insert_one(String writer, String title, String content, String id);
	public int delete(String id);
	public int update(String id, String writer, String title, String content);
	
}
	 
