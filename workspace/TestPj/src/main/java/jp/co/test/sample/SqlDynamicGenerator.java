package jp.co.test.sample;

import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SqlDynamicGenerator {

	private static final String SPLIT_STRING_SELECT_SENTENCE = " (?!)SELECT ";
	private static final String SUB_QUERY_START_PHRASE = "with";
	private static final String[] SEARCH_STRING_LIST = new String[] { "\r\n", "\r", "\n", "\t", "(", ")" };
	private static final String[] REPLACEMENT_STRING_LIST = new String[] { StringUtils.SPACE, StringUtils.SPACE, StringUtils.SPACE, StringUtils.SPACE, "( ", ") " };
	private static final String REGEX_SPACES = " +";

	record SqlPhraseParts(String[] select, Boolean distinct, String from, String[] innerJoin, String[] leftOuterJoin, String[] rightOuterJoin, String[] where, String[] groupBy, String[] having, String[] orderBy, String limit) {
	}

	public static List<SqlPhraseParts> generateSqlPhrasePartsList(String sqlAsString) {
		return splitSql(sqlAsString).map(sql -> generateSqlPhraseParts(sql)).toList();

	}

	private static Stream<String> splitSql(String sqlAsString) {
		var oneLineSql = RegExUtils.replaceAll(StringUtils.replaceEach(sqlAsString, SEARCH_STRING_LIST, REPLACEMENT_STRING_LIST), REGEX_SPACES, StringUtils.SPACE);
		return Stream.of(oneLineSql.split(SPLIT_STRING_SELECT_SENTENCE)).map(sql -> " SELECT " + sql);
	}
	
	private static SqlPhraseParts generateSqlPhraseParts(String sqlAsString) {
		// TODO 未実装
		return null;
	}

	public static String generateSql() {
		return new SQL() {
			{
				SELECT("");
			}
		}.toString();
	}
}
