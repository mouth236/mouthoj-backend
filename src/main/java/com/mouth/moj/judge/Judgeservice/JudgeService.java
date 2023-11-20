package com.mouth.moj.judge.Judgeservice;

import com.mouth.moj.judge.codesandbox.model.ExecuteCodeReponse;
import com.mouth.moj.judge.codesandbox.model.ExecuteCodeRequest;
import com.mouth.moj.model.entity.QuestionSubmit;
import com.mouth.moj.model.vo.QuestionSubmitVO;

/**
 * @ClassName JudgeService
 * @Description 判题服务
 * @date 2023/11/20 22:22
 * @Version 1.0
 */
public interface JudgeService {

    /**
     * 执行判题操作
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
