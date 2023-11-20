package com.mouth.moj.judge.codesandbox;

import com.mouth.moj.judge.codesandbox.model.ExecuteCodeReponse;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName CodeSandboxProxy
 * @Description TODO
 * @date 2023/11/20 22:08
 * @Version 1.0
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox{

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeReponse exexuteCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息："+ executeCodeRequest.toString());
        ExecuteCodeReponse executeCodeReponse = codeSandbox.exexuteCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeReponse.toString());
        return executeCodeReponse;
    }
}
