package jp.co.test.sample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
	List<SampleResource> findAll();

	SampleResource findById(int id);
	List<Map<String, Object>> findKeibaData(int id);

	int insert(SampleResource resource);

	int update(SampleResource resource);

	int delete(int id);
	
	String getSql(int id);
	
	List testGeneralSearch(Map<String, Object> whereMap);
}