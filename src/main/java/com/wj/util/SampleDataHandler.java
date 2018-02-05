package com.wj.util;

import com.wj.domain.SampleData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SampleDataHandler {
    /*
   * 数据筛选
   * 如果某项数据数据为null则跳过
   * @param SampleDate sd 样本数据
   * */
    public List<Double> dataList_OnlyDigital(SampleData sd){
        List<Double> dataList = new ArrayList<Double>();
        dataList.add(sd.getSampleData_one());
        dataList.add(sd.getSampleData_two());
        dataList.add(sd.getSampleData_three());
        dataList.add(sd.getSampleData_four());
        dataList.add(sd.getSampleData_five());

        List<Double> after_dataLiat=new ArrayList<Double>();
        for(Double d : dataList){
            if(d.isNaN()) {            //如果为非数字，则跳过
                continue;
            }
            else {
                after_dataLiat.add(d);
            }
        }
        return after_dataLiat;
    }

    /*
    *计算平方和
    * @param List
    * @return Double res
    * */
    public Double get_SquareSum(List<Double> dataList){
        int len=dataList.size();
        double sqrsum = 0.0000;
        for (int i = 0; i <len; i++) {
            sqrsum = sqrsum + dataList.get(i)*dataList.get(i);
        }
        return sqrsum;
    }

    /*
    * 计算平均值
    * 数据来源 SampleDate
    * @param SampleDate sd 样本数据
    * @return  Double average
    * */
    public double get_average(SampleData sd){
        List<Double> dataList = dataList_OnlyDigital(sd);
        Double sum = 0.0000;
        for(Double d : dataList) {
            sum += d;
        }
        int Denominator=dataList.size();
        return sum/Denominator;
    }

    /*
    * 计算方差
    * 数据来源 SampleDate
    * @param SampleDate sd 样本数据
    * @return  Double variance
    * */
    public Double get_variance(SampleData sd){
        List<Double> D_dataList = dataList_OnlyDigital(sd);
        int count = D_dataList.size();
        Double sqrsum = get_SquareSum(D_dataList);
        Double average = get_average(sd);
        double result=0.0000;
        result = (sqrsum - count * average * average) / count;
        return result;

    }

    /*计算标准差
    * 数据来源 SampleDate
    * @param SampleDate sd 样本数据
    * @return  Double standard_Deviation
    * */
    public Double get_standard_Deviation(SampleData sd){
        Double variance = get_variance(sd);
        Double result;
        result = Math.sqrt(Math.abs(variance));
        return result;
    }

    /*格式化数据
    * 输出位数统一为5位
    * @param Double data
    * @return Double res
    * */
    public Double get_stanardData(Double data){
        BigDecimal bg = new BigDecimal(data);
        double res = bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return res;
    }
}
