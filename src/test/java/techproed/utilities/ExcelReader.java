package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.devtools.v85.io.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaIsmi){
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook = WorkbookFactory.create(fis);
            sheet= workbook.getSheet(sayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Satır ve sütun sayılarını girdiğimizde, O hücredeki veriyi return eden method
    public String getCellData(int satır, int sütun){
        Cell cell = sheet.getRow(satır).getCell(sütun);
        return cell.toString();
    }

    //Exceldeki satır sayısını return eden method
    public int rowCount(){
        return sheet.getLastRowNum();
    }
}
