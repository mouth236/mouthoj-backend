package com.mouth.moj.judge;

import com.mouth.moj.judge.strategy.DefaultJudgeStrategy;
import com.mouth.moj.judge.strategy.JavaLanguageJudgeStrategy;
import com.mouth.moj.judge.strategy.JudgeContext;
import com.mouth.moj.judge.strategy.JudgeStrategy;
import com.mouth.moj.judge.codesandbox.model.JudgeInfo;
import com.mouth.moj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @ClassName JudgeManager
 * @Description 判题管理（简化调用）
 * @date 2023/11/20 23:42
 * @Version 1.0
 */
@Service
public class JudgeManager {

    public JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
