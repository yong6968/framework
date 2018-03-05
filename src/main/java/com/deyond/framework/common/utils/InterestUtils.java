package com.deyond.framework.common.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deyond.framework.common.interceptor.GlobalInterceptor;

/**
 * 计算
 * @version 2018年3月2日上午10:47:08
 * @author zhiyong.lin
 */
public class InterestUtils {
    private static Logger log = LoggerFactory.getLogger(GlobalInterceptor.class);
    
    public static void main(String[] args) {
        BigDecimal investmentAmount = BigDecimal.ZERO;//投资金额
        BigDecimal totalInvestmentAmount = new BigDecimal(50250);//投资总金额
        BigDecimal totalInvestmentAmountBean = totalInvestmentAmount;
        int investmentMaxLimit = 90;                             //产品最大期限
        BigDecimal interest = BigDecimal.ZERO;                   //利息
        BigDecimal totalInterest = BigDecimal.ZERO;              //利息总收益
        log.info("尊敬的客户，你投资金额为:{},最大接受投资期限为{}天",totalInvestmentAmount,investmentMaxLimit);
        //购买新手金
        if(true){
            totalInvestmentAmount = totalInvestmentAmount.subtract(BigDecimal.valueOf(249));
            interest = BigDecimal.valueOf(249).multiply(BigDecimal.valueOf(0.042)).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(90));
            totalInterest =  interest.add(BigDecimal.valueOf(20));
            log.info("投资新手金1克，期限90天,年化4.2%,买入价249元,卖出价按实时金价（270左右）");
            log.info("投资剩余金额:{},利息收益:{},差价奖励:20,总利息：{},",totalInvestmentAmount,interest,totalInterest);
        }
        log.info("投资产品{}，期限{}天,年化{}%",InterestUtils.Product.STEADYWINS90.name,InterestUtils.Product.STEADYWINS90.deadline,InterestUtils.Product.STEADYWINS90.annualRate.multiply(BigDecimal.valueOf(100)));
        BigDecimal interestRateCoupons = BigDecimal.valueOf(0.036);
        BigDecimal cashCoupons = BigDecimal.ZERO;
        if(interestRateCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}%加息红包,",interestRateCoupons.multiply(BigDecimal.valueOf(100)));
        }
        investmentAmount = totalInvestmentAmount;//投资金额
        interest = investmentAmount.multiply(InterestUtils.Product.STEADYWINS90.annualRate).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        BigDecimal  couponsInterest = investmentAmount.multiply(interestRateCoupons).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        totalInterest =  interest.add(totalInterest).add(couponsInterest);
        totalInvestmentAmount = totalInvestmentAmount.subtract(investmentAmount);
        log.info("投资金额{},剩余金额{},利息收益：{},红包收益:{},总利息累计收益:{}",investmentAmount,totalInvestmentAmount,interest,couponsInterest,totalInterest);
        log.info("到期本息合计：{}",totalInvestmentAmountBean.add(totalInterest));
        //---------------------------------按多笔投的话-------------------------------------------
        log.info("--------------------------多笔投资------------------------------------------");
        investmentAmount = BigDecimal.ZERO;//投资金额
        totalInvestmentAmount = new BigDecimal(50250);//投资总金额
        totalInvestmentAmountBean = totalInvestmentAmount;
        investmentMaxLimit = 90;                      //产品最大期限
        interest = BigDecimal.ZERO;                   //利息
        totalInterest = BigDecimal.ZERO;              //利息总收益
        BigDecimal amount = BigDecimal.ZERO;           //累计投入本金
        log.info("尊敬的客户，你投资金额为:{},最大接受投资期限为{}天",totalInvestmentAmount,investmentMaxLimit);
        //购买新手金
        if(true){
            totalInvestmentAmount = totalInvestmentAmount.subtract(BigDecimal.valueOf(249));
            amount = BigDecimal.valueOf(249);
            interest = BigDecimal.valueOf(249).multiply(BigDecimal.valueOf(0.042)).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(90));
            totalInterest =  interest.add(BigDecimal.valueOf(20));
            log.info("投资新手金1克，期限90天,年化4.2%,买入价249元,卖出价按实时金价（270左右）");
            log.info("投资剩余金额:{},利息收益:{},差价奖励:20,总利息：{},",totalInvestmentAmount,interest,totalInterest);
        }
        //购买20001元
        log.info("投资产品{}，期限{}天,年化{}%",InterestUtils.Product.STEADYWINS90.name,InterestUtils.Product.STEADYWINS90.deadline,InterestUtils.Product.STEADYWINS90.annualRate.multiply(BigDecimal.valueOf(100)));
        interestRateCoupons = BigDecimal.ZERO;
        if(interestRateCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}%加息红包,",interestRateCoupons.multiply(BigDecimal.valueOf(100)));
        }
        cashCoupons = BigDecimal.valueOf(188);
        if(cashCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}元现金红包,",cashCoupons);
        }
        investmentAmount = BigDecimal.valueOf(20001);//投资金额
        amount = amount.add(investmentAmount);
        interest = investmentAmount.multiply(InterestUtils.Product.STEADYWINS90.annualRate).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        couponsInterest = investmentAmount.multiply(interestRateCoupons).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        totalInterest =  interest.add(totalInterest).add(couponsInterest);
        totalInvestmentAmount = totalInvestmentAmount.subtract(investmentAmount).add(cashCoupons);
        log.info("投资金额{},剩余金额{},利息收益：{},红包收益:{},总利息累计收益:{}",investmentAmount,totalInvestmentAmount,interest,couponsInterest,totalInterest);
        //购买15001元
        log.info("投资产品{}，期限{}天,年化{}%",InterestUtils.Product.STEADYWINS90.name,InterestUtils.Product.STEADYWINS90.deadline,InterestUtils.Product.STEADYWINS90.annualRate.multiply(BigDecimal.valueOf(100)));
        interestRateCoupons = BigDecimal.ZERO;
        if(interestRateCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}%加息红包,",interestRateCoupons.multiply(BigDecimal.valueOf(100)));
        }
        cashCoupons = BigDecimal.valueOf(158);
        if(cashCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}元现金红包,",cashCoupons);
        }
        investmentAmount = BigDecimal.valueOf(15001);//投资金额
        amount = amount.add(investmentAmount);
        interest = investmentAmount.multiply(InterestUtils.Product.STEADYWINS90.annualRate).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        couponsInterest = investmentAmount.multiply(interestRateCoupons).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        totalInterest =  interest.add(totalInterest).add(couponsInterest);
        totalInvestmentAmount = totalInvestmentAmount.subtract(investmentAmount).add(cashCoupons);
        log.info("投资金额{},剩余金额{},利息收益：{},红包收益:{},总利息累计收益:{}",investmentAmount,totalInvestmentAmount,interest,couponsInterest,totalInterest);
        //购买5001
        log.info("投资产品{}，期限{}天,年化{}%",InterestUtils.Product.STEADYWINS90.name,InterestUtils.Product.STEADYWINS90.deadline,InterestUtils.Product.STEADYWINS90.annualRate.multiply(BigDecimal.valueOf(100)));
        interestRateCoupons = BigDecimal.ZERO;
        if(interestRateCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}%加息红包,",interestRateCoupons.multiply(BigDecimal.valueOf(100)));
        }
        cashCoupons = BigDecimal.valueOf(60);
        if(cashCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}元现金红包,",cashCoupons);
        }
        investmentAmount = BigDecimal.valueOf(5001);//投资金额
        amount = amount.add(investmentAmount);
        interest = investmentAmount.multiply(InterestUtils.Product.STEADYWINS90.annualRate).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        couponsInterest = investmentAmount.multiply(interestRateCoupons).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        totalInterest =  interest.add(totalInterest).add(couponsInterest);
        totalInvestmentAmount = totalInvestmentAmount.subtract(investmentAmount).add(cashCoupons);
        log.info("投资金额{},剩余金额{},利息收益：{},红包收益:{},总利息累计收益:{}",investmentAmount,totalInvestmentAmount,interest,couponsInterest,totalInterest);
        //需要的使用加息红包
        log.info("投资产品{}，期限{}天,年化{}%",InterestUtils.Product.STEADYWINS90.name,InterestUtils.Product.STEADYWINS90.deadline,InterestUtils.Product.STEADYWINS90.annualRate.multiply(BigDecimal.valueOf(100)));
        interestRateCoupons = BigDecimal.valueOf(0.036);
        if(interestRateCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}%加息红包,",interestRateCoupons.multiply(BigDecimal.valueOf(100)));
        }
        cashCoupons = BigDecimal.ZERO;
        if(cashCoupons.compareTo(BigDecimal.ZERO)>0){
            log.info("使用{}元现金红包,",cashCoupons);
        }
        investmentAmount = totalInvestmentAmount;//投资金额
        amount = amount.add(investmentAmount);
        interest = investmentAmount.multiply(InterestUtils.Product.STEADYWINS90.annualRate).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        couponsInterest = investmentAmount.multiply(interestRateCoupons).divide(BigDecimal.valueOf(365),2,BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(InterestUtils.Product.STEADYWINS90.deadline));
        totalInterest =  interest.add(totalInterest).add(couponsInterest);
        totalInvestmentAmount = totalInvestmentAmount.subtract(investmentAmount).add(cashCoupons);
        log.info("投资金额{},剩余金额{},利息收益：{},红包收益:{},总利息累计收益:{}",investmentAmount,totalInvestmentAmount,interest,couponsInterest,totalInterest);
        log.info("到期本息合计：{}",amount.add(totalInterest));
    }
    
    public void print(){
        
    }
    
    public enum Product {  
        NOVICE("新手金",90,BigDecimal.valueOf(0.05),BigDecimal.valueOf(20)), STEADYWINS30("稳赢金30天",30,BigDecimal.valueOf(0.068),BigDecimal.ZERO), STEADYWINS90("稳赢金90天",90,BigDecimal.valueOf(0.08),BigDecimal.ZERO);  
        // 成员变量  
        private String name;  
        private int deadline;
        private BigDecimal annualRate;  
        private BigDecimal rewardAmount;
        // 构造方法  
        private Product(String name, int deadline,BigDecimal annualRate,BigDecimal rewardAmount) {  
            this.name = name;  
            this.deadline = deadline;
            this.annualRate = annualRate;  
            this.rewardAmount = rewardAmount;
        }  
        // get set 方法  
        public String getName() {  
            return name;  
        }  
        public BigDecimal getAnnualRate() {  
            return annualRate;  
        }  
        public int getDeadline(){
            return deadline;
        }
        public BigDecimal getRewardAmount(){
            return rewardAmount;
        }
    }  

}
