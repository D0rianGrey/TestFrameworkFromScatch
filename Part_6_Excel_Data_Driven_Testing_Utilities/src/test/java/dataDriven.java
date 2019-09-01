import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    //Identify testcases column by scanning the entire 1st row
    //once column is identified then scan entire testcase column to identify purchase testcase row
    //after you grab purchase testcase row = pull all the data of that row and feed into test

    public ArrayList<String> getData(String testcaseName) throws IOException {

        //fileInputStream argument
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream("C:\\Users\\utyfd\\IdeaProjects\\TestFrameworkFromScatch\\Part_6_Excel_Data_Driven_Testing_Utilities\\demoData.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);

        int sheets = xssfWorkbook.getNumberOfSheets(); //amount of sheets into excel file
        for (int i = 0; i < sheets; i++) {
            if (xssfWorkbook.getSheetName(i).equals("testdata")) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);

                //Identify testcases column by scanning the entire 1st row
                Iterator<Row> rows = xssfSheet.iterator(); // xssfSheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> cell = firstrow.cellIterator(); // row in collection of cells
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        //desired column
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        //after you grab purchase testcase row = pull all the data of that row and feed into test

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {


    }
}

