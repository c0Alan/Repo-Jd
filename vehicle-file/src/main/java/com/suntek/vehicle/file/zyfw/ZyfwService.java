package com.suntek.vehicle.file.zyfw;

import com.suntek.pci.gzbidata.service.bean.ServiceInfo;
import com.suntek.pci.gzbidata.service.service.DataQuery;
import com.suntek.pci.gzbidata.service.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源服务接口访问方式 Service
 *
 * @author liuxilin
 * @date 2018/7/27 22:04
 */
@Service
public class ZyfwService {

    private static final Logger logger = Logger.getLogger(ZyfwService.class);

    private DataQuery dataQuery;

    public ZyfwService() {
//        ClassLoader classLoader = getClass().getClassLoader();
//        URL url = classLoader.getResource("serviceConf.xml");
        ServiceInfo serviceInfo = CommonUtil.parseServiceInfo("serviceConf.xml");
        this.dataQuery = new DataQuery(serviceInfo);
    }

    /**
     * 获取资源服务平台的车档数据
     * @param hphm 号牌号码
     * @return
     */
    public List<Map<String, Object>> getRecords(String hphm) {
        List<Map<String, Object>> records = null;
        try {
            records = dataQuery.requestData(1, hphm, 30L);
        }catch (Exception e){
            logger.info("一车一档 - zyfw - 资源服务平台获数据错误, ", e);
            return null;
        }
        logger.info("一车一档 - zyfw - 资源服务平台获取到的数据, " + records);
/*        List<Map<String, Object>> records = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map map = new HashMap();
            map.put("XH", "XH" + i);
            map.put("aaa", "HPZL" + i);
            map.put("HPHM", "HPZL" + i);
            map.put("FHGZRQ", "2017-03-09 15:17:46.0");
//            map.put("FHGZRQ", "2017-03-09 15:17:46");
            records.add(map);
        }*/
        return records;
    }
}
