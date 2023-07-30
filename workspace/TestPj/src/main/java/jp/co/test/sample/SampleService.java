package jp.co.test.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.test.sample.W2uiObjectDynamicGenerator.FormInfo;
import jp.co.test.sample.W2uiObjectDynamicGenerator.GridInfo;
import jp.co.test.sample.W2uiObjectDynamicGenerator.GridSearchCondition;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
class SampleService {

	private final SampleMapper mapper;
	private final NamedParameterJdbcTemplate template;

	public SampleResource findById(int id) throws NotFoundException {
		try {
//			var sql = mapper.getSql(10);
//			var sql = mapper.findKeibaData(10);
			var sql = "select id, sql_test from sample where id = :id";
			var conditions = Map.of("id", 10);
			var aaa = template.queryForList(sql, conditions);

			var whereMap = new HashMap<String, Object>();
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

	public List<FormInfo> generateFormInfo() {
		return W2uiObjectDynamicGenerator.generateFormInfo();
	}

	public List<GridInfo> generateGridInfo() {
		return W2uiObjectDynamicGenerator.generateGridInfo();
	}

//	public List<GridSearchCondition> generateGridSearches() {
//		return W2uiObjectDynamicGenerator.generateGridSearches();
//	}
}