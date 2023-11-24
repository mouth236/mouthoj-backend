package com.mouth.moj.judge.codesandbox.impl;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.mouth.moj.common.ErrorCode;
import com.mouth.moj.exception.BusinessException;
import com.mouth.moj.judge.codesandbox.CodeSandbox;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeReponse;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName ExampleCodeSandbox
 * @Description 远程代码沙箱
 * @date 2023/11/20 21:25
 * @Version 1.0
 */
public class RemoteCodeSandbox implements CodeSandbox {
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";
    @Override
    public ExecuteCodeReponse exexuteCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8102/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if(StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode remoteSandbox error ,message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr,ExecuteCodeReponse.class);
    }
}
