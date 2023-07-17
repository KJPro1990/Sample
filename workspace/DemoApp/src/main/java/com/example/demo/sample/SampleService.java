package com.example.demo.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.sample.W2uiObjectDynamicGenerator.GridColumns;
import com.example.demo.sample.W2uiObjectDynamicGenerator.GridSearchCondition;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
class SampleService {

	private final SampleMapper mapper;

	public SampleResource findById(int id) throws NotFoundException {
		try {
			String sql = mapper.getSql(0);
			Map<String, Object> whereMap = new HashMap<>();
			whereMap.put("sql", sql);
			whereMap.put("place", "札幌");
			var result = mapper.testGeneralSearch(whereMap);
			if (result == null) {
				String errorMessage = "対象データが存在しません";
				throw new NotFoundException(errorMessage);
			}
			return null;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public List<SampleResource> findList(SampleResource form) {
		return mapper.findAll();
	}

	public int insert(SampleResource form) {
		return mapper.insert(form);
	}

	public int update(SampleResource form) {
		return mapper.update(form);
	}

	public int delete(int id) {
		return mapper.delete(id);
	}

	public List<FormFields> generateFormFields() {
		return W2uiObjectDynamicGenerator.generateFormFields();
	}

	public List<GridColumns> generateGridColumns() {
		return W2uiObjectDynamicGenerator.generateGridColumns();
	}

	public List<GridSearchCondition> generateGridSearches() {
		return W2uiObjectDynamicGenerator.generateGridSearches();
	}
}