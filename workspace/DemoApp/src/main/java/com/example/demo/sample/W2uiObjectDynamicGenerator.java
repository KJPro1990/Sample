package com.example.demo.sample;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class W2uiObjectDynamicGenerator {

	record FormFieldsNormal(String field, String type, Boolean required) implements FormFields {
	}

	record FormFieldsWithHtml(String field, String type, Boolean required, @NonNull FormFieldsHtml html) implements FormFields {
		// TODO FormFieldsHtmlを生成するコンストラクタ
	}

	record FormFieldsWithOptions(String field, String type, Boolean required, @NonNull FormFieldsOptions options) implements FormFields {
		// TODO FormFieldsOptionsを自動生成するコンストラクタ
	}

	record FormFieldsWithHtmlAndOptions(String field, String type, Boolean required, @NonNull FormFieldsHtml html, @NonNull FormFieldsOptions options) implements FormFields {
		// TODO FormFieldsHtml、FormFieldsOptionsを自動生成するコンストラクタ
		// TODO FormFieldsHtmlを生成するコンストラクタ
	}

	record FormFieldsHtmlNormal(String label, String attr) implements FormFieldsHtml {
	}

	record FormFieldsHtmlWithText(String label, String attr, String text) implements FormFieldsHtml {
	}

	record FormFieldsHtmlWithAnchor(String label, String attr, String anchor) implements FormFieldsHtml {
	}

	record FormFieldsHtmlWithTextAndAnchor(String label, String attr, String text, String anchor) implements FormFieldsHtml {
	}

	record FormFieldsIntegerOptions(@NonNull Integer min, @NonNull Integer max, Boolean format) implements FormFieldsOptions {
		public FormFieldsIntegerOptions() {
			this(0, 0, false);
		}

		public FormFieldsIntegerOptions(Integer min, Integer max) {
			this(min, max, false);
		}
	}

	record FormFieldsDecimalOptions(Integer min, Integer max, @NonNull Integer precision, Boolean format) implements FormFieldsOptions {
		public FormFieldsDecimalOptions(Integer min, Integer max, Integer precision) {
			this(min, max, precision, false);
		}
	}

	record FormFieldsComboboxOptions(List<ComboboxItem> items) implements FormFieldsOptions {
	}

	interface ComboboxItem {
	}

	record ComboboxItemNormal(String id, String text) implements ComboboxItem {
		public ComboboxItemNormal() {
			this("", "");
		}
	}

	record ComboboxItemOnlyText(String text) implements ComboboxItem {
		public ComboboxItemOnlyText() {
			this("");
		}
	}

	public static List<FormFields> generateFormFields() {
		return List.of(new FormFieldsWithHtml("userid", "text", true, new FormFieldsHtmlNormal("ユーザＩＤ", "style='width: 100px'")),
				new FormFieldsWithHtml("password", "password", true, new FormFieldsHtmlNormal("パスワード", "style='width: 100px'")),
				new FormFieldsWithHtmlAndOptions("integer", "int", false, new FormFieldsHtmlNormal("数値(整数)", "style='width: 50px'"), new FormFieldsIntegerOptions(0, 100)),
				new FormFieldsWithHtmlAndOptions("decimal", "float", false, new FormFieldsHtmlNormal("数値(小数)", "style='width: 100px'"), new FormFieldsDecimalOptions(0, 100, 2)),
				new FormFieldsWithHtmlAndOptions("list", "list", false, new FormFieldsHtmlNormal("リスト", "style='width: 200px'"), new FormFieldsComboboxOptions(
						List.of(new ComboboxItemNormal(), new ComboboxItemNormal("id1", "text1"), new ComboboxItemNormal("id2", "text2")))));
	}

	record GridColumns(String field, String caption, String size, Boolean sortable) {
	}

	public static List<GridColumns> generateGridColumns() {
		return List.of(new GridColumns("recid", "ID", "50px", true),
				new GridColumns("fname", "First Name", "100px", true),
				new GridColumns("lname", "Last Name", "100px", true),
				new GridColumns("email", "Email", "300px", true),
				new GridColumns("sdate", "Start Date", "80px", false));
	}

	interface GridSearchCondition {
	}

	record GridSearchConditionNormal(String field, String label, String type) implements GridSearchCondition {
	}

	record GridSearchConditionWithStyle(String field, String label, String type, @NonNull String style) implements GridSearchCondition {
	}

	record GridSearchConditionWithOptions(String field, String label, String type, @NonNull FormFieldsOptions options) implements GridSearchCondition {
	}

	record GridSearchConditionWithStyleAndOptions(String field, String label, String type, @NonNull String style, @NonNull FormFieldsOptions options) implements GridSearchCondition {
	}

	public static List<GridSearchCondition> generateGridSearches() {
		return List.of(new GridSearchConditionNormal("recid", "ID", "int"),
				new GridSearchConditionNormal("fname", "First Name", "text"),
				new GridSearchConditionNormal("lname", "Last Name", "text"),
				new GridSearchConditionWithStyle("email", "Email", "text", "width: 400px"),
				new GridSearchConditionNormal("sdate", "Start Date", "date"));
	}
}