package jp.co.test.sample;

import java.io.Serializable;

import lombok.Data;

@Data
public class SampleResource implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String content;
	private String cd;
	private String name;
}