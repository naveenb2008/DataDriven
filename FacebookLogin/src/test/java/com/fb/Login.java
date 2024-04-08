package com.fb;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Login {
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.facebook.com/");

        File file = new File("C:\\Users\\pragadeesh\\IdeaProjects\\FacebookLogin\\Excel\\Fb.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook WB = new XSSFWorkbook(fileInputStream);
        Sheet sheetAt = WB.getSheetAt(0);
        Row row = sheetAt.getRow(0);
        Cell cell = row.getCell(0);
       // CellType cellType = cell.getCellType();
        String stringCellValue = cell.getStringCellValue();

        //Sheet sheetAt = WB.getSheetAt(1);
        Row row1 = sheetAt.getRow(0);
        Cell cell1 = row.getCell(1);
        // CellType cellType = cell.getCellType();
        String stringCellValue1= cell.getStringCellValue();


        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(stringCellValue);
       driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(stringCellValue1);
       //driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
