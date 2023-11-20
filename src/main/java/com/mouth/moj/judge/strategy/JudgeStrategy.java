package com.mouth.moj.judge.strategy;

import com.mouth.moj.model.dto.questionsubmit.JudgeInfo;

/**
 * @ClassName JudgeStrategy
 * @Description 判题策略（策略模式）
 * @date 2023/11/20 23:12
 * @Version 1.0
 */
public interface JudgeStrategy {

    JudgeInfo doJudge(JudgeContext judgeContext);
}
