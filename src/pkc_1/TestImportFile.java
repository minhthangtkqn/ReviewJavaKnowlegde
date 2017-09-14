package pkc_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
 
public class TestImportFile {
 
   public static void main(String[] args) throws IOException {
  
       // Đọc một file XSL.
       FileInputStream inputStream = new FileInputStream(new File("E:/1.xls"));
  
       // Đối tượng workbook cho file XSL.
       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
       // Lấy ra sheet đầu tiên từ workbook
       HSSFSheet sheet = workbook.getSheetAt(0);
 
  
       // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
       Iterator<Row> rowIterator = sheet.iterator();
 
       while (rowIterator.hasNext()) {
           Row row = rowIterator.next();
     
           // Lấy Iterator cho tất cả các cell của dòng hiện tại.
           Iterator<Cell> cellIterator = row.cellIterator();
 
           while (cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
  
               // Đổi thành getCellType() nếu sử dụng POI 4.x
               CellType cellType = cell.getCellTypeEnum();
 
               switch (cellType) {
               case _NONE:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case BOOLEAN:
                   System.out.print(cell.getBooleanCellValue());
                   System.out.print("\t");
                   break;
               case BLANK:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case FORMULA:
       
                   // Công thức
                   System.out.print(cell.getCellFormula());
                   System.out.print("\t");
                    
                   FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
         
                   // In ra giá trị từ công thức
                   System.out.print(evaluator.evaluate(cell).getNumberValue());
                   System.out.println("--FORMULA\t");
                   break;
               case NUMERIC:
                   System.out.print(cell.getNumericCellValue());
                   System.out.print("--Number\t");
                   break;
               case STRING:
                   System.out.print(cell.getStringCellValue());
                   System.out.print("--String\t");
                   break;
               case ERROR:
                   System.out.print("!");
                   System.out.print("\t");
                   break;
               }
 
           }
           System.out.println("");
       }
       workbook.close();
   }
 
}