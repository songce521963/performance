package com.wtc.admin.performance.utils;

import com.csvreader.CsvReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

@Slf4j
public class CSVUtils {
	
	/**
	 * 读取CSV文件
	 * @param csvIs csv导入数据流
	 */
	public static ArrayList<String[]> readeCsvByIs(InputStream csvIs) {
		ArrayList<String[]> csvList = new ArrayList<>();
		try {
			CsvReader reader = new CsvReader(csvIs, Charset.forName("GBK"));
			reader.readHeaders();
			while (reader.readRecord()) {
				csvList.add(reader.getValues());
			}
			reader.close();
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return csvList;
	}
	
	
	/**
	 * 判断数据是否为空字段
	 * @param data
	 */
	public static boolean isNotBlank(String data){
		if (StringUtils.equals(data, "-"))
			return false;
		return true;
	}
}
