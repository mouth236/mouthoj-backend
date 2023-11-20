package com.mouth.moj.judge.codesandbox.impl;

import com.mouth.moj.judge.codesandbox.CodeSandbox;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeReponse;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeRequest;

/**
 * @ClassName ExampleCodeSandbox
 * @Description 第三方代码沙箱
 * @date 2023/11/20 21:25
 * @Version 1.0
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeReponse exexuteCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
