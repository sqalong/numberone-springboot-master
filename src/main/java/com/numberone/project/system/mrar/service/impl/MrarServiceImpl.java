package com.numberone.project.system.mrar.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.numberone.common.utils.text.Convert;
import com.numberone.project.system.mrar.domain.Mrar;
import com.numberone.project.system.mrar.exception.MyException;
import com.numberone.project.system.mrar.mapper.MrarMapper;
import com.numberone.project.system.mrar.service.IMrarService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;






/**
 * 表具抄表录入Service业务层处理
 * 
 * @author numberone
 * @date 2020-11-12
 */
@Service
public class MrarServiceImpl implements IMrarService
{
    @Autowired
    private MrarMapper mrarMapper;

    /**
     * 查询表具抄表录入
     * 
     * @param id 表具抄表录入ID
     * @return 表具抄表录入
     */
    @Override
    public Mrar selectMrarById(Integer id)
    {
        return mrarMapper.selectMrarById(id);
    }

    /**
     * 查询表具抄表录入列表
     * 
     * @param mrar 表具抄表录入
     * @return 表具抄表录入
     */
    @Override
    public List<Mrar> selectMrarList(Mrar mrar)
    {
        return mrarMapper.selectMrarList(mrar);
    }

    /**
     * 新增表具抄表录入
     * 
     * @param mrar 表具抄表录入
     * @return 结果
     */
    @Override
    public int insertMrar(Mrar mrar)
    {
        return mrarMapper.insertMrar(mrar);
    }

    /**
     * 修改表具抄表录入
     * 
     * @param mrar 表具抄表录入
     * @return 结果
     */
    @Override
    public int updateMrar(Mrar mrar)
    {
        return mrarMapper.updateMrar(mrar);
    }

    /**
     * 删除表具抄表录入对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrarByIds(String ids)
    {
        return mrarMapper.deleteMrarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除表具抄表录入信息
     * 
     * @param id 表具抄表录入ID
     * @return 结果
     */
    @Override
    public int deleteMrarById(Integer id)
    {
        return mrarMapper.deleteMrarById(id);
    }

    @Override
    public int addMrar(MultipartFile file) throws Exception {
        int result = 0;
//		存放excel表中所有user细腻
        List<Mrar> mrarList = new ArrayList<>();
        /**
         *
         * 判断文件版本
         */
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);

        InputStream ins = file.getInputStream();

        Workbook wb = null;

        if(suffix.equals("xlsx")){

            wb = new XSSFWorkbook(ins);

        }else{
            wb = new HSSFWorkbook(ins);
        }
        /**
         * 获取excel表单
         */
        Sheet sheet = wb.getSheetAt(0);


        /**
         * line = 2 :从表的第三行开始获取记录
         *
         */
        if(null != sheet){

            for(int line = 2; line <= sheet.getLastRowNum();line++){

                Mrar mrar = new Mrar();

                Row row = sheet.getRow(line);

                if(null == row){
                    continue;
                }
                /**
                 * 判断单元格类型是否为文本类型
                 */
//                if(1 != row.getCell(0).getCellType()){
//                    throw new MyException("单元格类型不是文本类型！");
//                }

                /**
                 * 获取第一个单元格的内容
                 */
                String coding = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String number = row.getCell(2).getStringCellValue();
                String period = row.getCell(3).getStringCellValue();
                String badname = row.getCell(4).getStringCellValue();
                String time = row.getCell(5).getStringCellValue();
                String lastreading = row.getCell(6).getStringCellValue();
                String reading = row.getCell(7).getStringCellValue();
                String unit = row.getCell(8).getStringCellValue();
                String state = row.getCell(9).getStringCellValue();


                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                /**
                 * 获取第二个单元格的内容
                 */

                String password = row.getCell(1).getStringCellValue();
                mrar.setCoding(coding);
                mrar.setName(name);
                mrar.setNumber(number);
                mrar.setPeriod(period);
                mrar.setBadname(badname);
                mrar.setTime(time);
                mrar.setLastreading(lastreading);
                mrar.setReading(reading);
                mrar.setUnit(unit);
                mrar.setState(state);
                mrarList.add(mrar);

            }

            for(Mrar MrarInfo:mrarList){

//                /**
//                 * 判断数据库表中是否存在用户记录，若存在，则更新，不存在，则保存记录
//                 */
//                String name = userInfo.getUsername();
//
//                int count = userMapper.selectUser(name);

                result = mrarMapper.addMran(MrarInfo);

//                if(0 == count){
//                    result = userMapper.addUser(userInfo);
//                }else{
//                    result = userMapper.updateUser(userInfo);
//                }



            }
        }

        return result;

    }







}
