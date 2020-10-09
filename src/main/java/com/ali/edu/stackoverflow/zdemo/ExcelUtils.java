package com.ali.edu.stackoverflow.zdemo;

import com.ali.edu.stackoverflow.entity.*;
import com.ali.edu.stackoverflow.utils.entity.FactorCategory;
import com.ali.edu.stackoverflow.utils.entity.UUIDGenerator;
import com.ali.edu.stackoverflow.zdemo.MeasureFactor;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 15:51
 */
public class ExcelUtils {

    public static List<DeviceAddParam> poiReadExcelAndReturnDevice(String filePath, HashMap<String, String> map) {
        File file = new File(filePath);
        try {
            FileInputStream stream = FileUtils.openInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            //获取第一个表单
            XSSFSheet sheet = workbook.getSheetAt(0);
            //获取sheet中最后一行行号
            int lastRowNum = sheet.getLastRowNum();
            List<DeviceAddParam> deviceAddParamList = new ArrayList<>();
            for (int i = 1; i <= lastRowNum; i++) {
                DeviceCommonNameAttrs deviceCommonNameAttrs = new DeviceCommonNameAttrs();
                //获取一条数据
                XSSFRow row = sheet.getRow(i);

                XSSFCell deviceCodeCell = row.getCell(7);
                //deivceCode
                if (null != deviceCodeCell) {
                    deviceCodeCell.setCellType(CellType.STRING);
                    String factorNameValue = deviceCodeCell.getStringCellValue();
                    deviceCommonNameAttrs.setDeviceCode(String.valueOf(factorNameValue));
                }
                XSSFCell manufactureCell = row.getCell(6);
                if (null != manufactureCell) {
                    manufactureCell.setCellType(CellType.STRING);
                    String manufactureValue = manufactureCell.getStringCellValue();
                    deviceCommonNameAttrs.setManufacturerName(String.valueOf(manufactureValue));
                }
                XSSFCell deviceTypeCell = row.getCell(5);
                if (null != deviceTypeCell) {
                    deviceTypeCell.setCellType(CellType.STRING);
                    String deviceTypeNameCell = deviceTypeCell.getStringCellValue();
                    deviceCommonNameAttrs.setDeviceTypeName(String.valueOf(deviceTypeNameCell));
                }

                //基本属性
                XSSFCell categoryCell = row.getCell(4);
                Map<String, DeviceBasicAttrNameValueVo> basicAttrVoMap = new HashMap<>();
                if (null != categoryCell) {
                    DeviceBasicAttrNameValueVo deviceBasicAttrNameValueVo = new DeviceBasicAttrNameValueVo();
                    categoryCell.setCellType(CellType.STRING);
                    String categoryName = categoryCell.getStringCellValue();
                    //to do fuck pm
                    deviceBasicAttrNameValueVo.setBasicAttrValue(categoryName);
                    basicAttrVoMap.put("category", deviceBasicAttrNameValueVo);
                }
                XSSFCell allowDisconnectionTimeCell = row.getCell(3);
                if (null != allowDisconnectionTimeCell) {
                    DeviceBasicAttrNameValueVo deviceBasicAttrNameValueVo = new DeviceBasicAttrNameValueVo();
                    allowDisconnectionTimeCell.setCellType(CellType.STRING);
                    String allowDisconnectionTime = allowDisconnectionTimeCell.getStringCellValue();
                    //to do fuck pm
                    deviceBasicAttrNameValueVo.setBasicAttrValue(allowDisconnectionTime);
                    basicAttrVoMap.put("allow_disconection_time", deviceBasicAttrNameValueVo);
                }
                XSSFCell frequencyCell = row.getCell(2);
                if (null != frequencyCell) {
                    DeviceBasicAttrNameValueVo deviceBasicAttrNameValueVo = new DeviceBasicAttrNameValueVo();
                    frequencyCell.setCellType(CellType.STRING);
                    String frequencyCellValue = frequencyCell.getStringCellValue();
                    //to do fuck pm
                    deviceBasicAttrNameValueVo.setBasicAttrValue(frequencyCellValue);
                    basicAttrVoMap.put("frequency", deviceBasicAttrNameValueVo);
                }
                XSSFCell deviceNameCell = row.getCell(0);
                if (null != deviceNameCell) {
                    DeviceBasicAttrNameValueVo deviceBasicAttrNameValueVo = new DeviceBasicAttrNameValueVo();
                    deviceNameCell.setCellType(CellType.STRING);
                    String deviceNameCellValue = deviceNameCell.getStringCellValue();
                    //to do fuck pm
                    deviceBasicAttrNameValueVo.setBasicAttrValue(deviceNameCellValue);
                    basicAttrVoMap.put("deviceName", deviceBasicAttrNameValueVo);
                }
                Map<String, DeviceExtendAttrNameValueVo> extendAttrVoMap = new HashMap<>();
                //扩展属性
                XSSFCell measureCodeCell = row.getCell(1);
                if (null != measureCodeCell) {
                    measureCodeCell.setCellType(CellType.STRING);
                    List<Map<String, DeviceSubAttrNameValueVo>> extendAttrValuesMapList = new ArrayList<>();
                    //获取数据
                    String measureCodeCellValue = measureCodeCell.getStringCellValue();
                    String[] split = measureCodeCellValue.split(",");
                    for (String s : split) {
                        Map<String, DeviceSubAttrNameValueVo> subFactorNameMap = new HashMap<>();
                        DeviceSubAttrNameValueVo deviceSubAttrNameValueVo = new DeviceSubAttrNameValueVo();
                        deviceSubAttrNameValueVo.setSubAttrValue(s);
                        subFactorNameMap.put("factorName", deviceSubAttrNameValueVo);
                        extendAttrValuesMapList.add(subFactorNameMap);

                        Map<String, DeviceSubAttrNameValueVo> subFactorCodeMap = new HashMap<>();
                        DeviceSubAttrNameValueVo deviceSubAttrNameValueVoCode = new DeviceSubAttrNameValueVo();
                        if(map.containsKey(s)){
                            deviceSubAttrNameValueVoCode.setSubAttrValue(map.get(s));
                        }else {
                            deviceSubAttrNameValueVoCode.setSubAttrValue(generateShortUuid());
                        }
                        subFactorCodeMap.put("factorCode",deviceSubAttrNameValueVoCode);
                        extendAttrValuesMapList.add(subFactorCodeMap);
                    }
                    DeviceExtendAttrNameValueVo deviceExtendAttrNameValueVo = new DeviceExtendAttrNameValueVo();
                    deviceExtendAttrNameValueVo.setExtendAttrValuesMapList(extendAttrValuesMapList);
                    extendAttrVoMap.put("factors", deviceExtendAttrNameValueVo);
                }
                DeviceAddParam deviceAddParam = new DeviceAddParam();
                deviceAddParam.setDeviceCommonNameAttrs(deviceCommonNameAttrs);
                deviceAddParam.setBasicAttrVoMap(basicAttrVoMap);
                deviceAddParam.setExtendAttrVoMap(extendAttrVoMap);
                deviceAddParamList.add(deviceAddParam);
            }
            return deviceAddParamList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将制造商名称放入HashSet
     *
     * @param
     * @return
     */
    public static HashSet<String> poiReadExcelReadManufacture(String filePath) {
        int repeat = 0;
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = FileUtils.openInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            //获取第一个表单
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            HashSet<String> set = new HashSet<>();
            for (int i = 1; i < lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(0);
                cell.setCellType(CellType.STRING);
                String stringCellValue = cell.getStringCellValue();
                if(set.contains(stringCellValue)){
                    repeat++;
                    continue;
                }
                set.add(stringCellValue);
            }
            System.out.println(String.format("一共%d, 重复%d条",lastRowNum,repeat));
            return set;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<FactorIndex> poiReadExcelgetFactorIndex(String url) {

        List<FactorIndex> list= new ArrayList<>();
        try {
            File file = new File(url);
            FileInputStream fileInputStream = FileUtils.openInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            //获取第一个表单
            XSSFSheet sheet = workbook.getSheetAt(1);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);

                FactorIndex factorIndex = new FactorIndex();
                XSSFCell codeCell = row.getCell(0);
                codeCell.setCellType(CellType.STRING);
                String codeCellValue = codeCell.getStringCellValue().trim();
                factorIndex.setCode(codeCellValue);

                XSSFCell chineseNameCell = row.getCell(2);
                chineseNameCell.setCellType(CellType.STRING);
                String chineseNameCellValue = chineseNameCell.getStringCellValue().trim();
                factorIndex.setName(chineseNameCellValue);
                factorIndex.setId(UUIDGenerator.getUUID());
                list.add(factorIndex);
            }
            return  list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<FactorCategory> poiReadExcelgetFactorCategory(String filePath) {
        List<FactorCategory> list= new ArrayList<>();
        FactorCategory parent = new FactorCategory();
        parent.setId("3333ae2734d64bbe8b598af6c6610003");
        int repeat = 0;
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = FileUtils.openInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            //获取第一个表单
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            HashSet<String> set = new HashSet<>();
            for (int i = 1; i < lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell codeCell = row.getCell(0);
                codeCell.setCellType(CellType.STRING);
                String codeCellValue = codeCell.getStringCellValue();
                XSSFCell ChineseName = row.getCell(1);
                ChineseName.setCellType(CellType.STRING);
                String chineseNameValue = ChineseName.getStringCellValue();
                XSSFCell descriptionCell = row.getCell(2);
                descriptionCell.setCellType(CellType.STRING);
                String descriptionCellValue = descriptionCell.getStringCellValue();
                FactorCategory factorCategory = new FactorCategory();
                factorCategory.setCode(codeCellValue);
                factorCategory.setDescription(descriptionCellValue);
                factorCategory.setName(chineseNameValue);
                factorCategory.setParent(parent);
                factorCategory.setParentId("3333ae2734d64bbe8b598af6c6610003");
                list.add(factorCategory);
            }
            return  list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成uuid
     * @return
     */
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    /**
     * 生成较段短的uuid
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
}
