package com.magician.web;

import com.magician.web.core.util.MesUtil;
import com.magician.web.execute.ApiExecute;
import com.magician.web.load.ApiLoad;
import io.magician.application.request.MagicianRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MagicianWeb
 */
public class MagicianWeb {

    private static Logger logger = LoggerFactory.getLogger(MagicianWeb.class);

    /**
     * 创建一个web
     * @return
     */
    public static MagicianWeb createWeb(){
        return new MagicianWeb();
    }

    /**
     * 执行请求
     */
    public void request(MagicianRequest request) throws Exception {
        try {
            /* 加载资源 */
            ApiLoad.load();

            /* 执行业务逻辑 */
            ApiExecute.execute(request);
        } catch (Exception e){
            logger.error("执行MagicianWeb出现异常", e);

            request.getResponse()
                    .sendJson(MesUtil.getMes(500, e.getMessage()));
        }
    }
}
