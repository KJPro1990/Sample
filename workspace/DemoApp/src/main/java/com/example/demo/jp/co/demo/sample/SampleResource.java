package com.example.demo.jp.co.demo.sample;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

@Data
public class SampleResource implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String content;
	private String cd;
	private String name;
}