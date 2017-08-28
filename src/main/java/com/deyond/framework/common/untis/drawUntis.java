package com.deyond.framework.common.untis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by linzhiyong on 2017/8/29.
 */
public class drawUntis {




    public static Award lottery(List<Award> awards){
        // 总的概率区间
        float totalPro = 0f;
        //存储每个奖品新的概率区间
        List<Float> proSection = new ArrayList<Float>();
        proSection.add(0f);
        //遍历每个奖品，设置概率区间，总的概率区间为每个概率区间的总和
        for (Award award : awards){
            //每个概率区间为奖品概率乘以1000 （把三位小数转化为整数）再乘以剩余奖品数量
            totalPro += award.probabilty * 10 * award.count;
            proSection.add(totalPro);
        }
    }


    /**
     * 抽奖方法
     */
    public void darw(){
        final Map<String,Integer> awardStockMap = new ConcurrentHashMap<String, Integer>(); //奖品 奖品库存
        awardStockMap.put("1",5000);
        awardStockMap.put("2",1000);
        awardStockMap.put("3",500);
        awardStockMap.put("5",100);
        awardStockMap.put("iphone",1);
        awardStockMap.put("未中奖",59406);
        //权重默认等于库存
        final Map<String,Integer> awardWeightMap = new ConcurrentHashMap<String, Integer>(awardStockMap);

        int userNum = 30000; //日活用户数
        int drawNum = userNum * 3; // 每日抽奖次数 = 日活数 * 抽奖次数
        Map<String, Integer> dailWinCountMap = new ConcurrentHashMap<String, Integer>();// 每天实际中奖计数
        for(int j=0;j<drawNum;j++){
            //排除掉库存未0的奖品
            //Map<String,Integer> awardWeightHaveStockMap = awardWeightMap.entrySet().stream().filter()
        }
    }

}
