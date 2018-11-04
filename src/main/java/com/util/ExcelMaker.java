package com.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.domain.Problem;

@Component
public class ExcelMaker {

	private static final Logger LOG = LoggerFactory.getLogger(ExcelMaker.class);
	private static final String PATH = "d:/Мониторинг судов/Мониторинг суды ";

	public boolean makeXls(List<Problem> problems) {
		Workbook book = new HSSFWorkbook();
		Sheet sheet = book.createSheet("monitoring");
		createHeader(sheet);
		fillSheet(problems, sheet);
		normalize(sheet);
		boolean result = export(problems, book);
		return result;
	}

	private boolean export(List<Problem> problems, Workbook book) {
		String date = problems.get(1).getDate();
		OutputStream os;
		try {
			os = new FileOutputStream(PATH + date + ".xls");
			book.write(os);
			book.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			LOG.error("can't create book  " + e);
			return false;
		}
		return true;
	}

	private void fillSheet(List<Problem> problems, Sheet sheet) {
		for (int i = 0; i < problems.size(); i++) {
			setData(sheet, problems.get(i), i);
		}
	}

	private void setData(Sheet sheet, Problem problem, int i) {
		Row row = sheet.createRow(++i);
		Cell[] cells = createCells(row);
		cells[0].setCellValue(problem.getDate());
		cells[1].setCellValue(problem.getTimeDown());
		cells[2].setCellValue(problem.getTimeUp());
		cells[3].setCellValue(problem.getRegion());
		cells[4].setCellValue(problem.getCourt());
		cells[5].setCellValue(problem.getProblem());
		cells[6].setCellValue(problem.getStatus());
		cells[7].setCellValue(problem.getSupport());
		cells[8].setCellValue(problem.getDescription());
	}

	private Cell[] createCells(Row row) {
		Cell[] cells = new Cell[9];
		cells[0] = row.createCell(0);
		cells[1] = row.createCell(1);
		cells[2] = row.createCell(2);
		cells[3] = row.createCell(3);
		cells[4] = row.createCell(4);
		cells[5] = row.createCell(5);
		cells[6] = row.createCell(6);
		cells[7] = row.createCell(7);
		cells[8] = row.createCell(8);
		return cells;
	}

	private void createHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		Cell[] cells = createCells(row);
		cells[0].setCellValue("Дата");
		cells[1].setCellValue("Время обнаружения");
		cells[2].setCellValue("Время устранения");
		cells[3].setCellValue("Область");
		cells[4].setCellValue("Суд");
		cells[5].setCellValue("Проблема");
		cells[6].setCellValue("Статус");
		cells[7].setCellValue("РСП(ФИО)");
		cells[8].setCellValue("Комментарий");
	}

	private void normalize(Sheet sheet) {
		for (int i = 0; i < 9; i++) {
			sheet.autoSizeColumn(i);
		}
	}

}
