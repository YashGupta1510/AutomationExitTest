package annotationUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import fileReaderUtils.ExcelSheetReader;

public class AnnotationTransformer implements IAnnotationTransformer {
	
    private static Map<String, Boolean> executionMap;
	protected static List<String[]> testData;

    static {
    	executionMap = new HashMap<String, Boolean>();
    	 testData = ExcelSheetReader.readExcelData("src\\test\\resources\\flipkart_test_cases.xlsx", "Sheet1");
    	 for (int i = 1; i < testData.size(); i++) {
             String testCaseName = testData.get(i)[6];
             boolean executionRequired = testData.get(i)[5].equalsIgnoreCase("Yes");
             executionMap.put(testCaseName, executionRequired);
         }
    	 System.out.println(executionMap.toString());
    }

    @Override
    public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            String methodName = testMethod.getName();
            if (executionMap.containsKey(methodName)) {
                annotation.setEnabled(executionMap.get(methodName));
            }
        }
    }
}
